package gamercompanion.src.dataObjects.plugin;

import com.google.common.collect.ImmutableCollection;

import gamercompanion.src.activities.GameDBMenu;
import gamercompanion.src.activities.controlling.ControlledActivity;
import gamercompanion.src.synchronizer.MetascoreAllGames;
import gamercompanion.src.synchronizer.WebCall;

/**
 * Created by dklemm on 14.07.15.
 */
public class GameDBPlugin extends Plugin {
    public GameDBPlugin(String pluginName, String propertyName) {
        super(pluginName,propertyName);
    }

    @Override
    public ImmutableCollection<WebCall> updateTasks() {
        //TODO all platforms to track should become a call
        new MetascoreAllGames();

        return null;
    }

    @Override
    public Class<? extends ControlledActivity> firstPage() {
        return GameDBMenu.class;
    }


}
