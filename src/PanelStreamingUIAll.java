import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class PanelStreamingUIAll extends JPanel {
    private Stream stream;

    public PanelStreamingUIAll() {
        stream = new Stream();
        this.addImageButtons();
    }

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
            mediaButton.setForeground(Color.white);
            mediaButton.setBorder(new EmptyBorder(15, 15, 15, 15));
            //remove standard styling
            mediaButton.setBorderPainted(false);
            mediaButton.setFocusPainted(false);
            mediaButton.setContentAreaFilled(false);
            this.add(mediaButton);
        }
    }
}
