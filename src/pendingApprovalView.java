import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;

public class pendingApprovalView extends JFrame {
    JPanel mainJPanel;
    JTable table1;
    JButton Approval;
    private static DefaultTableModel model;
    BufferedReader br;
    String filePath = "MeetAndGreetCompleted.txt";
    File file = new File(filePath);
    Dog dog = new Dog();
    Application app = new Application();
    String dogName, appName;

    public void setDog(){
        try {
            br = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Object[] tableLines = br.lines().toArray();
        String line = tableLines[1].toString().trim();
        String[] dataRow = line.split(", ");
        dogName = dataRow[1];


    }
    public void setApplication(){
        try {
            br = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Object[] tableLines = br.lines().toArray();
        String line = tableLines[1].toString().trim();
        String[] dataRow = line.split(", ");
        appName = dataRow[0];

    }


    public pendingApprovalView() {
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
        Approval.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                DecisionMenu dm = new DecisionMenu();
                dm.setContentPane(dm.DecisionMenuJPanel);
                dm.setSize(400,400);
                dm.setVisible(true);

                setDog();
                int dogIndex = dog.getLineNumber(dogName, new File("Dogs.txt")) - 1;
                String[] dogData = dog.getAll(dogIndex);
                try {
                    dog.setAll(dog, dogData);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }

                setApplication();
                int appIndex = app.getLineNumber(appName, new File("Applications.txt")) - 1;
                String[] appData = app.getAll(appIndex);
                try {
                    app.setAll(app, appData);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }

                dm.textField1.setText(dog.getName());
                dm.textField2.setText(app.getName());
                dm.dog = dog;
                dm.app = app;
            }
        });
    }
}
