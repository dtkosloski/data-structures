import java.util.PriorityQueue;
import java.util.Queue;


/**
 * This program demonstrates a priority queue of to-do items. The
 * most important to-do items are removed first.
*/
public class PriorityQueueDemo
{
    public static void main(String[] args)
    {
        //Create a priority queue of to do items
        //a WorkOrder has an message ID that is used to determine priority
        //A priority queue can only store Comparable objects
        Queue<WorkOrder> toDo = new PriorityQueue<>();

        toDo.add(new WorkOrder(3,"Water plants"));
        toDo.add(new WorkOrder(2,"Make dinner"));
        toDo.add(new WorkOrder(2, "Walk dog"));
        toDo.add(new WorkOrder(9,"Play videogames"));
        toDo.add(new WorkOrder(1, "Study for exams"));

        System.out.println(toDo);//prints/adds in priority order

        while (toDo.size() > 0){
            System.out.println(toDo.remove());
        }
    }
}
