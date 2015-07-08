package gamercompanion.src.activities.controlling;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import gamercompanion.src.utils.Unit;

/**
 * Needs to be extended by every activity to handle systemProperties
 */
public class ControlledActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityController.set_activeContext(this);
        ActivityController.set_activeActivity(this);
    }
}
