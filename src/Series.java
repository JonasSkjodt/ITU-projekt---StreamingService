//ort java.awt.image.BufferedImage;
import java.util.List;

public class Series extends Media {
    private int season;
    private int episode;

    public Series(String name, List<String> genre, int season, int episode) {
        super(name, genre);
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
}
