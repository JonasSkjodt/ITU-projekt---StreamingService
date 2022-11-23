import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Database implements DatabaseInterface{
    List<String> favoriteList;
    List<String> nameList;
    List<Media> media;
    Database() {
        favoriteList = new ArrayList<>();
        nameList = new ArrayList<>();
        media = new ArrayList<>();
    }
    public static void readFile() {
        try {
            File file = new File("Data\\film.txt");
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                System.out.println(data);
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

    public List<Media> getMedia() {
        return media;
    }


}
