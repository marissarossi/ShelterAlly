import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.lang.Integer.*;

public class ShelterEntry extends JFrame{
    JPanel ShelterEntryJPanel;
    JPanel OuterJPanel;
    JPanel bodyJPanel;
    JTextField textField1;
    JTextField textField2;
    JTextField textField3;
    JTextField textField4;
    JTextField textField5;
    JTextField textField6;
    JButton submitButton;
    JTextField textField7;


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

                try {
                    shelter.writeTo(shelter);
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
