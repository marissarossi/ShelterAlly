import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Shelter implements ShelterElementIF2{
    ArrayList<ShelterElementIF2> items = new ArrayList();
    String ShelterItem;
    String shelterName;
    String address;
    String phoneNumber;
    int capacity;

    public Shelter(String name){
        this.shelterName = name;
    }

    public String GetName(){
        return shelterName;
    }
    public void setAddress(String str){
        this.address = str;
    }
    public String getAddress(){
        return address;
    }
    public void setPhoneNumber(String str){
        this.phoneNumber = str;
    }
    public String getPhoneNumber(){
        return phoneNumber;
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
    public static void writeTo(Shelter shelter) throws IOException {
        FileWriter fw = new FileWriter("Shelters.txt",true);
        PrintWriter out = new PrintWriter(fw);
        int buildings=0, sing=0, dub=0, play=0;
        for (int i = 0; i < shelter.items.size(); i++) {

            if (shelter.items.get(i) instanceof SinglePen) {
                sing++;
            }
            else if (shelter.items.get(i) instanceof DoublePen){
                dub++;
            }
            else if (shelter.items.get(i) instanceof Building){
                buildings++;
            }
            else if (shelter.items.get(i) instanceof Playard){
                play++;
            }
        }
        out.println(shelter.GetName() + ", " + shelter.getAddress() + ", " +  shelter.getPhoneNumber() + ", "
                + buildings + ", " + sing + ", " + dub + ", " + play + ", " + shelter.capacity);
        out.close();

    }
}
