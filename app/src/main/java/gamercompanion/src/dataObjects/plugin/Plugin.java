package gamercompanion.src.dataObjects.plugin;

/**
 * DaO of a Plugin
 */
public class Plugin {
    public static final String AMIIBO_PLUGIN ="Amiibo";
    public static final String NEWS_PLUGIN ="News";
    public static final String SEARCH_PLUGIN ="Search";
    public static final String MY_GAMES_PLUGIN ="MyGames";
    public static final String GAMEDB_PLUGIN ="GameDB";
    public static final String LAUNCH_CALENDAR_PLUGIN ="LaunchCalendar";
    public static final String WISHLIST_PLUGIN ="Wishlist";

    public String _propertyName;
    public String _pluginName;

    public Plugin(String propertyName, String pluginName) {
        _propertyName = propertyName;
        _pluginName = pluginName;
    }
}
