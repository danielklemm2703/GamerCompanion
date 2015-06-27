package gamercompanion.src.dataObjects.game;

import com.google.common.base.Optional;

import gamercompanion.src.dataObjects.gameProgress.GameProgress;
import gamercompanion.src.utils.Platform;

/**
 * DaO for DetailedGameObject
 */
public class DetailedGameObject extends GameObject {
    public String _developer;
    public String _releaseDate;
    public String _genre;
    public String _rating;
    public String _imageURL;
    public Optional<GameOptions> _options;
    public Optional<GameProgress> _gameProgress;

    public DetailedGameObject(String name, Platform platform, Integer metascore, String metascoreURLName,
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
}
