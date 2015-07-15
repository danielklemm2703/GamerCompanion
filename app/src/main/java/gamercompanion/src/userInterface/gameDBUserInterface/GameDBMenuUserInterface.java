package gamercompanion.src.userInterface.gameDBUserInterface;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.google.common.base.Optional;
import com.google.common.base.Supplier;

import gamercompanion.src.activities.GameDBActivities.GameDBList;
import gamercompanion.src.activities.GameDBActivities.GameDBMenu;
import gamercompanion.src.activities.controlling.ActivityController;
import gamercompanion.src.activities.controlling.ControlledActivity;
import gamercompanion.src.dataOperator.PlatformOperator;
import gamercompanion.src.userInterface.interfaceTools.StableArrayAdapter;
import gamercompanion.src.utils.Platform;
import gamercompanion.src.utils.Unit;
import gamercompanion.src.utils.tryUtil.Try;

import static gamercompanion.src.error.ErrorUtil.showCriticalError;
import static gamercompanion.src.error.ErrorUtil.showWarning;

/**
 * Drawes the UI of the {@link GameDBMenu} activity
 */
public class GameDBMenuUserInterface {
    public final static String EXTRA_MESSAGE = "gamercompanion.MESSAGE";
    /**
     *   main function to dram the UI
     */
    public static Try<Unit> drawGameDBMenuInterface() {
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
                        android.R.layout.simple_list_item_1, PlatformOperator.namesOfPlatformsToTrack().toList());
                listView.setAdapter(listAdapter);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String itemName = (String) parent.getAdapter().getItem(position);
                        Optional<Platform> platform = PlatformOperator.getPlatform(itemName);
                        if(!platform.isPresent())
                        {
                            showWarning("An Error occured while loading the platform Games of '" + itemName + "', is the Name correct and the platform tracked?");
                        }
                        else
                        {
                            Intent intent = new Intent(activeActivity, GameDBList.class);
                            intent.putExtra(EXTRA_MESSAGE, platform.get()._platform);
                            activeActivity.startActivity(intent);
                        }
                    }
                });

                activeActivity.setContentView(relativeLayout, relativeLayoutParams);
                return Unit.VALUE;
            }
        });
    }
}
