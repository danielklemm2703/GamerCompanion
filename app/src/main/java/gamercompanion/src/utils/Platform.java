package gamercompanion.src.utils;

import com.google.common.base.Supplier;

import gamercompanion.src.utils.tryUtil.Try;

/**
 * This class is intended to provide platform specific data.
 * All Platforms the app can technically track must be registered here.
 * Also extended Data can be held here (e.g. like URL parts etc.)
 */
public enum Platform {

    PS4("Playstation 4", "Sony Computer Entertainment","playstation-4","ps4","ps4","ps4"),
    PS3("Playstation 3", "Sony Computer Entertainment","playstation-3","ps3","ps3","ps3"),
    PSV("Playstation Vita", "Sony Computer Entertainment","playstation-vita","vita","vita","psv"),
    WIIU("WiiU", "Nintendo","wii-u","wii-u","wii-u","wiiu"),
    TDS("3DS", "Nintendo","3ds","3ds","3ds","3ds"),
    XBO("Xbox One", "Microsoft","xbox-one","xboxone","xboxone","xbo"),
    X360("Xbox 360", "Microsoft","xbox-360","xbox360","xbox360","x360"),
    PC("PC", "Microsoft?","pc","pc","pc","pc");

    public String _platform;
    public String _developer;
    public String _singleGameURLname;
    public String _allGamesURLname;
    public String _comingSoonURLname;
    public String _systemPropertiesName;

    Platform(String platform, String developer, String singleGameURLname, String allGamesURLname, String comingSoonURLname, String systemPropertiesName)
    {
        this._developer = developer;
        this._platform = platform;
        this._singleGameURLname = singleGameURLname;
        this._allGamesURLname = allGamesURLname;
        this._comingSoonURLname = comingSoonURLname;
        this._systemPropertiesName = systemPropertiesName;
    }

    public static final Try<Platform> platformByName(final String systemPropertiesName)
    {
        return Try.of(new Supplier<Platform>() {
            @Override
            public Platform get() {
                for(Platform p : values())
                {
                    if(p._systemPropertiesName.equals(systemPropertiesName))
                    {
                        return p;
                    }
                }
                throw new IllegalStateException("The requested Platform '"+systemPropertiesName+"' is not a valid Platform");
            }
        });
    }
}
