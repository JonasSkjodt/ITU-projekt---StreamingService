import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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

    public StreamingUI() {
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
        mediaRegistry = new MediaRegistry();
        //contentPanel is the first and biggest panel. It fills the entire frame. It has a borderlayout.
        contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout(10,0));
        contentPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        contentPanel.setBackground(Color.decode("#0d131f"));
    }

    /**
     * Header
     * All panels in panelForTheHeader() holds the application logo, name, links to movies, series,
     * genres, the search function and the profile image.
     * panelHeaderUI adds a panel for the rest of the panels to be in, as the header
     * headerLogoandName acts as the panel for the header logo and name
     * headerLinkstoMoviesSeriesandGenres acts as the panel for the header links to movies, series and genres
     * headerProfileLinksandSearch stores search button and the profile image and profile name
     */
    private MediaRegistry mediaRegistry;
    public void allChangeablePanelsInTheUI() {

        //mediaPanel is CENTERED inside contentPanel with a borderLayout inside contentpanel's borderlayout. It acts as a panel in a panel so we can build a better layout.
        mediaPanel = new JPanel();
        mediaPanel.setLayout(new BorderLayout(10,0));
        mediaPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        mediaPanel.setBackground(Color.decode("#0d131f"));
        contentPanel.add(mediaPanel, BorderLayout.CENTER);

        //TESTING TESTING TESTING NEW PANEL ON CLICK
        mediaPanelGenres = new JPanel();
        mediaPanelGenres.setLayout(new BorderLayout(10,0));
        mediaPanelGenres.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        mediaPanelGenres.setLayout(new GridLayout(0, 9)); //must be set to 0 rows, otherwise it gets wonky
        mediaPanelGenres.setBackground(Color.decode("#0d131f"));

        //TESTING TESTING TESTING NEW PANEL ON CLICK
        mediaPanelMovies = new JPanel();
        mediaPanelMovies.setLayout(new BorderLayout(10,0));
        mediaPanelMovies.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        mediaPanelMovies.setLayout(new GridLayout(0, 9)); //must be set to 0 rows, otherwise it gets wonky
        mediaPanelMovies.setBackground(Color.decode("#0d131f"));

        //TESTING TESTING TESTING NEW PANEL ON CLICK
        mediaPanelSeries = new JPanel();
        mediaPanelSeries.setLayout(new BorderLayout(10,0));
        mediaPanelSeries.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        mediaPanelSeries.setLayout(new GridLayout(0, 9)); //must be set to 0 rows, otherwise it gets wonky
        mediaPanelSeries.setBackground(Color.decode("#0d131f"));

        //TESTING TESTING TESTING NEW PANEL ON CLICK
        mediaPanelFavorites = new JPanel();
        mediaPanelFavorites.setLayout(new BorderLayout(10,0));
        mediaPanelFavorites.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        mediaPanelFavorites.setLayout(new GridLayout(0, 9)); //must be set to 0 rows, otherwise it gets wonky
        mediaPanelFavorites.setBackground(Color.decode("#0d131f"));

        //Header Panel, TOP NORTH in contentpanel's border layout
        panelHeaderUIWithAllHeaderElements = new JPanel();
        panelHeaderUIWithAllHeaderElements.setLayout(new BorderLayout(10, 0));
        panelHeaderUIWithAllHeaderElements.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        panelHeaderUIWithAllHeaderElements.setBackground(Color.decode("#141c2e"));
        contentPanel.add(panelHeaderUIWithAllHeaderElements, BorderLayout.PAGE_START); //top

        /**
         * inside the headerUI panel
         */
        //LEFT SIDE: LOGO AND NAME
        headerLogoandName = new JPanel();
        headerLogoandName.setLayout(new BorderLayout(10, 0));
        headerLogoandName.setBorder(new EmptyBorder(4, 5, 0, 0));
        headerLogoandName.setBackground(Color.decode("#141c2e"));
        panelHeaderUIWithAllHeaderElements.add(headerLogoandName, BorderLayout.LINE_START);

        // button for logo and name to go back to start page
        StreamerAppLogoAndName = new JButton("Welcome to Streamer");
        StreamerAppLogoAndName.setForeground(Color.white);
        //remove standard styling for search button
        StreamerAppLogoAndName.setBorderPainted(false);
        StreamerAppLogoAndName.setFocusPainted(false);
        StreamerAppLogoAndName.setContentAreaFilled(false);
        ImageIcon StreamerLogoPathToImage = new ImageIcon("data/img/logo.png");
        StreamerAppLogoAndName.setIcon(StreamerLogoPathToImage);

        //hover animation effect
        StreamerAppLogoAndName.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {

                //change the mouse marker on media buttons
                StreamerAppLogoAndName.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }
        });

        StreamerAppLogoAndName.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removePanels();
                contentPanel.revalidate();
                contentPanel.repaint();

                contentPanel.add(mediaPanel, BorderLayout.CENTER);
                contentPanel.revalidate();
                contentPanel.repaint();

            }
        });
        //add the button to the panel
        headerLogoandName.add(StreamerAppLogoAndName);


        //CENTER: LINKS TO MOVIES, SERIES AND GENRES
        headerLinkstoMoviesSeriesandGenres = new JPanel();
        headerLinkstoMoviesSeriesandGenres.setOpaque(true);
        headerLinkstoMoviesSeriesandGenres.setBackground(Color.decode("#141c2e"));
        headerLinkstoMoviesSeriesandGenres.setBorder(new EmptyBorder(8, 0, 0, 0));
        panelHeaderUIWithAllHeaderElements.add(headerLinkstoMoviesSeriesandGenres, BorderLayout.CENTER);

        /**
         * movie link
         */
            HeaderLinkMovie = new JButton("Movies");
            HeaderLinkMovie.setForeground(Color.white);
            //remove standard styling
            HeaderLinkMovie.setBorderPainted(false);
            HeaderLinkMovie.setFocusPainted(false);
            HeaderLinkMovie.setContentAreaFilled(false);

            //hover animation effect
            HeaderLinkMovie.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {

                    //change the mouse marker on media buttons
                    HeaderLinkMovie.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                }
            });

            HeaderLinkMovie.addActionListener(new java.awt.event.ActionListener() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    removePanels();
                    contentPanel.revalidate();
                    contentPanel.repaint();

                    contentPanel.add(mediaPanelMovies, BorderLayout.CENTER);
                    contentPanel.revalidate();
                    contentPanel.repaint();

                    // add component to the new panel
                    mediaPanelMovies = AddButtonsUI.addButtonsToPanel("Movies", mediaPanelMovies);

                }
            });

            //add the button to the panel
            headerLinkstoMoviesSeriesandGenres.add(HeaderLinkMovie);

            /**
             * series link
             */
            HeaderLinkSeries = new JButton("Series");
            HeaderLinkSeries.setForeground(Color.white);
            //remove standard styling
            HeaderLinkSeries.setBorderPainted(false);
            HeaderLinkSeries.setFocusPainted(false);
            HeaderLinkSeries.setContentAreaFilled(false);

            //hover animation effect
            HeaderLinkSeries.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {

                    //change the mouse marker on media buttons
                    HeaderLinkSeries.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                }
            });

            HeaderLinkSeries.addActionListener(new java.awt.event.ActionListener() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    removePanels();
                    contentPanel.revalidate();
                    contentPanel.repaint();

                    contentPanel.add(mediaPanelSeries, BorderLayout.CENTER);
                    contentPanel.revalidate();
                    contentPanel.repaint();

                    // add component to the new panel
                    mediaPanelSeries = AddButtonsUI.addButtonsToPanel("Series", mediaPanelSeries);
                }
            });

            //add the button to the panel
            headerLinkstoMoviesSeriesandGenres.add(HeaderLinkSeries);

        /**
         * genres link
         */
            HeaderLinkFavorites = new JButton("Favorites");
            HeaderLinkFavorites.setForeground(Color.white);
            //remove standard styling
            HeaderLinkFavorites.setBorderPainted(false);
            HeaderLinkFavorites.setFocusPainted(false);
            HeaderLinkFavorites.setContentAreaFilled(false);

            //hover animation effect
            HeaderLinkFavorites.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    //change the mouse marker on media buttons
                    HeaderLinkFavorites.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                }
            });

            HeaderLinkFavorites.addActionListener(new java.awt.event.ActionListener() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    removePanels();
                    contentPanel.revalidate();
                    contentPanel.repaint();

                    contentPanel.add(mediaPanelFavorites, BorderLayout.CENTER);
                    contentPanel.revalidate();
                    contentPanel.repaint();

                    // add component to the new panel
                    mediaPanelFavorites = AddButtonsUI.addButtonsToPanel("Favorites", mediaPanelFavorites);
                }
            });

            //add the button to the panel
        headerLinkstoMoviesSeriesandGenres.add(HeaderLinkFavorites);


        /**
         * RIGHT SIDE: SEARCH AND PROFILE
         */
        headerProfileLinksandSearch = new JPanel();
        headerProfileLinksandSearch.setOpaque(true);
        headerProfileLinksandSearch.setBackground(Color.decode("#141c2e"));
        panelHeaderUIWithAllHeaderElements.add(headerProfileLinksandSearch, BorderLayout.LINE_END);

        //search button
        searchAllMediaButton = new JButton();
        searchAllMediaButton.setForeground(Color.white);
        //remove standard styling for search button
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
                String name = JOptionPane.showInputDialog("TO DO: this is the search", null);
            }
        });

        //add the button to the panel
        headerProfileLinksandSearch.add(searchAllMediaButton);

        //profile button with image and name
        UserProfileButton = new JButton("Dan Smith");
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
                removePanels();
                contentPanel.revalidate();
                contentPanel.repaint();

                contentPanel.add(mediaPanelFavorites, BorderLayout.CENTER);
                contentPanel.revalidate();
                contentPanel.repaint();

                // add component to the new panel
                mediaPanelFavorites = AddButtonsUI.addButtonsToPanel("Favorites", mediaPanelFavorites);
            }
        });

        //add the button to the panel
        headerProfileLinksandSearch.add(UserProfileButton);


    /**
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
        final JLabel filterLabelShowGenreChoice = new JLabel();
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

        //Action when genre choice is made
        filterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String data = "You've selected the genre: " + filterDropDownComboBox.getItemAt(filterDropDownComboBox.getSelectedIndex());
                filterLabelShowGenreChoice.setForeground(Color.white);
                filterLabelShowGenreChoice.setText(data);

            }
        });
        filterButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removePanels();
                contentPanel.revalidate();
                contentPanel.repaint();

                contentPanel.add(mediaPanelGenres, BorderLayout.CENTER);
                contentPanel.revalidate();
                contentPanel.repaint();

                // add component to the new panel
                mediaPanelGenres = AddButtonsUI.addButtonsToPanel(filterDropDownComboBox.getItemAt(filterDropDownComboBox.getSelectedIndex()).toString(), mediaPanelFavorites);
            }
        });




        //add them all to the panel
        comboboxGenreFilter.add(filterDropDownComboBox);
        comboboxGenreFilter.add(filterButton);
        comboboxGenreFilter.add(filterLabelShowGenreChoice);

        /**
         * All movies and series
         */
        //this panel SHOWS ALL MEDIA
        //PanelStreamingUIAll is CENTERED inside mediaPanel
        PanelStreamingUIAll PanelWithAllMedia = new PanelStreamingUIAll();
        PanelWithAllMedia.setOpaque(true);
        PanelWithAllMedia.setBackground(Color.decode("#0d131f"));
        PanelWithAllMedia.setLayout(new GridLayout(0, 9)); //must be set to 0 rows, otherwise it gets wonky
        PanelWithAllMedia.setBorder(new EmptyBorder(0, 0, 0, 10)); //making an empty border because of the scrollbar
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
        frame.getContentPane().add(scrollPane);
    }

    public static void main(String[] args) {
        try {
            new StreamingUI();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void removePanels() { //This should probably be moved elsewhere
        contentPanel.remove(mediaPanel);
        contentPanel.remove(mediaPanelMovies);
        contentPanel.remove(mediaPanelSeries);
        contentPanel.remove(mediaPanelFavorites);
        contentPanel.remove(mediaPanelGenres);
    }
}

