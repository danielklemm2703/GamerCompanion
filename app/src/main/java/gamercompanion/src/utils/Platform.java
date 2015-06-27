package gamercompanion.src.utils;

/**
 * This class is intended to provide platform specific data.
 * All Platforms the app can technically track must be registered here.
 * Also extended Data can be held here (e.g. like URL parts etc.)
 */
public enum Platform {

    PS4("Playstation 4", "Sony"),
    WIIU("WiiU", "Nintendo"),
    TDS("3DS", "Nintendo");

    public String _platform;
    public String _developer;

    Platform(String platform, String developer)
    {
        this._developer = developer;
        this._platform = platform;
    }
}
