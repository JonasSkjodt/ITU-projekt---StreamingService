import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelStreamingUIInsideMoviesAndSeries extends JPanel {
    private MediaRegistry mediaRegistry;

    private JButton favorites;
    public PanelStreamingUIInsideMoviesAndSeries(String name) {
        this.movieAndSeriesData(name);
    }

    private void movieAndSeriesData(String name) {
        mediaRegistry = new MediaRegistry();
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

        /*JButton favorites = new JButton("Favorite");
        favorites.addActionListener(e -> {
            if(favorites.getText().equals("Favorite")) {
                favorites.setText("Remove Favorite");
                favorites.setBackground(Color.RED);
            } else if(favorites.getText().equals("Remove Favorite")){
                favorites.setText("Favorite");
                favorites.setBackground(Color.GREEN);
            }
        });
        this.add(favorites);*/

        favorites = new JButton("Favorite");
        favorites.addActionListener(e -> {
            if(favorites.getText().equals("Favorite")) {
                updateFavoritesButton("Remove Favorite", Color.RED);
            } else if(favorites.getText().equals("Remove Favorite")){
                updateFavoritesButton("Favorite", Color.GREEN);
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
