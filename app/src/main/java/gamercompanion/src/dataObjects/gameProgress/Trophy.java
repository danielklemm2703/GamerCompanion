package gamercompanion.src.dataObjects.gameProgress;

import com.google.common.base.Optional;

/**
 * DaO of Trophy
 */
public class Trophy {
    public String _name;
    public String _text;
    public String _type; //P,G,S,B maybe extraType?
    public String _rarity;
    public Optional<String> _earnedDate;

    public Trophy(String name, String text, String type, String rarity, Optional<String> earnedDate)
    {
        _name = name;
        _text = text;
        _type = type;
        _rarity = rarity;
        _earnedDate = earnedDate;
    }
}
