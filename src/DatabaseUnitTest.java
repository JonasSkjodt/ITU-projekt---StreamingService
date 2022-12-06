import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;

import java.util.*;

public class DatabaseUnitTest {


    private static final Database DB = new Database();

    DatabaseUnitTest() {
        Database DB = new Database();
        DB.readFile();
    }

    @BeforeEach
    public void setUp() {
    }

    @Test //This test counts the length of the media list to check if the right amount of movies, series and other types of media are present
    public void test_Media_Length() {
        assertEquals(200,DB.getMedia().size());
    }

    @AfterEach
    public void tearDown() {

    }

}
