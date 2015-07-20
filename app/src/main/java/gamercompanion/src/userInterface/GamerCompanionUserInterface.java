package gamercompanion.src.userInterface;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.google.common.base.Optional;
import com.google.common.base.Supplier;

import gamercompanion.src.activities.GamerCompanion;
import gamercompanion.src.activities.controlling.ActivityController;
import gamercompanion.src.activities.controlling.ControlledActivity;
import gamercompanion.src.dataObjects.plugin.Plugin;
import gamercompanion.src.dataOperator.PluginOperator;
import static gamercompanion.src.error.ErrorUtil.*;

import static gamercompanion.src.synchronizer.Synchronizer.*;

import gamercompanion.src.synchronizer.Synchronizer;
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
                                Intent intent = new Intent(activeActivity, nextActivity.get());
                                activeActivity.startActivity(intent);
                            }
                        }
                    }
                });

                //Set up question to synchronize with the web
                AlertDialog.Builder builder = new AlertDialog.Builder(activeActivity);
                builder.setMessage("Do you want to synchronize your data base with the web?");
                builder.setCancelable(false);
                builder.setTitle("Synchronize");

                builder.setPositiveButton("Synchronize", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        synchronize();
                    }
                });
                builder.setNegativeButton("Take local data", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        showWarning("This is not implemented yet");
                    }
                });

                AlertDialog alert11 = builder.create();
                alert11.show();

                activeActivity.setContentView(relativeLayout, relativeLayoutParams);
                return Unit.VALUE;
            }
        });
    }

    private static Try<Class<?>> getNextActivity(final Plugin plugin) {
        return Try.of(new Supplier<Class<?>>() {
            @Override
            public Class<?> get() {
                return plugin.firstPage();
            }
        });
    }
}
