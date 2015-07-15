package gamercompanion.src.dataOperator;

import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableMap;

import gamercompanion.src.dataManager.GameObjectManager;
import gamercompanion.src.dataObjects.game.GameObject;
import gamercompanion.src.utils.Platform;

/**
 *  Provides a bunch of functions related processing information about the Platforms.
 */
public class GameObjectOperator {
    public static ImmutableCollection<GameObject> gamesOfPlatform(Platform platform) {
        ImmutableMap<Platform, ImmutableCollection<GameObject>> allGames = GameObjectManager.asImmutableMap();
        return allGames.get(platform);
    }
}
