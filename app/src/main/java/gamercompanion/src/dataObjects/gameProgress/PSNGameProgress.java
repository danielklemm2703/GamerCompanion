package gamercompanion.src.dataObjects.gameProgress;

import android.content.Intent;

import com.google.common.base.Optional;

import java.util.List;

/**
 * Created by dklemm on 26.06.15.
 */
public class PSNGameProgress extends GameProgress {
    private String _rank;
    private Integer _platinum;
    private Integer _gold;
    private Integer _silver;
    private Integer _bronze;
    private Integer _all;
    private Integer _earned;
    private Integer _progress;
    private Optional<String> _firstTrophyDate;
    private Optional<String> _latestTrophyDate;
    private Optional<String> _gapTime;
    private Optional<String> _platinDate;
    private List<Trophy> _trophies;

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

    public String get_rank() {
        return _rank;
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

    public Integer get_progress() {
        return _progress;
    }

    public Optional<String> get_firstTrophyDate() {
        return _firstTrophyDate;
    }

    public Optional<String> get_latestTrophyDate() {
        return _latestTrophyDate;
    }

    public Optional<String> get_gapTime() {
        return _gapTime;
    }

    public Optional<String> get_platinDate() {
        return _platinDate;
    }

    public List<Trophy> get_trophies() {
        return _trophies;
    }
}
