
/**
 * Write a description of crawlbook here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.io.*;
public class crawlbook {

    public void findUrls(String url){
        URLResource page = new URLResource(url);
        String source = page.asString();

        int start = 0;
        while(true){

            int index = source.indexOf("itemprop=", start);
            if(index == -1){
                break;
            }
            int firstQuote = index + 10; // after href="
            int endQuote = source.indexOf("span", firstQuote);

            String sub = source.substring(firstQuote,endQuote);
            if(sub.startsWith("name")){
                System.out.println(sub);
            }
            start = endQuote + 1;
        }

    }
}

