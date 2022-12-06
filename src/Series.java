import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Series extends Media{
    private List<Map<String,String>> maps;
    private Map<String, String> seasonToEpisodes;

    Series(String name, String year, List<String> genre, List<String> seasonAndEpisodes, ImageIcon image) {
        super(name, year, genre, image);
        maps = new ArrayList<>();
        seasonToEpisodes = new HashMap<>();
        for(int i = 0 ; i < seasonAndEpisodes.size()/2 ; i++) {
            seasonToEpisodes.put(seasonAndEpisodes.get(i), seasonAndEpisodes.get(i+1));
        }
        maps.add(seasonToEpisodes);
    }
    public String getSeasonToEpisodes(String season) {
        return maps.get(0).get(season);
    }

    public String getSeasons() {
        return "" + maps.get(0).size();
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
