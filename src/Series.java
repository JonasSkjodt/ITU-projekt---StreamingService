import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Series extends Media{
    private List<Map<String,String>> maps;
    private Map<String, String> seasonToEpisodes;

    Series(String name, String year, List<String> genre, List<String> seasonAndEpisodes) {
        super(name, year, genre);
        maps = new ArrayList<>();
        seasonToEpisodes = new HashMap<>();
        for(int i = 0 ; i < seasonAndEpisodes.size()/2 ; i++) {
            seasonToEpisodes.put(seasonAndEpisodes.get(i), seasonAndEpisodes.get(i+1));
        }
        maps.add(seasonToEpisodes);
    }
    public String getSeasonToEpisodes(String season) {
        return maps.get(0).get(season); // ved ikke helt hvorfor det her ikke virker???
    }

    public String getSeasons() {
        return "" + maps.get(0).size();
    }


}
