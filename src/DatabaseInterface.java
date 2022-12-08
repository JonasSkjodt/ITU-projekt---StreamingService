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

    List<List<String[]>> readFile();

    //void readImage();
    Set<Media> getFavoriteSet();


    String addFavoriteSet(Media media);

    String removeFavoriteSet(Media media);
}
