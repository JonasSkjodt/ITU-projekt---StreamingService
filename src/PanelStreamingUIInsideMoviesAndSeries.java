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

        JPanel leftPanel = new JPanel();
        JPanel rightPanel = new JPanel();
        this.add(leftPanel);
        this.add(rightPanel);
        leftPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        leftPanel.setLayout(new GridLayout(3,0));
        leftPanel.setBackground(Color.decode("#0d131f"));
        rightPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        rightPanel.setLayout(new GridLayout(3,0));
        rightPanel.setBackground(Color.decode("#0d131f"));

        //whats inside the panels
        Media media = mediaRegistry.getMedia(name);

        JLabel labelForImage = new JLabel();
        labelForImage.setIcon(media.getImageMedia());
        rightPanel.add(labelForImage);

        leftPanel.add(new JLabel("Name: " + media.getName())).setForeground(Color.WHITE);
        leftPanel.add(new JLabel("Year: " + media.getYear())).setForeground(Color.WHITE);;
        leftPanel.add(new JLabel("Genre: " + media.getGenre())).setForeground(Color.WHITE);;

    //dropdown
        JComboBox comboBox = new JComboBox();

        //Panel to view season and episodes in series
        if(media.getType().equals("Series")) {
            Series series = (Series) media;
            //this.add(new JLabel("Seasons: " + series.getSeasons())); to get the full amount of seasons
            for(int i = 0 ; i < Integer.parseInt(series.getSeasons()) ; i++) {
                //newPanel1.add(new JLabel("Season " + (i+1) + " Episodes: " + series.getSeasonToEpisodes("" + (i+1)))); // add dropdown

                comboBox.addItem("Season " + (i+1) + " Episodes: " + series.getSeasonToEpisodes("" + (i+1)));
            }
            leftPanel.add(comboBox);
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
        rightPanel.add(favorites);

        JButton play = new JButton("Play");
        play.addActionListener(e -> {
            play.setIcon(new ImageIcon("GreenPlayButton.png"));
            JOptionPane.showMessageDialog(null, "Your " + media.getType() + " is now playing!");
        });
        rightPanel.add(play);
    }

    private void updateFavoritesButton(String buttonText, Color color) {
        favorites.setText(buttonText);
        favorites.setBackground(color);
    }
}