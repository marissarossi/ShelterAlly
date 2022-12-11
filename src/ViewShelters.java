import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ViewShelters extends JFrame{
    private static DefaultTableModel model;

    JPanel shelterMainPanel;
    private JTable table1;
    private JButton addShelterButton;
    BufferedReader br;
    String filePath = "Shelters.txt";
    File file = new File(filePath);

    public ViewShelters() {
        model = new DefaultTableModel();
        table1.setAutoCreateRowSorter(true);
        table1.setFillsViewportHeight(true);
        model.addColumn("Name");
        model.addColumn("Capacity");
        table1.setModel(model);
        try {
            br = new BufferedReader(new FileReader(file));
            String firstLine = br.readLine().trim();
            String[] columnsName = firstLine.split(", ");
            model = (DefaultTableModel) table1.getModel();
            model.setColumnIdentifiers(columnsName);

            Object[] tableLines = br.lines().toArray();

            for (int i = 0; i < tableLines.length; i++) {
                String line = tableLines[i].toString().trim();
                String[] dataRow = line.split(", ");
                model.addRow(dataRow);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
            addShelterButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e);
                    ShelterEntry se = new ShelterEntry();
                    se.setContentPane(se.ShelterEntryJPanel);
                    se.setTitle("Shelter Ally");
                    se.setSize(600,400);
                    se.setVisible(true);

                }
            });
        }
    public static DefaultTableModel getModel() {
        return model;
    }

}
