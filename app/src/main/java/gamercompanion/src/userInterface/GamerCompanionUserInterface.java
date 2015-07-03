package gamercompanion.src.userInterface;

import android.text.Layout;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.common.base.Supplier;

import gamercompanion.src.activities.GamerCompanion;
import gamercompanion.src.dataOperator.PluginOperator;
import gamercompanion.src.userInterface.interfaceTools.StableArrayAdapter;
import gamercompanion.src.utils.Unit;
import gamercompanion.src.utils.tryUtil.Try;

/**
 * Drawes the UI of the {@link GamerCompanion} activity
 */
public class GamerCompanionUserInterface {

    static Boolean click = true;
    /**
    *   main function to dram the UI
    */
    public static Try<Unit> drawGamerCompanionInterface(final GamerCompanion gamerCompanion)
    {
        return Try.of(new Supplier<Unit>() {
            @Override
            public Unit get() {
                // Defining the RelativeLayout layout parameters with Fill_Parent
                final RelativeLayout relativeLayout = new RelativeLayout(gamerCompanion);
                RelativeLayout.LayoutParams relativeLayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.FILL_PARENT, RelativeLayout.LayoutParams.FILL_PARENT);
                ListView listView = new ListView(gamerCompanion);
                relativeLayout.addView(listView);

                //Draw all activated plugins from the system.properties as a List
                StableArrayAdapter listAdapter = new StableArrayAdapter(gamerCompanion,
                        android.R.layout.simple_list_item_1, PluginOperator.activatedPluginNames().toList());
                listView.setAdapter(listAdapter);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String item = (String) parent.getAdapter().getItem(position);
                        //                startDetailsActivity(item);
                    }
                });

                gamerCompanion.setContentView(relativeLayout, relativeLayoutParams);
                return Unit.VALUE;
            }
        });
    }
}
