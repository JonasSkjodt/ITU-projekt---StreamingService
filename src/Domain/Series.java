package Domain;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Series extends Media{
    private List<Map<String,String>> listOfSeasonToEpisodes;
    private Map<String, String> seasonToEpisodes;

    Series(String name, String year, List<String> genre, List<String> seasonAndEpisodes, ImageIcon image) {
        super(name, year, genre, image);
        listOfSeasonToEpisodes = new ArrayList<>();
        seasonToEpisodes = new HashMap<>();
        int j = 0;
        for(int i = 0 ; i < seasonAndEpisodes.size()/2 ; i++) { // runs through the list of seasons and episodes and adds them to the map
            seasonToEpisodes.put(seasonAndEpisodes.get(j), seasonAndEpisodes.get(j+1));
            j = j + 2; // Local variable that is used to iterate through the list
        }
        listOfSeasonToEpisodes.add(seasonToEpisodes);
    }
    public String getSeasonToEpisodes(String season) {
        return listOfSeasonToEpisodes.get(0).get(season);
    }

    public String getSeasons() {
        return "" + listOfSeasonToEpisodes.get(0).size();
    }
    
    
    @Override
    public String getType() {
        return "Series";
    }
    
    /*
    @Override
    public String toString() {
        return super.toString() + ", Season= " + getSeasons() + //", Episode= " + getEpisode( +  " : Series";
    }
    */
}
