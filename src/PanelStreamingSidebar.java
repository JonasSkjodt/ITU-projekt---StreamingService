import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class PanelStreamingSidebar extends JPanel {

    public JButton pressMeButton;

    public PanelStreamingSidebar() {
        this.add(new JLabel("This is the sidebar panel"));
        this.initPressMeButton();
    }

    private void initPressMeButton() {
        this.pressMeButton = new JButton("Press Me");
        //action listener
        // this.pressMeButton.addActionListener(new PressMeButtonActionListener());
        this.add(pressMeButton, BorderLayout.SOUTH);
        //Movies button
        pressMeButton.setForeground(Color.white);
        pressMeButton.setBorder(new EmptyBorder(0, 0, 15, 0));
        //remove standard styling
        pressMeButton.setBorderPainted(false);
        pressMeButton.setFocusPainted(false);
        pressMeButton.setContentAreaFilled(false);
    }


}