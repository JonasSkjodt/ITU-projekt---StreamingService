import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class StreamingUI extends JFrame {

    /**
     * mediaPanel
     * mediaPanel stores all the panels which has something to do with
     * featured post, movies, series, filter, genres
     */
    private JPanel mediaPanel;
    private JPanel mediaPanelMovies;
    private JPanel mediaPanelFavorites;
    private JPanel mediaPanelSeries;
    private JPanel mediaPanelGenres;
    private JPanel mediaPanelSearch;
    private JPanel mediaPanelInsideMedia;

    private JPanel panelHeaderUIWithAllHeaderElements;

    //variables for Header left side logo and name
    private JPanel headerLogoandName;
    private JButton StreamerAppLogoAndName;

    //variables for header center links
    private JPanel headerLinkstoMoviesSeriesandGenres;
    private JButton HeaderLinkMovie;
    private JButton HeaderLinkSeries;
    private JButton HeaderLinkFavorites;

    //variables for header right side search and profile
    private JPanel headerProfileLinksandSearch;
    private JButton UserProfileButton;
    private JButton searchAllMediaButton;

    //variables for center elements, showing featured post, filter dropdown, all movies and series
    private JPanel featuredPostWithImage;
    private JLabel featuredMediaLabel;

    //combobox filter
    private JPanel comboboxGenreFilter;
    private JButton filterButton;
    private JComboBox filterDropDownComboBox;

    //MediaRegistry
    private MediaRegistry mediaRegistry;

    public StreamingUI() {
        //MediaRegistry
        mediaRegistry = new MediaRegistry();
        //main panel
        this.mainPanelForAllOtherPanels();
        //panels for the header
        this.allChangeablePanelsInTheUI();
        //the frame
        this.theFrame();
        //Scrollbar
        this.scrollBarintheFrame();
    }

    /**
     * contentPanel
     * acts as the first panel on top of the frame
     * all other panels sits in this one
     */
    private JPanel contentPanel;

    public void mainPanelForAllOtherPanels(){
        //contentPanel is the first and biggest panel. It fills the entire frame. It has a borderlayout.
        contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout(10,0));
        contentPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        contentPanel.setBackground(Color.decode("#0d131f"));
    }

    /**
     * PANELS and BUTTONS
     * All panels were moved in here
     * Most buttons were moved in here
     */

    public void allChangeablePanelsInTheUI() {

        /**
         * PANELS
         * all the changeable panels
         */
        //mediaPanel is CENTERED inside contentPanel with a borderLayout inside contentpanel's borderlayout. It acts as a panel in a panel so we can build a better layout.
        mediaPanel = new JPanel(new BorderLayout(10,0));
        mediaPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        mediaPanel.setBackground(Color.decode("#0d131f"));
        contentPanel.add(mediaPanel, BorderLayout.CENTER);

        //These are the panels, createMediaPanel inserts them in mediaPanel.
        // All of them have int 9 to indicate how many columns are in them,
        // showcasing each movie or series in a grid on the given panel.
        mediaPanelGenres = createMediaPanel(9);
        mediaPanelMovies = createMediaPanel(9);
        mediaPanelSeries = createMediaPanel(9);
        mediaPanelFavorites = createMediaPanel(9);
        mediaPanelSearch = createMediaPanel(9);
        mediaPanelInsideMedia = createMediaPanel(9);

        /**
         * HEADER
         * Panels
         */
        panelHeaderUIWithAllHeaderElements = new JPanel(new BorderLayout(10, 0));
        panelHeaderUIWithAllHeaderElements.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        panelHeaderUIWithAllHeaderElements.setBackground(Color.decode("#141c2e"));
        panelHeaderUIWithAllHeaderElements.setBorder(new EmptyBorder(4, 5, 0, 0));
        panelHeaderUIWithAllHeaderElements.setOpaque(true);
        contentPanel.add(panelHeaderUIWithAllHeaderElements, BorderLayout.PAGE_START); //top

        //LEFT SIDE: LOGO AND NAME
        headerLogoandName = new JPanel(new BorderLayout(10, 0));
        headerLogoandName.setBackground(Color.decode("#141c2e"));
        panelHeaderUIWithAllHeaderElements.add(headerLogoandName, BorderLayout.LINE_START);

        //CENTER: LINKS TO MOVIES, SERIES AND GENRES
        headerLinkstoMoviesSeriesandGenres = new JPanel();
        headerLinkstoMoviesSeriesandGenres.setBackground(Color.decode("#141c2e"));
        headerLinkstoMoviesSeriesandGenres.setBorder(new EmptyBorder(8, 0, 0, 0));
        panelHeaderUIWithAllHeaderElements.add(headerLinkstoMoviesSeriesandGenres, BorderLayout.CENTER);

        //RIGHT SIDE: PROFILE LINKS AND SEARCH
        headerProfileLinksandSearch = new JPanel();
        headerProfileLinksandSearch.setBackground(Color.decode("#141c2e"));
        panelHeaderUIWithAllHeaderElements.add(headerProfileLinksandSearch, BorderLayout.LINE_END);

        /**
         * HEADER
         * links and other things in the header
         */
        //HEADER: logo and Welcome to the program
        StreamerAppLogoAndName = new JButton("Welcome to Streamer");
        StreamerAppLogoAndName.setForeground(Color.white);
        StreamerAppLogoAndName.setBorderPainted(false);
        StreamerAppLogoAndName.setFocusPainted(false);
        StreamerAppLogoAndName.setContentAreaFilled(false);
        StreamerAppLogoAndName.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        ImageIcon StreamerLogoPathToImage = new ImageIcon("data/img/logo.png");
        StreamerAppLogoAndName.setIcon(StreamerLogoPathToImage);

        StreamerAppLogoAndName.addActionListener(evt -> {
            removePanels();
            contentPanel.add(mediaPanel, BorderLayout.CENTER);
            contentPanel.revalidate();
            contentPanel.repaint();
        });
        headerLogoandName.add(StreamerAppLogoAndName);

        // HEADER: Links to movies, series and favoritelist
        HeaderLinkMovie = new JButton("Movies");
        HeaderLinkMovie.setForeground(Color.white);
        //remove standard styling
        HeaderLinkMovie.setBorderPainted(false);
        HeaderLinkMovie.setFocusPainted(false);
        HeaderLinkMovie.setContentAreaFilled(false);
        HeaderLinkMovie.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        HeaderLinkMovie.addActionListener(new java.awt.event.ActionListener() {
            @Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    removePanels();
                    contentPanel.add(mediaPanelMovies, BorderLayout.CENTER);
                    contentPanel.revalidate();
                    contentPanel.repaint();
                    // add component to the new panel
                    mediaPanelMovies = AddButtonsUI.addButtonsToPanel("Movies", mediaPanelMovies, mediaRegistry);
                }
            });
        //add the button to the panel
        headerLinkstoMoviesSeriesandGenres.add(HeaderLinkMovie);

        //HEADER Series link
        HeaderLinkSeries = new JButton("Series");
        HeaderLinkSeries.setForeground(Color.white);
        //remove standard styling
        HeaderLinkSeries.setBorderPainted(false);
        HeaderLinkSeries.setFocusPainted(false);
        HeaderLinkSeries.setContentAreaFilled(false);
        HeaderLinkSeries.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        HeaderLinkSeries.addActionListener(new java.awt.event.ActionListener() {
            @Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    removePanels();
                    contentPanel.add(mediaPanelSeries, BorderLayout.CENTER);
                    contentPanel.revalidate();
                    contentPanel.repaint();
                    contentPanel.add(AddButtonsUI.addButtonsToPanel("Series", mediaPanelSeries, mediaRegistry));
                }
            });
        //add the button to the panel
        headerLinkstoMoviesSeriesandGenres.add(HeaderLinkSeries);

        //HEADER: favoritelist link
        HeaderLinkFavorites = new JButton("Favorites");
        HeaderLinkFavorites.setForeground(Color.white);
        //remove standard styling
        HeaderLinkFavorites.setBorderPainted(false);
        HeaderLinkFavorites.setFocusPainted(false);
        HeaderLinkFavorites.setContentAreaFilled(false);
        HeaderLinkFavorites.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        HeaderLinkFavorites.addActionListener(new java.awt.event.ActionListener() {
            @Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    removePanels();
                    contentPanel.add(mediaPanelFavorites, BorderLayout.CENTER);
                    contentPanel.revalidate();
                    contentPanel.repaint();
                    mediaPanelFavorites = AddButtonsUI.addButtonsToPanel("Favorites", mediaPanelFavorites,mediaRegistry);
                }
            });
        //add the button to the panel
        headerLinkstoMoviesSeriesandGenres.add(HeaderLinkFavorites);

        //HEADER: Search button
        searchAllMediaButton = new JButton();
        searchAllMediaButton.setForeground(Color.white);
        //remove standard styling for search button
        searchAllMediaButton.setBorderPainted(false);
        searchAllMediaButton.setFocusPainted(false);
        searchAllMediaButton.setContentAreaFilled(false);
        //insert image in button
        ImageIcon searchimageIcon = new ImageIcon("data/img/search.png");
        searchAllMediaButton.setIcon(searchimageIcon);
        searchAllMediaButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        searchAllMediaButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String input = JOptionPane.showInputDialog("What would you like to search for?", null);
                if (input != null) {
                    removePanels();
                    contentPanel.add(mediaPanelSearch, BorderLayout.CENTER);
                    contentPanel.revalidate();
                    contentPanel.repaint();
                    mediaPanelSearch = AddButtonsUI.addButtonsToPanel(input, mediaPanelSearch, mediaRegistry);
                }
            }
        });
        //add the button to the panel
        headerProfileLinksandSearch.add(searchAllMediaButton);

        //HEADER: profile button with image and name
        UserProfileButton = new JButton("Dan Smith");
        UserProfileButton.setForeground(Color.white);
        //remove standard styling
        UserProfileButton.setBorderPainted(false);
        UserProfileButton.setFocusPainted(false);
        UserProfileButton.setContentAreaFilled(false);
        //insert image in button
        ImageIcon profileimageIcon = new ImageIcon("data/img/man.png");
        UserProfileButton.setIcon(profileimageIcon);
        UserProfileButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        UserProfileButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removePanels();
                contentPanel.add(mediaPanelFavorites, BorderLayout.CENTER);
                contentPanel.revalidate();
                contentPanel.repaint();
                // add component to the new panel
                // code here for the profil stuff
            }
        });
        //add the button to the panel
        headerProfileLinksandSearch.add(UserProfileButton);

        /**
         * PANELS CONTINUED
         * FEATURED POST, FILTER, PANEL WILL ALL FILMS AND SERIES ON START PAGE
         * All panels to build the featured post, the dropdown genre filter box
         * and showcasing all the movies and series in image buttons
         * mediaPanel is only used as a borderlayout element, and lets the following panels sit inside it:
         * featuredPostWithImage a panel which holds the featured post with a big image in the top (below the header)
         * comboboxGenreFilter a panel which holds the dropdown filter
         * PanelWithAllMedia a panel which holds all movies and series
         */
        /**
         * featured post
         */
        //featuredPostWithImage TOP NORTH inside mediaPanel, it's a button for a featured post
        featuredPostWithImage = new JPanel();
        featuredPostWithImage.setOpaque(true);
        featuredPostWithImage.setBackground(Color.decode("#0d131f"));
        featuredPostWithImage.setBorder(new EmptyBorder(10, 0, 0, 0));
        mediaPanel.add(featuredPostWithImage, BorderLayout.PAGE_START);

        featuredMediaLabel = new JLabel();
        //insert image in label
        ImageIcon featuredMediaLabelImage = new ImageIcon("data/img/featured.jpg");
        featuredMediaLabel.setIcon(featuredMediaLabelImage);
        //add the label and the button to the panel
        featuredPostWithImage.add(featuredMediaLabel);

        /**
         * filter
         */
        //comboboxGenreFilter is EAST of the insides of mediaPanel, it filters genres. It is TOP RIGHT inside mediaPanel
        comboboxGenreFilter = new JPanel();
        comboboxGenreFilter.setOpaque(true);
        comboboxGenreFilter.setBackground(Color.decode("#0d131f"));
        comboboxGenreFilter.setBorder(new EmptyBorder(10, 0, 0, 20));
        mediaPanel.add(comboboxGenreFilter, BorderLayout.LINE_END);

        //label to be shown after genre choice has been made
        JLabel filterLabelShowGenreChoice = new JLabel();
        filterLabelShowGenreChoice.setSize(400,100);

        //filter button
        filterButton=new JButton("Show");
        filterButton.setBounds(200,100,75,20);

        //insert the genres in a string
        ArrayList<String> genre = new ArrayList<>();
        genre = mediaRegistry.getGenreList();

        //initiate the combobox (drop down menu with genres)
        filterDropDownComboBox=new JComboBox(genre.toArray());
        filterDropDownComboBox.setBounds(50, 100,150,20);

        filterButton.addActionListener(evt -> {
            removePanels();
            contentPanel.add(mediaPanelGenres, BorderLayout.CENTER);
            contentPanel.revalidate();
            contentPanel.repaint();
            //show a label for which genre was picked
            String data = "You've selected the genre: " + filterDropDownComboBox.getItemAt(filterDropDownComboBox.getSelectedIndex());
            filterLabelShowGenreChoice.setForeground(Color.white);
            filterLabelShowGenreChoice.setText(data);
            mediaPanelGenres.add(filterLabelShowGenreChoice);
            //media to show
            mediaPanelGenres = AddButtonsUI.addButtonsToPanel(filterDropDownComboBox.getItemAt(filterDropDownComboBox.getSelectedIndex()).toString(), mediaPanelGenres, mediaRegistry);
        });
        //add them all to the panel
        comboboxGenreFilter.add(filterDropDownComboBox);
        comboboxGenreFilter.add(filterButton);
        comboboxGenreFilter.add(filterLabelShowGenreChoice);

        /**
         * All movies and series
         * TODO: look at this and integrate it properly into addbuttonsUI
         */
        //this panel SHOWS ALL MEDIA
        //PanelStreamingUIAll is CENTERED inside mediaPanel
        JPanel PanelWithAllMedia = new JPanel();
        PanelWithAllMedia.setOpaque(true);
        PanelWithAllMedia.setBackground(Color.decode("#0d131f"));
        PanelWithAllMedia.setLayout(new GridLayout(0, 9)); //must be set to 0 rows, otherwise it gets wonky
        PanelWithAllMedia.setBorder(new EmptyBorder(0, 0, 0, 10)); //making an empty border because of the scrollbar
        AddButtonsUI.addButtonsToPanel("All", PanelWithAllMedia, mediaRegistry);
        mediaPanel.add(PanelWithAllMedia, BorderLayout.PAGE_END);
    }

    /**
     * Frame
     * frame Creates the GUI window to operate the program
     */
    private JFrame frame;
    private void theFrame(){
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
     * scrollPane creates a scrollbar which is set to only vertical
     * and connects to the frame
     */
    private void scrollBarintheFrame() {
        JScrollPane scrollPane = new JScrollPane(contentPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16); //Increases the distance the scrollbar moves on a scroll (was too slow before) ||--> Nice!!
        frame.getContentPane().add(scrollPane);
    }

    public void removePanels() { //This should probably be moved elsewhere
        contentPanel.remove(mediaPanel);
        contentPanel.remove(mediaPanelMovies);
        contentPanel.remove(mediaPanelSeries);
        contentPanel.remove(mediaPanelFavorites);
        mediaPanelFavorites.removeAll();
        contentPanel.remove(mediaPanelGenres);
        contentPanel.remove(mediaPanelSearch);
        mediaPanelGenres.removeAll();
        mediaPanelSearch.removeAll();
    }

    // to insert the other panels into mediaPanel
    private JPanel createMediaPanel(int columns) {
        JPanel mediaPanel = new JPanel(new BorderLayout(10,0));
        mediaPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        mediaPanel.setLayout(new GridLayout(0, columns)); //must be set to 0 rows, otherwise it gets wonky
        mediaPanel.setBackground(Color.decode("#0d131f"));
        return mediaPanel;
    }



    public static void main(String[] args) {
        try {
            new StreamingUI();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

