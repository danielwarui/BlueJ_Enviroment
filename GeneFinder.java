
/**
 * Write a description of GeneFinder here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.io.*;

public class GeneFinder {
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
}
