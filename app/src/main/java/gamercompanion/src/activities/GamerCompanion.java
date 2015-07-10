package gamercompanion.src.activities;

import android.os.Bundle;

import gamercompanion.src.activities.controlling.ControlledActivity;
import static gamercompanion.src.error.ErrorUtil.*;

import gamercompanion.src.utils.Platform;
import gamercompanion.src.utils.Unit;
import gamercompanion.src.utils.tryUtil.Try;
import gamercompanion.src.synchronizer.WebCallTask;
import gamercompanion.src.synchronizer.MetascoreAllGames;

import static gamercompanion.src.userInterface.GamerCompanionUserInterface.*;

/*
* This class implements the starting activity of GamerCompanion app
*/
public class GamerCompanion extends ControlledActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Try<Unit> tryLayout = drawGamerCompanionInterface();
        if(!tryLayout.isSuccess())
        {
            showWarning(tryLayout.failure().getMessage());
        }
        new WebCallTask(new MetascoreAllGames(Platform.PS4)).execute();
    }
}
