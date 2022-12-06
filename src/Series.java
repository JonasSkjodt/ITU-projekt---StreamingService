//ort java.awt.image.BufferedImage;
import java.util.List;
import java.util.Map;

public class Series extends Media {
    private int season;
    private int episode;
    //private List<Map<String, String>> ???
    private Map<String, String> seasonToEpisodes;

    public Map<String, String> getSeasonToEpisodes() {
        return seasonToEpisodes;
    }

    public Series(String name, List<String> genre, String year, int season, int episode) {
        super(name, genre, year);
        this.season = season;
        this.episode = episode;
    }

    @Override
    public String toString() {
        return super.toString() + ", Season= " + getSeason() + ", Episode= " + getEpisode() + " : Series";
    }

    public int getSeason() {
        return season;
    }

    public int getEpisode() {
        return episode;
    }

    @Override
    public String getType() {
        return "Series";
    }
}
