import java.util.List;
import java.util.Set;

public interface MediaRegistryInterface {

    public List<Media> searchField(String input);

    public List<Media> filterMovie();

    public List<Media> filterSeries();

    public List<Media> filterGenre(String input);

    //public String editFavorite(String mediaName, String input);

    public String addFavorite(String input);

    public String removeFavorite(String input);

    public Media getMedia(String input);

    public List<Media> getMediaList();

    //public void initializeMedia();

    public List<Media> getFavoritesList();
}
