import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class PendingApplications extends JFrame{
    JTable table1;
    JPanel MainJPanel;
    private static DefaultTableModel model;
    String filePath = "Applications.txt";
    File file = new File(filePath);
    BufferedReader br;




    PendingApplications(){
        {
            try {
                br = new BufferedReader(new FileReader(file));
                String firstLine = br.readLine().trim();
                String[] columnsName = firstLine.split(", ");
                model = (DefaultTableModel) table1.getModel();
                model.setColumnIdentifiers(columnsName);

                Object[] tableLines = br.lines().toArray();

                for (int i = 0; i< tableLines.length; i++){
                    String line = tableLines[i].toString().trim();
                    String[] dataRow = line.split(", ");
                    model.addRow(dataRow);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static DefaultTableModel getModel() {
        return model;
    }


}
