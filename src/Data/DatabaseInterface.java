package Data;

import Domain.Media;

import javax.swing.*;
import java.io.IOException;
import java.util.*;

public interface DatabaseInterface {

    public List<List<String[]>> readFile();
    public Map<String, ImageIcon> getImage();

    public Set<String> getFavoriteSet();

    public String addFavoriteSet(String mediaName);

    public String removeFavoriteSet(String mediaName);

    public void saveFavoriteSet() throws IOException;
    public void loadFavoriteSet() throws IOException;
}
