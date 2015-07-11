package gamercompanion.src.dataOperator;

import com.google.common.base.Function;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableCollection;

import gamercompanion.src.dataManager.PlatformManager;
import gamercompanion.src.utils.Platform;

/**
 * Provides a bunch of functions related processing information about the Platforms.
 */
public class PlatformOperator {
    /**
     * gives all platforms to track
     */
    public static ImmutableCollection<Platform> platformsToTrack() {
        return PlatformManager.asImmutableCollection();
    }

    /*
    * gives all names of platforms to track
    */
    public static FluentIterable<String> namesOfPlatformsToTrack()
    {
        return FluentIterable.from(platformsToTrack()).transform(new Function<Platform, String>() {
            @Override
            public String apply(Platform input) {
                return input._platform;
            }
        });
    }
}
