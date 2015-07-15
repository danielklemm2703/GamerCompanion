package gamercompanion.src.dataObjects.plugin;

import com.google.common.base.Supplier;

import gamercompanion.src.activities.LaunchCalendarMenu;
import gamercompanion.src.activities.controlling.ControlledActivity;
import gamercompanion.src.utils.Unit;
import gamercompanion.src.utils.tryUtil.Try;

/**
 * Created by dklemm on 14.07.15.
 */
public class LaunchCalendarPlugin extends Plugin {
    public LaunchCalendarPlugin(String pluginName, String propertyName) {
        super(pluginName,propertyName);
    }

    @Override
    public Try<Unit> executeTasks() {
        return Try.of(new Supplier<Unit>() {
            @Override
            public Unit get() {
                return null;
            }
        });
    }

    @Override
    public Class<? extends ControlledActivity> firstPage() {
        return LaunchCalendarMenu.class;
    }
}
