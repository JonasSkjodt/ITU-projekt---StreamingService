import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelStreamingUIFeaturedMedia extends JPanel {
    private JLabel featuredMediaLabel;

    public PanelStreamingUIFeaturedMedia() {
        this.streamerFeaturedMedia();
    }

    private void streamerFeaturedMedia(){
        this.featuredMediaLabel = new JLabel();
        //insert image in label
        ImageIcon featuredMediaLabelImage = new ImageIcon("data/img/featured.jpg");
        featuredMediaLabel.setIcon(featuredMediaLabelImage);

        //TODO: Get a button in here for the featured post
        //featuredMediaLabel.setLayout(new FlowLayout(FlowLayout.CENTER));
        //JButton buttontoteststuff = new JButton("English Course");

        //add the label and the button to the panel
        this.add(featuredMediaLabel);

    }
}
