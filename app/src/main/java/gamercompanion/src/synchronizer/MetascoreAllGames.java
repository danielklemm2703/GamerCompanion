package gamercompanion.src.synchronizer;

import gamercompanion.src.utils.Platform;

import gamercompanion.src.utils.Unit;

/**
 * Describes how to proceed with a call to the metacritic all games platform
 */
public class MetascoreAllGames extends WebCall
{
    private static final String METASCORE_ALL_GAMES_URL_PATTERN = "http://%s:%s@metacritic.com/browse/games/release-date/available/%s/metascore";

    public MetascoreAllGames(Platform platform) {
        super(platform);
    }

    @Override
    public Unit computeResult(String result) {
        //TODO implement the API to synchronizer
        return Unit.VALUE;
    }

    @Override
    public String computeURL() {
        //TODO password read via system properties
        return String.format(METASCORE_ALL_GAMES_URL_PATTERN,"danielk2703","holymonk1234",_platform()._allGamesURLname);
    }
}
