package gamercompanion.src.dataObjects.gameProgress;

/**
 * DaO of PSN Profile Details
 */
public class PSNProfileDetails {
    public Integer _platinum;
    public Integer _gold;
    public Integer _silver;
    public Integer _bronze;
    public Integer _all;
    public Integer _earned;
    public Integer _unearned;
    public Integer _progress;
    public Integer _playedGames;
    public Integer _completedGames;
    public Integer _countryRank;
    public Integer _countryDiff;
    public Integer _worldRank;
    public Integer _worldDiff;
    public RarestTrophies _rarestTrophies;
    public TrophyMilestones _trophyMilestones;

    public PSNProfileDetails(Integer platinum, Integer gold, Integer silver, Integer bronze, Integer all,
                             Integer earned, Integer unearned, Integer progress, Integer playedGames,
                             Integer completedGames, Integer countryRank, Integer countryDiff,
                             Integer worldRank, Integer worldDiff, RarestTrophies rarestTrophies, TrophyMilestones trophyMilestones)
    {
        _platinum = platinum;
        _gold = gold;
        _silver = silver;
        _bronze = bronze;
        _all = all;
        _earned = earned;
        _unearned = unearned;
        _progress = progress;
        _playedGames = playedGames;
        _completedGames = completedGames;
        _countryRank = countryRank;
        _countryDiff = countryDiff;
        _worldRank = worldRank;
        _worldDiff = worldDiff;
        _rarestTrophies = rarestTrophies;
        _trophyMilestones = trophyMilestones;
    }
}
