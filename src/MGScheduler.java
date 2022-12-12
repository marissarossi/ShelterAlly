import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class MGScheduler extends JFrame{
    JTextField pleaseCallTextField;
    JTextField textField2;
    JTextField toMeetTextField;
    JTextField textField1;
    JTextField phoneNumberTextField;
    JTextField textField3;
    JButton scheduleButton;
    JTextField enterDateMmDdTextField;
    JTextField textField4;
    JTextField enterTimeHhMmTextField;
    JTextField textField5;
    JPanel MGJPanel;
    Dog dog = new Dog();
    Application app = new Application();

    public MGScheduler() {
        this.setTitle("Shelter Ally");
        scheduleButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                MeetAndGreetEnvironment mg = new MeetAndGreetEnvironment();
                mg.date = textField4.getText();
                mg.time = textField5.getText();
                try {
                    mg.writeTo(dog, app);
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
