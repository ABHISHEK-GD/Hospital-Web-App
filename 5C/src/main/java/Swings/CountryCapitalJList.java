/*6a. Develop a Swing program in Java to add the countries  USA,  India,  Vietnam,  Canada,  Denmark, France,   Great Britain, Japan,   Africa, Greenland,  Singapore into a JList  and display them on console  whenever the countries are selected on the list. */

package Swings;

import java.util.HashMap;
import java.util.List;
import javax.swing.*;
import javax.swing.event.*;

public class CountryCapitalJList extends JFrame {

    private JList<String> countryList;
    private HashMap<String, String> capitalMap;

    public CountryCapitalJList() {

        // Create capital map
        capitalMap = new HashMap<>();
        capitalMap.put("USA", "Washington D.C.");
        capitalMap.put("India", "New Delhi");
        capitalMap.put("Vietnam", "Hanoi");
        capitalMap.put("Canada", "Ottawa");
        capitalMap.put("Denmark", "Copenhagen");
        capitalMap.put("France", "Paris");
        capitalMap.put("Great Britain", "London");
        capitalMap.put("Japan", "Tokyo");
        capitalMap.put("Africa", "Addis Ababa");
        capitalMap.put("Greenland", "Nuuk");
        capitalMap.put("Singapore", "Singapore");

        // Create list model
        DefaultListModel<String> listModel = new DefaultListModel<>();
        listModel.addElement("USA");
        listModel.addElement("India");
        listModel.addElement("Vietnam");
        listModel.addElement("Canada");
        listModel.addElement("Denmark");
        listModel.addElement("France");
        listModel.addElement("Great Britain");
        listModel.addElement("Japan");
        listModel.addElement("Africa");
        listModel.addElement("Greenland");
        listModel.addElement("Singapore");

        // Create JList
        countryList = new JList<>(listModel);

        // Add listener
        countryList.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    List<String> selected = countryList.getSelectedValuesList();

                    for (String country : selected) {
                        String capital = capitalMap.get(country);
                        System.out.println("Capital of " + country + " is: " + capital);
                    }
                }
            }
        });

        add(new JScrollPane(countryList));

        setTitle("Country Capitals");
        setSize(250, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new CountryCapitalJList();
    }
}