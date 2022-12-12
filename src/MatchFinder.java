import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MatchFinder extends JFrame {
    JTextField matchFoundTextField;
    JTextField dogNameTextField;
    JButton scheduleMeetAndGreetButton;
    JPanel MatchFoundJPanel;
    JTextField textField1;
    Dog dog = new Dog();
    Application app = new Application();

    public MatchFinder(){
        this.setTitle("Shelter Ally");

        scheduleMeetAndGreetButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                MGScheduler mg = new MGScheduler();
                mg.setContentPane(mg.MGJPanel);
                mg.setSize(500,500);
                mg.setVisible(true);
                mg.textField2.setText(app.getName());
                mg.textField3.setText(dog.getName());
                mg.textField1.setText(app.getPhoneNumber());
                mg.dog = dog;
                mg.app = app;
                JComponent comp = (JComponent) e.getSource();
                Window win = SwingUtilities.getWindowAncestor(comp);
                win.dispose();
            }
        });
    }
}
