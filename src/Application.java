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


}
