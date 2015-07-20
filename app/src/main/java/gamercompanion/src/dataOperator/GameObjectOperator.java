package gamercompanion.src.dataOperator;

import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import gamercompanion.src.dataManager.GameObjectManager;
import gamercompanion.src.dataObjects.game.GameObject;
import gamercompanion.src.utils.Platform;
import gamercompanion.src.utils.Unit;
import gamercompanion.src.utils.tryUtil.Try;

/**
 *  Provides a bunch of functions related processing information about the Platforms.
 */
public class GameObjectOperator {
    public static ImmutableCollection<GameObject> gamesOfPlatform(Platform platform) {
        ImmutableMap<Platform, ImmutableCollection<GameObject>> allGames = GameObjectManager.asImmutableMap();
        return allGames.get(platform);
    }

    /**
     * inserts new game objects in the manager
     *
     * @param platform
     * @param gamesOfPlatform
     * @return
     */
    public static Try<Unit> insertAndOverwriteInGameBD(final Platform platform, final ImmutableCollection<GameObject> gamesOfPlatform)
    {
        return Try.of(new Supplier<Unit>() {
            @Override
            public Unit get() {
                Map<Platform, ImmutableCollection<GameObject>> map = toMap(GameObjectManager.asImmutableMap());
                if(map.containsKey(platform))
                {
                    map.remove(platform);
                }
                map.put(platform, gamesOfPlatform);
                GameObjectManager.set_games(ImmutableMap.copyOf(map));
                return Unit.VALUE;
            }
        });
    }

    private static Map<Platform, ImmutableCollection<GameObject>> toMap(ImmutableMap<Platform, ImmutableCollection<GameObject>> games) {
        Map<Platform, ImmutableCollection<GameObject>> map = new HashMap<>();
        for(Platform p:games.keySet())
        {
            map.put(p,games.get(p));
        }
        return map;
    }

    public static Try<Unit> appendInGameDB(final Platform platform, final ImmutableCollection<GameObject> gameObjects) {
        return Try.of(new Supplier<Unit>() {
            @Override
            public Unit get() {
                Map<Platform, ImmutableCollection<GameObject>> map = toMap(GameObjectManager.asImmutableMap());
                if (map.containsKey(platform)) {
                    //TODO refactor this copy handling!
                    ImmutableCollection<GameObject> immuListGames = map.get(platform);
                    GameObject[] gamesAsArray = immuListGames.toArray(new GameObject[200]);
                    List<GameObject> gamesList = new ArrayList<>();
                    gamesList.addAll(Arrays.asList(gamesAsArray));
                    gamesList.addAll(gameObjects);
                    ImmutableList<GameObject> newGameList = ImmutableList.copyOf(gamesList);
                    map.remove(platform);
                    map.put(platform, newGameList);
                    GameObjectManager.set_games(ImmutableMap.copyOf(map));
                } else {
                    map.put(platform, gameObjects);
                    GameObjectManager.set_games(ImmutableMap.copyOf(map));
                }
                return Unit.VALUE;
            }
        });
    }
}
