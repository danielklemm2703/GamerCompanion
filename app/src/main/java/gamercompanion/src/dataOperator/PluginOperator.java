package gamercompanion.src.dataOperator;

import com.google.common.base.Function;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableCollection;

import gamercompanion.src.dataManager.PluginManager;
import gamercompanion.src.dataObjects.plugin.Plugin;

/**
 * Provides a bunch of functions related processing information about the Plugins.
 *
 */
public class PluginOperator {
    /**
     * gives all activated Plugins
     */
    public static ImmutableCollection<Plugin> activatedPlugins() {
        return PluginManager.asImmutableCollection();
    }

    /*
    * gives all names of activated Plugins
    */
    public static FluentIterable<String> activatedPluginNames()
    {
       return FluentIterable.from(activatedPlugins()).transform(new Function<Plugin, String>() {
            @Override
            public String apply(Plugin input) {
                return input._pluginName;
            }
        });
    }
}