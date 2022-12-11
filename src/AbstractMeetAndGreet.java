import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

abstract class AbstractMeetAndGreet implements MeetAndGreetIF{
    String date;
    String time;

    public void writeTo(Dog dog, Application app) throws IOException {
        FileWriter fw = new FileWriter("MeetAndGreet.txt",true);
        PrintWriter out = new PrintWriter(fw);
        out.println(date + ", " + time + ", " + dog.getName() + ", " + app.getName());
        out.close();
    }
}
