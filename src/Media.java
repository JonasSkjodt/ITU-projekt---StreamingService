//import java.awt.image.BufferedImage;

import java.util.List;

public abstract class Media {
    private String name;
    private List<String> genre;
    private String year;
    public Media(String name, List<String> genre, String year) {
        this.name = name;
        this.genre = genre;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public List<String> getGenre() {
        return genre;
    }

    public String getType() {
        return "Media";
    }

    @Override
    public String toString() {
        return  "name= " + getName() + ", genre= " + getGenre();
    }
}
