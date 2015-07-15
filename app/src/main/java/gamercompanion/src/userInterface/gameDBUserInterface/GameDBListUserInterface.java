package gamercompanion.src.userInterface.gameDBUserInterface;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.google.common.base.Function;
import com.google.common.base.Supplier;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableCollection;

import gamercompanion.src.activities.controlling.ActivityController;
import gamercompanion.src.activities.controlling.ControlledActivity;
import gamercompanion.src.dataObjects.game.GameObject;
import gamercompanion.src.dataOperator.GameObjectOperator;
import gamercompanion.src.dataOperator.PlatformOperator;
import gamercompanion.src.userInterface.interfaceTools.StableArrayAdapter;
import gamercompanion.src.utils.Platform;
import gamercompanion.src.utils.Unit;
import gamercompanion.src.utils.tryUtil.Try;

/**
 * draws the list of games
 */
public class GameDBListUserInterface {
    public static Try<Unit> drawGameDBListInterface(final Platform platform) {
        return Try.of(new Supplier<Unit>() {
            @Override
            public Unit get() {
                final ControlledActivity activeActivity = ActivityController.get_activeActivity();
                // Defining the RelativeLayout layout parameters with Fill_Parent
                final RelativeLayout relativeLayout = new RelativeLayout(activeActivity);
                RelativeLayout.LayoutParams relativeLayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.FILL_PARENT, RelativeLayout.LayoutParams.FILL_PARENT);
                ListView listView = new ListView(activeActivity);
                relativeLayout.addView(listView);

                ImmutableCollection<GameObject> games = GameObjectOperator.gamesOfPlatform(platform);
                ImmutableCollection<String> gamesToDisplay = toDisplay(games);

                //Draw all activated plugins from the system.properties as a List
                StableArrayAdapter listAdapter = new StableArrayAdapter(activeActivity,
                        android.R.layout.simple_list_item_1, gamesToDisplay.asList());
                listView.setAdapter(listAdapter);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                        String itemName = (String) parent.getAdapter().getItem(position);
//                        Optional<Platform> platform = PlatformOperator.getPlatform(itemName);
//                        if(!platform.isPresent())
//                        {
//                            showWarning("An Error occured while loading the platform Games of '" + itemName + "', is the Name correct and the platform tracked?");
//                        }
//                        else
//                        {
//                            //TODO forward to next activity
//                        }
                    }
                });

                activeActivity.setContentView(relativeLayout, relativeLayoutParams);
                return Unit.VALUE;
            }
        });
    }

    private static ImmutableCollection<String> toDisplay(ImmutableCollection<GameObject> games) {
        return FluentIterable.from(games).transform(new Function<GameObject, String>() {
            @Override
            public String apply(GameObject game) {
                return game._metascore+" "+game._name;
            }
        }).toSet();
    }
}
