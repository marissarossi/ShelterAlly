import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.Integer.*;

public class ShelterEntry {
    private JPanel ShelterEntryJPanel;
    private JPanel OuterJPanel;
    private JPanel bodyJPanel;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JButton submitButton;
    private JTextField textField7;


    public ShelterEntry() {
        submitButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Shelter shelter = new Shelter(textField1.getText());
                int singlePen = Integer.parseInt(textField4.getText());
                int doublePen = Integer.parseInt(textField5.getText());
                int playYard = Integer.parseInt(textField6.getText());
                int building = Integer.parseInt(textField7.getText());

                for (int i = 0; i < singlePen; i++){
                    SinglePen single = new SinglePen();
                    shelter.items.add(single);
                }
                for (int i = 0; i < doublePen; i++){
                    DoublePen doublePen1 = new DoublePen();
                    shelter.items.add(doublePen1);
                }
                for (int i = 0; i < playYard; i++){
                    Playard play = new Playard();
                    shelter.items.add(play);
                }
                for (int i = 0; i < building; i++){
                    Building building1 = new Building();
                    shelter.items.add(building1);
                }
                shelter.CalculateCapacity();
            }
        });
    }
}
