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
    int clicks = 0;



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
                clicks = clicks +1;

                try {
                    br = new BufferedReader(new FileReader(file));
                    Object[] tableLines = br.lines().toArray();

                    for (int i = clicks; i< clicks + 1; i++){
                        String line = tableLines[i].toString().trim();
                        String[] appDataRow = line.split(", ");
                        app.setAll(app, appDataRow);

                    }

                } catch (Exception e1) {
                    e1.printStackTrace();
                }


                try {
                    br = new BufferedReader(new FileReader(dogFile));
                    Object[] tableLines = br.lines().toArray();
                    for (int i = 0; i< tableLines.length; i++){
                        String line = tableLines[i].toString().trim();
                        String[] dogDataRow = line.split(", ");
                        dog.setAll(dog, dogDataRow);
                        findMatch(app, dog);
                        if(matchFound){
                            break;
                        }
                    }
                    if (matchFound){
                        MatchFinder mf = new MatchFinder();
                        mf.setContentPane(mf.MatchFoundJPanel);
                        mf.setSize(300,200);
                        mf.setVisible(true);
                        mf.textField1.setText(dog.getName());
                    }
                    if (!matchFound) {

                        NoMatchFound noMatch = new NoMatchFound();
                        noMatch.setContentPane(noMatch.panel1);
                        noMatch.setSize(200, 150);
                        noMatch.textField1.setText(app.getName());
                        noMatch.setVisible(true);
                    }

                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            }
        });
    }
    public void findMatch(Application app, Dog dog){
        if(!app.getDogSize().equals(dog.getSize())){
            matchFound = false;
        }
        else if (app.getKidsInHome() && !dog.getKidsOK()){
            matchFound = false;
        }
        else if (app.getOtherDogs() && !dog.getOtherDogsOK()){
            matchFound = false;
        }
        else if (app.getHasCats() && !dog.getCatsOK()){
            matchFound = false;
        }
        else if (dog.getNeedsYard() && !app.getHasYard()){
            matchFound = false;
        }
        else matchFound = app.getEnergyLevel().equals(dog.getEnergyLevel());
    }

}
