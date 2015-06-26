package gamercompanion.src.dataObjects.game;

import gamercompanion.src.utils.Platform;

/**
 * Created by dklemm on 26.06.15.
 */
public class GameObject {
    private String _name;
    private Enum _platform;
    private Integer _metascore;
    private String _meatscoreURLName;

    public GameObject(String name, Platform platform, Integer metascore, String metascoreURLName)
    {
        _name = name;
        _platform = platform;
        _metascore = metascore;
        _meatscoreURLName = metascoreURLName;
    }

    public String get_name() {
        return _name;
    }

    public Enum get_platform() {
        return _platform;
    }

    public Integer get_metascore() {
        return _metascore;
    }

    public String get_meatscoreURLName() {
        return _meatscoreURLName;
    }
}
