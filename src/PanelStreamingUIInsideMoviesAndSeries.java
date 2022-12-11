import javax.swing.*;
import java.awt.*;

public class PanelStreamingUIInsideMoviesAndSeries extends JPanel {
    private MediaRegistry mediaRegistry;

    public PanelStreamingUIInsideMoviesAndSeries(String name) {
        this.movieAndSeriesData(name);
    }

    private void movieAndSeriesData(String name) {
        mediaRegistry = new MediaRegistry();
        Media media = mediaRegistry.getMedia(name);
        //wheres the info for the movies and series?
        //String mediaData = mediaRegistry.();

        JButton favorites = new JButton("Favorites");
        this.add(favorites); //changes from a plus to a minus depending on add or remove and changes color

        JButton play = new JButton("Play");
        this.add(play); //When pressed change icon from red play button to green play button and add a popup that say "Your .getType() is now playing"


        JLabel label123 = new JLabel("Name: " + media.getName());
        label123.setForeground(Color.white);
        ImageIcon justatestimage = new ImageIcon("data/img/logo.png");
        label123.setIcon(justatestimage);
        this.add(label123, BorderLayout.CENTER);
    }

}
