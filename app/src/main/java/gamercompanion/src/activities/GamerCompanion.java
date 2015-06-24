package gamercompanion.src.activities;

import android.os.Bundle;
import android.widget.ListView;

import com.google.common.collect.ImmutableList;

import java.util.ArrayList;

import gamercompanion.gamercompanion.R;
import gamercompanion.src.activities.controlling.ControlledActivity;
import gamercompanion.src.dataManager.DataManager;
import gamercompanion.src.dataObjects.Plugin;
import gamercompanion.src.userInterface.StableArrayAdapter;


public class GamerCompanion extends ControlledActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Draw all activated plugins from the system.properties as a List
        ImmutableList<Plugin> activatedPlugins = DataManager.getActivatedPlugins();
        //TODO refactor transform
        ArrayList<String> inputList = new ArrayList<String>();
        for(Plugin item : activatedPlugins)
        {
            inputList.add(item.toString());
        }

        StableArrayAdapter listAdapter = new StableArrayAdapter(this,
                android.R.layout.simple_list_item_1, inputList);
        this.listView.setAdapter(listAdapter);

        setContentView(R.layout.activity_gamer_companion);
    }

}
