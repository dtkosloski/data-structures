/**
 *   A program that demonstrates the LinkedList class
 */
public class ListDemo
{
    public static void main(String[] args)
    {
        LinkedList students = new LinkedList();
        students.addFirst("Joe");
        students.addFirst("Jim");
        students.addFirst("Jack");
        students.addFirst("John");
        students.addFirst("Jake");
        System.out.println(students);

        ListIterator iterator = students.listIterator();
        iterator.next();
        iterator.next();
        iterator.next();
        iterator.add("Devon");
        System.out.println(students);
        iterator.next();
        iterator.remove();
        System.out.println(students);    
    }
}
