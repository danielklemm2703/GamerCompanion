package gamercompanion.src.dataObjects;

/**
 * Created by dklemm on 24.06.15.
 */
public class Plugin {
    private String _title;

    public Plugin(String title) {
        _title = title;
    }

    public String get_title() {
        return _title;
    }
}
