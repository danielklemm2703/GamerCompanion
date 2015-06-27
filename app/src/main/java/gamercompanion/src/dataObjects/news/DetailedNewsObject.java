package gamercompanion.src.dataObjects.news;

/**
 * DaO of a DetailedNewsObject
 */
public class DetailedNewsObject extends NewsObject {
    public String _text;
    public String _imageURL;
    public String _source;

    public DetailedNewsObject(String dateOfPublishment, String headline, String text, String imageURL, String source) {
        super(dateOfPublishment, headline);
        _text = text;
        _imageURL = imageURL;
        _source = source;
    }
}
