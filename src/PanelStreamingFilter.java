import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class PanelStreamingFilter extends JPanel {

    private JButton filterButton;
    private JComboBox filterDropDownComboBox;

    public PanelStreamingFilter() {
        this.filterDropDown();
    }

    private void filterDropDown() {
        final JLabel filterLabelShowGenreChoice = new JLabel();
        filterLabelShowGenreChoice.setHorizontalAlignment(JLabel.CENTER);
        filterLabelShowGenreChoice.setSize(400,100);
        filterButton=new JButton("Show");
        filterButton.setBounds(200,100,75,20);

        //insert the genres in a string
        String genre[]={"Action","Adventure","Crime","Comedy","Drama", "...etc"};

        filterDropDownComboBox=new JComboBox(genre);
        filterDropDownComboBox.setBounds(50, 100,150,20);

        //Action when genre choice is made
        filterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String data = "You've selected the genre: " + filterDropDownComboBox.getItemAt(filterDropDownComboBox.getSelectedIndex());
                filterLabelShowGenreChoice.setForeground(Color.white);
                filterLabelShowGenreChoice.setText(data);
            }
        });

        //add them all to the panel
        this.add(filterDropDownComboBox);
        this.add(filterLabelShowGenreChoice);
        this.add(filterButton);
    }
}

