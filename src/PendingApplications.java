import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class PendingApplications extends JFrame{
    JTable table1;
    JPanel MainJPanel;
    private static DefaultTableModel model;


    PendingApplications(){
        model = new DefaultTableModel();
        table1.setAutoCreateRowSorter(true);
        table1.setFillsViewportHeight(true);
        model.addColumn("Name");
        model.addColumn("Address");
        model.addColumn("Phone Number");
        model.addColumn("Desired Dog Size");
        model.addColumn("Have Other Dogs?");
        model.addColumn("Have Cats?");
        model.addColumn("Preferred Energy Level");
        model.addColumn("Have Yard?");
        table1.setModel(model);
    }

    public static DefaultTableModel getModel() {
        return model;
    }
    public void AddRowToTable(Object[] row){
        model.addRow(row);
    }


}
