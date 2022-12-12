package Presentation;
import Domain.MediaRegistry;
import Domain.Media;
import Domain.Series;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class StreamingPopUp extends JPanel {

    private JButton favorites;
    public StreamingPopUp(String name, MediaRegistry mediaRegistry) {
        this.movieAndSeriesData(name, mediaRegistry);
    }

    private void movieAndSeriesData(String name, MediaRegistry mediaRegistry) {
        Media media = mediaRegistry.getMedia(name);

        //create the panels
        JPanel leftPanel = new JPanel();
        JPanel rightPanel = new JPanel();
        this.add(leftPanel);
        this.add(rightPanel);
        leftPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        leftPanel.setLayout(new GridBagLayout());
        leftPanel.setBackground(Color.decode("#0d131f"));
        rightPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        rightPanel.setLayout(new GridBagLayout());
        rightPanel.setBackground(Color.decode("#0d131f"));

        //left panel
        GridBagConstraints gbcName = new GridBagConstraints();
        gbcName.gridx = 0;
        gbcName.gridy = 0;
        JLabel labelName = new JLabel("Name: " + media.getName());
        labelName.setForeground(Color.white);
        leftPanel.add(labelName, gbcName);

        GridBagConstraints gbcYear = new GridBagConstraints();
        gbcYear.gridx = 0;
        gbcYear.gridy = 1;
        JLabel labelYear = new JLabel("Year: " + media.getYear());
        labelYear.setBorder(new EmptyBorder(10, 0, 0, 0));
        labelYear.setForeground(Color.white);
        leftPanel.add(labelYear, gbcYear);

        GridBagConstraints gbcGenre = new GridBagConstraints();
        gbcGenre.gridx = 0;
        gbcGenre.gridy = 2;
        JLabel labelGenre = new JLabel("Genre: " + media.getGenre());
        labelGenre.setBorder(new EmptyBorder(10, 0, 10, 0));
        labelGenre.setForeground(Color.white);
        leftPanel.add(labelGenre, gbcGenre);

        //dropdown
        JComboBox seasonsToEpisodes = new JComboBox();
        //Panel to view season and episodes in series
        if(media.getType().equals("Series")) {
            Series series = (Series) media;
            //this.add(new JLabel("Seasons: " + series.getSeasons())); to get the full amount of seasons
            for(int i = 0 ; i < Integer.parseInt(series.getSeasons()) ; i++) {
                seasonsToEpisodes.addItem("Season " + (i+1) + " Episodes: " + series.getSeasonToEpisodes("" + (i+1)));
            }
            GridBagConstraints gbcSeason = new GridBagConstraints();
            gbcSeason.gridx = 0;
            gbcSeason.gridy = 3;
            leftPanel.add(seasonsToEpisodes, gbcSeason);
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

        //right panel
        JLabel labelForImage = new JLabel();
        labelForImage.setIcon(media.getImageMedia());
        GridBagConstraints gbcImage = new GridBagConstraints();
        gbcImage.gridx = 0;
        gbcImage.gridy = 0;
        labelForImage.setBorder(new EmptyBorder(0, 0, 20, 0));
        rightPanel.add(labelForImage, gbcImage);

        GridBagConstraints gbcFavorites = new GridBagConstraints();
        gbcFavorites.gridx = 0;
        gbcFavorites.gridy = 1;
        favorites.setPreferredSize(new Dimension(150, 30));
        rightPanel.add(favorites, gbcFavorites);

        JButton play = new JButton("Play");
        // Sets the background of the button to hexcode
        play.setBackground(Color.decode("#ffffff"));
        // Sets the font of the button to a sans-serif font
        play.setFont(new Font("Sans-Serif", Font.PLAIN, 14));
        // Sets the foreground color of the button to black
        play.setForeground(Color.BLACK);
        // Sets the size of the button to the preferred size
        play.setPreferredSize(new Dimension(150, 30));
        GridBagConstraints gbcPlay = new GridBagConstraints();
        gbcPlay.gridx = 0;
        gbcPlay.gridy = 2;
        play.addActionListener(e -> {
            play.setIcon(new ImageIcon("Data/img/playGreen.png"));
            JOptionPane.showMessageDialog(null, "Your " + media.getType() + " is now playing!");
        });
        rightPanel.add(play, gbcPlay);
    }

    private void updateFavoritesButton(String buttonText, Color color) {
        favorites.setText(buttonText);
        favorites.setBackground(color);
    }
}