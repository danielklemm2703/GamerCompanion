package gamercompanion.src.dataObjects.game;

import com.google.common.base.Optional;

import gamercompanion.src.dataObjects.gameProgress.GameProgress;
import gamercompanion.src.utils.Platform;

/**
 * Created by dklemm on 26.06.15.
 */
public class DetailedGameObjcet extends GameObject {
    private String _developer;
    private String _releaseDate;
    private String _genre;
    private String _rating;
    private String _imageURL;
    private Optional<GameOptions> _options;
    private Optional<GameProgress> _gameProgress;


    public DetailedGameObjcet(String name, Platform platform, Integer metascore, String metascoreURLName,
                              String developer, String releaseDate, String genre, String rating,
                              String imageURL, Optional<GameOptions> options, Optional<GameProgress> gameProgress) {
        super(name, platform, metascore, metascoreURLName);
        _developer = developer;
        _releaseDate = releaseDate;
        _genre = genre;
        _rating = rating;
        _imageURL = imageURL;
        _options = options;
        _gameProgress = gameProgress;
    }

    public String get_developer() {
        return _developer;
    }

    public String get_releaseDate() {
        return _releaseDate;
    }

    public String get_genre() {
        return _genre;
    }

    public String get_rating() {
        return _rating;
    }

    public String get_imageURL() {
        return _imageURL;
    }

    public Optional<GameOptions> get_options() {
        return _options;
    }

    public Optional<GameProgress> get_gameProgress() {
        return _gameProgress;
    }
}
