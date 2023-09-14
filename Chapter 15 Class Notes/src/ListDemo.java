import java.util.LinkedList;
import java.util.ListIterator;

/**
 * This program demonstrates the LinkedList class
 * and ListIterator class.
*/
public class ListDemo
{
    public static void main(String[] args)
    {
        //The addLast and add method can be used to populate a linked list
        LinkedList<String> staff = new LinkedList<>();
        staff.addLast("Diana");
        staff.addLast("Harry");
        staff.addLast("Romeo");
        staff.addLast("Tom");
        //The list currently: DHRT

        //The list iterator method creates a new list iterator that is positioned at the head of the list, | represents the iterator
        ListIterator<String> iterator = staff.listIterator(); // |DHRT

        //The next method advances the iterator to the next element in the list
        iterator.next(); // D|HRT

        //The next method also returns the element that the iterator is passing
        String name = iterator.next(); // DH|RT
        System.out.println(name); 
        System.out.println("Expected: Harry"); 

        //The add method for iterators inserts an element at the iterators position, the iterator is then positioned after the element that was added
        iterator.add("Juliet"); // DHJ|RT
        iterator.add("Nina"); // DHJN|RT

        //The iterator remove method removes the element, returned to the last call to next or previous, 
        //the remove method can only be called once after calling next or previous, cant be called after calling add
        iterator.next(); // DHJNR|T
        iterator.remove(); // DHJN|T
        System.out.println(staff);
        System.out.println("Expected: [Diana, Harry, Juliet, Nina, Tom]");

        //The iterator set method updates the element returned by the last call to next or previous
        iterator.previous(); // DHJ|NT
        iterator.set("Albert"); // DHJ|AT
        System.out.println(staff);
        System.out.println("Expected: [Diana, Harry, Juliet, ALbert, Tom]");

        //The hasNext method returns true if the list has another element, often used in the condition of a while loop
        iterator = staff.listIterator();// |DHJAT
        while(iterator.hasNext()){
            String n = iterator.next();
            if(n.equals("Juliet")) // DHJ|AT
                iterator.remove(); // DH|AT
        } // DHAT|

        //Enhanced for loops work with linked lists
        for(String n : staff){
            System.out.print(n+" ");
        }
        System.out.println("\nExpected: Diana Harry Albert Tom");

        //Concurrent modification exception, can't modify the list while iterating through it, unless you use the iterator to do it
        iterator = staff.listIterator();
        while(iterator.hasNext()){
            String n = iterator.next();
            if(n.equals("Harry")){
                //staff.remove("Diana");
            }
        }
    }
}
