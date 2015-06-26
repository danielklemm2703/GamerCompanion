package gamercompanion.src.dataOperator;

import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;

import gamercompanion.src.dataManager.PluginManager;
import gamercompanion.src.dataObjects.Plugin;

/**
 * Created by dklemm on 26.06.15.
 */
public class PluginOperator {
    public static ImmutableCollection<Plugin> getActivatedPlugins() {
        return PluginManager.asImmutableCollection();
    }

}
