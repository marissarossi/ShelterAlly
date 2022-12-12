import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;

public class DecisionMenu extends JFrame{
    JPanel DecisionMenuJPanel;
    JTextField textField1;
    JTextField textField2;
    JButton approveButton;
    JButton denyButton;
    Dog dog = new Dog();
    Application app = new Application();
    Manager manager = new Manager();





    public DecisionMenu() {
        this.setTitle("Shelter Ally");

        approveButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                //code to call manager's approve method
                manager.makeTemp("MeetAndGreetCompleted.txt", 2);
                manager.rewrite("MeetAndGreetCompleted.txt");
                dog.callDelete(dog.getName());
                app.callDelete(app.getName());
                JComponent comp = (JComponent) e.getSource();
                Window win = SwingUtilities.getWindowAncestor(comp);
                win.dispose();
            }
        });
        denyButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                //code to perform manager's deny method
                manager.makeTemp("MeetAndGreetCompleted.txt", 2);
                manager.rewrite("MeetAndGreetCompleted.txt");
                JComponent comp = (JComponent) e.getSource();
                Window win = SwingUtilities.getWindowAncestor(comp);
                win.dispose();
            }
        });
    }
}
