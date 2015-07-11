package gamercompanion.test;

import android.test.AndroidTestCase;

import com.google.common.collect.ImmutableCollection;

import gamercompanion.src.activities.controlling.ActivityController;
import gamercompanion.src.dataManager.PluginManager;
import gamercompanion.src.dataObjects.plugin.Plugin;

/**
 * Created by dklemm on 27.06.15.
 */
public class PluginManagerTest extends AndroidTestCase {

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        ActivityController.set_activeContext(getContext());
    }

    public void testAsImmutableCollection() throws Exception {
        ImmutableCollection<Plugin> plugins = PluginManager.asImmutableCollection();
        assertFalse(plugins.isEmpty());
    }
}