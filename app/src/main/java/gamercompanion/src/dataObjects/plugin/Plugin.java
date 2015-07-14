package gamercompanion.src.dataObjects.plugin;

import com.google.common.collect.ImmutableCollection;

import gamercompanion.src.activities.GameDBMenu;
import gamercompanion.src.activities.controlling.ControlledActivity;
import gamercompanion.src.synchronizer.WebCall;

/**
 * DaO of a Plugin
 */
public abstract class Plugin {
    //TODO plugin needs to define a priority
    //e.g. GameDB must be loaded before news checkup makes sense
    private final String _pluginName;
    private final String _propertyName;

    public Plugin(String pluginName, String propertyName)
    {
        _pluginName= pluginName;
        _propertyName = propertyName;
    }

    public String propertyName()
    {
        return _propertyName;
    }

    public String pluginName()
    {
        return _pluginName;
    }

    abstract public ImmutableCollection<WebCall> updateTasks();

    abstract public Class<? extends ControlledActivity> firstPage();
}
