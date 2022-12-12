package Data;

import Domain.Media;

import javax.swing.*;
import java.util.*;

public interface DatabaseInterface {
    Set<String> favoriteSet = new HashSet<>();
    List<String> nameList = new ArrayList<>();
    List<String> genreList = new ArrayList<>();
    List<Media> media = new ArrayList<>();

    List<List<String[]>> readFile();
    public Map<String, ImageIcon> getImage();

    Set<String> getFavoriteSet();

    String addFavoriteSet(String mediaName);

    String removeFavoriteSet(String mediaName);
}
