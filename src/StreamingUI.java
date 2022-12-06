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
    private JPanel panelHeaderUI;

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
        PanelWithAllMedia.setLayout(new GridLayout(0, 7)); //must be set to 0 rows, otherwise it gets wonky
        PanelWithAllMedia.setBorder(new EmptyBorder(0, 0, 0, 20)); //making an empty border because of the scrollbar
        contentPanel.add(PanelWithAllMedia, BorderLayout.CENTER); //center


        //this is panel 2 (MOVIES ONLY)
        //PanelStreamingUIMovies PanelWithMovies = new PanelStreamingUIMovies();
        //contentPanel.add(PanelWithMovies, BorderLayout.LINE_END);

        //this is panel 3 (SERIES ONLY)
        //PanelStreamingUISeries PanelWithSeries = new PanelStreamingUISeries();
        //mediaPanel.add(PanelWithSeries, BorderLayout.CENTER);

        //HeaderUI
        panelHeaderUI = new JPanel();
        panelHeaderUI.setLayout(new BorderLayout(10,0));
        panelHeaderUI.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        panelHeaderUI.setBackground(Color.decode("#0d131f"));
        contentPanel.add(panelHeaderUI, BorderLayout.PAGE_START); //top

        PanelHeader InsideHeaderUI = new PanelHeader();
        InsideHeaderUI.setOpaque(true);
        InsideHeaderUI.setBackground(Color.decode("#141c2e"));
        panelHeaderUI.add(InsideHeaderUI);

        /**
         * Frame
         * The overall window the program is working in
         */
        frame = new JFrame();
        frame.add(contentPanel,BorderLayout.CENTER);
        frame.setDefaultCloseOperation((JFrame.EXIT_ON_CLOSE));
        frame.setTitle("Streamer");
        frame.pack();
        frame.setSize(1280,720);
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

