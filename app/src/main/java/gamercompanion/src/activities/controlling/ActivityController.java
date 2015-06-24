package gamercompanion.src.activities.controlling;

import android.app.Activity;
import android.content.Context;

/**
 * Created by dklemm on 21.06.15.
 */
public class ActivityController {

    private static Activity _activeActivity;

    public static Context get_Context() {
        return _activeActivity;
    }

    public static Activity get_activeActivity() {
        return _activeActivity;
    }

    public static void set_activeActivity(Activity activeActivity) {
        ActivityController._activeActivity = activeActivity;
    }
}
