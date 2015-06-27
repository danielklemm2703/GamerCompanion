package gamercompanion.src.dataObjects.gameProgress;

import com.google.common.base.Optional;

/**
 * DaO of RarestTrophies
 */
public class RarestTrophies {
    public Optional<Trophy> _first;
    public Optional<Trophy> _second;
    public Optional<Trophy> _third;
    public Optional<Trophy> _fourth;
    public Optional<Trophy> _fifth;

    public RarestTrophies(Optional<Trophy> first, Optional<Trophy> second, Optional<Trophy> third,
                          Optional<Trophy> fouth, Optional<Trophy> fifth)
    {
        _first = first;
        _second = second;
        _third = third;
        _fourth = fouth;
        _fifth = fifth;
    }
}
