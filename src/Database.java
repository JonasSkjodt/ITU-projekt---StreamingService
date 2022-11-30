import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Database implements DatabaseInterface{
    List<String> favoriteList;
    static List<String> movieNameList;
    static List<String> seriesNameList;
    static ArrayList<String> genreList;
    static List<String> yearList;
    static List<Media> media;
    Database() {
        favoriteList = new ArrayList<>();
        movieNameList = new ArrayList<>();
        seriesNameList = new ArrayList<>();
        genreList = new ArrayList<>();
        yearList = new ArrayList<>();
        media = new ArrayList<>();
    }
    public static void readFile() { //Edit to work on series as well
        try { //reading film.txt
            File file = new File("Data\\film.txt");
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) { //reading file and splitting the data into categories
                String data = reader.nextLine();
                String[] splitData = data.split(";"); //[0] = name, [1] = year, [2] = genre, [3] = rating
                movieNameList.add(splitData[0]);

                //splitting genre into standalone components and parsing it as a list to create a movie
                String[] splitGenre = splitData[2].split(",");
                Movie movie = new Movie(splitData[0], splitData[1], Arrays.asList(splitGenre));
                media.add(movie);
            }
            reader.close();
        } catch (FileNotFoundException fnfe) {
            System.out.println(fnfe.getMessage());
        }
        try { //reading serier.txt
            File file = new File("Data\\serier.txt");
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) { //reading file and splitting the data into categories
                String data = reader.nextLine();
                String[] splitData = data.split(";"); //[0] = name, [1] = year, [2] = genre, [3] = rating, [4] = season and episode number
                seriesNameList.add(splitData[0]);

                //splitting genre into standalone strings
                String[] splitGenre = splitData[2].split(",");

                //splitting seasons and episode pairs into standalone strings
                String[] splitSeasonEpisode = splitData[4].split(",");

                Series series = new Series(splitData[0], splitData[1], Arrays.asList(splitGenre),);
                media.add(series);
            }
            reader.close();
        } catch (FileNotFoundException fnfe) {
            System.out.println(fnfe.getMessage());
        }

    }
    public List<String> getFavoriteList() {
        return favoriteList;
    }

    public List<String> getNameList() {
        return nameList;
    }

    public static List<Media> getMedia() {
        return media;
    }


}
