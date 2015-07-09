package gamercompanion.src.dataManager;

import com.google.common.base.Function;
import com.google.common.base.Supplier;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;

import java.util.Map;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicReference;

import static gamercompanion.src.activities.controlling.ActivityController.*;
import static gamercompanion.src.error.ErrorUtil.*;
import gamercompanion.src.utils.Platform;
import gamercompanion.src.utils.SystemProperties;
import gamercompanion.src.utils.tryUtil.Try;

/**
 * Platform Manager loads all properties from system.properties
 * that are describing platforms that shall be tracked
 */
public class PlatformManager {
    private static final String PLATFORM_PREFIX = "platforms.to.track";
    static final AtomicReference<PlatformManager> _instance = new AtomicReference<>();
    private final ImmutableCollection<Platform> _platforms;

    PlatformManager() {

        Try<ImmutableCollection<Platform>> platforms = loadPlatforms();
        if(platforms.isSuccess())
        {
            _platforms = platforms.get();
        }
        else
        {
            _platforms = ImmutableSet.of();
            showWarning( platforms.failure().getMessage());
        }

    }

    private static Try<ImmutableCollection<Platform>> loadPlatforms() {
        return Try.of(new Supplier<ImmutableCollection<Platform>>() {
            @Override
            public ImmutableCollection<Platform> get() {
                final ImmutableMap<String, String> systemProperties = SystemProperties.asImmutableMap();
                String platformsToTrack = systemProperties.get(PLATFORM_PREFIX);
                if(platformsToTrack == null || platformsToTrack.isEmpty())
                {
                    throw new IllegalStateException("No Platforms to track in the system properties");
                }
                return FluentIterable.from(ImmutableList.copyOf(platformsToTrack.split(","))).transform(new Function<String, Platform>() {
                    @Override
                    public Platform apply(String input) {
                        Try<Platform> platform = Platform.platformByName(input);
                        if(platform.isSuccess())
                        {
                            return platform.get();
                        }
                        throw new IllegalStateException(platform.failure().getMessage());
                    }
                }).toSet();
            }
        });
    }

    /*
     * gives all properties as immutable map (String, String), loads properties, if not already done
     */
    public static ImmutableCollection<Platform> asImmutableCollection()
    {
        initializeIfNotSet(_instance);
        return _instance.get()._platforms;
    }

    private static ImmutableMap<String, String> toImmutableMap(final Properties properties) {
        ImmutableMap.copyOf(properties);
        ImmutableMap.Builder<String, String> b = ImmutableMap.builder();
        for (Map.Entry<Object, Object> e : properties.entrySet()) {
            b.put(e.getKey().toString(), e.getValue().toString());
        }
        return b.build();
    }

    private static void initializeIfNotSet(AtomicReference<PlatformManager> instance) {
        if (instance.get() == null) {
            instance.set(new PlatformManager());
        }
    }
}
