import java.util.List;

public interface MediaRegistryInterface {

    public List<Media> searchField(String input);

    public List<Media> filterMovie();

    public List<Media> filterSeries();

    public List<Media> filterGenre(String input);

    public String editFavorite(Media media, String input);
}
