
/**
 * Write a description of CaersarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class CaesarCipher {
    public String encrypt(String input, int key){
        // make a StringBuilder (encrypted) with input message
        StringBuilder encrypted = new StringBuilder(input);
        // write down the alphabet
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        // Compute the shifted alphabet
        String shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);

        // Count from 0 to < length of encrypted, (call it i)
        for(int i = 0; i < encrypted.length(); i++){
            // create a \/ holder for a character from input we want to modify 
            char currChar = encrypted.charAt(i);
            if (Character.isLowerCase(currChar)){
                //convert currChar to upperCase first
                currChar = Character.toUpperCase(currChar);
                int idx = alphabet.indexOf(currChar);
                if(idx != -1){
                    char newChar = shiftedAlphabet.charAt(idx);
                    newChar = Character.toLowerCase(newChar);
                    encrypted.setCharAt(i, newChar);
                }

            }else{
                int idx = alphabet.indexOf(currChar);
                if(idx != -1){
                    char newChar = shiftedAlphabet.charAt(idx);
                    encrypted.setCharAt(i, newChar);
                }
            }

        }
        System.out.println(encrypted.toString());
        return encrypted.toString();
    }

    public void testCaesar(){
        int key = 17;
        FileResource fr = new FileResource();
        String message = fr.asString();
        String encrypted = encrypt(message, key);
        System.out.println(encrypted);
        String decrypted = encrypt(encrypted, 26-key);
        System.out.println(decrypted);
    }

    public boolean isEvenNumber(int number){
        return (number % 2 == 0);
    }

    public String encryptTwoKeys(String input, int key1, int key2){
        // make a StringBuilder (encrypted) with input message
        StringBuilder encrypted = new StringBuilder(input);
        // write down the alphabet
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        // Compute the shifted alphabet
        String shiftedAlphabet = alphabet.substring(key1) + alphabet.substring(0, key1);

        String shiftedAlphabetTwo = alphabet.substring(key2) + alphabet.substring(0, key2);

        // Count from 0 to < length of encrypted, (call it i)
        for(int i = 0; i < encrypted.length(); i++){
            // create a \/ holder for a character from input we want to modify 
            char currChar = encrypted.charAt(i);
            // check for index odd or even number
            if(isEvenNumber(i)){

                if (Character.isLowerCase(currChar)){
                    //convert currChar to upperCase first
                    currChar = Character.toUpperCase(currChar);
                    int idx = alphabet.indexOf(currChar);
                    if(idx != -1){
                        char newChar = shiftedAlphabet.charAt(idx);
                        newChar = Character.toLowerCase(newChar);
                        encrypted.setCharAt(i, newChar);
                    }

                }else{
                    int idx = alphabet.indexOf(currChar);
                    if(idx != -1){
                        char newChar = shiftedAlphabet.charAt(idx);
                        encrypted.setCharAt(i, newChar);
                    }
                }
            }
            else {
                if (Character.isLowerCase(currChar)){
                    //convert currChar to upperCase first
                    currChar = Character.toUpperCase(currChar);
                    int idx = alphabet.indexOf(currChar);
                    if(idx != -1){
                        char newChar = shiftedAlphabetTwo.charAt(idx);
                        newChar = Character.toLowerCase(newChar);
                        encrypted.setCharAt(i, newChar);
                    }

                }else{
                    int idx = alphabet.indexOf(currChar);
                    if(idx != -1){
                        char newChar = shiftedAlphabetTwo.charAt(idx);
                        encrypted.setCharAt(i, newChar);
                    }
                }
            }
        }
        System.out.println(encrypted.toString());
        return encrypted.toString();
    }

}
