package gamercompanion.src.synchronizer;

import com.google.common.base.Optional;
import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableCollection;

import gamercompanion.src.dataManager.GameObjectManager;
import gamercompanion.src.dataObjects.credentials.WebCredentials;
import gamercompanion.src.dataObjects.game.GameObject;
import gamercompanion.src.dataOperator.CredentialsOperator;
import static gamercompanion.src.error.ErrorUtil.*;

import gamercompanion.src.utils.ParsingOperator;
import gamercompanion.src.utils.Platform;

import gamercompanion.src.utils.Unit;
import gamercompanion.src.utils.tryUtil.Try;

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
    public Try<Unit> computeResult(final String result) {
        final Platform platform = this._platform();
        return Try.of(new Supplier<Unit>() {
            @Override
            public Unit get() {
                ParsingOperator po = new ParsingOperator();
                Try<ImmutableCollection<GameObject>> platformGames = po.parseGamesOfPlatformOfWebsite(platform, result);
                if(!platformGames.isSuccess())
                {
                     throw new IllegalStateException("Could not parse game DB entries: "+platformGames.failure().getMessage());
                }
                GameObjectManager.insertAndOverwrite(platform, platformGames.get());
                return Unit.VALUE;
            }
        });
    }

    @Override
    public String computeURL() {
        Optional<WebCredentials> credentials = CredentialsOperator.credentialsForWebsite(WEBSITE);
        if(!credentials.isPresent())
        {
            showWarning("No credentials for website '"+WEBSITE+"' found in system.properties");
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
