import java.util.Scanner;
import java.util.Stack;

/**
 * Class for reversing the order of a sentence.
*/
public class SentenceReverser
{
    /**
     * Reverses the given sentence.
     *
     * @param sentence Sentence to be reversed.
     * @return reversed sentence.
    */
    public static String reverse(String sentence)
    {
    	Scanner scanner = new Scanner(sentence);
    	
        // Complete this method. Use a Stack.
        Stack<String> words = new Stack<>();
        String newsentence1 = "";
        String newsentence2 = "";
            
        
        while (scanner.hasNext()){
            String word = scanner.next();
            if(word.contains(".")){
                word = word.substring(0,word.length()-1);
                words.push(word);
            }
            else
                words.push(word);

        }
        
        for (int i = 0; i < words.size() ; i++){
            String word = words.pop();
            newsentence2 += " "+word;
        }
        newsentence2 += ".";
        for (int i = 0; i < words.size()+4 ; i++){
            String word = words.pop();
            newsentence1 += " "+word;
        }
        newsentence1 += ".";
        
        return newsentence1+newsentence2;






    }
}
