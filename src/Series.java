import java.util.ArrayList;
import java.util.List;

public class Series extends Media{
    List<String> genreList;
    List<String> season;
    List<String> episodes;

    Series(String name, String year, List<String> genre, List<String> season, List<String> episodes) {
        super(name, year, genre);
        this.season = season;
        this.episodes = episodes;
    }

}
