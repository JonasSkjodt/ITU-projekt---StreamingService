import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class PanelStreamingUIAll extends JPanel {
    private Stream stream;

    public PanelStreamingUIAll() {
        //this.setLayout(new BorderLayout());
        this.add(new JLabel("This is panel 1 where all the media is"), BorderLayout.CENTER);

        stream = new Stream();
        this.addImageButtons();



    }

    private void addImageButtons() {
        for (Media m : stream.getMediaList()) {
            //this.add(new JLabel(m.getImageMedia()));

            //String label = m.getName();
            JButton mediaButton = new JButton();
            try {
                ImageIcon img = m.getImageMedia();
                mediaButton.setIcon(img);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
            mediaButton.setForeground(Color.white);
            mediaButton.setBorder(new EmptyBorder(0, 0, 15, 0));
            //remove standard styling
            mediaButton.setBorderPainted(false);
            mediaButton.setFocusPainted(false);
            mediaButton.setContentAreaFilled(false);
            this.add(mediaButton);
        }
    }

}
