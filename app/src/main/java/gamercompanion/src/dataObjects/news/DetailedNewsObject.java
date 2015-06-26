package gamercompanion.src.dataObjects.news;

/**
 * Created by dklemm on 26.06.15.
 */
public class DetailedNewsObject extends NewsObject {
    private String _text;
    private String _imageURL;
    private String _source;

    public DetailedNewsObject(String dateOfPublishment, String headline, String text, String imageURL, String source) {
        super(dateOfPublishment, headline);
        _text = text;
        _imageURL = imageURL;
        _source = source;
    }

    public String get_text() {
        return _text;
    }

    public String get_imageURL() {
        return _imageURL;
    }

    public String get_source() {
        return _source;
    }
}
