import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewShelters extends JFrame{
    private static DefaultTableModel model;

    JPanel shelterMainPanel;
    private JTable table1;

    public ViewShelters(){
        model = new DefaultTableModel();
        table1.setAutoCreateRowSorter(true);
        table1.setFillsViewportHeight(true);
        model.addColumn("Name");
        model.addColumn("Capacity");
        table1.setModel(model);
    }

    public static DefaultTableModel getShelterTableModel() {
        return model;
    }

    public void AddRowToShelterTable(Object[] row){
        model.addRow(row);
    }
}
