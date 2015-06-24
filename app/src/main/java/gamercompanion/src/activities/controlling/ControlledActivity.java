package gamercompanion.src.activities.controlling;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by dklemm on 21.06.15.
 */
public class ControlledActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityController.set_activeActivity(this);
    }
}
