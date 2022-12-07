import java.util.List;

public class Shelter implements ShelterElementIF2{
    List<ShelterElementIF2> items;
    String shelterItem;
    int capacity;
    Building building;

    public Shelter(String name){
    }

    public String GetName(){
        return building.GetName();
    }
}
