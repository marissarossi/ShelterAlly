import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MatchFinder extends JFrame {
    JTextField matchFoundTextField;
    JTextField dogNameTextField;
    JButton scheduleMeetAndGreetButton;
    JPanel MatchFoundJPanel;
    JTextField textField1;

    public MatchFinder(){

        scheduleMeetAndGreetButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
    }
}
