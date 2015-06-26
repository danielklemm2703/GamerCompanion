package gamercompanion.src.dataObjects.plugin;

/**
 * Created by dklemm on 24.06.15.
 */
public class Plugin {
    private String _propertyName;
    private String _pluginName;

    public Plugin(String propertyName, String pluginName) {
        _propertyName = propertyName;
        _pluginName = pluginName;
    }

    public String get_propertyName() {
        return _propertyName;
    }

    public String get_pluginName() {
        return _pluginName;
    }
}
