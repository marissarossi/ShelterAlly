import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SignIn {
    private JTextField enterPasswordTextField;
    private JButton submitButton;
    private JPasswordField passwordField1;
    private JTextField accessDeniedField;

    public SignIn() {
        submitButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                String password = passwordField1.getPassword().toString();
                if (password == "password"){
                    pendingApprovalView pa = new pendingApprovalView();
                    pa.setContentPane(pa.mainJPanel);
                    pa.setSize(400,400);
                    pa.setVisible(true);

                    JComponent comp = (JComponent) e.getSource();
                    Window win = SwingUtilities.getWindowAncestor(comp);
                    win.dispose();
                }
                else{
                    accessDeniedField.setEnabled(true);
                }

            }
        });
    }
}
