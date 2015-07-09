package gamercompanion.src.activities;

import android.os.Bundle;

import gamercompanion.src.activities.controlling.ControlledActivity;
import static gamercompanion.src.userInterface.GameDBMenuUserInterface.*;
import gamercompanion.src.utils.Unit;
import gamercompanion.src.utils.tryUtil.Try;

import static gamercompanion.src.error.ErrorUtil.showWarning;

/*
* This class implements overview of the GameDB, displaying the trcaked platforms
*/
public class GameDBMenu extends ControlledActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Try<Unit> tryLayout = drawGameDBMenuInterface();
        if(!tryLayout.isSuccess())
        {
            showWarning(tryLayout.failure().getMessage());
        }
    }
}
