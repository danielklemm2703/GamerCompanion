package gamercompanion.test;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.test.ActivityInstrumentationTestCase2;
import android.test.AndroidTestCase;
import android.test.InstrumentationTestCase;

import com.google.common.base.Optional;
import com.google.common.collect.ImmutableMap;

import gamercompanion.src.activities.GamerCompanion;
import gamercompanion.src.activities.controlling.ActivityController;
import gamercompanion.src.utils.SystemProperties;
/**
 * Created by dklemm on 27.06.15.
 */
public class SystemPropertiesTest extends AndroidTestCase {

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        ActivityController.set_activeContext(getContext());
    }

    public void testAsImmutableMap() throws Exception {
        ImmutableMap<String, String> properties = SystemProperties.asImmutableMap();
        assertTrue(properties.size() > 0);
        assertTrue(properties.containsKey("platforms.to.track"));
    }

    public void testGetProperty() throws Exception {
        Optional<String> property = SystemProperties.getProperty("platforms.to.track");
        assertTrue(property.isPresent());
        assertTrue(!property.get().isEmpty());
    }
}