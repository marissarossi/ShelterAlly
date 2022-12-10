import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class PendingApplications extends JFrame{
    JTable table1;
    JPanel MainJPanel;
    private JButton findMatchButton;
    private static DefaultTableModel model;
    String filePath = "Applications.txt";
    String dogFilePath = "Dogs.txt";
    File file = new File(filePath);
    File dogFile = new File(dogFilePath);
    BufferedReader br;
    boolean matchFound = false;



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
        findMatchButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Employee employee = new Employee();
                Application app = new Application();
                Dog dog = new Dog();
                Object[] dataRow = null;
                int[] selectedRows = table1.getSelectedRows();
                ArrayList<Object[]> data = new ArrayList<Object[]>();

                for (int i = 0; i < selectedRows.length; i++) {
                    for (int j = 0; j < table1.getColumnCount(); j++) {
                        dataRow[j] = (table1.getValueAt(table1.convertRowIndexToModel(selectedRows[i]),table1.convertColumnIndexToModel(j)));
                    }
                }
                String[] stringArray = Arrays.copyOf(dataRow, dataRow.length, String[].class);

                try {
                    app.setAll(app, stringArray);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }

                try {
                    br = new BufferedReader(new FileReader(dogFile));
                    Object[] tableLines = br.lines().toArray();
                    for (int i = 1; i< tableLines.length; i++){
                        String line = tableLines[i].toString().trim();
                        String[] dogDataRow = line.split(", ");
                        dog.setAll(dog, dogDataRow);
                        findMatch(app, dog);
                        if (matchFound == true){
                            MatchFinder mf = new MatchFinder();
                            mf.setVisible(true);
                            mf.textField1.setText(dog.getName());
                            break;
                        }

                    }
                    if(matchFound == false){
                        NoMatchFound noMatch = new NoMatchFound();
                        noMatch.setVisible(true);
                    }

                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            }
        });
        table1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                findMatchButton.setEnabled(true); ;
            }
        });

    }
    public void findMatch(Application app, Dog dog){
        if(app.getDogSize() != dog.getSize()){
            matchFound = false;
        }
        else if (app.getKidsInHome() == true && dog.getKidsOK() == false){
            matchFound = false;
        }
        else if (app.getOtherDogs() == true && dog.getOtherDogsOK() == false){
            matchFound = false;
        }
        else if (app.getHasCats() == true && dog.getCatsOK() == false){
            matchFound = false;
        }
        else if (app.getEnergyLevel() != dog.getEnergyLevel()){
            matchFound = false;
        }
        else if (dog.getNeedsYard() == true && app.getHasYard() == false){
            matchFound = false;
        }
        else{
            matchFound = true;
        }
    }


}
