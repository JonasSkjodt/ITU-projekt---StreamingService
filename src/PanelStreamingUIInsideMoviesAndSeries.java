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

        JLabel label123 = new JLabel("Name: " + media.getName());
        label123.setForeground(Color.white);
        ImageIcon justatestimage = new ImageIcon("data/img/logo.png");
        label123.setIcon(justatestimage);
        this.add(label123, BorderLayout.CENTER);
    }

}
