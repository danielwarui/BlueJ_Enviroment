
/**
 * Write a description of WhichCountriesExport here.
 * 
 * @author Warui Daniel 
 * @version 1.0 on 27/12/2015 Sunday 8:36pm 
 */
import edu.duke.*;
import org.apache.commons.csv.*;
public class AssignmentOneCSV {
    public void tester(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        // listExportersTwoProducts(parser, "cotton", "flowers");
        /*int number = numberOfExporters(parser, "cocoa");
        System.out.println(number);*/
        /* String information = countryInfo(parser, "Nauru");
        System.out.println(information);*/
        bigExporters(parser, "$999,999,999,999");

    }
    //method returns infomartion about a country or NOT FOUND 
    public String countryInfo(CSVParser parser, String country){
        String countryInformation = null;
        /*
        FORMAT OF THE STRING RETURNED IS
        country: list of exports: countries export value
         */
        for(CSVRecord record : parser){
            String countryStr = record.get("Country");
            if(countryStr.equals(country)){
                // Name of the country is *CountryStr and not *country(parameter)
                String exports = record.get("Exports"); 
                String value = record.get("Value (dollars)");

                countryInformation = countryStr + ": " + exports + ": " + value;
                break;
            }
            else{
                countryInformation = "NOT FOUND";
            }

        }
        //check every row 
        return countryInformation;
    }

    // this method prints names of all the countries that have both export1 & 2
    public void listExportersTwoProducts(CSVParser parser, String exportItem1 , String exportItem2){
        // check each row printing the countries that have both export one and two
        for(CSVRecord record : parser){
            String exports = record.get("Exports");
            if(exports.contains(exportItem1) && exports.contains(exportItem2)){
                String country = record.get("Country");
                System.out.println(country);
            }
        }
    }
    // method returns number of countries that export a certain item
    public int numberOfExporters(CSVParser parser, String exportItem){
        int numberOfExporters = 0;
        for(CSVRecord record : parser){
            String exports = record.get("Exports");
            if(exports.contains(exportItem)){
                numberOfExporters++;
                String country = record.get("Country");
                System.out.println(numberOfExporters + ": "+ country);
            }
        }
        return numberOfExporters;
    }
    // this method prints thee names of countries and their value amount for all countries whose value of string is longer than string amount
    public void bigExporters(CSVParser parser, String amount){

        for(CSVRecord record : parser){
            String value = record.get("Value (dollars)");

            int len = amount.length();
            int valLength = value.length();
            if(valLength > len){

                String country = record.get("Country");
                System.out.println(country + " " + value);
            }

        }
    }

}
