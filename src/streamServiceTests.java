import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.util.*;


public class streamServiceTests {

    private StreamingUI streamingUI;
    private Stream stream;
    private Series series;
    private Movie movie;

    @BeforeEach
    public void setUp()
    {
        streamingUI = new StreamingUI();
        stream = new Stream();
        series = new Series("The walking dead", "Horror", "Dead person", 5, 12);
        movie = new Movie("Dune", "Action", "Sand");
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
    @Test //(expected = NullPointerException.class)
    public void stream_searchfield(){
        List<Media> mediaList = new ArrayList<>();
        mediaList.add(movie);
        mediaList.add(series);

        List<Media> filteredMediaList = new ArrayList<>();
        filteredMediaList = stream.searchField("Dune");

       assertEquals(mediaList, filteredMediaList);
    }


}
