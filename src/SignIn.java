import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

public class SignIn extends JFrame{
    private JButton submitButton;
    private JPasswordField passwordField1;
    private JLabel accessDeniedField;
    JPanel SignInJFrame;
    private JPanel accessPanel;

    public SignIn() {
        this.setTitle("Shelter Ally");
        this.setSize(250, 250);
        submitButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                char[] input = passwordField1.getPassword();

                if (isPasswordCorrect(input)){
                    pendingApprovalView pa = new pendingApprovalView();
                    pa.setContentPane(pa.mainJPanel);
                    pa.setSize(400,400);
                    pa.setVisible(true);

                    JComponent comp = (JComponent) e.getSource();
                    Window win = SwingUtilities.getWindowAncestor(comp);
                    win.dispose();
                }
                else{
                    accessDeniedField.setVisible(true);
                    accessPanel.revalidate();
                    accessPanel.repaint();
                }

            }
        });
    }
    private static boolean isPasswordCorrect(char[] input) {
        boolean isCorrect = true;
        char[] password = {'p', 'a', 's', 's', 'w', 'o', 'r', 'd'};

        if (input.length != password.length) {
            isCorrect = false;
        } else {
            isCorrect = Arrays.equals (input, password);
        }

        //Zero out the password.
        Arrays.fill(password,'0');

        return isCorrect;
    }
}
