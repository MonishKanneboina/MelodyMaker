import java.util.LinkedList;
import java.util.*;

public class Runner
   {
      public static void main(String[] args)
         {
            QueueProbs qB = new QueueProbs();
         
            Queue<Integer> myQ = new LinkedList<Integer>(Arrays.asList(3, 5, 4, 17, 6, 83, 1, 84, 16, 37));
            
            System.out.println(qB.evenFirst(myQ)); 
            System.out.println(qB.getPrimes(16)); 

         }
   }  