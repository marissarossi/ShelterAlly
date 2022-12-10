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
    public boolean setNeedsYard(boolean needsYard){
        return needsYard;
    }
    public void getNeedsYard(boolean needsYard){
        this.needsYard = needsYard;
    }
    public String getTemperament(){
        return temperament;
    }
    public void setTemperament(String temperament){
        this.temperament = temperament;
    }
}
