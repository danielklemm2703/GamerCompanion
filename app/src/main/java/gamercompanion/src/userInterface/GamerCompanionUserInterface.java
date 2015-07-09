package gamercompanion.src.userInterface;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.google.common.base.Optional;
import com.google.common.base.Supplier;

import gamercompanion.src.activities.GameDBMenu;
import gamercompanion.src.activities.GamerCompanion;
import gamercompanion.src.activities.LaunchCalendarMenu;
import gamercompanion.src.activities.controlling.ActivityController;
import gamercompanion.src.activities.controlling.ControlledActivity;
import gamercompanion.src.dataObjects.plugin.Plugin;
import gamercompanion.src.dataOperator.PluginOperator;
import static gamercompanion.src.error.ErrorUtil.*;
import gamercompanion.src.userInterface.interfaceTools.StableArrayAdapter;
import gamercompanion.src.utils.Unit;
import gamercompanion.src.utils.tryUtil.Try;

/**
 * Draws the UI of the {@link GamerCompanion} activity
 */
public class GamerCompanionUserInterface {

    /**
    *   main function to dram the UI
    */
    public static Try<Unit> drawGamerCompanionInterface()
    {
        return Try.of(new Supplier<Unit>() {
            @Override
            public Unit get() {
                final ControlledActivity activeActivity = ActivityController.get_activeActivity();
                // Defining the RelativeLayout layout parameters with Fill_Parent
                final RelativeLayout relativeLayout = new RelativeLayout(activeActivity);
                RelativeLayout.LayoutParams relativeLayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.FILL_PARENT, RelativeLayout.LayoutParams.FILL_PARENT);
                ListView listView = new ListView(activeActivity);
                relativeLayout.addView(listView);

                //Draw all activated plugins from the system.properties as a List
                StableArrayAdapter listAdapter = new StableArrayAdapter(activeActivity,
                        android.R.layout.simple_list_item_1, PluginOperator.activatedPluginNames().toList());
                listView.setAdapter(listAdapter);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String itemName = (String) parent.getAdapter().getItem(position);
                        Optional<Plugin> plugin = PluginOperator.getPlugin(itemName);
                        if(!plugin.isPresent())
                        {
                            showCriticalError( "An Error occured while loading the plugin '" + itemName + "'");
                        }
                        else
                        {
                            Try<Class<?>> nextActivity = getNextActivity(plugin.get());
                            if(!nextActivity.isSuccess())
                            {
                                showWarning( nextActivity.failure().getMessage());
                            }
                            else
                            {
                                Intent intent = new Intent(activeActivity, nextActivity.get() );
                                activeActivity.startActivity(intent);
                            }
                        }
                    }
                });

                activeActivity.setContentView(relativeLayout, relativeLayoutParams);
                return Unit.VALUE;
            }
        });
    }

    private static Try<Class<?>> getNextActivity(final Plugin plugin) {
        return Try.of(new Supplier<Class<?>>() {
            @Override
            public Class<?> get() {
                String pluginName = plugin._pluginName;
                if(pluginName.equals(Plugin.GAMEDB_PLUGIN))
                {
                    return GameDBMenu.class;
                }
                if(pluginName.equals(Plugin.LAUNCH_CALENDAR_PLUGIN))
                {
                    return LaunchCalendarMenu.class;
                }
                //TODO register next plugins here
                throw new IllegalStateException("Plugin '"+ pluginName +"' may not be implemented yet");
            }
        });
    }
}
