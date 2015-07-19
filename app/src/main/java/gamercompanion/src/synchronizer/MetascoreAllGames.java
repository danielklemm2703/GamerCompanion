package gamercompanion.src.synchronizer;

import android.util.Pair;

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
    private final int _page;
    private static final String WEBSITE = "metacritic";
    private static final String METASCORE_ALL_GAMES_URL_PATTERN = "http://%s:%s@metacritic.com/browse/games/release-date/available/%s/metascore?page=%d";
    private static final String EMPTY_METASCORE_ALL_GAMES_URL_PATTERN = "http://www.metacritic.com/browse/games/release-date/available/%s/metascore?page=%d";

    public MetascoreAllGames(Platform platform) {
        super(platform);
        _page =0;
    }

    public MetascoreAllGames(Platform platform, int page) {
        super(platform);
        _page =page;
    }

    @Override
    public Try<Unit> computeResult(final String result) {
        final Platform platform = this._platform();
        return Try.of(new Supplier<Unit>() {
            @Override
            public Unit get() {
                //TODO refactor, case handling is super ugly
                ParsingOperator po = new ParsingOperator();
                Try<Pair<Integer, ImmutableCollection<GameObject>>> platformGames = po.parseGamesOfPlatformOfWebsite(platform, result);
                if(!platformGames.isSuccess())
                {
                     throw new IllegalStateException("Could not parse game DB entries: "+platformGames.failure().getMessage());
                }

                if(platformGames.get().first != -1)
                {
                    //take next page entries
                    new MetascoreAllGames(platform, platformGames.get().first).execute();
                }

                // evaluate the results
                if(_page == 0)
                {
                    Try<Unit> unitTry = GameObjectManager.insertAndOverwrite(platform, platformGames.get().second);
                    if(!unitTry.isSuccess())
                    {
                        throw new IllegalStateException(unitTry.failure().getMessage());
                    }
                }
                else
                {
                    Try<Unit> unitTry = GameObjectManager.append(platform, platformGames.get().second);
                    if(!unitTry.isSuccess())
                    {
                        throw new IllegalStateException(unitTry.failure().getMessage());
                    }
                }
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
            return String.format(EMPTY_METASCORE_ALL_GAMES_URL_PATTERN,_platform(),_page);
        }
        return String.format(METASCORE_ALL_GAMES_URL_PATTERN,credentials.get()._username(),credentials.get()._password(),_platform()._allGamesURLname,_page);
    }

    @Override
        public Unit execute() {
        new WebCallTask(this).execute();
        return Unit.VALUE;
    }
}
