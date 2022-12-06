import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

public class StreamingUI extends JFrame {
    /**
     * Define variables
     */
    //frame
    private JFrame frame;

    //panels
    private JPanel contentPanel;

    public StreamingUI() {

        /**
         * Panels
         * The panels work as the containers for the components
         *
         */

        //contentPanel
        contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout(10,0));
        contentPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        contentPanel.setBackground(Color.decode("#0d131f"));

        //this is panel 1 (SHOWS ALL MEDIA)
        //PanelStreamingUIAll
        PanelStreamingUIAll PanelWithAllMedia = new PanelStreamingUIAll();
        PanelWithAllMedia.setOpaque(true);
        PanelWithAllMedia.setBackground(Color.decode("#0d131f"));
        PanelWithAllMedia.setLayout(new GridLayout(20, 9));
        //PanelWithAllMedia.setSize(50, 150);
        //PanelWithAllMedia.setPreferredSize(new Dimension(1280,720));
        contentPanel.add(PanelWithAllMedia, BorderLayout.CENTER); //center



        //this is panel 2 (MOVIES ONLY)
        //PanelStreamingUIMovies PanelWithMovies = new PanelStreamingUIMovies();
        //contentPanel.add(PanelWithMovies, BorderLayout.LINE_END);

        //this is panel 3 (SERIES ONLY)
        //PanelStreamingUISeries PanelWithSeries = new PanelStreamingUISeries();
        //mediaPanel.add(PanelWithSeries, BorderLayout.CENTER);

        //HeaderUI
        PanelHeader HeaderUI = new PanelHeader();
        HeaderUI.setOpaque(true);
        HeaderUI.setBackground(Color.decode("#141c2e"));
        //HeaderUI.setPreferredSize(new Dimension(1280,50));
        contentPanel.add(HeaderUI, BorderLayout.PAGE_START); //top



        /**
         * Frame
         * The overall window the program is working in
         */
        frame = new JFrame();
        frame.add(contentPanel,BorderLayout.CENTER);
        frame.setDefaultCloseOperation((JFrame.EXIT_ON_CLOSE));
        frame.setTitle("Streamer");
        frame.pack();
        //frame.setSize(1320,720);
        frame.setVisible(true);

        //Scrollbar
        JScrollPane scrollPane = new JScrollPane(contentPanel,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        frame.getContentPane().add(scrollPane);
    }

    public static void main(String[] args) {
        try {
            new StreamingUI();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

