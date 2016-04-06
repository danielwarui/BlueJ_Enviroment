
/**
 * Write a description of WordPlay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class WordPlay {
    public boolean isVowel(char ch){
        return ch == 'a' || ch == 'e'|| ch == 'i'|| ch == 'o'|| ch == 'u' || ch == 'A' || ch == 'E'|| ch == 'I'|| ch == 'O'|| ch == 'U';
    } 

    public void testIsVowel(char ch){
        if(isVowel(ch)){
            System.out.println(ch + " << is a vowel");
        }            else{
            System.out.println(ch + " << is not a vowel");
        }
    }

    public void testReplaceVowels(){
        String toReplace = "My name is daniel warui";
        char ch = '%';
        toReplace = replaceVowels(toReplace, ch);
        System.out.println(toReplace);
    }

    public String replaceVowels(String phrase, char ch){
        StringBuilder sb = new StringBuilder(phrase);

        for(int i = 0; i < sb.length(); i++){
            char holderChar = sb.charAt(i);
            if(isVowel(holderChar))
                sb.setCharAt(i, ch);
        }
        return sb.toString();
    }

    public boolean isEvenNumber(int number){
        return (number % 2 == 0);
    }

    public String emphasize(String phrase, char ch){
        /* ch should be replaced by * if it's an odd number in the string
         * or + if it's an even number in the string
         */
        // make an uppercase lowerchase check variable
        char chUpperLowerCheck;
    
        if (Character.isLowerCase(ch)){
          chUpperLowerCheck = Character.toUpperCase(ch);
    }
    else{
    chUpperLowerCheck = Character.toLowerCase(ch);
    }
        
        StringBuilder sb = new StringBuilder(phrase);
        for(int i = 0; i < sb.length(); i++){
            char holderChar = sb.charAt(i);
            if(holderChar == ch || holderChar == chUpperLowerCheck){
                if(isEvenNumber(i))
                sb.setCharAt(i, '*');
                else
                sb.setCharAt(i, '+');
            }
        }
        return sb.toString();
    }

}