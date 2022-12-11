import javax.swing.*;
import java.awt.*;

public class PanelStreamingUIInsideMoviesAndSeries extends JPanel {

    private JButton favorites;
    public PanelStreamingUIInsideMoviesAndSeries(String name, MediaRegistry mediaRegistry) {
        this.movieAndSeriesData(name, mediaRegistry);
    }

    private void movieAndSeriesData(String name, MediaRegistry mediaRegistry) {
        Media media = mediaRegistry.getMedia(name);

        JLabel labelForImage = new JLabel();
        labelForImage.setIcon(media.getImageMedia());
        this.add(labelForImage);
        this.setLayout(new GridLayout(0, 1));
        this.add(new JLabel("Name: " + media.getName()));
        this.add(new JLabel("Year: " + media.getYear()));
        this.add(new JLabel("Genre: " + media.getGenre()));

        //Panel to view season and episodes in series
        if(media.getType().equals("Series")) {
            Series series = (Series) media;
            this.add(new JLabel("Seasons: " + series.getSeasons()));
            this.add(new JLabel("Episodes: " + series.getSeasonToEpisodes("1")));
        }

        favorites = new JButton("Add Favorite");
        favorites.addActionListener(e -> {
            if (mediaRegistry.getFavoritesList().contains(media)) {
                mediaRegistry.removeFavorite(media.getName());
                updateFavoritesButton("Remove Favorite", Color.RED);
            } else {
                mediaRegistry.addFavorite(media.getName());
                updateFavoritesButton("Add Favorite", Color.GREEN);
            }
        });
        this.add(favorites);

        JButton play = new JButton("Play");
        play.addActionListener(e -> {
            play.setIcon(new ImageIcon("GreenPlayButton.png"));
            JOptionPane.showMessageDialog(null, "Your " + media.getType() + " is now playing!");
        });
        this.add(play);
    }

    private void updateFavoritesButton(String buttonText, Color color) {
        favorites.setText(buttonText);
        favorites.setBackground(color);
    }
}