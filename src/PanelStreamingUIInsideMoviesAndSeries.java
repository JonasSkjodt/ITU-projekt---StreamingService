import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelStreamingUIInsideMoviesAndSeries extends JPanel {

    public PanelStreamingUIInsideMoviesAndSeries() {
        this.testingStuff();
    }

    private void testingStuff() {
        JLabel label123 = new JLabel("Edit me inside PanelStreamingUIInsideMoviesAndSeries");
        label123.setForeground(Color.white);
        this.add(label123);
    }

}
