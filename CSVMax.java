
/**
 * Write a description of CSVMax here.
 * 
 * @author Warui Daniel
 * @version 1.0     12:02am. Monday December 28th 2015
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;
public class CSVMax {
    public CSVRecord hottestHourinFile(CSVParser parser){
        //start with largestSoFar as nothing
        CSVRecord largestSoFar = null;
        // For each row as(CurrentRow) in the CSV File
        for(CSVRecord currentRow : parser){
            //      If the largestSoFar is nothing
            largestSoFar = getLargestOfTwo(currentRow, largestSoFar);
        }
        //The largestSoFar is the answer
        return largestSoFar;
    }

    public CSVRecord getLargestOfTwo(CSVRecord currentRow,CSVRecord largestSoFar){
        if(largestSoFar == null){
            largestSoFar = currentRow;
        }
        else{
            double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
            double largestTemp = Double.parseDouble(largestSoFar.get("TemperatureF"));
            //          Check if currentRow's temperature > largestSoFar
            if(currentTemp > largestTemp){
                //              If so update largestSoFar to currentRow
                largestSoFar = currentRow;
            } 
        }
        return largestSoFar;
    }

    public void testHottestInDay(){
        FileResource fr = new FileResource();
        CSVRecord largest = hottestHourinFile(fr.getCSVParser());
        System.out.println("hottest temperature was " + largest.get("TemperatureF") + " at "+
            largest.get("TimeEDT"));
    }

    public void testHottestInManyDays(){
        CSVRecord largest = hottestInManyDays();
        System.out.println(largest.get("TimeEDT"));
    }

    public CSVRecord hottestInManyDays(){
        CSVRecord largestSoFar = null;
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            // use method to get largest in file.
            CSVRecord currentRow = hottestHourinFile(fr.getCSVParser());
            largestSoFar = getLargestOfTwo(currentRow, largestSoFar);
        }
        return largestSoFar;
    }
}
