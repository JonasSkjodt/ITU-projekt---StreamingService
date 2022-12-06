import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelStreamingUIAll extends JPanel {
    private Stream stream;

    public PanelStreamingUIAll() {
        stream = new Stream();
        this.addImageButtons();
    }

    /**
     * movie and series button with image
     * TODO: Get better resolution images
     */
    private void addImageButtons() {
        for (Media m : stream.getMediaList()) {
            //this.add(new JLabel(m.getImageMedia()));
            //String label = m.getName();
            JButton mediaButton = new JButton();
            try {
                ImageIcon imageIcon = m.getImageMedia(); //load the images
                //Image image = imageIcon.getImage(); // transform it
                //Image newimg = image.getScaledInstance(100, 150,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
                //imageIcon = new ImageIcon(newimg);  // transform it back
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
                    // image
                    ImageIcon hoverImage2 = new ImageIcon("data/img/play.png");
                    Image image = hoverImage2.getImage(); // transform it
                    Image newimg = image.getScaledInstance(70, 70,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
                    ImageIcon imageIcon = new ImageIcon(newimg);  // transform it back
                    mediaButton.setIcon(imageIcon);

                    //mouse marker
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
