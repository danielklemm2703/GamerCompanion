package gamercompanion.src.activities.controlling;

import android.app.Activity;
import android.content.Context;

/**
 * Has the active displayed activity, necessary for managing systemPropertiesq
 */
public class ActivityController {

    private static Context _activeContext;

    public static Context get_Context() {
        return _activeContext;
    }

    public static void set_activeContext(Context activeContext) {
        _activeContext = activeContext;
    }
}
