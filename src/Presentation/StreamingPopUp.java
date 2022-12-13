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
        JLabel labelGenre = new JLabel("Genre: " + media.getGenre().toString().replace("[","").replace("]",""));
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

        //right panel

        if(mediaRegistry.getFavoritesList().contains(media)) {
            favorites = new JButton("Remove favorite");
            favorites.setBackground(Color.RED);

        } else {
            favorites = new JButton("Add to favorites");
            favorites.setBackground(Color.GREEN);
        }
        //styling the favorite button further (testing)
        favorites.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        favorites.setFocusPainted(false);
        favorites.setFont(new Font("Arial", Font.BOLD, 13));
        favorites.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        favorites.addActionListener(e -> {
            if (mediaRegistry.getFavoritesList().contains(media)) {
                mediaRegistry.removeFavorite(media.getName());
                updateFavoritesButton("Add to favorites", Color.GREEN);
            } else {
                mediaRegistry.addFavorite(media.getName());
                updateFavoritesButton("Remove favorite", Color.RED);
            }
        });

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

        //<!-- styling started for play button -->
        play.setBackground(Color.decode("#ffffff"));
        play.setForeground(Color.BLACK);
        play.setPreferredSize(new Dimension(150, 30));
        play.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        play.setFocusPainted(false);
        play.setFont(new Font("Arial", Font.BOLD, 13));
        play.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        //different kind of icons for the button in each their state. Example: https://hajsoftutorial.com/jbutton-with-setrollovericon/
        //play.setRolloverEnabled(true);
        //play.setRolloverIcon(new ImageIcon(new ImageIcon("play-hover.png").getImage().getScaledInstance(150, 30, Image.SCALE_DEFAULT)));
        //play.setPressedIcon(new ImageIcon(new ImageIcon("play-pressed.png").getImage().getScaledInstance(150, 30, Image.SCALE_DEFAULT)));
        //hover effect
        play.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                play.setBackground(Color.decode("#cccccc"));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                play.setBackground(Color.decode("#ffffff"));
            }
        });
        //<!-- styling ended for play button -->

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