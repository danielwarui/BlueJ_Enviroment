
/**
 * Write a description of PrimeNumberGenerator here.
 * 
 * @author Warui Daniel
 * @version My custom prime number generator
 */
import java.io.*;

public class PrimeNumberGenerator {
    public void findPrimeNumbers(){
        String file_path = "prime_numbers_to_billion.txt";
        try{
            PrintWriter writer = new PrintWriter(file_path, "UTF-8");
            // PRINT PRIME NUMBERS ONE TO A BILLION
            for(int i = 1; i < 1000000000; i++){
                if(isPrime(i)){
                    writer.println("-->"+ i);
                }
            }
            writer.close();
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    public boolean isPrime(int num){
        int div = 2;
        if(num == 2){
            return true;
        }
        while(true){
            if(num % div == 0){
                return false;
            }
            if(div > Math.sqrt(num)){
                break;
            }
            div += 1;
        }
        return true;

    }
}
