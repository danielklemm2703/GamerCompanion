package gamercompanion.src.activities.controlling;

import android.app.Activity;
import android.os.Bundle;

/**
 * Needs to be extended by every activity to handle systemProperties
 */
public class ControlledActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityController.set_activeContext(this);
    }
}
