package gamercompanion.src.dataObjects.gameProgress;

import com.google.common.base.Optional;

/**
 * Created by dklemm on 26.06.15.
 */
public class TrophyMilestones {
    private Optional<Trophy> _latestPlatinum;
    private Optional<Trophy> _10thPlatinum;
    private Optional<Trophy> _500thTrophy;
    private Optional<Trophy> _fastestPlatinum;
    private Optional<Trophy> _firstPlatinum;
    private Optional<Trophy> _firstTrophy;

    public TrophyMilestones(Optional<Trophy> latestPlatinum, Optional<Trophy> tenthPlatinum, Optional<Trophy> fivehundretTrophy, Optional<Trophy> fastestPlatinum,
                            Optional<Trophy> firstPlatinum, Optional<Trophy> firstTrophy)
    {
        _latestPlatinum = latestPlatinum;
        _10thPlatinum = tenthPlatinum;
        _500thTrophy = fivehundretTrophy;
        _fastestPlatinum = fastestPlatinum;
        _firstPlatinum = firstPlatinum;
        _firstTrophy = firstTrophy;
    }

    public Optional<Trophy> get_firstTrophy() {
        return _firstTrophy;
    }

    public Optional<Trophy> get_firstPlatinum() {
        return _firstPlatinum;
    }

    public Optional<Trophy> get_fastestPlatinum() {
        return _fastestPlatinum;
    }

    public Optional<Trophy> get_500thTrophy() {
        return _500thTrophy;
    }

    public Optional<Trophy> get_10thPlatinum() {
        return _10thPlatinum;
    }

    public Optional<Trophy> get_latestPlatinum() {
        return _latestPlatinum;
    }
}
