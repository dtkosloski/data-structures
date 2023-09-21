import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * This program checks which words in a file are not present in a dictionary.
*/
public class WordAnalysis
{
    public static void main(String[] args)
        throws FileNotFoundException
    {
        Set<String> dictionaryWords = readWords("Chapter 15 Class Notes/src/words");
        Set<String> novelWords = readWords("Chapter 15 Class Notes/src/throughTheLookingGlass.txt");

        //Print all the words from the novel not in the dictionary
        for(String word: novelWords){
            if(!dictionaryWords.contains(word));
            System.out.println(word);
        }

        //count out how many unique words are in the novel
        System.out.println("There are "+novelWords.size()+" unique words in the novel.");

        //number of unique words with more than 3 letters
        Iterator<String> iterator = novelWords.iterator();
        while(iterator.hasNext()){
            if(iterator.next().length()<=3){
                iterator.remove();
            }
        }
        System.out.println("There are "+novelWords.size()+" unique words in the novel with more than 3 letters.");

    }

    /**
     * Reads all words from a file.
     *
     * @param filename the name of the file
     * @return a set with all lowercased words in the file. Here, a
     * word is a sequence of upper- and lowercase letters.
    */
    public static Set<String> readWords(String filename)
        throws FileNotFoundException
    {
        Set<String> words = new HashSet<>();
        //System.out.println(System.getProperty(key:"user.dir"));
        Scanner in = new Scanner(new File(filename), "UTF-8");

        //use any character other than letters as delimiter
        in.useDelimiter("[^a-zA-Z]+");

        //adding words to our set (ignores dupes)
        while(in.hasNext()){
            words.add(in.next().toLowerCase());
        }

        return words;
    }
}
