
/**
 * Write a description of FirstCSV here.
 * 
 * @author Warui
 * @version Saturday December 26th 2015
 */
import edu.duke.*;
import org.apache.commons.csv.*;
public class FirstCSV {
    public void readFood(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        for(CSVRecord record : parser){
            System.out.println(record.get("Name"));
        }
    }
}
