import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

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
         * TODO Collect all of this in its own method and connect it to StreamingUI()
         */

        //contentPanel is the first and biggest panel. It fills the entire frame. It has a borderlayout.
        contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout(10,0));
        contentPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        contentPanel.setBackground(Color.decode("#0d131f"));

        /**
         * header panels
         */
        //Header Panel, TOP NORTH in contentpanel's border layout
        panelHeaderUI = new JPanel();
        panelHeaderUI.setLayout(new BorderLayout(10,0));
        panelHeaderUI.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        panelHeaderUI.setBackground(Color.decode("#141c2e"));
        contentPanel.add(panelHeaderUI, BorderLayout.PAGE_START); //top

        //inside the headerUI panel
        //LEFT SIDE: LOGO AND NAME
        PanelStreamingHeaderLogo headerLogoandName = new PanelStreamingHeaderLogo();
        headerLogoandName.setOpaque(true);
        headerLogoandName.setBackground(Color.decode("#141c2e"));
        headerLogoandName.setBorder(new EmptyBorder(4, 5, 0, 0));
        panelHeaderUI.add(headerLogoandName, BorderLayout.LINE_START);

        //CENTER: LINKS TO MOVIES, SERIES AND GENRES
        PanelStreamingHeaderLinks headerLinkstoMoviesSeriesandGenres = new PanelStreamingHeaderLinks();
        headerLinkstoMoviesSeriesandGenres.setOpaque(true);
        headerLinkstoMoviesSeriesandGenres.setBackground(Color.decode("#141c2e"));
        headerLinkstoMoviesSeriesandGenres.setBorder(new EmptyBorder(8, 0, 0, 0));
        panelHeaderUI.add(headerLinkstoMoviesSeriesandGenres, BorderLayout.CENTER);

        //RIGHT SIDE: SEARCH AND PROFILE
        PanelHeader headerProfileLinksandSearch = new PanelHeader();
        headerProfileLinksandSearch.setOpaque(true);
        headerProfileLinksandSearch.setBackground(Color.decode("#141c2e"));
        panelHeaderUI.add(headerProfileLinksandSearch, BorderLayout.LINE_END);


        /**
         * movies and series and filter panels
         */

        //mediaPanel is CENTERED inside contentPanel with a borderLayout inside contentpanel's borderlayout. It acts as a panel in a panel so we can build a better layout.
        PanelStreamingUImedia mediaPanel = new PanelStreamingUImedia();
        mediaPanel.setLayout(new BorderLayout(10,0));
        mediaPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        mediaPanel.setBackground(Color.decode("#0d131f"));
        contentPanel.add(mediaPanel, BorderLayout.CENTER); //center

        //PanelStreamingUIFeaturedMedia is TOP NORTH of the insides of mediaPanel, it's a button for a featured post
        PanelStreamingUIFeaturedMedia featuredPostWithImage = new PanelStreamingUIFeaturedMedia();
        featuredPostWithImage.setOpaque(true);
        featuredPostWithImage.setBackground(Color.decode("#0d131f"));
        featuredPostWithImage.setBorder(new EmptyBorder(10, 0, 0, 0));
        mediaPanel.add(featuredPostWithImage, BorderLayout.PAGE_START); //EAST

        //comboboxGenreFilter is EAST of the insides of mediaPanel, it filters genres
        PanelStreamingFilter comboboxGenreFilter = new PanelStreamingFilter();
        comboboxGenreFilter.setOpaque(true);
        comboboxGenreFilter.setBackground(Color.decode("#0d131f"));
        comboboxGenreFilter.setBorder(new EmptyBorder(10, 0, 0, 20));
        mediaPanel.add(comboboxGenreFilter, BorderLayout.LINE_END); //EAST

        //this is panel 1 (SHOWS ALL MEDIA)
        //PanelStreamingUIAll is CENTERED inside mediaPanel
        PanelStreamingUIAll PanelWithAllMedia = new PanelStreamingUIAll();
        PanelWithAllMedia.setOpaque(true);
        PanelWithAllMedia.setBackground(Color.decode("#0d131f"));
        PanelWithAllMedia.setLayout(new GridLayout(0, 9)); //must be set to 0 rows, otherwise it gets wonky
        PanelWithAllMedia.setBorder(new EmptyBorder(0, 0, 0, 10)); //making an empty border because of the scrollbar
        mediaPanel.add(PanelWithAllMedia, BorderLayout.PAGE_END); //center

        //this is panel 2 (MOVIES ONLY)
        //PanelStreamingUIMovies PanelWithMovies = new PanelStreamingUIMovies();
        //contentPanel.add(PanelWithMovies, BorderLayout.LINE_END);

        //this is panel 3 (SERIES ONLY)
        //PanelStreamingUISeries PanelWithSeries = new PanelStreamingUISeries();
        //mediaPanel.add(PanelWithSeries, BorderLayout.CENTER);


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

