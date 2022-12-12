import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Employee extends AbstractHandler {
    public Decision decision;


    public Decision SuggestDecision(){
        return decision;
    }

    @Override
    public void HandleNotification(Notify notif) {

    }
    public void completeMeetAndGreet(String appName, String dogName, String date) throws IOException{
            FileWriter fw = new FileWriter("MeetAndGreetCompleted.txt",true);
            PrintWriter out = new PrintWriter(fw);
            out.println(appName + ", " + dogName + ", " +  date );
            out.close();

        }
    }

