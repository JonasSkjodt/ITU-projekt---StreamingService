//import java.awt.image.BufferedImage;
import java.util.List;

public class Movie extends Media {
    public Movie(String name, List<String> genre) {
        super(name, genre);
    }

    @Override
    public String toString() {
        return super.toString() + " : Movie";
    }
}
