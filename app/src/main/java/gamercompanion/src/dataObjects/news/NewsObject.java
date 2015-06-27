package gamercompanion.src.dataObjects.news;

/**
 * DaO of a standard NewsObject
 */
public class NewsObject {
    public String _dateOfPublishment;
    public String _headline;

    public NewsObject(String dateOfPublishment, String headline)
    {
        _dateOfPublishment = dateOfPublishment;
        _headline = headline;
    }
}
