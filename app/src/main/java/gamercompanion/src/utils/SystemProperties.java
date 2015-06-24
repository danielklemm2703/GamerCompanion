package gamercompanion.src.utils; /**
 * Created by Zapdos on 16.06.2015.
 */

import android.content.Context;
import android.content.res.AssetManager;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableMap;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicReference;

import gamercompanion.src.activities.controlling.ActivityController;
import gamercompanion.src.utils.tryUtil.Try;

/**
 * provides properties as an immutable map
 * runs through default.properties file first, then overwrites doubled entries,
   when reading the editable system.properties
 */
public final class SystemProperties {

    public static final String SYSTEM_PROPERTIES = "system.properties";
    static final AtomicReference<SystemProperties> _instance = new AtomicReference<>();
    private final ImmutableMap<String, String> _properties;

    // loads the system properties and default properties
    SystemProperties() {
        _properties = loadProperties(SYSTEM_PROPERTIES);
    }

    // gives all properties as immutable map (String, String), loads properties, if not already done
    public static ImmutableMap<String,String> asImmutableMap()
    {
        initializeIfNotSet(_instance);
        return _instance.get()._properties;
    }

    private static void initializeIfNotSet(AtomicReference<SystemProperties> instance) {
        if (instance.get() == null) {
            instance.set(new SystemProperties());
        }
    }

    // gives property according to the given string as an optional
    public static Optional<String> getProperty(String key)
    {
        Preconditions.checkNotNull(key, "Argument 'key' must not be null");
        if(asImmutableMap().containsKey(key))
        {
            return Optional.of(asImmutableMap().get(key));
        }
        return Optional.absent();
    }

    private static ImmutableMap<String, String> loadProperties(final String file) {
        Try<Properties> properties = readProperties(file);
        if(properties.isSuccess())
        {
            return toImmutableMap(properties.get());
        }
        //TODO Error class should handle this
        System.err.println(properties.failure().toString());
        return toImmutableMap(new Properties());
    }

    private static Try<Properties> readProperties(final String file) {
        return Try.of(new Supplier<Properties>() {
            @Override
            public Properties get() {
                try {
                    Properties properties = new Properties();
                    Context context = ActivityController.get_Context();
                    AssetManager assetManager = context.getAssets();
                    InputStream inputStream = null;
                    inputStream = assetManager.open(file);
                    properties.load(inputStream);
                    return properties;
                } catch (IOException e) {
                    throw new RuntimeException("PropertiesFile was not found: "+file);
                }
            }
        });
    }

    private static ImmutableMap<String, String> toImmutableMap(final Properties properties) {
        ImmutableMap.copyOf(properties);
        ImmutableMap.Builder<String, String> b = ImmutableMap.builder();
        for (Map.Entry<Object, Object> e : properties.entrySet()) {
            b.put(e.getKey().toString(), e.getValue().toString());
        }
        return b.build();
    }

}
