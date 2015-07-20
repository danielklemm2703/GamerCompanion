package gamercompanion.src.dataManager;

import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
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

    public static void set_games(ImmutableMap<Platform, ImmutableCollection<GameObject>> games)
    {
        _games = games;
    }

}
