import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.util.*;


public class streamServiceTests {

    private StreamingUI streamingUI;
    private MediaRegistry mediaRegistry;
    private Media media;
    private Database database;

    public streamServiceTests() {
        this.mediaRegistry = new MediaRegistry();
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
    public void MediaRegistry_filterMovie_size() {
        List<Media> filteredMediaList = new ArrayList<>();
        filteredMediaList = mediaRegistry.filterMovie();

        assertTrue(filteredMediaList.size() < 200 && filteredMediaList.size() != 0);
    }
    @Test
    public void MediaRegistry_filterMovie_all_Quiet_On_The_Western_Front() {
        List<Media> filteredMediaList = new ArrayList<>();
        filteredMediaList = mediaRegistry.filterMovie();

        assertTrue(filteredMediaList.size() < 200 & filteredMediaList.size() != 0);
    }

    @Test
    public void MediaRegistry_filterSeries() {
        List<Media> filteredMediaList = new ArrayList<>();
        filteredMediaList = mediaRegistry.filterSeries();

        assertTrue(filteredMediaList.size() < 200 & filteredMediaList.size() != 0);
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

}
