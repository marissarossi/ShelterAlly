import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ApplicationEntry extends JFrame{
    public JPanel MainJPanel;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JRadioButton lowRadioButton;
    private JRadioButton mediumRadioButton;
    private JRadioButton highRadioButton;
    private JRadioButton yesRadioButton;
    private JRadioButton noRadioButton;
    private JRadioButton yesRadioButton1;
    private JRadioButton noRadioButton1;
    private JRadioButton yesRadioButton2;
    private JRadioButton noRadioButton2;
    private JRadioButton smallRadioButton1;
    private JRadioButton mediumRadioButton1;
    private JRadioButton largeRadioButton1;
    private JRadioButton yesRadioButton3;
    private JRadioButton noRadioButton3;
    //private JPanel MainJPanel;
    private JPanel OutermostJpanel;
    private JPanel BodyJPanel;
    private JPanel QuestionsJPanel;
    private JPanel RadioButtJPanel;
    private JButton submitButton;
    ButtonGroup buttonGroup1, buttonGroup2;

    String name;
    String address;
    String phoneNumber;
    String size;
    boolean kidsInHome;
    boolean otherDogsInHome;
    boolean catsInHome;
    String energyLevel;
    boolean hasYard;

    public ApplicationEntry() {
        // size radio buttons
        smallRadioButton1.setActionCommand("small");
        mediumRadioButton1.setActionCommand("medium");
        largeRadioButton1.setActionCommand("large");
        // energy level radio buttons
        lowRadioButton.setActionCommand("low");
        mediumRadioButton.setActionCommand("medium");
        highRadioButton.setActionCommand("high");


        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                name = textField1.getText();
                address = textField2.getText();
                phoneNumber = textField3.getText();

                if (smallRadioButton1.isSelected()){
                    size = "small";
                }
                else if (mediumRadioButton1.isSelected()){
                    size = "medium";
                }
                else if (largeRadioButton1.isSelected()){
                    size = "large";
                }

                if (lowRadioButton.isSelected()){
                    energyLevel = "low";
                }
                else if (mediumRadioButton.isSelected()){
                    energyLevel = "medium";
                }
                else if (highRadioButton.isSelected()){
                    energyLevel = "high";
                }

                if (yesRadioButton.isSelected()){
                    kidsInHome = true;
                }
                else if (noRadioButton.isSelected()){
                    kidsInHome = false;
                }


                if (yesRadioButton1.isSelected()){
                    otherDogsInHome = true;
                }
                else if (noRadioButton1.isSelected()){
                    otherDogsInHome = false;
                }

                if (yesRadioButton2.isSelected()){
                    catsInHome = true;
                }
                else if (noRadioButton2.isSelected()){
                    catsInHome = false;
                }

                if (yesRadioButton3.isSelected()){
                    hasYard = true;
                }
                else if (noRadioButton3.isSelected()){
                    hasYard = false;
                }
                // for testing quick
                Application app = new Application();
                app.setName(name);
                app.setAddress(address);
                app.setPhoneNumber(phoneNumber);
                app.setDogSize(size);
                app.setEnergyLevel(energyLevel);
                app.setOtherDogs(otherDogsInHome);
                app.setHasCats(catsInHome);
                app.setKidsInHome(kidsInHome);
                app.setHasYard(hasYard);

                try {
                    app.writeTo(app);
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
