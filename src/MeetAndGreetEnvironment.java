import java.io.*;
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
    public void remove(String filepath, int i){
        String tempFile = "temp.txt";
        File oldFile = new File(filepath);
        File newFile = new File(tempFile);

        int line = 0;
        String currentLine;
        int deleteLine = i;
        try{
            FileWriter fw = new FileWriter(tempFile, false);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            FileReader fr = new FileReader(filepath);
            BufferedReader br = new BufferedReader(fr);

            while((currentLine = br.readLine()) != null){
                line++;
                if(deleteLine != line){
                    pw.println(currentLine);
                }
            }

            pw.flush();
            pw.close();
            fr.close();
            br.close();
            bw.close();
            fw.close();

            FileWriter fw2 = new FileWriter(filepath, false);
            BufferedWriter bw2 = new BufferedWriter(fw2);
            PrintWriter pw2 = new PrintWriter(bw2);

            FileReader fr2 = new FileReader("temp.txt");
            BufferedReader br2 = new BufferedReader(fr2);

            while ((currentLine = br2.readLine()) != null) {
                line++;
                pw2.println(currentLine);

            }
            pw2.flush();
            pw2.close();
            fr2.close();
            br2.close();
            bw2.close();
            fw2.close();


        }
        catch (Exception e){ System.out.println(e);}

    }

}
