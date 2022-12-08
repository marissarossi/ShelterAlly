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
    public void setName(){

    }
    public String getBreed(){
        return breed;
    }
    public void setBreed(){

    }
    public String getSize(){
        return size;
    }
    public void setSize(){

    }
    public boolean getKidsOK(){
        return kidsOK;
    }
    public void setKidsOK(){

    }
    public boolean getOtherDogsOK(){
        return otherDogsOK;
    }
    public void setOtherDogsOK(){

    }
    public boolean getCatsOK(){
        return catsOK;
    }
    public void setCatsOK(){

    }
    public String getEnergyLevel(){
        return energyLevel;
    }
    public void setEnergyLevel(){

    }
    public boolean setNeedsYard(){
        return needsYard;
    }
    public void getNeedsYard(){

    }
    public String getTemperament(){
        return temperament;
    }
    public void setTemperament(){

    }
}
