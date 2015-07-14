package gamercompanion.src.dataManager;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.base.Supplier;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableMap;

import java.util.Map;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicReference;

import gamercompanion.src.dataObjects.plugin.AmiiboPlugin;
import gamercompanion.src.dataObjects.plugin.GameDBPlugin;
import gamercompanion.src.dataObjects.plugin.LaunchCalendarPlugin;
import gamercompanion.src.dataObjects.plugin.MyGamesPlugin;
import gamercompanion.src.dataObjects.plugin.NewsPlugin;
import gamercompanion.src.dataObjects.plugin.Plugin;
import gamercompanion.src.dataObjects.plugin.SearchPlugin;
import gamercompanion.src.dataObjects.plugin.WhishlistPlugin;
import gamercompanion.src.error.ErrorUtil;
import gamercompanion.src.utils.SystemProperties;
import gamercompanion.src.utils.tryUtil.Try;

/**
 * Plugin Manager loads all properties from system.properties
 * that are describing Plugins
 */
public class PluginManager {
    private static final String AMIIBO_PLUGIN ="Amiibo";
    private static final String AMIIBO_PLUGIN_NAME ="Amiibo";
    private static final String NEWS_PLUGIN ="News";
    private static final String NEWS_PLUGIN_NAME ="News";
    private static final String SEARCH_PLUGIN ="Search";
    private static final String SEARCH_PLUGIN_NAME ="Search";
    private static final String MY_GAMES_PLUGIN ="MyGames";
    private static final String MY_GAMES_PLUGIN_NAME ="My Games";
    private static final String GAMEDB_PLUGIN ="GameDB";
    private static final String GAMEDB_PLUGIN_NAME ="Game DB";
    private static final String LAUNCH_CALENDAR_PLUGIN ="LaunchCalendar";
    private static final String LAUNCH_CALENDAR_PLUGIN_NAME ="Launch Calendar";
    private static final String WISHLIST_PLUGIN ="Wishlist";
    private static final String WISHLIST_PLUGIN_NAME ="Wishlist";

    private static final String PLUGIN_PREFIX = "plugin_";
    private static final String PLUGIN_IS_ACTIVE_VALUE = "true";
    static final AtomicReference<PluginManager> _instance = new AtomicReference<>();
    private final ImmutableCollection<Plugin> _plugins;

    PluginManager() {
        Try<ImmutableCollection<Plugin>> tryLoad = loadPlugins();
        if(!tryLoad.isSuccess())
        {
            ErrorUtil.showCriticalError("Could not load Plugins! "+tryLoad.failure().getMessage());
        }
        _plugins = tryLoad.get();
    }

    private static final Try<ImmutableCollection<Plugin>> loadPlugins() {
        final ImmutableMap<String, String> systemProperties = SystemProperties.asImmutableMap();

        return Try.of(new Supplier<ImmutableCollection<Plugin>>() {
            @Override
            public ImmutableCollection<Plugin> get() {
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
                        //TODO register new Plugins here!!
                        String propertyName = input.substring(7);
                        if(propertyName == null || propertyName.isEmpty())
                            throw new IllegalStateException("propertyname is empty");

                        if(propertyName.equals(AMIIBO_PLUGIN))
                            return new AmiiboPlugin(AMIIBO_PLUGIN_NAME, propertyName);
                        if(propertyName.equals(NEWS_PLUGIN))
                            return new NewsPlugin(NEWS_PLUGIN_NAME, propertyName);
                        if(propertyName.equals(SEARCH_PLUGIN))
                            return new SearchPlugin(SEARCH_PLUGIN_NAME, propertyName);
                        if(propertyName.equals(MY_GAMES_PLUGIN))
                            return new MyGamesPlugin(MY_GAMES_PLUGIN_NAME, propertyName);
                        if(propertyName.equals(GAMEDB_PLUGIN))
                            return new GameDBPlugin(GAMEDB_PLUGIN_NAME, propertyName);
                        if(propertyName.equals(LAUNCH_CALENDAR_PLUGIN))
                            return new LaunchCalendarPlugin(LAUNCH_CALENDAR_PLUGIN_NAME, propertyName);
                        if(propertyName.equals(WISHLIST_PLUGIN))
                            return new WhishlistPlugin(WISHLIST_PLUGIN_NAME, propertyName);

                        throw new IllegalStateException("Could not find a matching plugin!");
                    }
                }).toList();
            }
        });
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
