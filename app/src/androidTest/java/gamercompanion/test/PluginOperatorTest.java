package gamercompanion.test;

import android.test.AndroidTestCase;

import junit.framework.TestCase;

import gamercompanion.src.activities.controlling.ActivityController;

/**
 * Created by dklemm on 27.06.15.
 */
public class PluginOperatorTest extends AndroidTestCase {

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        ActivityController.set_activeContext(getContext());
    }

    public void testActivatedPlugins() throws Exception {

    }

    public void testActivatedPluginNames() throws Exception {

    }
}