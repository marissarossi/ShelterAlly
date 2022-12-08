import java.util.ArrayList;
import java.util.List;

public class Shelter implements ShelterElementIF2{
    List<ShelterElementIF2> items;
    String ShelterItem;
    String shelterName;// just using Shelter name for now until further clarification
    int capacity;

    public Shelter(String name){
        this.items = new ArrayList<>();
    }

    public String GetName(){
        return shelterName;
    }

    public void CalculateCapacity(){

    }
}
