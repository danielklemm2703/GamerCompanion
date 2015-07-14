package gamercompanion.src.dataObjects.plugin;

import com.google.common.collect.ImmutableCollection;

import gamercompanion.src.activities.GameDBMenu;
import gamercompanion.src.activities.LaunchCalendarMenu;
import gamercompanion.src.activities.controlling.ControlledActivity;
import gamercompanion.src.error.ErrorUtil;
import gamercompanion.src.synchronizer.WebCall;

/**
 * Created by dklemm on 14.07.15.
 */
public class LaunchCalendarPlugin extends Plugin {
    public LaunchCalendarPlugin(String pluginName, String propertyName) {
        super(pluginName,propertyName);
    }

    @Override
    public ImmutableCollection<WebCall> updateTasks() {
        return null;
    }

    @Override
    public Class<? extends ControlledActivity> firstPage() {
        return LaunchCalendarMenu.class;
    }
}
