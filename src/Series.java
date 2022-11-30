import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Series extends Media{
    private Map<String, String> seasonToEpisodes;

    Series(String name, String year, List<String> genre, List<String> season, List<String> episodes) {
        super(name, year, genre);
        seasonToEpisodes = new HashMap<>();
        for(int i = 0 ; i < season ; i++) {
            seasonToEpisodes.put(season.get(i), episodes.get(i));
        }
    }
    public String getSeasonToEpisode(String season) {
        return seasonToEpisode.get(season); // ved ikke helt hvorfor det her ikke virker???
    }
}
