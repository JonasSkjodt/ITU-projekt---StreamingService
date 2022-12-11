import javax.swing.*;
import java.lang.reflect.Array;
import java.util.*;

public class MediaRegistry implements MediaRegistryInterface {

    private Database db;
    private List<Media> mediaList;
    private List<Media> favoriteList;
    private Set<String> genreSet;
    public MediaRegistry() {
        this.db = new Database();
        this.mediaList = new ArrayList<>();
        this.favoriteList = new ArrayList<>();
        this.genreSet = new HashSet<>();
        initializeMedia();
    }

    //@Override
    private void initializeMedia() {
        db.readFile();
        Map<String, ImageIcon> images = db.getImage();


        //movie creation
        List<String[]> movieData = db.readFile().get(0); //fetches the StringArray from Database
        for(String[] array : movieData) { //[0] = name, [1] = year, [2] = genre, [3] = rating
            String[] splitGenreMovie = array[2].split(","); // replaceAll("\\s+", " ") to eradicate the space before genres in movies

            List<String> genreForMovie = new ArrayList<>(); // TODO: Could be made better. If it is not made like this, then the genre for each media would keep growing.

            for (String genre : splitGenreMovie) {
                genre = genre.replaceAll("\\s+", "");
                genreSet.add(genre);

                genreForMovie.add(genre); // TODO: Make it not suck. Make so maybe a new variable is not needed
            }
            ImageIcon image = images.get(array[0]);
            Movie movie = new Movie(array[0], array[1], genreForMovie, image); //Arrays.asList(splitGenreMovie)   //new ArrayList<>(genreSet)
            mediaList.add(movie);
        }
        //splitting genre into standalone components and parsing it as a list to create a movie


        //Series creation
        List<String[]> seriesData = db.readFile().get(1);
        //splitting seasons and episode pairs into standalone strings
        for(String[] array : seriesData) { //[0] = name, [1] = year, [2] = genre, [3] = rating, [4] = season and episode number
            String[] splitGenreSeries = array[2].split(","); // replaceAll("\\s+", " ") to eradicate the space before genres in movies

            List<String> genreForSeries = new ArrayList<>(); // TODO: Could be made better. If it is not made like this, then the genre for each media would keep growing.

            for (String genre : splitGenreSeries) {
                genre = genre.replaceAll("\\s+", "");
                genreSet.add(genre);

                genreForSeries.add(genre); // TODO: Make it not suck. Make so maybe a new variable is not needed
            }
            ImageIcon image = images.get(array[0]);
            String[] splitSeasonEpisode = array[4].split(",|-|;");
            Series series = new Series(array[0], array[1], genreForSeries, Arrays.asList(splitSeasonEpisode), image);
            mediaList.add(series);
        }
    }

    // This function is designed to be a sort of search function,
    // where the user's input is used to show movies and series based on the input
    public List<Media> searchField(String input) { // TODO: Add genre search
        // getting all the Media from the database
        List<Media> searchedMediaList = new ArrayList<>();
        if (input != null && input.length() > 2) {
            for (Media m : mediaList) {
                if (m.getName().matches("^.*?(?i)(" + input + ".*).*$")) {  // Old regex (?i)(" + input + ").*
                    searchedMediaList.add(m);
                }
            }
        }

        return searchedMediaList;
    }

    //This funktion is designed to filter movie and series by their genre
    @Override
    public List<Media> filterGenre(String input) {
        List<Media> filteredMediaList = new ArrayList<>();
        List<String> genreList = new ArrayList<>();

        for (Media m : mediaList) {
            genreList = m.getGenre();
            for (String s : genreList) {
                if (s.equals((input))) {
                    filteredMediaList.add(m);
                }
            }
        }
        return filteredMediaList;
    }

    @Override
    public List<Media> getMediaList() {
        return mediaList;
    }

    @Override
    public Media getMedia(String input) {
        for (Media media : mediaList) {
            if (media.getName().equals(input)) {
                return media;
            }
        }
        return null;
    }

    @Override
    public List<Media> filterMovie() { //This should probably be changed to filterMovies
        List<Media> filteredMediaList = new ArrayList<>();
        String type;

        for (Media m : mediaList) {
            type = m.getType();
            if (type.equals(("Movie"))) {
                filteredMediaList.add(m);
            }
        }
        return filteredMediaList;
    }

    @Override
    public List<Media> filterSeries() {
        List<Media> filteredMediaList = new ArrayList<>();
        String type;

        for (Media m : mediaList) {
            type = m.getType();
            if (type.equals(("Series"))) {
                filteredMediaList.add(m);
            }
        }
        return filteredMediaList;
    }

    @Override
    public String addFavorite(String input) {
        return db.addFavoriteSet(input);
    }
    @Override
    public String removeFavorite(String input) {
        return db.removeFavoriteSet(input);
    }

    public ArrayList<String> getGenreList() {
        //ArrayList<String> genreList = new ArrayList<>();
        //genreList.addAll(genreSet);
        return new ArrayList<>(genreSet);
    }

    @Override
    public List<Media> getFavoritesList() {
        for (String name : db.getFavoriteSet()) {
            favoriteList.add(getMedia(name));
        }
        return favoriteList;
    }


}