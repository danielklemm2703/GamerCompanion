package gamercompanion.src.dataObjects.game;

import com.google.common.base.Optional;

/**
 * DaO of GameOptions
 */
public class GameOptions {
    public Optional<Boolean> _mine;
    public Optional<Boolean> _whislist;
    public Boolean _news;

    public GameOptions(Optional<Boolean> mine, Optional<Boolean> whislist, Boolean news)
    {
        _mine = mine;
        _whislist = whislist;
        _news = news;
    }
}
