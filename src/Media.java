import java.util.ArrayList;
import java.util.List;

public abstract class Media {
    private String name; //begge felter skal måske være final da de ikke ændre sig
    private List<String> genreList;
    private String year;

    //Media Creation from list and String in Database
    Media(String name, String year, List<String> genre) {
        this.name = name;
        this.year = year;
        genreList = new ArrayList<>();
        genreList.addAll(genre);
    }

    public String getName() {
        return name;
    }

    public List<String> getGenre() { //TODO make it list out the items as Strings and not as a list maybe
        return genreList;
    }
}
