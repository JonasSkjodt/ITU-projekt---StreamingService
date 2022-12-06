import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.AbstractBorder;
import javax.swing.border.EmptyBorder;

public class PanelHeader extends JPanel {

    private JButton UserProfileButton;
    private JTextField searchText;
    private JLabel searchtextLabel;

    public PanelHeader() {
        this.SearchTextLabel();
        this.SearchAllMedia();
        this.UserProfile();
    }

    private void SearchTextLabel(){
        this.searchtextLabel = new JLabel("Search:");
        searchtextLabel.setBorder(new EmptyBorder(0, 0, 0, 20));
        searchtextLabel.setForeground(Color.white);
        this.add(searchtextLabel, BorderLayout.EAST);
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
        //add the button to the panel
        this.add(UserProfileButton, BorderLayout.EAST);
        //action listener
        // this.pressMeButton.addActionListener(new PressMeButtonActionListener());
    }

    //styling the textfield, dont make it activated until it's clicked
    boolean activate = false;
    public void setActivate(boolean activate){
        this.activate = activate;
    }

    private void SearchAllMedia() {
        searchText = new JTextField();
        searchText.setPreferredSize(new Dimension(350,40));
        this.add(searchText, BorderLayout.LINE_START);

        //Styling
        searchText.setBackground(Color.white);
        searchText.setForeground(Color.gray.brighter());
        searchText.setColumns(30);
        searchText.setBorder(BorderFactory.createCompoundBorder(
                new CustomeBorder(),
                new EmptyBorder(new Insets(5, 25, 5, 25))));
        searchText.addActionListener(new FieldListener());
        searchText.addMouseListener(new FieldMouseListener());

    }

    @SuppressWarnings("serial")
    class CustomeBorder extends AbstractBorder{
        @Override
        public void paintBorder(Component c, Graphics g, int x, int y,
                                int width, int height) {
            // TODO Auto-generated method stubs
            super.paintBorder(c, g, x, y, width, height);
            Graphics2D g2d = (Graphics2D)g;
            g2d.setStroke(new BasicStroke(12));
            g2d.setColor(Color.decode("#141c2e"));
            g2d.drawRoundRect(x, y, width - 1, height - 1, 25, 25);
        }
    }

    class FieldListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            System.out.println(searchText.getText());
        }

    }

    class FieldMouseListener implements MouseListener{
        @Override
        public void mouseClicked(MouseEvent e) {
            // TODO Auto-generated method stub
            if(activate == false){
                searchText.setText("");
            }
            activate = true;
            searchText.setForeground(Color.black);
        }

        @Override
        public void mousePressed(MouseEvent e) {
            // TODO Auto-generated method stub

        }

        @Override
        public void mouseReleased(MouseEvent e) {
            // TODO Auto-generated method stub

        }

        @Override
        public void mouseEntered(MouseEvent e) {
            // TODO Auto-generated method stub

        }

        @Override
        public void mouseExited(MouseEvent e) {
            // TODO Auto-generated method stub

        }
    }

}