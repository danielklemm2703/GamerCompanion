package gamercompanion.src.dataObjects.gameProgress;

import android.content.Intent;

import com.google.common.base.Optional;

import java.util.List;

/**
 * DaO of PSNGameProgress
 */
public class PSNGameProgress extends GameProgress {
    public String _rank;
    public Integer _platinum;
    public Integer _gold;
    public Integer _silver;
    public Integer _bronze;
    public Integer _all;
    public Integer _earned;
    public Integer _progress;
    public Optional<String> _firstTrophyDate;
    public Optional<String> _latestTrophyDate;
    public Optional<String> _gapTime;
    public Optional<String> _platinDate;
    public List<Trophy> _trophies;

    public PSNGameProgress(String rank, Integer platinum, Integer gold, Integer silver, Integer bronze, Integer all,
                           Integer earned, Integer progress, Optional<String> firstTrophyDate, Optional<String> latestTrophyDate,
                           Optional<String> gapTime, Optional<String> platinDate, List<Trophy> trophies)
    {
        _rank = rank;
        _platinum = platinum;
        _gold = gold;
        _silver = silver;
        _bronze = bronze;
        _all = all;
        _earned =earned;
        _progress = progress;
        _firstTrophyDate = firstTrophyDate;
        _latestTrophyDate = latestTrophyDate;
        _gapTime = gapTime;
        _platinDate = platinDate;
        _trophies = trophies;
    }
}
