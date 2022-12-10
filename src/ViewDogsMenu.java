import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewDogsMenu extends JFrame{
    private static DefaultTableModel model;
    JTable table1;
    JPanel DogJPanel;
    private JButton addNewDogButton;


    ViewDogsMenu(){
        model = new DefaultTableModel();
        table1.setAutoCreateRowSorter(true);
        table1.setFillsViewportHeight(true);
        model.addColumn("Name");
        model.addColumn("Breed");
        model.addColumn("Size");
        model.addColumn("Kids OK?");
        model.addColumn("Other Dogs OK?");
        model.addColumn("Cats OK?");
        model.addColumn("Energy Level");
        model.addColumn("Needs Yard?");
        model.addColumn("Temperament");
        table1.setModel(model);
        addNewDogButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // NewDogEntry JPanel
                NewDogEntry nd = new NewDogEntry();
                nd.setContentPane(nd.titlePanel);
                nd.setTitle("Shelter Ally");
                nd.setSize(600,400);
                nd.setVisible(true);
            }
        });
    }

    public static DefaultTableModel getModel() {
        return model;
    }

    public void AddRowToTable(Object[] row){
        model.addRow(row);
    }

}
