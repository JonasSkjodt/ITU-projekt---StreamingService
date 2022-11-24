import java.awt.image.BufferedImage;

public abstract class Media {
    private String name;
    private String genre;
    private String titleImage;
    public Media(String name, String genre, String titleImage) {
        this.name = name;
        this.genre = genre;
        this.titleImage = titleImage;
    }

    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }

    public String getTitleImage() {
        return titleImage;
    }
}
