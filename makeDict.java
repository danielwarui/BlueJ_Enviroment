
/**
 * Write a description of makeDict here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.io.*;
public class makeDict {
    // initialize the characters you want to check with
    String charDict[] = {"","","","",""};  
    String charDictMirror[] = {"","","","",""};
    // make a password with eight characters
    public void makeStringCombination(){
        String file_path = "string_combis.txt";
        try{
            PrintWriter writer = new PrintWriter(file_path, "UTF-8");
            // write to file that one combination for all possible combinations
            for(int i = 4; i<charDict.length; i++){
                while(i == 4){
                String[] result = getAllLists(charDict, i);
                for(int j=0; j<result.length; j++){
                   //  System.out.println(result[j]);
                    String[] resultMirror = getAllLists(charDictMirror, i);
                     for(int k=0; k<resultMirror.length; k++){
                         writer.println(result[j]+resultMirror[k]);
                        }
                     
                   
                }
                break;
            }
        }
            writer.close();
        }

        catch(IOException e){
            System.out.println(e.getMessage());
        }

    }

    public String[] getAllLists(String[] elements, int lengthOfList)
    {
        //initialize our returned list with the number of elements calculated above
        String[] allLists = new String[(int)Math.pow(elements.length, lengthOfList)];

        //lists of length 1 are just the original elements
        if(lengthOfList == 1) return elements; 
        else {
            //the recursion--get all lists of length 3, length 2, all the way up to 1
            String[] allSublists = getAllLists(elements, lengthOfList - 1);

            //append the sublists to each element
            int arrayIndex = 0;

            for(int i = 0; i < elements.length; i++){
                for(int j = 0; j < allSublists.length; j++){
                    //add the newly appended combination to the list
                    allLists[arrayIndex] = elements[i] + allSublists[j];
                    arrayIndex++;
                }
            }
            return allLists;
        }
    }

}
