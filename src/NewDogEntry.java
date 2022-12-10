
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Vector;

public class NewDogEntry extends JFrame{
    JPanel titlePanel;
    JPanel midPanel;
    JTextField textField1;
    JTextField textField2;
    JRadioButton smallRadioButton;
    JRadioButton mediumRadioButton;
    JRadioButton largeRadioButton;
    JCheckBox kidsOKCheckBox;
    JCheckBox otherDogsOKCheckBox;
    JCheckBox catsOKCheckBox;
    JCheckBox needsYardCheckBox;
    JPanel bottomPanel;
    JRadioButton lowRadioButton;
    JRadioButton mediumRadioButton1;
    JRadioButton highRadioButton;
    JRadioButton shyRadioButton;
    JRadioButton averageEasyGoingRadioButton;
    JRadioButton aggressiveRadioButton;
    JButton submitButton;
    ButtonGroup buttonGroup1, buttonGroup2, buttonGroup3;

    String name;
    String breed;
    String size;
    boolean kidsOK;
    boolean otherDogsOK;
    boolean catsOK;
    String energyLevel;
    boolean needsYard;
    String temperament;


    public NewDogEntry() {
        // size radio buttons
        smallRadioButton.setActionCommand("small");
        mediumRadioButton.setActionCommand("medium");
        largeRadioButton.setActionCommand("large");
        // energy level radio buttons
        lowRadioButton.setActionCommand("low");
        mediumRadioButton1.setActionCommand("medium");
        highRadioButton.setActionCommand("high");
        // temperament radio buttons
        shyRadioButton.setActionCommand("shy");
        averageEasyGoingRadioButton.setActionCommand("regular");
        aggressiveRadioButton.setActionCommand("aggressive");

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                name = textField1.getText();
                breed = textField2.getText();
                kidsOK = kidsOKCheckBox.isSelected();
                size = buttonGroup1.getSelection().getActionCommand();
                energyLevel = buttonGroup2.getSelection().getActionCommand();
                temperament = buttonGroup3.getSelection().getActionCommand();
                otherDogsOK = otherDogsOKCheckBox.isSelected();
                catsOK = catsOKCheckBox.isSelected();
                needsYard = needsYardCheckBox.isSelected();
                // for testing quick
                Dog dog = new Dog();
                dog.setName(name);
                dog.setBreed(breed);
                dog.setSize(size);
                dog.setEnergyLevel(energyLevel);
                dog.setTemperament(temperament);
                dog.setOtherDogsOK(otherDogsOK);
                dog.setCatsOK(catsOK);
                dog.setKidsOK(kidsOK);
                dog.setNeedsYard(needsYard);

                try {
                    dog.writeTo(dog);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }

                // to keep Added Dogs in the list in "Current Dogs", keep the window open
                ViewDogsMenu.getModel().addRow(new Object[]{name, breed, size, kidsOK, otherDogsOK, catsOK, energyLevel, needsYard, temperament});
            }
        });
    }
}
