
/**
 * Write a description of AssigmentOne here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.io.*;
import java.util.Arrays;
import edu.duke.*;
public class AssigmentOne {

    public void printsAllStarts(String strand){
        int start = 0;
        int counter = 0;
        while(true){
            int location = strand.indexOf("CTG", start);
            counter++;
            // a case where no start codon is found form the start position of the strand by loop
            if(location == -1){
                break;
            }
            System.out.println(counter + "Starts at " + location);

            start = location + 3;

        }
    }

    public int findStopIndex(String strand, int index){

        int firstStopCodon = strand.indexOf("TGA", index);
        if(firstStopCodon == -1 || (firstStopCodon - index) % 3 != 0){
            // if the firstStopCodon TGA is not found or is not a multiple of three away assign it the highest
            //value possible so that it fails when it comes to return the Math.min library result returned
            firstStopCodon = strand.length();
        }
        int secondStopCodon = strand.indexOf("TAA", index);
        if(secondStopCodon == -1 || (secondStopCodon - index) % 3 != 0){
            secondStopCodon = strand.length();
        }
        int thirdStopCodon = strand.indexOf("TAG", index);
        if(thirdStopCodon == -1 || (thirdStopCodon - index) % 3 != 0){
            thirdStopCodon = strand.length();
        }

        return Math.min(firstStopCodon, Math.min(secondStopCodon,thirdStopCodon));
    }

    public String getGenes(String dnaStrand){
        int start = 0;
        String result = null;
        while(true){
            int startMark = dnaStrand.indexOf("ATG",start);
            if(startMark == -1){
                break;
            }
            start = startMark + 3;       
            int stop = findStopIndex(dnaStrand, start);
            result = dnaStrand.substring(start, stop);
            start = stop + 3;
        }
        if(result.length() > 0){
            return result;
        }
        else{
            return "";
        }
    }
int startArr[] = new int[] {0,1};
    public void printAll(String dna){
        String nucleotide = null;
        int start = 0;
        int i = 1;
        
        while(true){
            int tag = dna.indexOf("ATG",start);
            if(tag == -1){
                break;
            }
            int end = findStopIndex(dna, tag+3);
            //gene residents
            if(end != dna.length()){
                //System.out.println(i + dna.substring(tag, end+3));
                nucleotide = dna.substring(tag, end+3);
                startArr = arrayAdd(nucleotide.length());
                /* finding the genes with CtoG ratio greater than 0.35*//*
                if(CtoGGreater(nucleotide)){
                System.out.println(i + nucleotide);
                i++;
                }*/
                /* find  greater than the length 60*//*
                if(nucleotide.length() > 60){
                System.out.println(i + nucleotide);
                i++;
                }*/
                System.out.println(nucleotide.length());
                //i++;
                start = end + 3;
            }
            else{
                start += 3;
            }

        }
        Arrays.sort(startArr);
        System.out.print(Arrays.toString(startArr));
        System.out.println(i);
    }

    public int numberC(String c){
        //getting all the Cs
        int counter = 0,start = 0;
        while(true){
            int loc = c.indexOf("C", start);
            if(loc == -1){
                break;
            }
            //System.out.println();
            counter ++;
            start = loc + 1;
        }

        return counter;
    }

    public int numberG(String g){
        //getting all the Gs
        int counter = 0,start = 0;
        while(true){
            int loc = g.indexOf("G", start);
            if(loc == -1){
                break;
            }
            //System.out.println();
            counter ++;
            start = loc + 1;
        }
        return counter;
    }

    public boolean CtoGGreater(String nucleotide){
        double CtoG_Ratio = 0.0;
        int C = numberC(nucleotide);
        int G = numberG(nucleotide);         

        CtoG_Ratio = (double)C/G;
        System.out.println(C + " / " + G +" = " + CtoG_Ratio);

        if(CtoG_Ratio > 0.35){
            return true;
        }
        else{
            return false;
        }
    }
    int[] arrayAdd(int pushValue){
        //define the new array
        int[] newArray = new int[startArr.length + 1];

        //copy values into new array
        for(int i=0;i < startArr.length;i++)
            newArray[i] = startArr[i];
        //another solution is to use 
        //System.arraycopy(oldArray, 0, newArray, 0, oldArray.length);

        //add new value to the new array
        newArray[newArray.length-1] = pushValue;

        //copy the address to the old reference 
        //the old array values will be deleted by the Garbage Collector
        startArr = newArray;
        //System.out.print(Arrays.toString(start));
        return startArr;       
    }

    public void realTesting(){
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            String s = fr.asString();
            //System.out.println("read " + s.length()+ " characters")
            printAll(s);
            //printsAllStarts(s);
            //System.out.println("found PROTEIN>> "+ result);
        }      
    }

}

