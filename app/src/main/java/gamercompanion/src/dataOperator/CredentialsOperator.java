package gamercompanion.src.dataOperator;

import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;

import gamercompanion.src.dataManager.CredentialsManager;
import gamercompanion.src.dataObjects.credentials.WebCredentials;

/**
 * Provides a bunch of functions related processing information about the credentials to a web site.
 */
public class CredentialsOperator {

    public static Optional<WebCredentials> credentialsForWebsite(final String website) {
        return  FluentIterable.from(CredentialsManager.asImmutableCollection()).filter(new Predicate<WebCredentials>() {
            @Override
            public boolean apply(WebCredentials input) {
                if (website.equals(input._website())) {
                    return true;
                }
                return false;
            }
        }).first();
    }
}
