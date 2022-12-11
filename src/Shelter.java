import java.util.ArrayList;
import java.util.List;

public class Shelter implements ShelterElementIF2{
    ArrayList<ShelterElementIF2> items = new ArrayList();
    String ShelterItem;
    String shelterName;
    int capacity;

    public Shelter(String name){
        this.shelterName = name;
    }

    public String GetName(){
        return shelterName;
    }

    public void CalculateCapacity(){
        int temp = 0;
        for (int i = 0; i < items.size(); i++) {

            if (items.get(i) instanceof SinglePen) {
                temp++;
            }
            else if (items.get(i) instanceof DoublePen){
                temp = temp +2;
            }
        }
        capacity = temp;
    }
}
