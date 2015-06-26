package gamercompanion.src.dataObjects.news;

/**
 * Created by dklemm on 26.06.15.
 */
public class NewsObject {
    private String _dateOfPublishment;
    private String _headline;

    public NewsObject(String dateOfPublishment, String headline)
    {
        _dateOfPublishment = dateOfPublishment;
        _headline = headline;
    }

    public String get_dateOfPublishment() {
        return _dateOfPublishment;
    }

    public String get_headline() {
        return _headline;
    }
}
