import java.util.LinkedList;
import java.util.Queue;

/**
 * This program simulates a print queue. Note that documents are printed
 * in the same order as they are submitted.
*/
public class QueueDemo
{
    public static void main(String[] args)
    {
        //Create a print queue of strings (using a linked list)
        Queue<String> jobs = new LinkedList<>();

        //add some print jobs
        jobs.add("Joe: Mama's delicious recipes");
        jobs.add("Cathy: Top Secret Document");

        System.out.println("Printing: "+jobs.remove());

        jobs.add("Cathy: Top Secret-er Document");
        jobs.add("Joe: Grocery List");
        jobs.add("Cathy: Secret Agent Stuff");

        System.out.println("Printing: "+jobs.remove());

        jobs.add("Boss: Hit List For Cathy");

        //Print the rest of the jobs in the queue
        //System.out.println(jobs);
        while (jobs.size()>0){
            String job = jobs.remove();
            System.out.println("Printing: "+jobs.remove());
        }
    }
}
