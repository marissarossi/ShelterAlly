import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;

public class MeetAndGreetMenu extends JFrame{
    JPanel MGJPanel;
    JButton runButton;
    JTable table1;
    private JPanel tablePanel;
    private static DefaultTableModel model;
    String filePath = "MeetAndGreet.txt";
    File file = new File(filePath);
    BufferedReader br;
    MeetAndGreetEnvironment MaG = new MeetAndGreetEnvironment();
    Employee emp = new Employee();
    Dog dog = new Dog();
    Application app = new Application();
    String date;
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
        dogName = dataRow[2];


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
        appName = dataRow[3];

    }

    public void setDate(){
        try {
            br = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Object[] tableLines = br.lines().toArray();
        String line = tableLines[1].toString().trim();
        String[] dataRow = line.split(", ");
        date = dataRow[0];

    }

    public MeetAndGreetMenu(){
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
        runButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                setDog();
                setDate();
                setApplication();
                MaG.remove("MeetAndGreet.txt", 2);
                try {
                    emp.completeMeetAndGreet(appName, dogName, date);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                JComponent comp = (JComponent) e.getSource();
                Window win = SwingUtilities.getWindowAncestor(comp);
                win.dispose();
            }
        });
    }

}
