package gamercompanion.src.dataObjects;

/**
 * Created by dklemm on 24.06.15.
 */
public class Plugin {
    private String _title;
    private String _pluginName;

    public Plugin(String title, String pluginName) {
        _title = title;
        _pluginName = pluginName;
    }

    public String get_title() {
        return _title;
    }

    public String get_pluginName() {
        return _pluginName;
    }
}
