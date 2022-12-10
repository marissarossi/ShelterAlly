import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewDogsMenu extends JFrame{
    JTable table1;
    JPanel DogJPanel;
    private JButton addNewDogButton;

    ViewDogsMenu(){
        DefaultTableModel model = new DefaultTableModel();

        table1.setAutoCreateRowSorter(true);
        table1.setFillsViewportHeight(true);
        model.addColumn("Name");
        model.addColumn("Breed");
        model.addColumn("Size");
        model.addColumn("Kids");
        model.addColumn("Other Dogs");
        model.addColumn("Cats");
        model.addColumn("Energy Level");
        model.addColumn("Needs Yard");
        model.addColumn("Temperament");
        table1.setModel(model);
        addNewDogButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // add dog Jpanel here
            }
        });
    }

}
