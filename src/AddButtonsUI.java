import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class AddButtonsUI {

    private static JPopupMenu pm;

    /*
    private static MediaRegistry mediaRegistry;
    private static List<Media> listMedia; */

    /*public AddButtonsUI() {
        this.mediaRegistry = new MediaRegistry();
        this.listMedia = new ArrayList<>();
    }*/


    public static JPanel addButtonsToPanel(String filter, JPanel mediaPanelMovies) {
        MediaRegistry mediaRegistry = new MediaRegistry();
        List<Media> listMedia = new ArrayList<>();
        pm = new JPopupMenu("Message");


        /*switch (filter) {
            case "Movies":
                listMedia = mediaRegistry.filterMovie();
                break;
            case "Series":
                listMedia = mediaRegistry.filterSeries();
                break;
            case "Favorites":
                listMedia = mediaRegistry.getFavoritesList();
                break;
        }*/

        if(mediaRegistry.getGenreList().contains(filter)) {
            listMedia = mediaRegistry.filterGenre(filter);
        } else if (filter.equals("Movies")) {
            listMedia = mediaRegistry.filterMovie();
        } else if (filter.equals("Series")) {
            listMedia = mediaRegistry.filterSeries();
        } else if (filter.equals("Favorites")) {
            listMedia = mediaRegistry.getFavoritesList();
        } else {
            listMedia = mediaRegistry.searchField(filter);
        }

        for (Media m : listMedia) {
            JButton mediaButton = new JButton();
            try {
                ImageIcon imageIcon = m.getImageMedia(); //load the images
                mediaButton.setIcon(imageIcon);
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
                    //silence is golden!
                    String s = e.getActionCommand();
                    if (s.equals("click")) {

                        // add the popup to the frame
                        pm.show(mediaPanelMovies, 200, 200);
                    }
                }
            });
            //add the mediaButton to the panel
            mediaPanelMovies.add(mediaButton);
        }
        return mediaPanelMovies;
    }

}
