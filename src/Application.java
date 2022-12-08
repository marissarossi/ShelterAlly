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

    public String getName(){
        return name;
    }
    public void setName(){

    }
    public String getAddress(){
        return address;
    }
    public void setAddress(){

    }
    public String getPhoneNumber(){
        return phoneNumber;
    }
    public void setPhoneNumber(){

    }
    public String getDogSize(){
        return dogSize;
    }
    public void setDogSize(){

    }
    public boolean getKidsInHome(){
        return kidsInHome;
    }
    public void setKidsInHome(){

    }
    public boolean getOtherDogs(){
        return otherDogs;
    }
    public void setOtherDogs(){

    }
    public boolean getHasCats(){
        return hasCats;
    }
    public void setHasCats(){

    }
    public String getEnergyLevel(){
        return energyLevel;
    }
    public void setEnergyLevel(){

    }
    public boolean setHasYard(){
        return hasYard;
    }
    public void getHasYard(){

    }
}
