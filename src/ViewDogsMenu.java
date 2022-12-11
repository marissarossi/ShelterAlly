import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ViewDogsMenu extends JFrame{
    private static DefaultTableModel model;
    JPanel DogJPanel;
    JButton addNewDog;
    JTable table1;
    String filePath = "Dogs.txt";
    File file = new File(filePath);
    BufferedReader br;


    ViewDogsMenu(){
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
        addNewDog.addActionListener(new ActionListener() {
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
}
