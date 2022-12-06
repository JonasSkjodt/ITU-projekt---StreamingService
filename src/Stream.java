import java.util.ArrayList;
import java.util.List;

public class Stream implements StreamInterface{

    private Database db;
    private List<Media> mediaList;

    public Stream() {
        this.db = new Database();

        // Reading the file that contains all the info
        this.db.readFile();

        // getting all the Media from the database
        mediaList = new ArrayList<>();
        mediaList = this.db.getMedia();
    }

    // This function is designed to be a sort of search function,
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

    //This funktion is designed to filter movie and series by their genre
    public List<Media> filterGenre(String input) {

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

    @Override
    public List<Media> filterType(String input) {
        List<Media> filteredMediaList = new ArrayList<>();
        String type;

        for (Media m : mediaList) {
            type = m.getType();
            if (type.equals((" " + input))) {
                filteredMediaList.add(m);
            }
        }
        return filteredMediaList;
    }

    @Override
    public String editFavorite(Media media, String input) {
        String messageFromDb;
        if (input.equals("ADD")) {
            messageFromDb = db.addFavoriteSet(media);
        } else if (input.equals("REMOVE")) {
            messageFromDb = db.removeFavoriteSet(media);
        } else {
            messageFromDb = "Something went wrong";
        }

        return messageFromDb;
    }
}