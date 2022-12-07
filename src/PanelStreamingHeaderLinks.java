import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelStreamingHeaderLinks extends JPanel {
    private JButton HeaderLinkMovie;
    private JButton HeaderLinkSeries;
    private JButton HeaderLinkGenres;

    public PanelStreamingHeaderLinks() {
        this.headerButtonforMovies();
        this.headerButtonforSeries();
        this.headerButtonforGenres();
    }

    private void headerButtonforMovies(){
        this.HeaderLinkMovie = new JButton("Movies");
        HeaderLinkMovie.setForeground(Color.white);
        //remove standard styling
        HeaderLinkMovie.setBorderPainted(false);
        HeaderLinkMovie.setFocusPainted(false);
        HeaderLinkMovie.setContentAreaFilled(false);

        //hover animation effect
        //TODO: insert moviespanel on click
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
                String name = JOptionPane.showInputDialog(
                        "Movies", null);
            }
        });


        //add the button to the panel
        this.add(HeaderLinkMovie);
    }
    private void headerButtonforSeries() {
        this.HeaderLinkSeries = new JButton("Series");
        HeaderLinkSeries.setForeground(Color.white);
        //remove standard styling
        HeaderLinkSeries.setBorderPainted(false);
        HeaderLinkSeries.setFocusPainted(false);
        HeaderLinkSeries.setContentAreaFilled(false);

        //hover animation effect
        //TODO: insert seriespanel on click
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
                String name = JOptionPane.showInputDialog(
                        "Series", null);
            }
        });

        //add the button to the panel
        this.add(HeaderLinkSeries);
    }

    private void headerButtonforGenres() {
        this.HeaderLinkGenres = new JButton("Genres");
        HeaderLinkGenres.setForeground(Color.white);
        //remove standard styling
        HeaderLinkGenres.setBorderPainted(false);
        HeaderLinkGenres.setFocusPainted(false);
        HeaderLinkGenres.setContentAreaFilled(false);

        //hover animation effect
        //TODO: insert genrespanel on click
        HeaderLinkGenres.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {

                //change the mouse marker on media buttons
                HeaderLinkGenres.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }
        });

        HeaderLinkGenres.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String name = JOptionPane.showInputDialog(
                        "Genres", null);
            }
        });

        //add the button to the panel
        this.add(HeaderLinkGenres);
    }

}

