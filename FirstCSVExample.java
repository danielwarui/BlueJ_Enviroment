
/**
 * Write a description of FirstCSVExample here.
 * 
 * @author Warui
 * @version Sunday December 9th 2015 9:44pm
 */
import edu.duke.*;
import org.apache.commons.csv.*;

public class FirstCSVExample {
    public void readFood(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        for(CSVRecord record : parser){
            System.out.println(record.get("Name"));
        }
    }
}
