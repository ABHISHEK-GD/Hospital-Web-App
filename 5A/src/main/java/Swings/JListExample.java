/*6a. Develop a Swing program in Java to add the countries  USA,  India,  Vietnam,  Canada,  Denmark, France,   Great Britain, Japan,   Africa, Greenland,  Singapore into a JList  and display them on console  whenever the countries are selected on the list. 
*/

//JList Example developed by Dr.Sm.Badhusha
package Swings;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
public class JListExample extends JFrame {
private JList<String> countryList;
public JListExample() {
//create the model and add elements
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
listModel.addElement("");
//create the list
countryList = new JList<>(listModel);
countryList.addListSelectionListener(new ListSelectionListener() {
@Override
public void valueChanged(ListSelectionEvent e) {
if (!e.getValueIsAdjusting()) {
final List<String> selectedValuesList = countryList.getSelectedValuesList();
System.out.println(selectedValuesList);
}
}
});
add(new JScrollPane(countryList));
this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
this.setTitle("JList Example");
this.setSize(200, 200);
this.setLocationRelativeTo(null);
this.setVisible(true);
}
public static void main(String[] args) {
new JListExample();
}
}

