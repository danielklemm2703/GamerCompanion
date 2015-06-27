package gamercompanion.test;

import android.test.AndroidTestCase;

import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableCollection;

import junit.framework.TestCase;

import gamercompanion.src.activities.controlling.ActivityController;
import gamercompanion.src.dataObjects.plugin.Plugin;
import gamercompanion.src.dataOperator.PluginOperator;

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
        ImmutableCollection<Plugin> plugins = PluginOperator.activatedPlugins();
        assertTrue(plugins.size()>0);
    }

    public void testActivatedPluginNames() throws Exception {
        FluentIterable<String> pluginNames = PluginOperator.activatedPluginNames();
        assertTrue(pluginNames.contains("News") || pluginNames.contains("GameDB"));
    }
}