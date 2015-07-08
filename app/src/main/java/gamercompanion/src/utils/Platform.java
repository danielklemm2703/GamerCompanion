package gamercompanion.src.utils;

/**
 * This class is intended to provide platform specific data.
 * All Platforms the app can technically track must be registered here.
 * Also extended Data can be held here (e.g. like URL parts etc.)
 */
public enum Platform {

    PS4("Playstation 4", "Sony Computer Entertainment","playstation-4","ps4","ps4"),
    PS3("Playstation 3", "Sony Computer Entertainment","playstation-3","ps3","ps3"),
    PSV("Playstation Vita", "Sony Computer Entertainment","playstation-vita","vita","vita"),
    WIIU("WiiU", "Nintendo","wii-u","wii-u","wii-u"),
    TDS("3DS", "Nintendo","3ds","3ds","3ds"),
    XBO("Xbox One", "Microsoft","xbox-one","xboxone","xboxone"),
    X360("Xbox 360", "Microsoft","xbo-360","xbox360","xbox360"),
    PC("PC", "Microsoft?","pc","pc","pc");

    public String _platform;
    public String _developer;
    public String _singleGameURLname;
    public String _allGamesURLname;
    public String _comingSoonURLname;

    Platform(String platform, String developer, String singleGameURLname, String allGamesURLname, String comingSoonURLname)
    {
        this._developer = developer;
        this._platform = platform;
        this._singleGameURLname = singleGameURLname;
        this._allGamesURLname = allGamesURLname;
        this._comingSoonURLname = comingSoonURLname;
    }
}
