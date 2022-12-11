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
        this.setLayout(new GridLayout(0, 1));
        this.add(new JLabel("Name: " + media.getName()));
        this.add(new JLabel("Year: " + media.getYear()));
        this.add(new JLabel("Genre: " + media.getGenre()));
        this.add(new JButton().setIcon(media.getImageMedia())); //TODO fix this shit
        if(media.getType().equals("Series")) {
            Series series = (Series) media;

            //Panel to view season and episodes in series

            //this.add(new JLabel("Seasons: " + series.getSeasons()));
            //this.add(new JLabel("Episodes: " + series.getSeasonToEpisodes("1")));
        }

        //wheres the info for the movies and series?
        //String mediaData = mediaRegistry.();
        JButton favorites = new JButton("Favorites");
        this.add(favorites); //changes from a plus to a minus depending on add or remove and changes color

        JButton play = new JButton("Play");
        this.add(play); //When pressed change icon from red play button to green play button and add a popup that say "Your .getType() is now playing"
    }

}
