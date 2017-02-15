import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Countries {
    HashMap<String, ArrayList<Country>> world = new HashMap<>();    // the key is a letter, value is collection of countries that start with that letter
    ArrayList<Country> countries = new ArrayList<>();               // List of all countries

    public String getFirstLetter() throws IOException {
        System.out.println("Please enter a letter that matches the first letter for associated countries in the world.");
        Scanner s = new Scanner(System.in);
        String firstLetter = s.nextLine().substring(0, 1);
        printNewCountries(firstLetter);
        return firstLetter;
    }
    /* Read and parse the "countries.txt" file into an HashMap<String, ArrayList<Country>>
    where the key is a single letter and the value is a list of countries whose names start with that letter.
    */

    public void readAndSortFile() throws FileNotFoundException {
        File f = new File("countries.txt");
        Scanner s = new Scanner(f);
        while (s.hasNext()) {
            String line = s.nextLine();
            String[] countriesColumn = line.split("\\|");
            Country countryData = new Country((countriesColumn[1]), countriesColumn[0]);
            countries.add(countryData);
        }
        s.close();
    }

    public void populateWorld() {
        //For every country in countries
        // create local variable for country
        //get the first letter of that country
        //check the map if there is a list for letter for whichever letter
        //if it is not there then create new list
        //add that country to the list
        //put k,v into map

        for (Country country : countries) {
            String letter = country.name.substring(0, 1);
            if (world.get(letter) == null) {
                //create an arraylist in the world
                ArrayList<Country> newList = new ArrayList<>();
                newList.add(country);
                world.put(letter, newList);
            } else {
                world.get(letter).add(country);

            }
        }
    }

    //get countries out of hashmap and put into arraylist to pirint
    public void printNewCountries(String firstLetter) throws IOException{
        ArrayList<Country> matchingCountries = world.get(firstLetter);
        //send matchingCountries somewhere
        //must iterate over `matchingCountries` and creating a local variable `c` of type `Country`
        // that represents the current Country
        String fileName = firstLetter.toUpperCase() + "_" + "countries.txt";
        File f = new File(fileName);
        FileWriter fw = new FileWriter(f);
        for (Country c : matchingCountries){
            System.out.println(c.name);
            fw.write(c.name);
        }
        fw.close();
    }

    /*
    public String createFileName(){
        String fileName = getFirstLetter() + "_" + "countries.txt";
        return fileName;
    }
    */
    /*
    public void writeFile(String fileName, String fileContent) throws IOException {
        File f = new File(fileName);
        FileWriter fw = new FileWriter(f);
        fw.write(fileContent);
        fw.close();
    }
    */
}

