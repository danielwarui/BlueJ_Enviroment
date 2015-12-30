
/**
 * Write a description of WhichCountriesExport here.
 * 
 * @author Warui Daniel 
 * @version 1.0 on 27/12/2015 Sunday 8:20pm 
 */
import edu.duke.*;
import org.apache.commons.csv.*;
public class WhichCountriesExport {
    public void listExporters(CSVParser parser, String exportOfInterest){
        /*the following is the algorithm written first of what we want to do*/

        //for each ROW in the CSV file
        for(CSVRecord record : parser){
            //      look at the exports column
            String export = record.get("Exports");
            //      check if it contains *exportOfInterest*
            if(export.contains(exportOfInterest)){
                String country = record.get("Country");
                System.out.println(country);
                //          if ROW contains the *exportOfInterest* write it down
            }
        }
    }

    public void whoExportsCoffee(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        // getCSVParser returns a parser Obj.
        listExporters(parser, "coffee");
    }
}
