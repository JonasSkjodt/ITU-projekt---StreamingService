import java.util.List;

public class Main {
    public static void main(String[] args) {
       MediaRegistry mediaRegistry = new MediaRegistry();
       List<Media> medias = mediaRegistry.searchField("god");

        for (Media m :
                medias) {
            System.out.println(m.getName());
        }

    }

}
