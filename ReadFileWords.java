
/**
 * Write a description of ReadFileWords here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.io.*;

public class ReadFileWords {
    public void readFileWords(){
        FileResource readFile = new FileResource("read.txt");
        for (String word : readFile.words()){
            System.out.println(word);
        }

    }

}
