package gamercompanion.gamercompanion.utils;


import java.util.ArrayList;

/**
 * Created by dklemm on 09.06.15.
 */
//TODO refactor
public class ParsingOperations {
//
//    public static final ArrayList<GameObject> parseScores(Platforms platformToParse, String inputString)
//    {
//        String platform = platformToParse(platformToParse);
//        String[] splittedInput = inputString.split("\\n");
//        boolean nextLineIsName = false;
//        String tempName="";
//        String tempScore="";
//        String tempNameUrl="";
//        ArrayList<GameObject> returnList = new ArrayList<GameObject>();
//        for(String line : splittedInput)
//        {
//            if(nextLineIsName)
//            {
//                tempName = line;
//                nextLineIsName = false;
//            }
//            if(line.contains("<a href=\"/game/"+platform))
//            {
//                tempNameUrl = line.replace("<a href=\"/game/"+platform+"/", "").replace("\">", "").trim();
//                nextLineIsName = true;
//            }
//            if(line.contains("<div class=\"metascore_w small game positive\">"))
//            {
//                tempScore = line.substring(45,47);
//                //TODO Parse name to add in URL _nameURL
//                returnList.add(new GameObject(tempName.trim(), Integer.parseInt(tempScore), platformToParse, tempNameUrl));
//            }
//        }
//
//        return returnList;
//    }
//
//    private static final String platformToParse(Platforms platformToParse) {
//        if(platformToParse.equals(Platforms.PS4))
//            return "playstation-4";
//        if(platformToParse.equals(Platforms.WIIU))
//            return "wii-u";
//        if (platformToParse.equals(Platforms.TDS))
//            return "3ds";
//        return null;
//    }
//
//    public static ExtendedGameObject parseExtendedGameObject(GameObject game, String input) {
//        String[] splittedInput = input.split("\\n");
//        String releaseDateString="";
//        String ratingString="";
//        String genreString="";
//        String urlString="";
//        Boolean developer = false;
//        int developerCounter = 0;
//        String developerString="";
//
//        for(String line:splittedInput)
//        {
//            if(developerCounter== 1)
//            {
//                developerString = line;
//                developer = false;
//                developerCounter =0;
//            }
//            if(developer)
//            {
//                developerCounter++;
//            }
//            if(line.contains("<span class=\"data\" itemprop=\"datePublished\">"))
//            {
//                releaseDateString = line;
//            }
//            if(line.contains("<span class=\"label\">Developer:</span>"))
//            {
//                developer=true;
//            }
//            if(line.contains("<span class=\"data\" itemprop=\"contentRating\">"))
//            {
//                ratingString= line;
//            }
//            if(line.contains("<span class=\"data\" itemprop=\"genre\">"))
//            {
//                genreString = line;
//            }
//            if(line.contains("<img class=\"product_image large_image\" src=\""))
//            {
//                urlString = line;
//            }
//        }
//        //<span class="data" itemprop="datePublished">Mar 24, 2015</span>
//        releaseDateString = releaseDateString.replace("<span class=\"data\" itemprop=\"datePublished\">","").replace("</span>","").trim();
//        //<span class="data" itemprop="contentRating">M</span>
//        ratingString = ratingString.replace("<span class=\"data\" itemprop=\"contentRating\">","").replace("</span>","").trim();
//        //<span class="data" itemprop="genre">Action RPG</span>
//        genreString = genreString.replace("<span class=\"data\" itemprop=\"genre\">","").replace("</span>","").trim();
//        //<img class="product_image large_image" src="http://static.metacritic.com/images/products/games/5/d31120073f909d2c034c09f91e7a5073-98.jpg"
//        urlString = urlString.replace("<img class=\"product_image large_image\" src=\"","").replace("\"","").trim();
//        //From Software                </span>
//        developerString = developerString.replace("</span>","").trim();
//        return new ExtendedGameObject(game.getName(),game.getMetascore(),game.getPlatform(),game.getNameURL(),developerString,releaseDateString,genreString,ratingString,urlString);
//    }
}
