
/**
 * Write a description of Assingment1 here.
 * 
 * @author (Daniel Warui) 
 * @version (December 5th, Saturday 9:41 pm)
 */
import edu.duke.*;
import java.io.*;

public class Assingment1 {
    public String findGene(String strand){

        String startCodon = "atg";
        String stopCodon1 = "tag";
        String stopCodon2 = "tga";
        String stopCodon3 = "taa";

        int start;
        int stop;
        int stop2;
        int stop3;

        start = strand.indexOf(startCodon);
        stop = strand.indexOf(stopCodon1, start + 3);
        stop2 = strand.indexOf(stopCodon2, start + 3);
        stop3 = strand.indexOf(stopCodon3, start + 3);

        if (start == -1){
            return "";
        }

        if ((stop - start) % 3 == 0){
            return strand.substring(start, stop+3) + "The stop codon identifying it is" + strand.substring(stop, stop + 3);
        }
        if ((stop2 - start) % 3 == 0){
            return strand.substring(start, stop2 + 3) + "The stop codon identifying it is" + strand.substring(stop2, stop2 + 3);
        } 
        if ((stop3 - start) % 3 == 0){
            return strand.substring(start, stop3 + 3) + "The stop codon identifying it is" + strand.substring(stop3, stop3 + 3);
        }
        else{
            return "";
        }
    }

    private static boolean isAllUpper(String s) {
        for(char c : s.toCharArray()) {
            if(Character.isLetter(c) && Character.isLowerCase(c)) {
                return false;
            }
        }
        return true;
    }
}