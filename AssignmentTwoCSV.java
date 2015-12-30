
/**
 * Write a description of CSVMax here.
 * 
 * @author Warui Daniel
 * @version 1.0     12:54am. Monday December 28th 2015 finished writing it 12:14pm. on the next day
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;
public class AssignmentTwoCSV {

    public void testAverageTemperatureWithHighHumidityInFile(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        double averageTemp = averageTemperatureWithHighHumidityInFile(parser, 80);
        if(averageTemp != 0.0){
            System.out.println("Average Temp when high humidity is " + averageTemp);
        }
        else{
            System.out.println("No temperatures with that humidity");
        }

    }

    public double averageTemperatureWithHighHumidityInFile(CSVParser parser, int value){
        int numberEntries = 0;
        int currentHum = 0;
        double sum = 0.0;
        // For each row as(CurrentRow) in the CSV File
        for(CSVRecord currentRow : parser){
            //      If the coolestSoFar is nothing
            currentHum = tryParseInt(currentRow.get("Humidity"));
            if(currentHum >= value){
                numberEntries++;
                sum += Double.parseDouble(currentRow.get("TemperatureF"));
            }
        }
        if(numberEntries != 0){
            return findAverage(sum, numberEntries);
        }else{
            return 0.0;
        }

    }

    public double averageTemperatureInFile(CSVParser parser){
        int numberEntries = 0;
        double sum = 0.0;
        // For each row as(CurrentRow) in the CSV File
        for(CSVRecord currentRow : parser){
            //      If the coolestSoFar is nothing
            numberEntries++;
            sum += Double.parseDouble(currentRow.get("TemperatureF"));
        }

        return findAverage(sum, numberEntries);
    } 

    public double findAverage(double sum, int noOfEntries){
        return sum / noOfEntries;
    }

    public void testAverageTemperatureInFile(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        double averageTemp = averageTemperatureInFile(parser);
        System.out.println("Average temperature in file is " + averageTemp);

    }

    public void testLowestHumidityInFile(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        CSVRecord csv = lowestHumidityInFile(parser);
        System.out.println("Lowest Humidity was" + csv.get("Humidity") + " at "+ csv.get("DateUTC"));
    }

    public CSVRecord lowestHumidityInFile(CSVParser parser){
        //start with coolestSoFar as nothing
        CSVRecord lowestSoFar = null;
        // For each row as(CurrentRow) in the CSV File
        for(CSVRecord currentRow : parser){
            //      If the coolestSoFar is nothing
            lowestSoFar = lowerHumididtyOfTwo(currentRow, lowestSoFar);
        }
        //The coolestSoFar is the answer

        return lowestSoFar;
    }

    int tryParseInt(String value) { 
        try {  
            return Integer.parseInt(value);  
        } catch(NumberFormatException nfe) {  
            // Log exception.
            return 0;
        }  
    }

    public CSVRecord lowerHumididtyOfTwo(CSVRecord currentRow,CSVRecord lowestSoFar){
        if(lowestSoFar == null){
            lowestSoFar = currentRow;
        }
        else{

            int currentHum = tryParseInt(currentRow.get("Humidity"));
            int coolestHum = tryParseInt(lowestSoFar.get("Humidity"));
            //          Check if currentRow's temperature > coolestSoFar
            if(currentHum > 0 && coolestHum > 0){
                if(currentHum < coolestHum){
                    //              If so update coolestSoFar to currentRow
                    lowestSoFar = currentRow;
                } 
            }

        }
        return lowestSoFar;
    }

    public void testFileWithLowestHumidity(){
        String lowest = fileWithlowestHumidity();
        System.out.println("lowest humidity day was in file " + lowest);
        FileResource fr = new FileResource(lowest);
        CSVRecord RecordCoolest = lowestHumidityInFile(fr.getCSVParser());
        System.out.println("lowest humidity on that day was " + RecordCoolest.get("Humidity") + "at " +
        RecordCoolest.get("DateUTC"));
      
    }

    public String fileWithlowestHumidity(){
        //String currentFile = null;
        String lowestFile = null;
        
        CSVRecord lowestSoFar = null;
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            CSVRecord currentRow = lowestHumidityInFile(fr.getCSVParser());

            if(lowestFile == null){
                lowestSoFar = currentRow;
                lowestFile = f.toString();
                //lowestFile = f.toString();

            }
            else{
                int currentHum = tryParseInt(currentRow.get("Humidity"));
                int coolestHum = tryParseInt(lowestSoFar.get("Humidity"));
                //          Check if currentRow's temperature > coolestSoFar
                if(currentHum > 0 && coolestHum > 0){
                    if(currentHum < coolestHum){
                        //              If so update coolestSoFar to currentRow
                        lowestSoFar = currentRow;
                        lowestFile = f.toString();
                    } 
                }

            }
        }
        return lowestFile;
    }

    public String fileWithColdestTemperature(){
        
        String coolestFile = null;
        CSVRecord coolestSoFar = null;
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);

            // use method to get largest in file.
            CSVRecord currentRow = coldestHourInFile(fr.getCSVParser());

            //largestSoFar = getLargestOfTwo(currentRow, largestSoFar);
            if(coolestSoFar == null){
                coolestSoFar = currentRow;
               // coolestFile = f.toString();

            }
            else{
                double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
                double coolestTemp = Double.parseDouble(coolestSoFar.get("TemperatureF"));
                //          Check if currentRow's temperature > coolestSoFar
                if(currentTemp < coolestTemp){
                    //              If so update coolestSoFar to currentRow
                    coolestSoFar = currentRow;
                    coolestFile = f.toString();
                } 
            }
        }

        return coolestFile;

    }

    public void testFileWithColdestTemperature(){
        String coolest = fileWithColdestTemperature();
        System.out.println("Coldest day was in file " + coolest);
        FileResource fr = new FileResource(coolest);
        CSVRecord RecordCoolest = coldestHourInFile(fr.getCSVParser());
        System.out.println("coolest temperature on that day was " + RecordCoolest.get("TemperatureF"));
        System.out.println("All the Temperatures on the coldest day were:");
        CSVParser parser = fr.getCSVParser();
        for(CSVRecord record : parser){
            System.out.println(record.get("DateUTC") + record.get("TemperatureF"));
        }
    }

    public CSVRecord coldestHourInFile(CSVParser parser){
        //start with coolestSoFar as nothing
        CSVRecord coolestSoFar = null;
        // For each row as(CurrentRow) in the CSV File
        for(CSVRecord currentRow : parser){
            //      If the coolestSoFar is nothing
            coolestSoFar = getCoolerOfTwo(currentRow, coolestSoFar);
        }
        //The coolestSoFar is the answer

        return coolestSoFar;
    }

    public CSVRecord getCoolerOfTwo(CSVRecord currentRow,CSVRecord coolestSoFar){
        if(coolestSoFar == null){
            coolestSoFar = currentRow;
        }
        else{
            double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
            double coolestTemp = Double.parseDouble(coolestSoFar.get("TemperatureF"));
            //          Check if currentRow's temperature > coolestSoFar
            if(currentTemp < coolestTemp){
                //              If so update coolestSoFar to currentRow
                coolestSoFar = currentRow;
            } 
        }
        return coolestSoFar;
    }

    /*Working Okay no need to modify*/
    public void testColdestHourInFile(){
        FileResource fr = new FileResource();
        CSVRecord coolest = coldestHourInFile(fr.getCSVParser());
        System.out.println("coolest temperature was " + coolest.get("TemperatureF") + " at "+
            coolest.get("DateUTC"));
    }
}
