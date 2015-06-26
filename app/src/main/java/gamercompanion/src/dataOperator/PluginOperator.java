package gamercompanion.src.dataOperator;

import com.google.common.base.Function;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableCollection;

import gamercompanion.src.dataManager.PluginManager;
import gamercompanion.src.dataObjects.plugin.Plugin;

/**
 * Created by dklemm on 26.06.15.
 */
public class PluginOperator {
    public static ImmutableCollection<Plugin> activatedPlugins() {
        return PluginManager.asImmutableCollection();
    }

    public static FluentIterable<String> activatedPluginNames()
    {
       return FluentIterable.from(activatedPlugins()).transform(new Function<Plugin, String>() {
            @Override
            public String apply(Plugin input) {
                return input.get_pluginName();
            }
        });
    }
}
