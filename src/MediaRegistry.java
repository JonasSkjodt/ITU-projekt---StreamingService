import javax.swing.*;
import java.util.*;

public class MediaRegistry implements MediaRegistryInterface {

    private Database db;
    private List<Media> mediaList;

    private Set<Media> favoriteSet;
    public MediaRegistry() {
        this.db = new Database();
        this.mediaList = new ArrayList<>();
        this.favoriteSet = new HashSet<>();
        initializeMedia();
    }

    //@Override
    private void initializeMedia() {
        db.readFile();
        Map<String, ImageIcon> images = db.getImage();

        //movie creation
        List<String[]> movieData = db.readFile().get(0); //fetches the StringArray from Database
        for(String[] array : movieData) { //[0] = name, [1] = year, [2] = genre, [3] = rating
            String[] splitGenreMovie = array[2].split(",");
            ImageIcon image = images.get(array[0]);
            Movie movie = new Movie(array[0], array[1], Arrays.asList(splitGenreMovie),image);
            mediaList.add(movie);
        }
        //splitting genre into standalone components and parsing it as a list to create a movie


        //Series creation
        List<String[]> seriesData = db.readFile().get(1);
        //splitting seasons and episode pairs into standalone strings
        for(String[] array : seriesData) { //[0] = name, [1] = year, [2] = genre, [3] = rating, [4] = season and episode number
            String[] splitGenreSeries = array[2].split(",");
            ImageIcon image = images.get(array[0]);
            String[] splitSeasonEpisode = array[4].split(",|-|;");
            Series series = new Series(array[0], array[1], Arrays.asList(splitGenreSeries),Arrays.asList(splitSeasonEpisode),image);
            mediaList.add(series);
        }
    }

    // This function is designed to be a sort of search function,
    // where the user's input is used to show movies and series based on the input
    public List<Media> searchField(String input) {
        // getting all the Media from the database
        List<Media> searchedMediaList = new ArrayList<>();
        if (input.length() > 2) {
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
                if (s.equals((" " + input))) {
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
    public List<Media> filterMovie() {
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

    /*@Override
    public String editFavorite(String input, String name) {
        String messageFromDb;
        if (input.equals("ADD")) {

            messageFromDb = db.addFavoriteSet(name);
        } else if (input.equals("REMOVE")) {
            messageFromDb = db.removeFavoriteSet(name);
        } else {
            messageFromDb = "Something went wrong";
        }
        return messageFromDb;
    }*/

    @Override
    public Set<Media> getFavoritesList() {
        for (String name : db.getFavoriteSet()) {
            favoriteSet.add(getMedia(name));
        }

        return favoriteSet;
    }
}