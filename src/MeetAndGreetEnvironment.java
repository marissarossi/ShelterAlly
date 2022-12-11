import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLClassLoader;

public class MeetAndGreetEnvironment implements MeetAndGreetIF{
    String date;
    String time;
    Dog dog = new Dog();

    private static final URL[] classPath; // URL for loading programs.
    static {
        try {
            classPath = new URL[]{new URL("file:///bin")};
        } catch (java.net.MalformedURLException e) {
            throw new ExceptionInInitializerError(e);
        } // try
    } // static

    public void setMGType(String str){}

    public void setConsultTime(int min){
        String consult = "Consult for " + min + " minutes.";
    }

    public void setMeetTime(int min){
        String meet = "Meet for " + min + " minutes.";
    }

    public void setPlayTime(int min){
        String play = "Play for " + min + " minutes.";
    }

    @Override
    public void done() {

    }


    public void writeTo(Dog dog, Application app) throws IOException {
        FileWriter fw = new FileWriter("MeetAndGreet.txt",true);
        PrintWriter out = new PrintWriter(fw);
        out.println(date + ", " + time + ", " + dog.getName() + ", " + app.getName());
        out.close();
    }
    void run(String str){
        URLClassLoader classLoader = new URLClassLoader(classPath);
        Class programClass;
        try {
            programClass = classLoader.loadClass(str);
        } catch (ClassNotFoundException e) {
            // Not found
            //...
            return;
        } // try
        AbstractMeetAndGreet program;
        try {
            program = (AbstractMeetAndGreet) programClass.newInstance();
        } catch (Exception e) {
            // Unable to run
            //...
            return;
        } // try
        program.setEnvironment(this);
        program.start();
    }

}
