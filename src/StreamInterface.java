import java.util.List;

public interface StreamInterface {

    public List<Media> searchField(String input);

    public List<Media> filterType(String input);

    public List<Media> filterGenre(String input);

    public String editFavorite(Media media, String input);
}
