package gamercompanion.src.dataObjects.gameProgress;

import com.google.common.base.Optional;

/**
 * Created by dklemm on 26.06.15.
 */
public class RarestTrophies {
    private Optional<Trophy> _first;
    private Optional<Trophy> _second;
    private Optional<Trophy> _third;
    private Optional<Trophy> _fourth;
    private Optional<Trophy> _fifth;

    public RarestTrophies(Optional<Trophy> first, Optional<Trophy> second, Optional<Trophy> third,
                          Optional<Trophy> fouth, Optional<Trophy> fifth)
    {
        _first = first;
        _second = second;
        _third = third;
        _fourth = fouth;
        _fifth = fifth;
    }

    public Optional<Trophy> get_first() {
        return _first;
    }

    public Optional<Trophy> get_second() {
        return _second;
    }

    public Optional<Trophy> get_third() {
        return _third;
    }

    public Optional<Trophy> get_fourth() {
        return _fourth;
    }

    public Optional<Trophy> get_fifth() {
        return _fifth;
    }
}
