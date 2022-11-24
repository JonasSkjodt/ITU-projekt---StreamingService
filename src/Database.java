import java.util.ArrayList;
import java.util.List;

public class Database implements DatabaseInterface {

    List<String> favoriteList;
    List<String> nameList;
    List<Media> media;
    Database() {
        favoriteList = new ArrayList<>();
        nameList = new ArrayList<>();
        media = new ArrayList<>();
    }


    public List<String> getFavoriteList() {
        return favoriteList;
    }

    public List<String> getNameList() {
        return nameList;
    }

    public List<Media> getMedia() {
        return media;
    }
}
