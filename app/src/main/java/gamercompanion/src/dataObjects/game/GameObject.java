package gamercompanion.src.dataObjects.game;

import gamercompanion.src.utils.Platform;

/**
 * DaO for the basic GameObject
 */
public class GameObject {
    public String _name;
    public Enum _platform;
    public Integer _metascore;
    public String _meatscoreURLName;

    public GameObject(String name, Platform platform, Integer metascore, String metascoreURLName)
    {
        _name = name;
        _platform = platform;
        _metascore = metascore;
        _meatscoreURLName = metascoreURLName;
    }
}
