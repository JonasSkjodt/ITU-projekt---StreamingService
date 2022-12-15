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

    // setting the media to null
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

    // This is testing for the searchfield input, to see if can take a input and find movies,
    // that has the input in it. This test takes the input "God"
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

    // This is testing for the searchfield input, to see if can take a input and find movies,
    // that has the input in it. This test takes the input "Lost"
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

    // This test sees if the size of the list has changed.
    // the input is a genre and the function will filter out all that media,
    // that does not have the input in it
    @Test
    public void MediaRegistry_filterGenre_input_Drama_size() {
        List<Media> filteredMediaList = new ArrayList<>();
        filteredMediaList = mediaRegistry.filterGenre("Drama");

        assertTrue(filteredMediaList.size() < 200 && filteredMediaList.size() != 0);
    }


    // This test sees if a movie is in the filtered list.
    // the input is a genre and the function will filter out all that media,
    // that does not have the input in it
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

    // This test sees if the size of the list has changed.
    // the input is a genre and the function will filter out all that media,
    // that does not have the input in it
    @Test
    public void MediaRegistry_filterGenre_input_Action_size_28() {
        List<Media> filteredMediaList = new ArrayList<>();
        filteredMediaList = mediaRegistry.filterGenre("Action");

        assertEquals(28, filteredMediaList.size());
    }

    // This test sees if the size of the list has changed.
    // the function will filter out all that is not a movie.
    @Test
    public void MediaRegistry_filterMovie_size() {
        List<Media> filteredMediaList = new ArrayList<>();
        filteredMediaList = mediaRegistry.filterMovie();

        assertTrue(filteredMediaList.size() < 200 && filteredMediaList.size() != 0);
    }

    // This test sees if a movie is in the filtered list.
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

    // This test sees if the size of the list has changed.
    // the function will filter out all that is not a series.
    @Test
    public void MediaRegistry_filterSeries() {
        List<Media> filteredMediaList = new ArrayList<>();
        filteredMediaList = mediaRegistry.filterSeries();

        assertTrue(filteredMediaList.size() < 200 & filteredMediaList.size() != 0);
    }

    // This test sees if a movie is in the filtered list.
    @Test
    public void MediaRegistry_filterSeries_Lost() {
        List<Media> filteredMediaList = new ArrayList<>();
        filteredMediaList = mediaRegistry.filterSeries();
        boolean check = false;

        for (Media m : filteredMediaList) {
            if(m.getName().equals("Lost")) {
                check = true;
                break;
            }
        }

        assertEquals(true, check);
    }

    // This test tries to add media into the favoritelist, and see if it gets the right String back
    @Test
    public void MediaRegistry_addFavorite_Success() {
        String messageFromDB;
        messageFromDB = mediaRegistry.addFavorite(mediaRegistry.getMediaList().get(0).getName()); //mediaRegistry.get.... Is temp for this to work : Was movie

        assertEquals("Success", messageFromDB);
    }

    // This test tries to add media into the favoritelist, and see if it gets the right String back
    @Test
    public void MediaRegistry_addFavorite_Failed() {
        String messageFromDB;
        mediaRegistry.addFavorite(mediaRegistry.getMediaList().get(0).getName()); //mediaRegistry.get.... Is temp for this to work : Was movie
        messageFromDB = mediaRegistry.addFavorite(mediaRegistry.getMediaList().get(0).getName());

        assertEquals("Failed", messageFromDB);
    }

    // This test tries to add media remove the favoritelist, and see if it gets the right String back
    @Test
    public void MediaRegistry_removeFavorite_Success() {
        String messageFromDB;
        mediaRegistry.addFavorite(mediaRegistry.getMediaList().get(0).getName());
        messageFromDB = mediaRegistry.removeFavorite(mediaRegistry.getMediaList().get(0).getName()); //mediaRegistry.get.... Is temp for this to work : Was movie

        assertEquals("Success", messageFromDB);
    }

    // This test tries to remove a media form the favoritelist, and see if it gets the right String back
    @Test
    public void MediaRegistry_removeFavorite_Failed() {
        String messageFromDB;
        mediaRegistry.addFavorite(mediaRegistry.getMediaList().get(1).getName());
        messageFromDB = mediaRegistry.removeFavorite(mediaRegistry.getMediaList().get(0).getName()); //mediaRegistry.get.... Is temp for this to work : Was movie

        assertEquals("Failed", messageFromDB);
    }

    // this test tries to get a media from a input. The input is in a form of a name to a media
    @Test
    public void MediaRegistry_getMedia_Name_Lost() {
        media = mediaRegistry.getMedia("Lost");

        assertEquals("Lost", media.getName());
    }





    //////////////////////////////////////////////////////////////////////////////// Data

    // This test counts the length of the media list to check if the right amount of movies, series and other types of media are present
    @Test
    public void test_Media_Length() {
        assertEquals(200,mediaRegistry.getMediaList().size());
    }

    // This test sees if by adding in a media to favortielist changes it's size
    @Test
    public void database_favoriteSet_size() {
        database.addFavoriteSet("Lost");

        assertEquals(1, database.getFavoriteSet().size());
    }

    // This test tries to add and remove a media(s) form the favoritelist, and see if it gets the right size
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
