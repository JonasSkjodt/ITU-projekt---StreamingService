//import java.awt.image.BufferedImage;

import java.util.List;

public abstract class Media {
    private String name;
    private List<String> genre;

    public Media(String name, List<String> genre) {
        this.name = name;
        this.genre = genre;
    }

    public String getName() {
        return name;
    }

    public List<String> getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return  "name= " + getName() + ", genre= " + getGenre();
    }
}
