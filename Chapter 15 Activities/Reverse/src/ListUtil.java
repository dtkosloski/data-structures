import java.util.LinkedList;
import java.util.ListIterator;

/**
 * This class supplies a utility method to reverse the entries in a linked list.
*/
public class ListUtil
{
    /**
     * Reverses the elements in a linked list
     *
     * @param strings the linked list to reverse
    */
    public static void reverse(LinkedList<String> strings)
    {
        ListIterator<String> iterator = strings.listIterator();
        int position = strings.size()-1;
        int counter = 0;
        while(iterator.hasNext()&&counter<strings.size()-1){
                String n = iterator.next();
                iterator.remove();
                for(int count = 0;count<position;count++ )
                    iterator.next();
                iterator.add(n);
                iterator = strings.listIterator();
                position--;
                counter++;
        }
    }
}