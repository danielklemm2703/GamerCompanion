package gamercompanion.src.activities;

import android.os.Bundle;
import android.widget.ListView;

import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;

import java.util.ArrayList;

import gamercompanion.gamercompanion.R;
import gamercompanion.src.activities.controlling.ControlledActivity;
import gamercompanion.src.dataObjects.Plugin;
import gamercompanion.src.dataOperator.PluginOperator;
import gamercompanion.src.userInterface.StableArrayAdapter;


public class GamerCompanion extends ControlledActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Draw all activated plugins from the system.properties as a List
        ImmutableCollection<Plugin> activatedPlugins = PluginOperator.getActivatedPlugins();
        //TODO refactor transform
        ArrayList<String> inputList = new ArrayList<String>();
        for(Plugin item : activatedPlugins)
        {
            inputList.add(item.get_title());
        }

        StableArrayAdapter listAdapter = new StableArrayAdapter(this,
                android.R.layout.simple_list_item_1, inputList);
        this.listView.setAdapter(listAdapter);

        setContentView(R.layout.activity_gamer_companion);
    }

}
