public class Medier {
    String navn;
    String genre;

    Medier(String navn, String genre) {
        this.navn = navn;
        this.genre = genre;
    }

    public String getNavn() {
        return navn;
    }

    public String getGenre() {
        return genre;
    }
}
