package gamercompanion.src.dataObjects.gameProgress;

import com.google.common.base.Optional;

/**
 * Created by dklemm on 26.06.15.
 */
public class Trophy {
    private String _name;
    private String _text;
    private String _type; //P,G,S,B
    private String _rarity;
    private Optional<String> _earnedDate;

    public Trophy(String name, String text, String type, String rarity, Optional<String> earnedDate)
    {
        _name = name;
        _text = text;
        _type = type;
        _rarity = rarity;
        _earnedDate = earnedDate;
    }

    public String get_name() {
        return _name;
    }

    public String get_text() {
        return _text;
    }

    public String get_type() {
        return _type;
    }

    public String get_rarity() {
        return _rarity;
    }

    public Optional<String> get_earnedDate() {
        return _earnedDate;
    }
}
