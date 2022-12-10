import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelStreamingUIAll extends JPanel {
    private MediaRegistry mediaRegistry;

    public PanelStreamingUIAll() {
        mediaRegistry = new MediaRegistry();
        this.addImageButtons();
    }

    /**
     * movie and series button with image loop
     */
    private void addImageButtons() {
        for (Media m : mediaRegistry.getMediaList()) {
            JButton mediaButton = new JButton();
            try {
                ImageIcon imageIcon = m.getImageMedia(); //load the images
                mediaButton.setIcon(imageIcon);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
            //style the button a bit
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
                    ImageIcon hoverImage = new ImageIcon("data/img/play.png");
                    mediaButton.setIcon(hoverImage);

                    //change the mouse marker on media buttons
                    mediaButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                }
                @Override
                public void mouseExited(MouseEvent e) {
                    ImageIcon imageIcon = m.getImageMedia(); //load the images
                    mediaButton.setIcon(imageIcon);
                }
            });


            // SHOULD NOT BE HERE BUT IN AddButtonsUI, temporary code
            /**
             * Pop Up for clicking on movies or series - should probably be somewhere else
             */
            // Fix this with better code (pop up with new panel container)
            JDialog dialog1 = new JDialog();
            dialog1.setModal(true);
            dialog1.setSize(1280, 720);
            dialog1.setLocationRelativeTo(null);

            //Set up the new panel from PanelStreamingUIInsideMoviesAndSeries
            PanelStreamingUIInsideMoviesAndSeries panelInsideMoviesAndSeries = new PanelStreamingUIInsideMoviesAndSeries();
            panelInsideMoviesAndSeries.setOpaque(true);
            panelInsideMoviesAndSeries.setBackground(Color.decode("#0d131f"));
            panelInsideMoviesAndSeries.setBorder(new EmptyBorder(10, 0, 0, 20));

            //set up the new container popup and add the panelInsideMoviesAndSeries panel to it:
            Container contentPane = dialog1.getContentPane();
            contentPane.setLayout(new BorderLayout(10,0));
            contentPane.add(panelInsideMoviesAndSeries);
            mediaButton.addActionListener(new java.awt.event.ActionListener() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    dialog1.setVisible(true);
                }
            });
            //add the mediaButton to the panel

            this.add(mediaButton);
        }
    }

}
