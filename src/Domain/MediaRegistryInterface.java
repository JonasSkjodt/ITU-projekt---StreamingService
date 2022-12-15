package Domain;

import Data.Database;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public interface MediaRegistryInterface {

    public List<Media> searchField(String input);

    public List<Media> filterMovie();

    public List<Media> filterSeries();

    public List<Media> filterGenre(String input);

    public String addFavorite(String input);

    public String removeFavorite(String input);

    public Media getMedia(String input);

    public List<Media> getMediaList();

    public ArrayList<String> getGenreList();

    public List<Media> getFavoritesList();

    public void saveOnExit() throws IOException;

}
