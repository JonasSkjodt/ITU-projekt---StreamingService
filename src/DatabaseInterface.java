import java.util.ArrayList;
import java.util.List;

public interface DatabaseInterface {
    List<String> favoriteList = new ArrayList<>();
    List<String> nameList = new ArrayList<>();
    List<Media> media = new ArrayList<>();

    static void readFile() {

    }

    //void readImage();
    List<String> getFavoriteList();
    List<String> getNameList();
    List<Media> getMedia();
}
