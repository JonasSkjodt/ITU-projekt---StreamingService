import java.util.ArrayList;
import java.util.List;

public class Stream {

    // This funktion is designed to be a sort of search funktion,
    // where the user's input is used to show movies and series based on the input
    public List<Media> searchField(String input) {
        Database db = new Database();

        List<Media> mediaList = new ArrayList<>();
        mediaList = db.getMedia();

        List<Media> filteredMediaList = new ArrayList<>();
        filteredMediaList = mediaList.stream().filter(media -> media.getName().startsWith(input)).toList();

        return filteredMediaList;
    }



}
