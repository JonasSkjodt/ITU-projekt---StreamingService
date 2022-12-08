import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.util.*;


public class streamServiceTests {

    private StreamingUI streamingUI;
    private Stream stream;
    private Series series;
    private Movie movie;
    private Database database;

    public streamServiceTests() {
        this.database = new Database();
    }

    @BeforeEach
    public void setUp()
    {
        this.streamingUI = new StreamingUI();
        this.stream = new Stream();

    }

    @AfterEach
    public void tearDown()
    {
        this.streamingUI = null;
        this.stream = null;
        this.series = null;
        this.movie = null;
    }

    // for this test, it is going to the class Stream, where the test will see if can get a list of possible related Media.
    // The expected result from this, would be a watered-down list of the original full list based on input from the searchfield.
    @Test
    public void stream_searchfield_input_the() {
        List<Media> searchedMediaList = new ArrayList<>();
        searchedMediaList = stream.searchField("The");

        assertTrue(searchedMediaList.size() < 100);
    }

    //
    @Test
    public void stream_filtergenre_input_Drama() {
        List<Media> filteredMediaList = new ArrayList<>();
        filteredMediaList = stream.filterGenre("Drama");

        assertTrue(filteredMediaList.size() < 200 & filteredMediaList.size() != 0);
    }

    @Test
    public void stream_filtertýpe_input_Movie() {
        List<Media> filteredMediaList = new ArrayList<>();
        filteredMediaList = stream.filterType("Movie");

        assertTrue(filteredMediaList.size() < 200 & filteredMediaList.size() != 0);
    }

    @Test
    public void stream_editFavorite_add_new_Movie() {
        String messageFromDB;
        messageFromDB = stream.editFavorite(movie, "ADD");

        assertEquals("Success", messageFromDB);
    }

    @Test
    public void stream_editFavorite_remove_Movie() {
        String messageFromDB;
        messageFromDB = stream.editFavorite(movie, "REMOVE");

        assertEquals("Failed", messageFromDB);
    }


    ////////////////////////////////////////////////////////////////////////////////

    @Test //This test counts the length of the media list to check if the right amount of movies, series and other types of media are present
    public void test_Media_Length() {
        assertEquals(200,this.database.getMedia().size());
    }

}
