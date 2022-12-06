import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.Image;

public class PanelHeader extends JPanel {

    public JButton UserProfileButton;
    private JTextField searchText;

    public PanelHeader() {
        this.add(new JLabel("This is header panel"));
        this.SearchAllMedia();
        this.UserProfile();
        this.UserProfileImage();
    }

    private void UserProfile() {
        this.UserProfileButton = new JButton("Profile User");
        //action listener
        // this.pressMeButton.addActionListener(new PressMeButtonActionListener());
        this.add(UserProfileButton);
        UserProfileButton.setForeground(Color.white);
        UserProfileButton.setBorder(new EmptyBorder(0, 0, 15, 0));
        //remove standard styling
        UserProfileButton.setBorderPainted(false);
        UserProfileButton.setFocusPainted(false);
        UserProfileButton.setContentAreaFilled(false);
    }

    private void UserProfileImage() {
        // Create the images
        ImageIcon icon1 = new ImageIcon("img/user.png");
        Image img1 = icon1.getImage();
        Image newimg1 = img1.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
        ImageIcon newIcon1 = new ImageIcon(newimg1);

        // Create the labels
        JLabel label1 = new JLabel(newIcon1);

        // Add the label to the panel
        this.add(label1);
    }

    private void SearchAllMedia() {
        searchText = new JTextField();
        searchText.setPreferredSize(new Dimension(350,40));
        this.add(searchText);
    }

}