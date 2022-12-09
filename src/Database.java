import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.List;

public class Database implements DatabaseInterface{
    private Set<String> favoriteSet;
    private List<String> movieNameList;
    private List<String> seriesNameList;
    private List<String> genreList;

    private Map<String, ImageIcon> images;

    Database() {
        favoriteSet = new HashSet<>();
        movieNameList = new ArrayList<>();
        seriesNameList = new ArrayList<>(); //TODO Evt. lav om til EN list som indholder et map som mapper fra name til et media
        genreList = new ArrayList<>();
        images = new HashMap<>();
    }
    public List<List<String[]>> readFile() {
        List<String[]> mediaDataMovie = new ArrayList<>();
        List<String[]> mediaDataSeries = new ArrayList<>();
        List<List<String[]>> mediaInfo = new ArrayList<>();

        try { //reading film.txt
            File file = new File("Data/film.txt");
            Scanner reader = new Scanner(file, StandardCharsets.ISO_8859_1);
            while (reader.hasNextLine()) { //reading file and splitting the data into categories
                String data = reader.nextLine();
                String[] splitData = data.split(";"); //[0] = name, [1] = year, [2] = genre, [3] = rating
                movieNameList.add(splitData[0]);
                genreList.add(splitData[2]);
                mediaDataMovie.add(splitData);


                //TODO Maybe add to a list of only movies to sepperate them out so we have both media film and series
            }
            reader.close();
        } catch (FileNotFoundException fnfe) {
            System.out.println(fnfe.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try { //reading serier.txt
            File file = new File("Data/serier.txt");
            Scanner reader = new Scanner(file, StandardCharsets.ISO_8859_1);
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
        } catch (IOException e) {
            throw new RuntimeException(e);
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
    public Set<String> getFavoriteSet() { //Returns the favoriteSet
        return favoriteSet;
    }

    public String addFavoriteSet(String mediaName) {
            int before = favoriteSet.size();
            favoriteSet.add(mediaName);
            int after = favoriteSet.size();
            if(before < after) {
                return "Success";
            } else {
                return "Failed";
            }

    }

    public String removeFavoriteSet(String mediaName) {
        try {
            int before = favoriteSet.size();
            favoriteSet.remove(mediaName);
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
