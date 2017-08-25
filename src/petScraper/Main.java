package petScraper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

public class Main {
	static ArrayList<Dog> dogInfo = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		downloadDogInfo("https://www.austinpetsalive.org/adopt/dogs/");
		
		for (int i=0; i<dogInfo.size(); i++) {
			System.out.println(String.valueOf(i)+"/"+dogInfo.size());
			
			getIDinfo(i);
		}
		System.out.println("done");
		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		try ( final FileWriter fileWriter = new FileWriter(new File("petScaperJSON.txt")) ) {
			gson.toJson(dogInfo, fileWriter);
		}
	}


	public static void downloadDogInfo (String...url) {
		try {
			Document doc = Jsoup.connect(url[0]).get();
			Elements dogNames = doc.select("h3");
			Elements dogURLs = doc.select("img[class=photo]");
			Elements dogStats = doc.select("div[class=legend-box]");

			//Dog URL - find URL for each dog and create Dog object
			for (Element e : dogURLs) {
				Dog dog = new Dog();
				dog.addURL(e.attr("src"));
				dogInfo.add(dog);
			}

			//Dog Name - find name for each dog. For loop restricted to size of dogInfo array to prevent extra <h3> content at end of document (i.e. sign up for updates, find us on facebook)
			for (int i = 0; i < dogInfo.size(); i++) {
				dogInfo.get(i).setName(dogNames.get(i).text());
			}

			//Dog Levels - find compatibility level table for each dog and parses it into object
			for (int i = 0; i < dogStats.size(); i++) {
				String dogStatsString = dogStats.get(i).text();
				String temp[] = dogStatsString.split(":");

				for (int k = 0; k < temp.length; k++) {
					temp[k] = temp[k].substring(1, 2);
				}
				dogInfo.get(i).setEnergyLevel(temp[1]);
				dogInfo.get(i).setChildLevel(temp[2]);
				dogInfo.get(i).setCatLevel(temp[3]);
				dogInfo.get(i).setDogLevel(temp[4]);
				dogInfo.get(i).setHomeAlone(temp[5]);
			}

			//Dog ID - uses same element as compatibility level table, but instead parses ID
			for (int i = 0; i < dogStats.size(); i++) {
				String temp = dogStats.get(i).attr("id").toString();
				temp = temp.replace("LegendBox", "");
				dogInfo.get(i).setID(temp);
			}

			//check to see if all arrays match, -5 to avoid <h3> elements such as i.e. sign up for updates, find us on facebook
			if ((dogNames.size() - 5) == dogURLs.size() && dogURLs.size() == dogStats.size()) {
				System.out.print("All sizes match: ");
				System.out.println(String.valueOf(dogNames.size()-5));
			} else {
				System.out.println("Mismatch in sizes: ");
				System.out.print("Dog Names: ");
				System.out.println(String.valueOf(dogNames.size()));
				System.out.print("Dog URLs: ");
				System.out.println( String.valueOf(dogURLs.size()));
				System.out.println((dogStats.size()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void getIDinfo(Integer... i) {
		//Details about each animal
		try {
			String URL = "https://www.austinpetsalive.org/adopt/available-dog-details/?ID=" + dogInfo.get(i[0]).getID();
			Document docID = Jsoup.connect(URL).get();
			Elements dogIDStats = docID.select("td");
			Elements dogDescription = docID.select("span[id=lbDescription]");
			Elements dogExtraUrls = docID.select("img[id=Photo1]");

			dogInfo.get(i[0]).setSex(dogIDStats.get(1).text());
			dogInfo.get(i[0]).setBreed(dogIDStats.get(2).text());
			dogInfo.get(i[0]).setWeight(dogIDStats.get(3).text());
			dogInfo.get(i[0]).setDOB(dogIDStats.get(4).text());
			dogInfo.get(i[0]).setAge(dogIDStats.get(5).text());
			dogInfo.get(i[0]).setLocation(dogIDStats.get(6).text());
			dogInfo.get(i[0]).setDescription(dogDescription.text());

			for (int k = 0; k < dogExtraUrls.size(); k++) {
				dogInfo.get(i[0]).URL.add(dogExtraUrls.get(k).attr("src"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		/*	        System.out.print("Name: ");
	        System.out.println(dogInfo.get(i[0]).getName());
	        System.out.print("Sex: ");
	        System.out.println(dogInfo.get(i[0]).getSex());
	        System.out.println("Breed: ");
	        System.out.println(dogInfo.get(i[0]).getBreed());
	        System.out.println("Weight: ");
	        System.out.println(dogInfo.get(i[0]).getWeight());
	        System.out.println("DOB: ");
	        System.out.println(dogInfo.get(i[0]).getDOB());
	        System.out.println("Age: ");
	        System.out.println(dogInfo.get(i[0]).getAge());
	        System.out.println("Location: ");
	        System.out.println(dogInfo.get(i[0]).getLocation());
	        System.out.println("ID: ");
	        System.out.println(dogInfo.get(i[0]).getID());
	        System.out.println("URL: ");
	        System.out.println(dogInfo.get(i[0]).getURL().toString());
	        System.out.println("Energy Level: ");
	        System.out.println(dogInfo.get(i[0]).getEnergyLevel());
	        System.out.println("Child Level: ");
	        System.out.println(dogInfo.get(i[0]).getChildLevel());
	        System.out.println("Cat Level: ");
	        System.out.println(dogInfo.get(i[0]).getCatLevel());
	        System.out.print("Dog Level: ");
	        System.out.println(dogInfo.get(i[0]).getDogLevel());
	        System.out.print("Home Alone: ");
	        System.out.println(dogInfo.get(i[0]).getHomeAlone());*/

	}

}


