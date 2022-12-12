import java.io.*;


public class Dog {
    private ReadWriteLock lockManager = new ReadWriteLock();
    public String name;
    public String breed;
    public String size;
    public boolean kidsOK;
    public boolean otherDogsOK;
    public boolean catsOK;
    public String energyLevel;
    public boolean needsYard;
    public String temperament;
    BufferedReader br;

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;

    }
    public String getBreed(){
        return breed;
    }
    public void setBreed(String breed){
        this.breed = breed;
    }
    public String getSize(){
        return size;
    }
    public void setSize(String size){
        this.size= size;

    }
    public boolean getKidsOK(){
        return kidsOK;
    }
    public void setKidsOK(boolean kidsOK){
        this.kidsOK = kidsOK;
    }
    public boolean getOtherDogsOK(){
        return otherDogsOK;
    }
    public void setOtherDogsOK(boolean otherDogsOK){
        this.otherDogsOK = otherDogsOK;

    }
    public boolean getCatsOK(){
        return catsOK;
    }
    public void setCatsOK(boolean catsOK){
        this.catsOK = catsOK;
    }
    public String getEnergyLevel(){
        return energyLevel;
    }
    public void setEnergyLevel(String energyLevel){
        this.energyLevel = energyLevel;
    }
    public boolean getNeedsYard(){
        return needsYard;
    }
    public void setNeedsYard(boolean needsYard){
        this.needsYard = needsYard;
    }
    public String getTemperament(){
        return temperament;
    }
    public void setTemperament(String temperament){
        this.temperament = temperament;
    }

    public static void writeTo(Dog dog) throws IOException {
        FileWriter fw = new FileWriter("Dogs.txt",true);
        PrintWriter out = new PrintWriter(fw);
        out.println(dog.getName() + ", " + dog.getBreed() + ", " +  dog.getSize() + ", " + dog.getKidsOK() +
                ", " + dog.getOtherDogsOK() + ", " + dog.getCatsOK() + ", " + dog.getEnergyLevel()
                + ", " + dog.getNeedsYard() + ", "+ dog.getTemperament());
        out.close();

    }
    public void setAll(Dog dog, String[] str) throws IOException{
        dog.setName(str[0]);
        dog.setBreed(str[1]);
        dog.setSize(str[2]);
        dog.setKidsOK(Boolean.valueOf(str[3]));
        dog.setOtherDogsOK(Boolean.valueOf(str[4]));
        dog.setCatsOK(Boolean.valueOf(str[5]));
        dog.setEnergyLevel(str[6]);
        dog.setNeedsYard(Boolean.valueOf(str[7]));
        dog.setTemperament(str[8]);
    }
    public String[] getAll(int index){
        try {
            br = new BufferedReader(new FileReader(new File("Dogs.txt")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Object[] tableLines = br.lines().toArray();
        String line = tableLines[index].toString().trim();
        String[] dataRow = line.split(", ");
        return dataRow;

    }
    public void callDelete(String dogName){
        String filepath = "Dogs.txt";
        File file = new File(filepath);
        int index = getLineNumber(dogName, file);
        remove(filepath, index);
    }
    public static int getLineNumber(String name, File file) {
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
