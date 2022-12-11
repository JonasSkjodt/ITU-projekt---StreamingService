import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
            for(int i = 0 ; i < Integer.parseInt(series.getSeasons()) ; i++) {
                this.add(new JLabel("Season " + (i+1) + " Episodes: " + series.getSeasonToEpisodes("" + (i+1))));
            }

        }
        if(mediaRegistry.getFavoritesList().contains(media)) {
            favorites = new JButton("Remove favorites");
            favorites.setBackground(Color.RED);
        } else {
            favorites = new JButton("Add favorites");
            favorites.setBackground(Color.GREEN);
        }

        favorites.addActionListener(e -> {
            if (mediaRegistry.getFavoritesList().contains(media)) {
                mediaRegistry.removeFavorite(media.getName());
                updateFavoritesButton("Add favorite", Color.GREEN);
            } else {
                mediaRegistry.addFavorite(media.getName());
                updateFavoritesButton("Remove favorite", Color.RED);
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