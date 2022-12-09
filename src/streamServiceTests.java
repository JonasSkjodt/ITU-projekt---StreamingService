import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.util.*;


public class streamServiceTests {

    private StreamingUI streamingUI;
    private MediaRegistry mediaRegistry;
    private Series series;
    private Movie movie;
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

    }

    //////////////////////////////////////////////////////////////////////////////// Domain

    // for this test, it is going to the class Stream, where the test will see if can get a list of possible related Media.
    // The expected result from this, would be a watered-down list of the original full list based on input from the searchfield.
    @Test
    public void stream_searchfield_input_the() {
        List<Media> searchedMediaList = new ArrayList<>();
        searchedMediaList = mediaRegistry.searchField("rest");

        assertTrue(searchedMediaList.size() < 10 & searchedMediaList.size() != 0);
    }

    //
    @Test
    public void stream_filtergenre_input_Drama() {
        List<Media> filteredMediaList = new ArrayList<>();
        filteredMediaList = mediaRegistry.filterGenre("Drama");

        assertTrue(filteredMediaList.size() < 200 & filteredMediaList.size() != 0);
    }

    @Test
    public void stream_filterMovie() {
        List<Media> filteredMediaList = new ArrayList<>();
        filteredMediaList = mediaRegistry.filterMovie();

        assertTrue(filteredMediaList.size() < 200 & filteredMediaList.size() != 0);
    }

    @Test
    public void stream_filterSeries() {
        List<Media> filteredMediaList = new ArrayList<>();
        filteredMediaList = mediaRegistry.filterSeries();

        assertTrue(filteredMediaList.size() < 200 & filteredMediaList.size() != 0);
    }

    @Test
    public void stream_editFavorite_add_new_Movie() {
        String messageFromDB;
        messageFromDB = mediaRegistry.editFavorite(mediaRegistry.getMediaList().get(0).getName(), "ADD"); //mediaRegistry.get.... Is temp for this to work : Was movie

        assertEquals("Success", messageFromDB);
    }

    @Test
    public void stream_editFavorite_remove_Movie() {
        String messageFromDB;
        messageFromDB = mediaRegistry.editFavorite(mediaRegistry.getMediaList().get(0).getName(), "REMOVE"); //mediaRegistry.get.... Is temp for this to work : Was movie

        assertEquals("Failed", messageFromDB);
    }


    //////////////////////////////////////////////////////////////////////////////// Data

    @Test //This test counts the length of the media list to check if the right amount of movies, series and other types of media are present
    public void test_Media_Length() {
        assertEquals(200,mediaRegistry.getMediaList().size());
    }

}
