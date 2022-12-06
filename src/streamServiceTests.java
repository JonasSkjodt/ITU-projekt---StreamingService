import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.util.*;


public class streamServiceTests {

    private StreamingUI streamingUI;
    private Stream stream;
    private Series series;
    private Movie movie;
    private Database database;

    @BeforeEach
    public void setUp()
    {
        streamingUI = new StreamingUI();
        stream = new Stream();
        series = new Series("The walking dead", new ArrayList<>(Arrays.asList("Action", "comedy")), "2000-2020", 4,  12);
        movie = new Movie("Dune", new ArrayList<>(Arrays.asList("Action", "comedy")), "2012");
        database = new Database();
    }

    @AfterEach
    public void tearDown()
    {
        streamingUI = null;
        stream = null;
        series = null;
        movie = null;
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
        filteredMediaList = stream.filterType("Drama");

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

        assertEquals("Media has been added", messageFromDB);
    }

    @Test
    public void stream_editFavorite_remove_Movie() {
        String messageFromDB;
        messageFromDB = stream.editFavorite(movie, "REMOVE");

        assertEquals("Media has been remove", messageFromDB);
    }

}
