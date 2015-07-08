package gamercompanion.src.activities;

import android.os.Bundle;

import com.google.common.collect.ImmutableCollection;

import gamercompanion.src.activities.controlling.ControlledActivity;
import static gamercompanion.src.error.ErrorUtil.*;

import gamercompanion.src.dataManager.PlatformManager;
import gamercompanion.src.utils.Platform;
import gamercompanion.src.utils.Unit;
import gamercompanion.src.utils.tryUtil.Try;

import static gamercompanion.src.userInterface.GamerCompanionUserInterface.*;

/*
* This class implements the starting activity of GamerCompanion app
*/
public class GamerCompanion extends ControlledActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Try<Unit> tryLayout = drawGamerCompanionInterface(this);
        if(!tryLayout.isSuccess())
        {
            showWarning(this, tryLayout.failure().getMessage());
        }
    }
}
