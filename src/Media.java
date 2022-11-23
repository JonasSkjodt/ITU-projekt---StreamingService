public class Media {
    private String name; //begge felter skal måske være final da de ikke ændre sig
    private String genre;

    Media(String name, String genre) {
        this.name = name;
        this.genre = genre;
    }

    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }
}
