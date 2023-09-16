import java.util.LinkedList;
import java.util.*;


public class QueueProbs
   {
      public Queue<Integer> evenFirst(Queue<Integer> nums)
         {
            Queue<Integer> myEvens = new LinkedList<Integer>();
            
            for (int i = nums.size() - 1; i >= 0; i--)
               {
               
                  //while loops?
                  int currentNum = nums.peek();
                  if (currentNum % 2 == 0)
                     {
                        myEvens.offer(nums.poll());
                     }
                  else
                     {
                        nums.offer(nums.poll());
                     }  
                    
               }
            Queue<Integer> sortedEvens = new LinkedList<Integer>();
            
            while(!myEvens.isEmpty())
               {
                  sortedEvens.offer(myEvens.poll());
               }
            
            while(!nums.isEmpty())
               {
                  sortedEvens.offer(nums.poll());
               }  
                
            return sortedEvens; //return old queue?     
         }
         
      public Stack<Integer> getPrimes(int n)
         {
            Queue<Integer> twoToN = new LinkedList<Integer>();
            Stack<Integer> stack = new Stack<>();
            
            for(int i = 2; i <= n; i++)
               {
                  twoToN.offer(i);
               }
               
            int qSize = 0;
            stack.push(twoToN.poll());
            while(!twoToN.isEmpty())
               {
                  qSize = twoToN.size();
                  for(int i = 0; i < qSize; i++)
                     {
                        if(twoToN.peek() % stack.peek() == 0)
                           {
                              twoToN.poll();
                           }
                        else
                           {
                               twoToN.offer(twoToN.poll());
                           }
                     }
                     stack.push(twoToN.poll());
               }
               
              return stack;
         }
   }