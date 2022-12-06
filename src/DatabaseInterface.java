import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public interface DatabaseInterface {
    Set<String> favoriteSet = new HashSet<>();
    List<String> nameList = new ArrayList<>();
    List<String> genreList = new ArrayList<>();
    List<String> yearList = new ArrayList<>();
    List<Media> media = new ArrayList<>();

    static void readFile() {}

    //void readImage();
    Set<Media> getFavoriteSet();

    List<String> getNameList();

    public static List<Media> getMedia() {
        return null;
    }

    String addFavoriteSet(Media media);

    String removeFavoriteSet(Media media);
}
