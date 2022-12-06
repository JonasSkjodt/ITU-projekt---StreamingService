import java.util.List;


public class Movie extends Media {

    Movie(String name, String year, List<String> genre) {
        super(name, year, genre);
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
