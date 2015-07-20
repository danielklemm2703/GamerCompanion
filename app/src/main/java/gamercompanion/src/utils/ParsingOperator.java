package gamercompanion.src.utils;


import android.util.Pair;

import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableSet;

import java.util.ArrayList;

import gamercompanion.src.dataObjects.game.GameObject;
import gamercompanion.src.synchronizer.MetascoreAllGames;
import gamercompanion.src.utils.tryUtil.Try;


//TODO refactor
public class ParsingOperator {

    public ParsingOperator()
    {

    }
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

    public final Try<Pair<Integer, ImmutableCollection<GameObject>>> parseGamesOfPlatformOfWebsite(final Platform platform, final String result) {
        return Try.of(new Supplier<Pair<Integer, ImmutableCollection<GameObject>>>() {
            @Override
            public Pair<Integer, ImmutableCollection<GameObject>> get() {
                String platformPattern = platform._singleGameURLname;
                String[] splittedInput = result.split("\\n");
                boolean nextLineIsName = false;
                String tempName = "";
                String tempScore = "";
                String tempNameUrl = "";
                int nextPageNumber =-1;
                ArrayList<GameObject> returnList = new ArrayList<GameObject>();
                for (String line : splittedInput) {
                    if (nextLineIsName) {
                        tempName = line;
                        nextLineIsName = false;
                    }
                    if (line.contains("<a href=\"/game/" + platformPattern)) {
                        tempNameUrl = line.replace("<a href=\"/game/" + platformPattern + "/", "").replace("\">", "").trim();
                        nextLineIsName = true;
                    }
                    if (line.contains("<div class=\"metascore_w small game")) {
                        String[] splitedMetascore = line.split(">");
                        tempScore = splitedMetascore[1].split("<")[0];

                        returnList.add(new GameObject(tempName.trim(), platform, Integer.parseInt(tempScore), tempNameUrl));
                        tempName = "";
                        tempNameUrl = "";
                    }
                    if(line.contains("<span class=\"flipper next\"><a class=\"action\" rel=\"next\" href=\""))
                    {
                        String[] split = line.split("page=");
                        String[] numberSplit = split[1].split("\"");
                        nextPageNumber = Integer.parseInt(numberSplit[0]);
                    }
                }
                ImmutableCollection<GameObject> gameObjects = ImmutableSet.copyOf(returnList);
                return Pair.create(nextPageNumber, gameObjects);
            }
        });
    }
}
