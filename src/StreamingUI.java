import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicScrollBarUI;
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
    private JPanel mediaPanel;

    public StreamingUI() {

        /**
         * Panels
         * The panels work as the containers for the components
         */

        //contentPanel is the first, and biggest panel on top of the frame. It has a borderlayout.
        contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout(10,0));
        contentPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        contentPanel.setBackground(Color.decode("#0d131f"));

        //mediaPanel is CENTERED inside contentPanel with a borderLayout inside contentpanels borderlayout.
        mediaPanel = new JPanel();
        mediaPanel.setLayout(new BorderLayout(10,0));
        mediaPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        mediaPanel.setBackground(Color.decode("#0d131f"));
        contentPanel.add(mediaPanel, BorderLayout.CENTER); //center

        //comboboxMoviesandSeries is TOP NORTH of the insides of mediaPanel
        PanelStreamingFilter comboboxMoviesandSeries = new PanelStreamingFilter();
        comboboxMoviesandSeries.setOpaque(true);
        comboboxMoviesandSeries.setBackground(Color.decode("#0d131f"));
        mediaPanel.add(comboboxMoviesandSeries, BorderLayout.PAGE_START); //Top

        //this is panel 1 (SHOWS ALL MEDIA)
        //PanelStreamingUIAll is CENTERED inside mediaPanel
        PanelStreamingUIAll PanelWithAllMedia = new PanelStreamingUIAll();
        PanelWithAllMedia.setOpaque(true);
        PanelWithAllMedia.setBackground(Color.decode("#0d131f"));
        PanelWithAllMedia.setLayout(new GridLayout(0, 9)); //must be set to 0 rows, otherwise it gets wonky
        PanelWithAllMedia.setBorder(new EmptyBorder(0, 0, 0, 20)); //making an empty border because of the scrollbar
        mediaPanel.add(PanelWithAllMedia, BorderLayout.CENTER); //center

        //this is panel 2 (MOVIES ONLY)
        //PanelStreamingUIMovies PanelWithMovies = new PanelStreamingUIMovies();
        //contentPanel.add(PanelWithMovies, BorderLayout.LINE_END);

        //this is panel 3 (SERIES ONLY)
        //PanelStreamingUISeries PanelWithSeries = new PanelStreamingUISeries();
        //mediaPanel.add(PanelWithSeries, BorderLayout.CENTER);

        //Header Panel, TOP NORTH in contentpanel's border layout
        panelHeaderUI = new JPanel();
        panelHeaderUI.setLayout(new BorderLayout(10,0));
        panelHeaderUI.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        panelHeaderUI.setBackground(Color.decode("#0d131f"));
        contentPanel.add(panelHeaderUI, BorderLayout.PAGE_START); //top

        //inside the headerUI panel
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
        frame.setSize(1600,900);
        frame.setVisible(true);

        //Scrollbar
        JScrollPane scrollPane = new JScrollPane(contentPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
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

