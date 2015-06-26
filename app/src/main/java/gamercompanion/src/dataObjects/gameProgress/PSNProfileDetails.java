package gamercompanion.src.dataObjects.gameProgress;

/**
 * Created by dklemm on 26.06.15.
 */
public class PSNProfileDetails {
    private Integer _platinum;
    private Integer _gold;
    private Integer _silver;
    private Integer _bronze;
    private Integer _all;
    private Integer _earned;
    private Integer _unearned;
    private Integer _progress;
    private Integer _playedGames;
    private Integer _completedGames;
    private Integer _countryRank;
    private Integer _countryDiff;
    private Integer _worldRank;
    private Integer _worldDiff;
    private RarestTrophies _rarestTrophies;
    private TrophyMilestones _trophyMilestones;

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

    public Integer get_platinum() {
        return _platinum;
    }

    public Integer get_gold() {
        return _gold;
    }

    public Integer get_silver() {
        return _silver;
    }

    public Integer get_bronze() {
        return _bronze;
    }

    public Integer get_all() {
        return _all;
    }

    public Integer get_earned() {
        return _earned;
    }

    public Integer get_unearned() {
        return _unearned;
    }

    public Integer get_progress() {
        return _progress;
    }

    public Integer get_playedGames() {
        return _playedGames;
    }

    public Integer get_completedGames() {
        return _completedGames;
    }

    public Integer get_countryRank() {
        return _countryRank;
    }

    public Integer get_countryDiff() {
        return _countryDiff;
    }

    public Integer get_worldRank() {
        return _worldRank;
    }

    public Integer get_worldDiff() {
        return _worldDiff;
    }

    public RarestTrophies get_rarestTrophies() {
        return _rarestTrophies;
    }

    public TrophyMilestones get_trophyMilestones() {
        return _trophyMilestones;
    }
}
