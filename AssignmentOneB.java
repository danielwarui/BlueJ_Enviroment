
/**
 * Write a description of AssignmentOneB here.
 * 
 * @author Warui 
 * @version (a version number or a date)
 */
import java.io.*;
import edu.duke.*;

public class AssignmentOneB {
    public void findURLs(String url){
        URLResource page = new URLResource(url);
        String source = page.asString();
        int start = 0,i = 0,f = 0;
        int startDot = 0;
        int foundDot = 0;
        while(true){
            int index = source.indexOf("href=", start); 

            if(index == -1){
                break;
            }
            int firstQuote = index + 6;
            int endQuote = source.indexOf("\"", firstQuote);
            String sub = source.substring(firstQuote,endQuote);
            //counting Dots found
            
            /*checking links that end with contains or startWith*/
              if(sub.contains("http")){
            foundDot = numberG(sub);
            f += foundDot;
            i++;
            System.out.println(f);
            }
             
           // System.out.println(i + sub);
            start = endQuote + 1;
        }
        System.out.println(i);
    }

    public int numberG(String g){
        //getting all the Gs
        int counter = 0,start = 0;
        while(true){
            int loc = g.indexOf(".", start);
            if(loc == -1){
                break;
            }
            //System.out.println();
            counter ++;
            start = loc + 1;
        }
        return counter;
    }
    public void testURL(){
        findURLs("http://www.dukelearntoprogram.com/course2/data/newyorktimes.html");
    }
}
