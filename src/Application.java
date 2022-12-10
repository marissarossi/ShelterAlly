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
}
