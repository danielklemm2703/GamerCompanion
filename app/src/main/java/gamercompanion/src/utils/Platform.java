package gamercompanion.src.utils;

/**
 * Created by dklemm on 09.06.15.
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
