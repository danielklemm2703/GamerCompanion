package gamercompanion.src.dataManager;

import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableMap;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

import gamercompanion.src.dataObjects.game.GameObject;
import gamercompanion.src.utils.Platform;
import gamercompanion.src.utils.Unit;
import gamercompanion.src.utils.tryUtil.Try;

/**
 * manages the lists of game objects
 */
public class GameObjectManager {
    private static ImmutableMap<Platform, ImmutableCollection<GameObject>> _games;
    static final AtomicReference<GameObjectManager> _instance = new AtomicReference<>();

    GameObjectManager() {
        _games = ImmutableMap.of();
    }

    /*
     * gives all games as immutable map, loads games from DB, if not already done
     */
    public static ImmutableMap<Platform, ImmutableCollection<GameObject>> asImmutableMap()
    {
        initializeIfNotSet(_instance);
        return _instance.get()._games;
    }

    private static void initializeIfNotSet(AtomicReference<GameObjectManager> instance) {
        if (instance.get() == null) {
            instance.set(new GameObjectManager());
        }
    }

    /**
     * inserts new game objects in the manager
     *
     * @param platform
     * @param gamesOfPlatform
     * @return
     */
    public static Try<Unit> insertAndOverwrite(final Platform platform, final ImmutableCollection<GameObject> gamesOfPlatform)
    {
        return Try.of(new Supplier<Unit>() {
            @Override
            public Unit get() {
                initializeIfNotSet(_instance);
                Map<Platform, ImmutableCollection<GameObject>> map = toMap(_games);
                if(map.containsKey(platform))
                {
                    map.remove(platform);
                }
                map.put(platform, gamesOfPlatform);
                _games = ImmutableMap.copyOf(map);
                return Unit.VALUE;
            }
        });
    }

    private static Map<Platform, ImmutableCollection<GameObject>> toMap(ImmutableMap<Platform, ImmutableCollection<GameObject>> games) {
        Map<Platform, ImmutableCollection<GameObject>> map = new HashMap<>();
        for(Platform p:_games.keySet())
        {
            map.put(p,_games.get(p));
        }
        return map;
    }
}
