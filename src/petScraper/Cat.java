package petScraper;

import java.util.ArrayList;

public class Cat {
	String name;
	public ArrayList<String> URL;
	String IDURL;
	String sex;
	String breed;
	String weight;
	String DOB;
	String age;
	String location;
	String description;
	String ID;

	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

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

	public String getIDURL() {
		return IDURL;
	}

	public void setIDURL(String IDURL) {
		this.IDURL = IDURL;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}

