package gamercompanion.src.error;

/**
 * Created by dklemm on 03.07.15.
 */
public enum MessageType {
    ERROR ("Error"),
    WARNING ("Warning"),
    INFO("Information");

    public String _name;

    MessageType(String name)
    {
        this._name = name;
    }
}
