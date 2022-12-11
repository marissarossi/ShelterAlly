import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLClassLoader;

public class MeetAndGreetEnvironment implements MeetAndGreetIF{
    String date;
    String time;
    Dog dog = new Dog();

    public void writeTo(Dog dog, Application app) throws IOException {
        FileWriter fw = new FileWriter("MeetAndGreet.txt",true);
        PrintWriter out = new PrintWriter(fw);
        out.println(date + ", " + time + ", " + dog.getName() + ", " + app.getName());
        out.close();
    }

}
