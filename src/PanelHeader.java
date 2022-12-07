import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelHeader extends JPanel {
    private JButton UserProfileButton;
    private JButton searchAllMediaButton;

    public PanelHeader() {
        this.SearchTextButton();
        this.UserProfile();
    }

    private void SearchTextButton(){
        this.searchAllMediaButton = new JButton();
        searchAllMediaButton.setForeground(Color.white);
        //remove standard styling
        searchAllMediaButton.setBorderPainted(false);
        searchAllMediaButton.setFocusPainted(false);
        searchAllMediaButton.setContentAreaFilled(false);
        //insert image in button
        ImageIcon searchimageIcon = new ImageIcon("data/img/search.png");
        searchAllMediaButton.setIcon(searchimageIcon);

        //hover animation effect
        //TODO: insert search on click
        searchAllMediaButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                //change the mouse marker on media buttons
                searchAllMediaButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }
        });

        searchAllMediaButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String name = JOptionPane.showInputDialog(
                        "TO DO: this is the search", null);
            }
        });

        //add the button to the panel
        this.add(searchAllMediaButton);
    }
    private void UserProfile() {
        this.UserProfileButton = new JButton("Dan Smith");
        UserProfileButton.setForeground(Color.white);
        //remove standard styling
        UserProfileButton.setBorderPainted(false);
        UserProfileButton.setFocusPainted(false);
        UserProfileButton.setContentAreaFilled(false);
        //insert image in button
        ImageIcon profileimageIcon = new ImageIcon("data/img/man.png");
        UserProfileButton.setIcon(profileimageIcon);

        //hover animation effect
        //TODO: insert profilepanel on click
        UserProfileButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {

                //change the mouse marker on media buttons
                UserProfileButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }
        });

        UserProfileButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String name = JOptionPane.showInputDialog(
                        "TO DO: this is the profile panel", null);
            }
        });

        //add the button to the panel
        this.add(UserProfileButton);
    }

}