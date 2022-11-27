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
        series = new Series("The walking dead", new ArrayList<>(Arrays.asList("Action", "comedy")), 4,  12);
        movie = new Movie("Dune", new ArrayList<>(Arrays.asList("Action", "comedy")));
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

    @Test
    public void stream_filter_input_Drama() {
        List<Media> filteredMediaList = new ArrayList<>();
        filteredMediaList = stream.filter("Drama");

        assertTrue(filteredMediaList.size() < 100 & filteredMediaList.size() != 0);
    }


}
