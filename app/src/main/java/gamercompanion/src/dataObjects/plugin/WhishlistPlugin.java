package gamercompanion.src.dataObjects.plugin;

import com.google.common.collect.ImmutableCollection;

import gamercompanion.src.activities.GameDBMenu;
import gamercompanion.src.activities.controlling.ControlledActivity;
import gamercompanion.src.error.ErrorUtil;
import gamercompanion.src.synchronizer.WebCall;

/**
 * Created by dklemm on 14.07.15.
 */
public class WhishlistPlugin extends Plugin {
    public WhishlistPlugin(String pluginName, String propertyName) {
        super(pluginName,propertyName);
    }

    @Override
    public ImmutableCollection<WebCall> updateTasks() {
        return null;
    }

    @Override
    public Class<? extends ControlledActivity> firstPage() {
        ErrorUtil.showWarning("Not implemented yet");
        return null;
    }
}
