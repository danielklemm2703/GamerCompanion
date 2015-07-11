package gamercompanion.src.synchronizer;

import com.google.common.base.Optional;
import com.google.common.collect.ImmutableCollection;

import gamercompanion.src.dataManager.CredentialsManager;
import gamercompanion.src.dataObjects.credentials.WebCredentials;
import gamercompanion.src.dataOperator.CredentialsOperator;
import gamercompanion.src.error.ErrorUtil;
import gamercompanion.src.utils.Platform;

import gamercompanion.src.utils.Unit;

/**
 * Describes how to proceed with a call to the metacritic all games platform
 */
public class MetascoreAllGames extends WebCall
{
    private static final String WEBSITE = "metacritic";
    private static final String METASCORE_ALL_GAMES_URL_PATTERN = "http://%s:%s@metacritic.com/browse/games/release-date/available/%s/metascore";
    private static final String EMPTY_METASCORE_ALL_GAMES_URL_PATTERN = "http://www.metacritic.com/browse/games/release-date/available/%s/metascore";

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
        Optional<WebCredentials> credentials = CredentialsOperator.credentialsForWebsite(WEBSITE);
        if(!credentials.isPresent())
        {
            ErrorUtil.showWarning("No credentials for website '"+WEBSITE+"' found in system.properties");
            return String.format(EMPTY_METASCORE_ALL_GAMES_URL_PATTERN,_platform());
        }
        return String.format(METASCORE_ALL_GAMES_URL_PATTERN,credentials.get()._username(),credentials.get()._password(),_platform()._allGamesURLname);
    }

    @Override
    public Unit execute() {
        new WebCallTask(this).execute();
        return Unit.VALUE;
    }
}
