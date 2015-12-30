
/**
 * Write a description of ExportCountries here.
 * 
 * @author (warui) 
 * @version (1:23 am Monday December 7th 2015)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
public class ExportCountries {
    public void listExporters(CSVParser parser, String exportOfInterest){
        for (CSVRecord record : parser){
            String export = record.get("Exports");

            if(export.contains(exportOfInterest)){
                String country = record.get("Country");
                System.out.println(country);
            }
        }
    }
    public void whoExportsCoffee(){
    FileResource fr = new FileResource();
    CSVParser parser = fr.getCSVParser();
    listExporters(parser, "coffee");
    }

}
