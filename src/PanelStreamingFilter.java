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

    //filter method
    private void filterDropDown() {
        //label to be shown after genre choice has been made
        final JLabel filterLabelShowGenreChoice = new JLabel();
        filterLabelShowGenreChoice.setSize(400,100);

        //filter button
        filterButton=new JButton("Show");
        filterButton.setBounds(200,100,75,20);

        //insert the genres in a string
        String genre[]={"Action","Adventure","Crime","Comedy","Drama", "...etc"};

        //initiate the combobox (drop down menu with genres)
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
        this.add(filterButton);
        this.add(filterLabelShowGenreChoice);
    }
}

