
/**
 * Write a description of BabyBirths here.
 * 
 * @author Ndungu Daniel Warui
 * @version : 1.0 29th December 2015 at 1821hrs
 */
import java.io.*;
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
        boolean nameFound = false;
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser(false);
        for(CSVRecord record : parser){
            // when the desired gender is found initialize counter
            if(gender.equals(record.get(1))){
                rank++;
                if(name.equals(record.get(0))){
                    nameFound = true;
                    // we can break from the loop once we find the name we are looking for;
                    break;
                }
                else{
                    // says name was not found until record shows that name was found
                    nameFound = false;
                }
            }
        }

        if(nameFound){
            System.out.println("The name " + name + " is rank " + rank);
        }else{
            System.out.println("The name " + name + " is not found ");
            rank = -1;
        }

        return rank;
    }

    public void testGetRank(String name, String gender){
        int highestRank = getRank( 3 , name, gender);
    }

    public String getName(int year, int rank, String gender){
        String halfling = null;
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser(false);
        for(CSVRecord record : parser){
            // when the desired gender is found initialize counter
            if(gender.equals(record.get(1))){
                rank--;
                if(rank == 0){
                    System.out.println(record.get(0));
                    halfling = record.get(0);
                    break;
                }
                else{
                    halfling = "NO NAME";
                }
            }
        }

        return halfling;
    }

    public void whatIsNameInYear(int rank, int yearOne, int yearTwo, String gender){
        String pronoun = null;
        if(gender == "M"){
            pronoun = "he";
        }
        else{
            pronoun = "she";
        }

        String nameInFirstYear = getName(yearOne, rank, gender);
        String nameInSecondYear = getName(yearTwo, rank, gender);
        System.out.println(nameInFirstYear + " born in " + yearOne + " would be "+ nameInSecondYear + " if " + pronoun + " was born in " + yearTwo + ".");

    }

    public int getRankinFile(File f, int year, String name, String gender){
        int rank = 0;
        boolean nameFound = false;
        FileResource fr = new FileResource(f);
        CSVParser parser = fr.getCSVParser(false);
        for(CSVRecord record : parser){
            // when the desired gender is found initialize counter
            if(gender.equals(record.get(1))){
                rank++;
                if(name.equals(record.get(0))){
                    nameFound = true;
                    // we can break from the loop once we find the name we are looking for;
                    break;
                }
                else{
                    // says name was not found until record shows that name was found
                    nameFound = false;
                }
            }
        }

        if(nameFound){
            //  System.out.println("The name " + name + " is rank " + rank);
        }else{
            //  System.out.println("The name " + name + " is not found ");
            rank = -1;
        }

        return rank;
    }

    public int yearOfHighestRank(String name, String gender){
        int highestRankSoFar = 0;
        int rank = 0;
        boolean nameFound = false;
        String yearOfHighestRank;
        // setup check for many files
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles()){
            // check file by file
            int currentRankSoFar = getRankinFile(f,2,name,gender);
            if(currentRankSoFar == -1){
                currentRankSoFar = 2147483647;
                // System.out.println(name + " was not found in the file " + f.toString());
            }
            if(currentRankSoFar == 3546){
            
            System.out.println(" current highest rank so far " + f.toString());
            }
            highestRankSoFar = getHigherRankOfTwo(currentRankSoFar, highestRankSoFar);
          //  System.out.println(currentRankSoFar + "  " + highestRankSoFar + f.toString());
            //int highestRank = getRank( 3 , name, gender);
            // getRank for name and gender as given
            // update smallest rank so far
        }
        
        return highestRankSoFar; 
    }

    public int getHigherRankOfTwo(int currentSmallest,int smallestSoFar){

        if(smallestSoFar == 0){
            smallestSoFar = currentSmallest;
        }

        if(currentSmallest < smallestSoFar){

            smallestSoFar = currentSmallest;
        } 

        return smallestSoFar;
    }

    public double findAverage(double sum, int noOfEntries){
        return sum / noOfEntries;
    }

    public double getAverageRank(String name, String gender){
        double averageRank = 0.0;
        int sumRanks = 0;
        int sumFilesWithName = 0;
        // Set up check for selecting multiple files
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles()){
            // check file by file
            // get rank through name and gender given 
            int currentRankSoFar = getRankinFile(f,2,name,gender);
            if(currentRankSoFar == -1){

                // System.out.println(name + " was not found in the file " + f.toString());
            }else{
                sumFilesWithName++;
                sumRanks += currentRankSoFar;
            }

            // highestRankSoFar = getHigherRankOfTwo(currentRankSoFar, highestRankSoFar);
            // System.out.println(currentRankSoFar + "  " + highestRankSoFar + f.toString());

        }
        averageRank = findAverage((double) sumRanks, sumFilesWithName);
        // sum of ranks collected for every file
        /*count number of files checked and minus the file for everytime -1 rank is returned*/
        /*have value of the total number of ranks */

        return averageRank;
    }
    // method returns total number of births of the gender above the name passed.
    public int getTotalBirthsRankedHigher(int year, String name, String gender){
        // get Rank for name gender
        // initialize sum for counting items in row 2 

        int totalBirthsRankedHigher = 0;
        int counter = 0;

        int rankinUse = getRank(year, name, gender);
        rankinUse -= 1;
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser(false);
        for(CSVRecord record : parser){

            // when the desired gender is found initialize counter
            if(gender.equals(record.get(1))){
                counter++;
                totalBirthsRankedHigher += Integer.parseInt(record.get(2));
                //once we get the gender we are suposed to add up until negative one rank
                if(counter == rankinUse){
                    break;

                }

            }
        }
        return totalBirthsRankedHigher;
    }

    /*
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
     */
}