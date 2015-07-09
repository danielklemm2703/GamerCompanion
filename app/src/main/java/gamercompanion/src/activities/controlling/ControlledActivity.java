package gamercompanion.src.activities.controlling;

import android.app.Activity;
import android.os.Bundle;

import static gamercompanion.src.activities.controlling.ActivityController.*;
/**
 * Needs to be extended by every activity to handle systemProperties
 */
public class ControlledActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        set_activeContext(this);
        set_activeActivity(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        set_activeContext(this);
        set_activeActivity(this);
    }
}
