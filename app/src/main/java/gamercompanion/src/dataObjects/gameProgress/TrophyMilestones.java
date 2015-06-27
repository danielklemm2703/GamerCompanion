package gamercompanion.src.dataObjects.gameProgress;

import com.google.common.base.Optional;

/**
 * DaO of TrophyMilestones
 */
public class TrophyMilestones {
    public Optional<Trophy> _latestPlatinum;
    public Optional<Trophy> _10thPlatinum;
    public Optional<Trophy> _500thTrophy;
    public Optional<Trophy> _fastestPlatinum;
    public Optional<Trophy> _firstPlatinum;
    public Optional<Trophy> _firstTrophy;

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
}
