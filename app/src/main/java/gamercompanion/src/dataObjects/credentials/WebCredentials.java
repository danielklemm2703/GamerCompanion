package gamercompanion.src.dataObjects.credentials;

import static com.google.common.base.Preconditions.*;
import static gamercompanion.src.error.ErrorUtil.*;

/**
 * WebCredentials holds the username and password and the website that is called to work with it
 */
public class WebCredentials {
    private String _username;
    private String _password;
    private String _website;

    public WebCredentials(String credentialsAtribute, String credentials) {
        checkNotNull(credentials, "Argument 'credentials' must not be null");
        checkNotNull(credentialsAtribute, "Argument 'credentialsAtribute' must not be null");

        String[] split = credentialsAtribute.split("_");
        if(split == null || split.length <2)
        {
            showWarning("An Error parsing the credentials from system.properties occured. Do you have a typo in the key attribute?");
            return;
        }

        _website = split[0];

        String[] strings = credentials.split(":");
        if(split == null || split.length != 2)
        {
            showWarning("An Error encoding the credentials from system.properties occured. ':' is not allowed in the username or password");
            return;
        }

        _username = strings[0];
        _password = strings[1];
    }

    public String _username() {
        return _username;
    }

    public String _password() {
        return _password;
    }

    public String _website() {
        return _website;
    }
}
