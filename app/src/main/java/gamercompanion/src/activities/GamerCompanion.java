package gamercompanion.src.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.google.common.base.Function;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;

import java.util.ArrayList;

import gamercompanion.gamercompanion.R;
import gamercompanion.src.activities.controlling.ControlledActivity;
import gamercompanion.src.dataObjects.Plugin;
import gamercompanion.src.dataOperator.PluginOperator;
import gamercompanion.src.userInterface.StableArrayAdapter;


public class GamerCompanion extends ControlledActivity {

    private ListView _listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Defining the RelativeLayout layout parameters with Fill_Parent
        RelativeLayout relativeLayout = new RelativeLayout(this);
        RelativeLayout.LayoutParams relativeLayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.FILL_PARENT, RelativeLayout.LayoutParams.FILL_PARENT);

        _listView = new ListView(this);
        relativeLayout.addView(_listView);

        //Draw all activated plugins from the system.properties as a List
        ImmutableCollection<Plugin> activatedPlugins = PluginOperator.getActivatedPlugins();
        final FluentIterable<String> pluginTitles = FluentIterable.from(activatedPlugins).transform(new Function<Plugin, String>() {
            @Override
            public String apply(Plugin input) {
                return input.get_pluginName();
            }
        });

        StableArrayAdapter listAdapter = new StableArrayAdapter(this,
                android.R.layout.simple_list_item_1, pluginTitles.toList());
        _listView.setAdapter(listAdapter);
        _listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = (String) parent.getAdapter().getItem(position);
//                startDetailsActivity(item);
            }
        });

        setContentView(relativeLayout,relativeLayoutParams);
    }

}
