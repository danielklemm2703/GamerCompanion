package gamercompanion.src.activities;

import android.os.Bundle;

import gamercompanion.src.activities.controlling.ControlledActivity;
import static gamercompanion.src.error.ErrorUtil.*;
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
            //TODO draw Error
        }
        showWarning(this, "Inserted Error Message");
    }
}
