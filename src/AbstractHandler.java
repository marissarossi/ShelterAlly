import java.util.List;
import java.util.Objects;

abstract class AbstractHandler implements HandlerIF{
    private String worker_name;
    private List<HandlerIF> subordinates;
    private HandlerIF head_Person;

    public void PostNotification(Notify notif, String s){

    } // end PostNotification

    public abstract void HandleNotification(Notify notif);

    public List<HandlerIF> GetSubordinates(){
        return subordinates;
    }

    public void SetSubordinates(List<HandlerIF> people){
        subordinates = people;
    }

    public String GetName(){
        return worker_name;
    }

    public void SetName(String name){
        worker_name = name;
    }

    public HandlerIF GetHead_Person(){
        return head_Person;
    }

    public void SetHeadPerson(HandlerIF person){
        head_Person = person;
    }
}

