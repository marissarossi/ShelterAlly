import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ViewShelters extends JFrame{
    private static DefaultTableModel model;

    JPanel shelterMainPanel;
    private JTable table1;
    private JButton addShelterButton;

    public ViewShelters(){
        model = new DefaultTableModel();
        table1.setAutoCreateRowSorter(true);
        table1.setFillsViewportHeight(true);
        model.addColumn("Name");
        model.addColumn("Capacity");
        table1.setModel(model);
        addShelterButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

            }
        });
    }

    public static DefaultTableModel getShelterTableModel() {
        return model;
    }

    public void AddRowToShelterTable(Object[] row){
        model.addRow(row);
    }
}
