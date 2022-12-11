import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class MainMenu extends JFrame{
    private JButton newApplicationEntryButton;
    private JButton viewSheltersButton;
    private JButton viewCurrentDogsButton;
    private JPanel mmPanel;
    private JButton pendingApplicationsButton;
    private JButton meetAndGreetsButton;
    private JButton managerButton;


    public MainMenu() {
        newApplicationEntryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ApplicationEntry ae = new ApplicationEntry();
                ae.setContentPane(ae.MainJPanel);
                ae.setSize(400,400);
                ae.setTitle("Shelter Ally");
                ae.setVisible(true);
            }
        });
        viewCurrentDogsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewDogsMenu vdm = new ViewDogsMenu();
                vdm.setContentPane(vdm.DogJPanel);
                vdm.setSize(800,600);
                vdm.setTitle("Shelter Ally");
                vdm.setVisible(true);
            }
        });
        pendingApplicationsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PendingApplications pa = new PendingApplications();
                pa.setContentPane(pa.MainJPanel);
                pa.setSize(900,500);
                pa.setTitle("Shelter Ally");
                pa.setVisible(true);
            }
        });
        viewSheltersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewShelters vs = new ViewShelters();
                vs.setContentPane(vs.shelterMainPanel);
                vs.setSize(500,500);
                vs.setTitle("Shelter Ally");
                vs.setVisible(true);
            }
        });
        meetAndGreetsButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                MeetAndGreetMenu mg = new MeetAndGreetMenu();
                mg.setContentPane(mg.MGJPanel);
                mg.setSize(500,500);
                mg.setTitle("Shelter Ally");
                mg.setVisible(true);

            }
        });
        managerButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
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
        mm.setSize(450,400);
        mm.setVisible(true);
        mm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
