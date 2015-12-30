
/**
 * Write a description of WhileLoop here.
 * 
 * @author (wariver) 
 * @version (December 5th Saturday 2015, 9:44 pm)
 */
import edu.duke.*;
import java.io.*;

public class WhileLoop{
    public String findProtein(String strand){
        int start = strand.indexOf("atg");
        if (start == -1){
            return "";
        }
        int stop = strand.indexOf("tag", start + 3);
        if ((stop - start) % 3 == 0){
            return strand.substring(start, stop+3);
        }
        else{
            return "";
        }

    }

    public void actualPrintingStarts(){
        FileResource readFile = new FileResource("GRch38dnapart.fa");
        for (String word : readFile.lines()){
            //      System.out.println(word + "-- ");
            printAllStarts(word);
        }

    }

    public void printAllStarts(String strand){
        int start = 0;
        int  genecounter = 1;
        while(true){
            int location = strand.indexOf("ATG", start);
            if(location == -1){
                break;// breaks from while loop as no start codon has been found
            }
            /* while it continues to find start codonswe have to increment start for it to move on searching infront 
            of the one previously found*/

            //            System.out.println("Starts at" + location );
            start = location + 3;

            // find end of this start tag ...
            int endindex = findStopIndex(strand.substring(start, strand.length()),start);

            System.out.println("gene " + genecounter + " - " + strand.substring(start-3,endindex+3) + " lenght " + strand.substring(start-3,endindex+3).length()); 
            //   System.out.println("End index " + endindex );
            genecounter ++;

        }
    }
    public int findStopIndex(String strand, int index){
        int stop1 = strand.indexOf("TGA", index);
        int stop2 = strand.indexOf("TAA", index);
        int stop3 = strand.indexOf("TAG", index);

        //        System.out.println(strand + "strand " + "stop1 " + stop1 + " stop2 " + stop2 + " stop3 " + stop3);

        if (stop1 > 0  && modThree(stop1-index)){
            // is true
            //        System.out.println(strand.substring(0,stop1));
            //            stop1 = strand.length();
        }

        if (stop2  > 0  && modThree(stop2-index))	{
            //          System.out.println(strand.substring(0,stop1));
            //            stop2 = strand.length();
        }
        if (stop3  > 0  && modThree(stop3-index)){
            //            System.out.println(strand.substring(0,stop1));
            //stop3 = strand.length();
        }
        return Math.min(stop1, Math.min(stop2, stop3));
    }

    private boolean modThree(int index){
        boolean  ismodthree = false; 
        if (index % 3 == 0){
            ismodthree = true;
        }
        return ismodthree;
    }

}
