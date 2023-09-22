import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;


/**
 * A program that implements the sieve of Eratosthenes.
*/
public class Sieve
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Compute primes up to which integer?");
        int n = in.nextInt();
        
        System.out.println();
        Set<Integer> numbers = new HashSet<>();

        int num = 2;
        while (num <= n){
            numbers.add(num);
            num++;
        }

        for(Integer number: numbers){
            if(!(number%2 == 0 || number%3 == 0) || number == 2)
                System.out.println(number);
        }






    }
}
