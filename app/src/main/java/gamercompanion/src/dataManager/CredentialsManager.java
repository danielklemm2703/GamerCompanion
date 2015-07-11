package gamercompanion.src.dataManager;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableMap;

import java.util.Map;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicReference;

import gamercompanion.src.dataObjects.credentials.WebCredentials;
import gamercompanion.src.dataObjects.plugin.Plugin;
import gamercompanion.src.utils.SystemProperties;

/**
 * Credentials Manager loads all properties from system.properties
 * that are describing WebCredentials for access to the needed web sites
 */
public class CredentialsManager {
    private static final String CREDENTIALS_PREFIX = "credentials";
    static final AtomicReference<CredentialsManager> _instance = new AtomicReference<>();
    private final ImmutableCollection<WebCredentials> _webCredentials;

    CredentialsManager() {
        _webCredentials = loadCredentials();
    }

    private static final ImmutableCollection<WebCredentials> loadCredentials() {
        final ImmutableMap<String, String> systemProperties = SystemProperties.asImmutableMap();

        return FluentIterable.from(systemProperties.keySet()).filter(new Predicate<String>() {
            @Override
            public boolean apply(String input) {
                if (input.startsWith(CREDENTIALS_PREFIX)) {
                    return true;
                }
                return false;
            }
        }).transform(new Function<String, WebCredentials>() {
            @Override
            public WebCredentials apply(String input) {
                return new WebCredentials(input.substring(12), systemProperties.get(input));
            }
        }).toList();
    }

    /*
     * gives all WebCredentials as immutable map, loads them, if not already done
     */
    public static ImmutableCollection<WebCredentials> asImmutableCollection()
    {
        initializeIfNotSet(_instance);
        return _instance.get()._webCredentials;
    }

    private static ImmutableMap<String, String> toImmutableMap(final Properties properties) {
        ImmutableMap.copyOf(properties);
        ImmutableMap.Builder<String, String> b = ImmutableMap.builder();
        for (Map.Entry<Object, Object> e : properties.entrySet()) {
            b.put(e.getKey().toString(), e.getValue().toString());
        }
        return b.build();
    }

    private static void initializeIfNotSet(AtomicReference<CredentialsManager> instance) {
        if (instance.get() == null) {
            instance.set(new CredentialsManager());
        }
    }
}
