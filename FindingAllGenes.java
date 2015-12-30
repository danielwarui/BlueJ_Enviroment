
/**
 * Write a description of FindingAllGenes here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FindingAllGenes {
public void printsAllStarts(String strand){
int start = 0;
while(true){
int location = strand.indexOf("atg", start);
// a case where no start codon is found form the start position of the strand by loop
if(location == -1){
break;
}
System.out.println("Starts at " + location);
start = location + 3;

}
}

public int findStopIndex(String strand, int index){
    
int firstStopCodon = strand.indexOf("tga", index);
if(firstStopCodon == -1 || (firstStopCodon - index) % 3 != 0){
    firstStopCodon = strand.length();
}
int secondStopCodon = strand.indexOf("taa", index);
if(secondStopCodon == -1 || (secondStopCodon - index) % 3 != 0){
    secondStopCodon = strand.length();
}
int thirdStopCodon = strand.indexOf("tag", index);
if(thirdStopCodon == -1 || (thirdStopCodon - index) % 3 != 0){
    thirdStopCodon = strand.length();
}

return Math.min(firstStopCodon, Math.min(secondStopCodon,thirdStopCodon));
}
}
