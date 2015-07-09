package gamercompanion.src.userInterface;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.google.common.base.Supplier;

import gamercompanion.src.activities.controlling.ActivityController;
import gamercompanion.src.activities.controlling.ControlledActivity;
import gamercompanion.src.dataOperator.PlatformOperator;
import gamercompanion.src.userInterface.interfaceTools.StableArrayAdapter;
import gamercompanion.src.utils.Unit;
import gamercompanion.src.utils.tryUtil.Try;

/**
 * Draws the UI of the {@link gamercompanion.src.activities.LaunchCalendarMenu} activity
 */
public class LaunchCalendarMenuUserInterface {

    /**
     *   main function to dram the UI
     */
    public static Try<Unit> drawLaunchCalendarMenuInterface()
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
                        android.R.layout.simple_list_item_1, PlatformOperator.namesOfPlatformsToTrack().toList());
                listView.setAdapter(listAdapter);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        //TODO forward to specific Platform DB page
                    }
                });

                activeActivity.setContentView(relativeLayout, relativeLayoutParams);
                return Unit.VALUE;
            }
        });
    }
}
