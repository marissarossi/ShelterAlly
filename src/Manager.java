import java.io.*;

public class Manager extends AbstractHandler{
    //private List<Decision> suggestedDecisions;
    //private int counter;
    Dog dog = new Dog();
    Application app = new Application();

    public void DecisionGranted(){
        /*if(counter == 1){
            Decision decision = suggestedDecision[0];
            //print statement maybe
        }
         */
        //counter++
    }

    public void makeTemp(String filepath, int i) {
        String tempFile = "temp.txt";
        File oldFile = new File(filepath);
        File newFile = new File(tempFile);

        int line = 0;
        String currentLine;
        int deleteLine = i;
        try {
            FileWriter fw = new FileWriter(tempFile, false);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            FileReader fr = new FileReader(filepath);
            BufferedReader br = new BufferedReader(fr);

            while ((currentLine = br.readLine()) != null) {
                line++;
                if (deleteLine != line) {
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

            FileReader fr2 = new FileReader(tempFile);
            BufferedReader br2 = new BufferedReader(fr2);

            while ((currentLine = br2.readLine()) != null) {
                line++;
                pw2.println(currentLine);

            }




        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void rewrite(String filepath){
        File oldFile = new File(filepath);
        File newFile = new File("temp.txt");
        int line = 0;
        String currentLine;
        try {

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




        } catch (Exception e) {
            System.out.println(e);
        }


    }
    @Override
    public void HandleNotification(Notify notif) {
    }
}
