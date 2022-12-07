import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame{
    private JButton newApplicationEntryButton;
    private JButton viewSheltersButton;
    private JButton newShelterEntryButton;
    private JButton currentDogsButton;
    private JButton newDogEntryButton;
    private JPanel mmPanel;

    public MainMenu() {
        newApplicationEntryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(newApplicationEntryButton, "New Application!");
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    public static void main(String[] args) {
        MainMenu mm = new MainMenu();
        mm.setContentPane(mm.mmPanel);
        mm.setTitle("Shelter Ally");
        mm.setSize(400,400);
        mm.setVisible(true);
        mm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
