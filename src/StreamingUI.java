import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class StreamingUI extends JFrame {
    public JFrame frame;

    public JPanel contentPanel;
    public JPanel mediaPanel;
    public JPanel panelHeaderUI;

    public StreamingUI() {
        //main panel
        this.mainPanelForAllOtherPanels();
        //panels for the header
        this.panelForTheHeader();
        //panels for allmedia, movies, series, genres
        this.panelToStoreAllMedia();
        //panel for featured post, all movies and series, combobox (filter)
        this.panelForAllMoviesSeriesandFeatured();
        //frame
        this.theFrame();
        //Scrollbar
        this.scrollBarintheFrame();
    }

    /**
     * contentPanel
     * contentpanel acts as the first panel on top of the frame
     * all other panels sits in this one
     */
    public void mainPanelForAllOtherPanels(){
        //contentPanel is the first and biggest panel. It fills the entire frame. It has a borderlayout.
        contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout(10,0));
        contentPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        contentPanel.setBackground(Color.decode("#0d131f"));
    }

    public void panelToStoreAllMedia() {
//mediaPanel is CENTERED inside contentPanel with a borderLayout inside contentpanel's borderlayout. It acts as a panel in a panel so we can build a better layout.
        mediaPanel = new JPanel();
        mediaPanel.setLayout(new BorderLayout(10,0));
        mediaPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        mediaPanel.setBackground(Color.decode("#0d131f"));
        contentPanel.add(mediaPanel, BorderLayout.CENTER);
    }

    /**
     * Header
     * All panels in panelForTheHeader() holds the application logo, name, links to movies, series,
     * genres, the search function and the profile image.
     * @panelHeaderUI adds a panel for the rest of the panels to be in, as the header
     * @headerLogoandName acts as the panel for the header logo and name
     * @headerLinkstoMoviesSeriesandGenres acts as the panel for the header links to movies, series and genres
     * @headerProfileLinksandSearch stores search button and the profile image and profile name
     */
    public void panelForTheHeader() {
        //Header Panel, TOP NORTH in contentpanel's border layout
        panelHeaderUI = new JPanel();
        panelHeaderUI.setLayout(new BorderLayout(10, 0));
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
    }

    /**
     * All panels to build the featured post, the dropdown genre filter box
     * and showcasing all the movies and series in image buttons
     * @mediaPanel is only used as a borderlayout element, and lets the following panels sit inside it:
     * @featuredPostWithImage a panel which holds the featured post with a big image in the top (below the header)
     * @comboboxGenreFilter a panel which holds the dropdown filter
     * @PanelWithAllMedia a panel which holds all movies and series
     */
    public void panelForAllMoviesSeriesandFeatured() {
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
    }

    /**
     * Frame
     * @frame Creates the GUI window to operate the program
     */
    public void theFrame(){
        frame = new JFrame();
        frame.add(contentPanel,BorderLayout.CENTER);
        frame.setDefaultCloseOperation((JFrame.EXIT_ON_CLOSE));
        frame.setTitle("Streamer");
        frame.pack();
        frame.setSize(1600,900);
        frame.setVisible(true);
    }

    /**
     * Scrollbar
     * @scrollPane creates a scrollbar which is set to only vertical
     * and connects to the frame
     */
    public void scrollBarintheFrame() {
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

