import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.List;

public class Database implements DatabaseInterface{
    static Set<Media> favoriteSet;
    static List<String> movieNameList;
    static List<String> seriesNameList;
    static List<String> genreList;
    static List<String> yearList;
    static List<Media> media;

    Database() {
        favoriteSet = new HashSet<>();
        movieNameList = new ArrayList<>();
        seriesNameList = new ArrayList<>(); //TODO Evt. lav om til EN list som indholder et map som mapper fra name til et media
        genreList = new ArrayList<>();
        yearList = new ArrayList<>();
        media = new ArrayList<>();
    }
    public void readFile() { //TODO All of read file could be moved into the constructor to not have to run readfile every time the program starts
        try { //reading film.txt
            File file = new File("Data/film.txt");

            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) { //reading file and splitting the data into categories
                String data = reader.nextLine();
                String[] splitData = data.split(";"); //[0] = name, [1] = year, [2] = genre, [3] = rating
                movieNameList.add(splitData[0]);

                //splitting genre into standalone components and parsing it as a list to create a movie
                String[] splitGenre = splitData[2].split(",");

                String tempName = splitData[0];
                ImageIcon imageMovie = new ImageIcon("Data/filmplakater/" + tempName + ".jpg");
                Movie movie = new Movie(splitData[0], splitData[1], Arrays.asList(splitGenre),imageMovie);
                media.add(movie);

                //TODO Maybe add to a list of only movies to sepperate them out so we have both media film and series
            }
            reader.close();
        } catch (FileNotFoundException fnfe) {
            System.out.println(fnfe.getMessage());
        }
        try { //reading serier.txt
            File file = new File("Data/serier.txt");
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) { //reading file and splitting the data into categories
                String data = reader.nextLine();
                String[] splitData = data.split(";"); //[0] = name, [1] = year, [2] = genre, [3] = rating, [4] = season and episode number
                seriesNameList.add(splitData[0]);

                //splitting genre into standalone strings
                String[] splitGenre = splitData[2].split(",");

                //splitting seasons and episode pairs into standalone strings
                String[] splitSeasonEpisode = splitData[4].split(",|-");

                String tempName = splitData[0];
                ImageIcon imageSeries = new ImageIcon("Data/serieforsider/" + tempName + ".jpg");
                //Creates a series and adds it to the media list. The different datatypes can be seen above next to splitData
                Series series = new Series(splitData[0], splitData[1], Arrays.asList(splitGenre),Arrays.asList(splitSeasonEpisode),imageSeries);
                media.add(series);
                //TODO see other todo above this one
            }
            reader.close();
        } catch (FileNotFoundException fnfe) {
            System.out.println(fnfe.getMessage());
        }
    }

    //This is the favoriteSet Section of the Database
    public Set<Media> getFavoriteSet() { //Returns the favoriteSet
        return favoriteSet;
    }

    public String addFavoriteSet(Media media) {
            int before = favoriteSet.size();
            favoriteSet.add(media);
            int after = favoriteSet.size();
            if(before < after) {
                return "Success";
            } else {
                return "Failed";
            }

    }

    public String removeFavoriteSet(Media media) {
        try {
            int before = favoriteSet.size();
            favoriteSet.remove(media);
            int after = favoriteSet.size();
            if(before > after) {
                return "Success";
            } else {
                return "Failed";
            }
        } catch (NoSuchElementException nsee) {
            return nsee.getMessage();
        }
    }

    public List<String> getNameList() {
        return nameList;
    }

    public List<Media> getMedia() {
        return media;
    }



}
