import java.awt.image.BufferedImage;

public class Series extends Media {
    private int season;
    private int episode;

    public Series(String name, String genre, String titleImage, int season, int episode) {
        super(name, genre, titleImage);
        this.season = season;
        this.episode = episode;
    }

    public int getSeason() {
        return season;
    }

    public int getEpisode() {
        return episode;
    }
}
