package gamercompanion.src.dataObjects.game;

import com.google.common.base.Optional;

/**
 * Created by dklemm on 26.06.15.
 */
public class GameOptions {
    private Optional<Boolean> _mine;
    private Optional<Boolean> _whislist;
    private Boolean _news;

    public GameOptions(Optional<Boolean> mine, Optional<Boolean> whislist, Boolean news)
    {
        _mine = mine;
        _whislist = whislist;
        _news = news;
    }
}
