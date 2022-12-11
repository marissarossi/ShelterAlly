import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Application {
    private ReadWriteLock lockManager = new ReadWriteLock();
    public String name;
    public String address;
    public String phoneNumber;
    public String dogSize;
    public boolean kidsInHome;
    public boolean otherDogs;
    public boolean hasCats;
    public String energyLevel;
    public boolean hasYard;
    File apps = new File("Applications.txt");


    public String getName(){ return name; }
    public void setName(String name){ this.name = name; }
    public String getAddress(){
        return address;
    }
    public void setAddress(String address){this.address = address;    }
    public String getPhoneNumber(){
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber){ this.phoneNumber = phoneNumber;    }
    public String getDogSize(){return dogSize;    }
    public void setDogSize(String dogSize){ this.dogSize = dogSize;    }
    public boolean getKidsInHome(){return kidsInHome;    }
    public void setKidsInHome(boolean kidsInHome){this.kidsInHome = kidsInHome;    }
    public boolean getOtherDogs(){
        return otherDogs;
    }
    public void setOtherDogs(boolean otherDogs){this.otherDogs = otherDogs;    }
    public boolean getHasCats(){
        return hasCats;
    }
    public void setHasCats(boolean hasCats){ this.hasCats = hasCats;}
    public String getEnergyLevel(){ return energyLevel;    }
    public void setEnergyLevel(String energyLevel){ this.energyLevel = energyLevel;    }
    public boolean getHasYard(){
        return hasYard;
    }
    public void setHasYard(boolean hasYard){this.hasYard = hasYard;    }

    public static void writeTo(Application app) throws IOException{
        FileWriter fw = new FileWriter("Applications.txt",true);
        PrintWriter out = new PrintWriter(fw);
        out.println(app.getName() + ", " + app.getAddress() + ", " + app.getPhoneNumber() + ", " + app.getDogSize() +
                ", " + app.getKidsInHome() + ", " + app.getOtherDogs() + ", " + app.getHasCats() + ", " + app.getEnergyLevel()
                + ", " + app.getHasYard());
        out.close();

    }
    public void setAll(Application app, String[] str) throws IOException{
        app.setName(str[0]);
        app.setAddress(str[1]);
        app.setPhoneNumber(str[2]);
        app.setDogSize(str[3]);
        app.setKidsInHome(Boolean.valueOf(str[4]));
        app.setOtherDogs(Boolean.valueOf(str[5]));
        app.setHasCats(Boolean.valueOf(str[6]));
        app.setEnergyLevel(str[7]);
        app.setHasYard(Boolean.valueOf(str[8]));
    }
    public void callDelete(String dogName){
        String filepath = "Applications.txt";
        File file = new File(filepath);
        int index = getLineNumber(dogName, file);
        remove(filepath, index);
    }
    private static int getLineNumber(String name, File file) {
        boolean found = false;
        int lineCount = 0;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
            String line;
            while ((line = reader.readLine()) != null && !found) {
                ++lineCount; // increment and get (start at 0)
                found = line.trim().contains(name); // found it?
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        if (!found) {
            // we didn't find it... return -1 (an impossible valid value) to handle that scenario.
            lineCount = -1;
        }
        return lineCount; // found it, what line?

    }

    public void remove(String filepath, int i){
        String tempFile = "temp.txt";
        File oldFile = new File(filepath);
        File newFile = new File(tempFile);

        int line = 0;
        String currentLine;
        int deleteLine = i;
        try{
            FileWriter fw = new FileWriter(tempFile, true);
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

            oldFile.delete();
            File dump = new File(filepath);
            newFile.renameTo(dump);


        }
        catch (Exception e){ System.out.println(e);}

    }
}



