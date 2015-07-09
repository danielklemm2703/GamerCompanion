package gamercompanion.src.activities;

import android.os.Bundle;

import gamercompanion.src.activities.controlling.ControlledActivity;
import static gamercompanion.src.userInterface.LaunchCalendarMenuUserInterface.*;
import gamercompanion.src.utils.Unit;
import gamercompanion.src.utils.tryUtil.Try;

import static gamercompanion.src.error.ErrorUtil.*;

/**
 * This class implements overview of the LaunchCalender, displaying the trcaked platforms
 */
public class LaunchCalendarMenu extends ControlledActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Try<Unit> tryLayout = drawLaunchCalendarMenuInterface();
        if(!tryLayout.isSuccess())
        {
            showWarning(tryLayout.failure().getMessage());
        }
    }
}
