package petScraper;

import java.util.ArrayList;

public class Dog {
    String name;
    ArrayList<String> URL;
    String energyLevel;
    String childLevel;
    String catLevel;
    String dogLevel;
    String homeAlone;
    String ID;
    String sex;
    String breed;
    String weight;
    String DOB;
    String age;
    String location;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    String description;

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSex() {

        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
    /*    public Dog(){
    }*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getURL() {
        return URL;
    }

    public void addURL(String URL) {
        if (this.URL == null){
            ArrayList<String> temp = new ArrayList<>();
            this.URL = temp;
        }
        this.URL.add(URL);
    }

    public String getEnergyLevel() {
        return energyLevel;
    }

    public Dog setEnergyLevel(String energyLevel) {
        this.energyLevel = energyLevel;
        return this;
    }

    public String getChildLevel() {
        return childLevel;
    }

    public void setChildLevel(String childLevel) {
        this.childLevel = childLevel;
    }

    public String getCatLevel() {
        return catLevel;
    }

    public void setCatLevel(String catLevel) {
        this.catLevel = catLevel;
    }

    public String getDogLevel() {
        return dogLevel;
    }

    public void setDogLevel(String dogLevel) {
        this.dogLevel = dogLevel;
    }

    public String getHomeAlone() {
        return homeAlone;
    }

    public void setHomeAlone(String homeAlone) {
        this.homeAlone = homeAlone;
    }
}