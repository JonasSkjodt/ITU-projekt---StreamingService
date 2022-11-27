import java.util.ArrayList;
import java.util.List;

public class Stream implements StreamInterface{

    private Database db;
    private List<Media> mediaList;

    public Stream() {
        this.db = new Database();

        // Reading the file that contains all the info
        db.readFile();

        // getting all the Media from the database
        mediaList = new ArrayList<>();
        mediaList = db.getMedia();
    }

    // This funktion is designed to be a sort of search funktion,
    // where the user's input is used to show movies and series based on the input
    public List<Media> searchField(String input) {
        // getting all the Media from the database
        List<Media> searchedMediaList = new ArrayList<>();

        for (Media m : mediaList) {
            if (m.getName().startsWith(input)) {
                searchedMediaList.add(m);
            }
        }

        return searchedMediaList;
    }

    //
    public List<Media> filter(String input) {

        List<Media> filteredMediaList = new ArrayList<>();
        List<String> genreList = new ArrayList<>();


        for (Media m : mediaList) {
            genreList = m.getGenre();
            for (String s : genreList) {
                if (s.equals((" " + input))) {
                    filteredMediaList.add(m);
                }
            }
        }


        return filteredMediaList;
    }
}
