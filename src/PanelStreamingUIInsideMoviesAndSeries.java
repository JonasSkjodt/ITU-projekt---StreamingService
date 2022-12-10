import javax.swing.*;
import java.awt.*;

public class PanelStreamingUIInsideMoviesAndSeries extends JPanel {
    private MediaRegistry mediaRegistry;

    public PanelStreamingUIInsideMoviesAndSeries() {
        this.movieAndSeriesData();
    }

    private void movieAndSeriesData() {

        mediaRegistry = new MediaRegistry();
        //wheres the info for the movies and series?
        //String mediaData = mediaRegistry.();

        JLabel label123 = new JLabel("Insert the media data here");
        label123.setForeground(Color.white);
        ImageIcon justatestimage = new ImageIcon("data/img/logo.png");
        label123.setIcon(justatestimage);
        this.add(label123, BorderLayout.CENTER);
    }

}
