import static org.junit.jupiter.api.Assertions.*;

import Data.Database;
import Domain.Media;
import Domain.MediaRegistry;
import Presentation.StreamingUI;
import org.junit.jupiter.api.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;


public class streamServiceTests {

    private StreamingUI streamingUI;
    private MediaRegistry mediaRegistry;
    private Media media;
    private Database database;

    public streamServiceTests() throws IOException {
        this.mediaRegistry = new MediaRegistry();
        this.database = new Database();
    }

    @BeforeEach
    public void setUp()
    {

    }

    @AfterEach
    public void tearDown()
    {
        media = null;
    }

    //////////////////////////////////////////////////////////////////////////////// UI

    //////////////////////////////////////////////////////////////////////////////// Domain

    // for this test, it is going to the class Stream, where the test will see if can get a list of possible related Media.
    // The expected result from this, would be a watered-down list of the original full list based on input from the searchfield.
    @Test
    public void MediaRegistry_searchfield_input_rest() {
        List<Media> searchedMediaList = new ArrayList<>();
        searchedMediaList = mediaRegistry.searchField("rest");

        assertTrue(searchedMediaList.size() < 10 & searchedMediaList.size() != 0);
    }

    @Test
    public void MediaRegistry_searchfield_Movie_input_God() {
        List<Media> searchedMediaList = new ArrayList<>();
        searchedMediaList = mediaRegistry.searchField("God");
        boolean check = false;

        for (Media m : searchedMediaList) {
            if(m.getName().equals("The Godfather")) {
                check = true;
                break;
            }
        }

        assertEquals(true, check);
    }

    @Test
    public void MediaRegistry_searchfield_Serie_input_lost() {
        List<Media> searchedMediaList = new ArrayList<>();
        searchedMediaList = mediaRegistry.searchField("lost");
        boolean check = false;

        for (Media m : searchedMediaList) {
            if(m.getName().equals("Lost")) {
                check = true;
                break;
            }
        }

        assertEquals(true, check);
    }

    @Test
    public void MediaRegistry_searchfield_Serie_input_äkte() {
        List<Media> searchedMediaList = new ArrayList<>();
        searchedMediaList = mediaRegistry.searchField("äkte");
        boolean check = false;

        for (Media m : searchedMediaList) {
            if(m.getName().equals("Scener ur ett äktenskap")) {
                check = true;
                break;
            }
        }

        assertEquals(true, check);
    }

    //
    @Test
    public void MediaRegistry_filterGenre_input_Drama_size() {
        List<Media> filteredMediaList = new ArrayList<>();
        filteredMediaList = mediaRegistry.filterGenre("Drama");

        assertTrue(filteredMediaList.size() < 200 && filteredMediaList.size() != 0);
    }

    @Test
    public void MediaRegistry_filterGenre_input_Drama() {
        List<Media> filteredMediaList = new ArrayList<>();
        filteredMediaList = mediaRegistry.filterGenre("Drama");
        boolean check = false;

        for (Media m : filteredMediaList) {
            if(m.getName().equals("Braveheart")) {
                check = true;
                break;
            }
        }

        assertEquals(true, check);
    }

    @Test
    public void MediaRegistry_filterGenre_input_Action_size_28() {
        List<Media> filteredMediaList = new ArrayList<>();
        filteredMediaList = mediaRegistry.filterGenre("Action");

        assertEquals(28, filteredMediaList.size());
    }

    @Test
    public void MediaRegistry_filterMovie_size() {
        List<Media> filteredMediaList = new ArrayList<>();
        filteredMediaList = mediaRegistry.filterMovie();

        assertTrue(filteredMediaList.size() < 200 && filteredMediaList.size() != 0);
    }
    @Test
    public void MediaRegistry_filterMovie_all_Quiet_On_The_Western_Front() {
        List<Media> filteredMediaList = new ArrayList<>();
        filteredMediaList = mediaRegistry.filterMovie();
        boolean check = false;

        for (Media m : filteredMediaList) {
            if(m.getName().equals("All Quiet On The Western Front")) {
                check = true;
                break;
            }
        }

        assertEquals(true, check);
    }

    @Test
    public void MediaRegistry_filterSeries() {
        List<Media> filteredMediaList = new ArrayList<>();
        filteredMediaList = mediaRegistry.filterSeries();

        assertTrue(filteredMediaList.size() < 200 & filteredMediaList.size() != 0);
    }

    @Test
    public void MediaRegistry_filterSeries_Scener_ur_ett_äktenskap() {
        List<Media> filteredMediaList = new ArrayList<>();
        filteredMediaList = mediaRegistry.filterSeries();
        boolean check = false;

        for (Media m : filteredMediaList) {
            if(m.getName().equals("Scener ur ett äktenskap")) {
                check = true;
                break;
            }
        }

        assertEquals(true, check);
    }

    @Test
    public void MediaRegistry_addFavorite_Success() {
        String messageFromDB;
        messageFromDB = mediaRegistry.addFavorite(mediaRegistry.getMediaList().get(0).getName()); //mediaRegistry.get.... Is temp for this to work : Was movie

        assertEquals("Success", messageFromDB);
    }

    @Test
    public void MediaRegistry_addFavorite_Failed() {
        String messageFromDB;
        mediaRegistry.addFavorite(mediaRegistry.getMediaList().get(0).getName()); //mediaRegistry.get.... Is temp for this to work : Was movie
        messageFromDB = mediaRegistry.addFavorite(mediaRegistry.getMediaList().get(0).getName());

        assertEquals("Failed", messageFromDB);
    }

    @Test
    public void MediaRegistry_removeFavorite_Success() {
        String messageFromDB;
        mediaRegistry.addFavorite(mediaRegistry.getMediaList().get(0).getName());
        messageFromDB = mediaRegistry.removeFavorite(mediaRegistry.getMediaList().get(0).getName()); //mediaRegistry.get.... Is temp for this to work : Was movie

        assertEquals("Success", messageFromDB);
    }

    @Test
    public void MediaRegistry_removeFavorite_Failed() {
        String messageFromDB;
        mediaRegistry.addFavorite(mediaRegistry.getMediaList().get(1).getName());
        messageFromDB = mediaRegistry.removeFavorite(mediaRegistry.getMediaList().get(0).getName()); //mediaRegistry.get.... Is temp for this to work : Was movie

        assertEquals("Failed", messageFromDB);
    }

    @Test
    public void MediaRegistry_getMedia_Name_Lost() {
        media = mediaRegistry.getMedia("Lost");

        assertEquals("Lost", media.getName());
    }





    //////////////////////////////////////////////////////////////////////////////// Data

    @Test //This test counts the length of the media list to check if the right amount of movies, series and other types of media are present
    public void test_Media_Length() {
        assertEquals(200,mediaRegistry.getMediaList().size());
    }

    @Test
    public void database_favoriteSet_size() {
        database.addFavoriteSet("Lost");

        assertEquals(1, database.getFavoriteSet().size());
    }

    @Test
    public void database_mediaRegistry_favoriteSet_size() {
        //for loop to read favorits.txt and get the size to add to assertEquals
        int favoritesSize = 0;
        if(new File("Data/favorites.txt").exists()) {
            File file = new File("Data/favorites.txt");
        favoritesSize = 0;
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                scanner.nextLine();
                favoritesSize++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        }


        mediaRegistry.addFavorite("Lost");
        mediaRegistry.addFavorite("Braveheart");
        mediaRegistry.addFavorite("All Quiet On The Western Front");
        mediaRegistry.removeFavorite("Lost");

        assertEquals(2 + favoritesSize, mediaRegistry.getFavoritesList().size());
    }
}
