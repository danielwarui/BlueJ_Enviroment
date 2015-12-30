
/**
 * Write a description of BabyBirths here.
 * 
 * @author Ndungu Daniel Warui
 * @version : 1.0 29th December 2015 at 1821hrs
 */
import edu.duke.*;
import org.apache.commons.csv.*;

public class BabyBirths {
    public void printNames(){
        FileResource fr = new FileResource();
        //false means does not have a heaser row
        for(CSVRecord record : fr.getCSVParser(false)){
            int numBorn = Integer.parseInt(record.get(2));
            if(numBorn <= 100){
                System.out.println("Name " + record.get(0) +
                    "Gender " + record.get(1) + 
                    "Number Born " + record.get(2));
            }
        }
    }

    public void totalBirths(FileResource fr){
        int totalBirths = 0,totalBoys = 0,totalGirls = 0;
        int boysNames = 0,girlsNames = 0;
        for(CSVRecord record : fr.getCSVParser(false)){
            // int numBorn = Integer.parseInt(record.get(2));
            // totalBirths += numBorn;
            if(record.get(1).equals("M")){
                // totalBoys += numBorn;
                boysNames++;
            }
            else{
                // totalGirls += numBorn;
                girlsNames++;
            }
        }
        //System.out.println("total births = " + totalBirths);
        //System.out.println("total girls = " + totalGirls);
        //System.out.println("total boys = " + totalBoys);
        System.out.println("Unique boys names: " + boysNames);
        System.out.println("Unique girls names: " + girlsNames);

    }

    public void testTotalBirths(){
        FileResource fr = new FileResource();
        totalBirths(fr);
    }

    public int getRank(int year, String name, String gender){
        int rank = 0;
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser(false);

        for(CSVRecord record : parser){
            // for gender Male
            if(gender.equals("M") || gender.equals("F")){
                if(gender.equals(record.get(1))){
                    rank++;
                    if(name.equals(record.get(0))){
                        System.out.println(rank + name);
                        break;
                    }
                }
            }
            else{
                System.out.println("Invalid gender input please use M(Male) or F(Female)");
                rank = -1;
            }
        }
        return rank;
    }

    public String getName(int year, int rank, String gender){
        String halfling = null;
        return halfling;
    }

}