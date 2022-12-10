import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class NoMatchFound extends JFrame{
    JPanel panel1;
    JTextField sorryNoMatchFoundTextField;
    JButton OKButton;

    public NoMatchFound() {
        OKButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
    }
}
