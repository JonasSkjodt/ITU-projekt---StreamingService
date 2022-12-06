import javax.swing.*;
import java.awt.*;
import java.util.List;


public class Movie extends Media {

    Movie(String name, String year, List<String> genre, ImageIcon image) {
        super(name, year, genre, image);
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
