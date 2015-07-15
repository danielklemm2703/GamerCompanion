package gamercompanion.src.dataOperator;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableCollection;

import gamercompanion.src.dataManager.PlatformManager;
import gamercompanion.src.dataManager.PluginManager;
import gamercompanion.src.dataObjects.plugin.Plugin;
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
    /*
    * returns a platform if the given name represents a plugin
    */
    public static Optional<Platform> getPlatform(final String platformName) {
        return FluentIterable.from(PlatformManager.asImmutableCollection()).filter(new Predicate<Platform>() {
            @Override
            public boolean apply(Platform input) {
                if (input._platform.equals(platformName))
                    return true;
                return false;
            }
        }).first();
    }
}
