package gamercompanion.src.utils;

//TODO refactor
public enum UrlCall {
    //TODO do sth safe with pw & user
    METACRITIC_SINGLE("danielk2703", "holymonk1234", "metacritic.com/game/"),
    METACRITIC_ALL("danielk2703", "holymonk1234", "metacritic.com/browse/games/release-date/available/");

    public String _username;
    public String _password;
    public String _urlPart;

    UrlCall(String username, String password, String urlPart)
    {
        this._username = username;
        this._password = password;
        this._urlPart = urlPart;
    }
}
