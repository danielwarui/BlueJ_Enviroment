
/**
 * Write a description of UrlsFinder here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.io.*;

public class urlsFinder{
public void findUrls(String url){
URLResource page = new URLResource(url);
String source = page.asString();

int start = 0;
while(true){

	int index = source.indexOf("href=", start);
	if(index == -1){
		break;
	}
	int firstQuote = index + 6; // after href="
	int endQuote = source.indexOf("\"", firstQuote);

	String sub = source.substring(firstQuote,endQuote);
	if(sub.startsWith("http")){
System.out.println(sub);
	}
	start = endQuote + 1;
}

}
}
