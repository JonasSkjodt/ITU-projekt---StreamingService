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
    static Map<String, ImageIcon> images;

    Database() {
        favoriteSet = new HashSet<>();
        movieNameList = new ArrayList<>();
        seriesNameList = new ArrayList<>(); //TODO Evt. lav om til EN list som indholder et map som mapper fra name til et media
        genreList = new ArrayList<>();
        yearList = new ArrayList<>();
        media = new ArrayList<>();
        images = new HashMap<>();
    }
    public List<List<String[]>> readFile() {
        List<String[]> mediaDataMovie = new ArrayList<>();
        List<String[]> mediaDataSeries = new ArrayList<>();
        List<List<String[]>> mediaInfo = new ArrayList<>();

        try { //reading film.txt
            File file = new File("Data/film.txt");
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) { //reading file and splitting the data into categories
                String data = reader.nextLine();
                String[] splitData = data.split(";"); //[0] = name, [1] = year, [2] = genre, [3] = rating
                movieNameList.add(splitData[0]);
                mediaDataMovie.add(splitData);

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
                mediaDataSeries.add(splitData);

                //TODO see other todo above this one
            }
            reader.close();
        } catch (FileNotFoundException fnfe) {
            System.out.println(fnfe.getMessage());
        }
        mediaInfo.add(mediaDataMovie);
        mediaInfo.add(mediaDataSeries);
        return mediaInfo;
    }

    public Map<String, ImageIcon> getImage() {
        for (String name : movieNameList) {
            ImageIcon imageMovie = new ImageIcon("Data/filmplakater/" + name + ".jpg");
            images.put(name, imageMovie);
        }
        for (String name : seriesNameList) {
            ImageIcon imageSeries = new ImageIcon("Data/serieforsider/" + name + ".jpg");
            images.put(name, imageSeries);
        }
        return images;
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





}
