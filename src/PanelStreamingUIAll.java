import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static java.lang.Thread.sleep;

public class PanelStreamingUIAll extends JPanel {
    private Stream stream;

    public PanelStreamingUIAll() {
        stream = new Stream();
        this.addImageButtons();
    }

    /**
     * movie and series button with image loop
     */
    private void addImageButtons() {
        for (Media m : stream.getMediaList()) {
            JButton mediaButton = new JButton();
            try {
                ImageIcon imageIcon = m.getImageMedia(); //load the images
                mediaButton.setIcon(imageIcon);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
            //style the button a bit
            mediaButton.setForeground(Color.white);
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
                    ImageIcon hoverImage2 = new ImageIcon("data/img/play.png");
                    mediaButton.setIcon(hoverImage2);

                    //change the mouse marker on media buttons
                    mediaButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                }
                @Override
                public void mouseExited(MouseEvent e) {
                    ImageIcon imageIcon = m.getImageMedia(); //load the images
                    mediaButton.setIcon(imageIcon);
                }
            });

            //add the mediaButton to the panel
            this.add(mediaButton);
        }
    }

}
