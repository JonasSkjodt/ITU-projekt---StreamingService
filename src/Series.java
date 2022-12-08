import javax.swing.*;
import java.awt.*;
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
        for(int i = 0 ; i < seasonAndEpisodes.size()/2 ; i++) {
            seasonToEpisodes.put(seasonAndEpisodes.get(i), seasonAndEpisodes.get(i+1));
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
    
    @Override
    public String toString() {
        return super.toString() + ", Season= " + getSeasons() + /*", Episode= " + getEpisode( + */ " : Series";
    }
}
