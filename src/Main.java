import java.util.ArrayList;

public class Main{

public static void main(String[]args) throws Exception{

    Countries selectedCountries = new Countries();

    selectedCountries.readAndSortFile();

    selectedCountries.populateWorld();

    selectedCountries.getFirstLetter();
 }
}