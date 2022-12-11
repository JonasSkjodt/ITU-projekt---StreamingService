import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;


public class AddButtonsUI {

    public static JPanel addButtonsToPanel(String filter, JPanel mediaPanelMovies) {
        MediaRegistry mediaRegistry = new MediaRegistry();
        List<Media> listMedia = new ArrayList<>();

        /**
         * Pop Up for clicking on movies or series
         * could probably be another place, so this is a temporary fix
         */
        JDialog dialog = new JDialog();
        dialog.setModal(true);
        dialog.setSize(1280, 720);
        dialog.setLocationRelativeTo(null);





        //If else statements to run the code where we are
        if(mediaRegistry.getGenreList().contains(filter)) {
            listMedia = mediaRegistry.filterGenre(filter);
        } else if (filter.equals("Movies")) {
            listMedia = mediaRegistry.filterMovie();
        } else if (filter.equals("Series")) {
            listMedia = mediaRegistry.filterSeries();
        } else if (filter.equals("Favorites")) {
            listMedia = mediaRegistry.getFavoritesList();
        } else if (filter.equals("All")) {
            listMedia = mediaRegistry.getMediaList();
        }    else {
            listMedia = mediaRegistry.searchField(filter);
        }

        // outputs the selected movies and series in buttons with images
        for (Media m : listMedia) {
            JButton mediaButton = new JButton();
            try {
                ImageIcon imageIcon = m.getImageMedia(); //load the images
                mediaButton.setIcon(imageIcon);
                mediaButton.setName(m.getName()); //set the text field visability to false
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
            //style the button a bit
            mediaButton.setBorder(new EmptyBorder(15, 15, 15, 15));

            //remove standard styling
            mediaButton.setBorderPainted(false);
            mediaButton.setFocusPainted(false);
            mediaButton.setContentAreaFilled(false);

            //hover animation effect, insert the new image on mouseEntered, and the old image on mouseExited
            mediaButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    // image to hover
                    ImageIcon hoverImage = new ImageIcon("data/img/play.png");
                    mediaButton.setIcon(hoverImage);
                    //change the mouse marker on media buttons
                    mediaButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                }
                @Override
                public void mouseExited(MouseEvent e) {
                    ImageIcon imageIcon = m.getImageMedia(); //load the images
                    mediaButton.setIcon(imageIcon);
                }
            });
            mediaButton.addActionListener(new java.awt.event.ActionListener() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    System.out.println(mediaButton.getText());
                    //opens up the new panel
                    dialog.setVisible(true);
                    //Set up the new panel from PanelStreamingUIInsideMoviesAndSeries
                    PanelStreamingUIInsideMoviesAndSeries panelInsideMoviesAndSeries = new PanelStreamingUIInsideMoviesAndSeries(mediaButton.getName());
                    panelInsideMoviesAndSeries.setOpaque(true);
                    panelInsideMoviesAndSeries.setBackground(Color.decode("#0d131f"));
                    panelInsideMoviesAndSeries.setBorder(new EmptyBorder(10, 0, 0, 20));

                    //set up the new container popup (the modal) and add the panelInsideMoviesAndSeries panel to it:
                    Container contentPane = dialog.getContentPane();
                    contentPane.setLayout(new BorderLayout(10,0));
                    contentPane.add(panelInsideMoviesAndSeries);

                }
            });
            //add the mediaButton to the panel
            mediaPanelMovies.add(mediaButton);
        }
        return mediaPanelMovies;
    }

}
