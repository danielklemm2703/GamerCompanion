package gamercompanion.src.dataObjects.plugin;


import gamercompanion.src.activities.controlling.ControlledActivity;
import gamercompanion.src.utils.Unit;
import gamercompanion.src.utils.tryUtil.Try;

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

    abstract public Try<Unit> executeTasks();

    abstract public Class<? extends ControlledActivity> firstPage();
}
