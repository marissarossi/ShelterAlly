import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class NoMatchFound extends JFrame{
    JPanel panel1;
    JButton OKButton;
    JTextField textField1;

    public NoMatchFound() {
        this.setTitle("Shelter Ally");
        OKButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                JComponent comp = (JComponent) e.getSource();
                Window win = SwingUtilities.getWindowAncestor(comp);
                win.dispose();

            }
        });
    }
}
