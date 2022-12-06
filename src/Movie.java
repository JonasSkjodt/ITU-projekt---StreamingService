//import java.awt.image.BufferedImage;
import java.util.List;

public class Movie extends Media {
    public Movie(String name, List<String> genre, String year) {
        super(name, genre, year);
    }

    @Override
    public String toString() {
        return super.toString() + " : Movie";
    }

    @Override
    public String getType() {
        return "Movie";
    }
}
