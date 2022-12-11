import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class MatchFinder extends JFrame {
    JButton scheduleMeetAndGreetButton;
    JPanel MatchFoundJPanel;
    JTextField textField1;

    public MatchFinder(){
        super.setSize(600,400);
        scheduleMeetAndGreetButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });

    }
}
