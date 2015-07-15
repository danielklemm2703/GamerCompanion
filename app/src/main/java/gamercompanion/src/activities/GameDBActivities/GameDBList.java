package gamercompanion.src.activities.GameDBActivities;

import android.content.Intent;
import android.os.Bundle;

import com.google.common.base.Optional;

import gamercompanion.src.activities.controlling.ControlledActivity;
import gamercompanion.src.dataOperator.PlatformOperator;
import gamercompanion.src.userInterface.gameDBUserInterface.GameDBListUserInterface;
import gamercompanion.src.userInterface.gameDBUserInterface.GameDBMenuUserInterface;
import gamercompanion.src.utils.Platform;
import gamercompanion.src.utils.Unit;
import gamercompanion.src.utils.tryUtil.Try;

import static gamercompanion.src.error.ErrorUtil.showWarning;

/**
 * shows a list of games according to a platform from the DB
 */
public class GameDBList extends ControlledActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        String platformName = intent.getStringExtra(GameDBMenuUserInterface.EXTRA_MESSAGE);
        setTitle("Game DB -"+platformName);
        Optional<Platform> platformOptional = PlatformOperator.getPlatform(platformName);
        if(!platformOptional.isPresent())
        {
            showWarning("An Error occured while loading the platform Games of '" + platformName + "', is the Name correct and the platform tracked?");
        }
        else
        {
            Try<Unit> tryLayout = GameDBListUserInterface.drawGameDBListInterface(platformOptional.get());
            if(!tryLayout.isSuccess())
            {
                showWarning(tryLayout.failure().getMessage());
            }
        }
    }
}
