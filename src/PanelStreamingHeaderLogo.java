import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

public class PanelStreamingHeaderLogo extends JPanel {
    private JLabel StreamerLogo;
    private JLabel StreamerName;

    public PanelStreamingHeaderLogo() {
        this.appHeaderLogo();
        this.appHeaderName();
    }

    private void appHeaderLogo(){
        this.StreamerLogo = new JLabel();
        StreamerLogo.setForeground(Color.white);
        //insert image in label
        ImageIcon StreamerLogoPathToImage = new ImageIcon("data/img/logo.png");
        StreamerLogo.setIcon(StreamerLogoPathToImage);
        //add the label to the panel
        this.add(StreamerLogo);
    }
    private void appHeaderName() {
        this.StreamerName = new JLabel("Welcome to Streamer");
        StreamerName.setForeground(Color.white);
        this.add(StreamerName);
    }
}
