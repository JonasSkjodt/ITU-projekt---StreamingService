import javax.swing.*;
import java.lang.reflect.Array;
import java.util.*;

public interface DatabaseInterface {
    Set<String> favoriteSet = new HashSet<>();
    List<String> nameList = new ArrayList<>();
    List<String> genreList = new ArrayList<>();
    List<Media> media = new ArrayList<>();

    List<List<String[]>> readFile();
    public Map<String, ImageIcon> getImage();

    Set<Media> getFavoriteSet();

    String addFavoriteSet(Media media);

    String removeFavoriteSet(Media media);
}
