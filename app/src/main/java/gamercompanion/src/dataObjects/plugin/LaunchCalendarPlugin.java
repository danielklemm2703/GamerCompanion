package gamercompanion.src.dataObjects.plugin;

import com.google.common.base.Supplier;

import gamercompanion.src.activities.LaunchCalendarMenu;
import gamercompanion.src.activities.controlling.ControlledActivity;
import gamercompanion.src.dataOperator.PlatformOperator;
import gamercompanion.src.utils.Platform;
import gamercompanion.src.utils.Unit;
import gamercompanion.src.utils.tryUtil.Try;

/**
 * provides all infos of the launchCalendar plugin
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
                for(Platform p : PlatformOperator.platformsToTrack())
                {
                    //TODO Execute the according tasks
                }
               return Unit.VALUE;
            }
        });
    }

    @Override
    public Class<? extends ControlledActivity> firstPage() {
        return LaunchCalendarMenu.class;
    }
}
