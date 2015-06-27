package gamercompanion.src.dataManager;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableMap;

import java.util.Map;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicReference;

import gamercompanion.src.dataObjects.plugin.Plugin;
import gamercompanion.src.utils.SystemProperties;

/**
 * Plugin Manager loads all properties from system.properties
 * that are describing Plugins
 */
public class PluginManager {
    private static final String PLUGIN_PREFIX = "plugin_";
    private static final String PLUGIN_IS_ACTIVE_VALUE = "true";
    static final AtomicReference<PluginManager> _instance = new AtomicReference<>();
    private final ImmutableCollection<Plugin> _plugins;

    PluginManager() {
        _plugins = loadPlugins();
    }

    private static final ImmutableCollection<Plugin> loadPlugins() {
        final ImmutableMap<String, String> systemProperties = SystemProperties.asImmutableMap();

        return FluentIterable.from(systemProperties.keySet()).filter(new Predicate<String>() {
            @Override
            public boolean apply(String input) {
                if (input.startsWith(PLUGIN_PREFIX) && systemProperties.get(input).equals(PLUGIN_IS_ACTIVE_VALUE)) {
                    return true;
                }
                return false;
            }
        }).transform(new Function<String, Plugin>() {
            @Override
            public Plugin apply(String input) {
                return new Plugin(input, input.substring(7));
            }
        }).toList();
    }

    /*
     * gives all properties as immutable map (String, String), loads properties, if not already done
     */
    public static ImmutableCollection<Plugin> asImmutableCollection()
    {
        initializeIfNotSet(_instance);
        return _instance.get()._plugins;
    }

    private static ImmutableMap<String, String> toImmutableMap(final Properties properties) {
        ImmutableMap.copyOf(properties);
        ImmutableMap.Builder<String, String> b = ImmutableMap.builder();
        for (Map.Entry<Object, Object> e : properties.entrySet()) {
            b.put(e.getKey().toString(), e.getValue().toString());
        }
        return b.build();
    }

    private static void initializeIfNotSet(AtomicReference<PluginManager> instance) {
        if (instance.get() == null) {
            instance.set(new PluginManager());
        }
    }
}
