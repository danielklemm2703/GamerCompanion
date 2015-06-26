package gamercompanion.src.activities;

import android.os.Bundle;

import gamercompanion.src.activities.controlling.ControlledActivity;
import gamercompanion.src.utils.Unit;
import gamercompanion.src.utils.tryUtil.Try;

import static gamercompanion.src.userInterface.GamerCompanionUserInterface.*;


public class GamerCompanion extends ControlledActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Try<Unit> tryUI = drawGamerCompanionInterface(this);
        if(!tryUI.isSuccess())
        {
            //TODO draw Error
        }
    }
}
