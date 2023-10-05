import java.util.Stack;
import java.util.Scanner;

/**
 * Class for simulating a driveway and a street, using stacks
 * of cars with license plate numbers as representation.
*/
public class Driveway
{
    /**
      * Stack representing the cars in the driveway.
    */
    private Stack<Integer> driveway;
    /**
      * Stack representing the cars in the street.
    */
    private Stack<Integer> street;

    /**
      * Constructor.
    */
    public Driveway()
    {
        // Complete the constructor
        this.driveway = new Stack<Integer>();
        this.street = new Stack<Integer>();


    }

    /**
      * Add the given license plate to the driveway.
      *
      * @param licensePlate number of license plate.
    */
    public void add(int licensePlate)
    {
        this.driveway.push(licensePlate);


    }

    /**
      * Remove the given license plate from the driveway.
      *
      * @param licensePlate number of license plate.
    */
    public void remove(int licensePlate)
    {
        if (this.driveway.contains(licensePlate)){
          for (int i = this.driveway.size(); i > 0 && this.driveway.contains(licensePlate) ; i--){
            int num = this.driveway.pop();
            if(num == licensePlate)
              System.out.println(num+" has left the driveway");
            else{
              System.out.println(num+" has moved into the street");
              this.street.push(num);
            }
          }  
        }
        else{
          System.out.println("That car is not in the driveway");
        }
        while(this.street.size()>0){
            int car = this.street.pop();
            System.out.println(car+" has moved back into the driveway");
            this.driveway.push(car);
        }

    }

    /**
      * Prints the driveway and street details to the screen.
    */
    public void print()
    {
        System.out.println("In Driveway, starting at first in (one license plate per line):");
        // Print the cars in the driveway here
        for(int car: this.driveway){
          System.out.println(car);
        }

        System.out.println("In Street, starting at first in (one license plate per line):");
        // Print the cars in the street here
        for(int car: this.street){
          System.out.println(car);
        }

    }
}
