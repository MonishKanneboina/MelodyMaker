import java.util.LinkedList;
import java.util.*;

public class Melody
   {
      private Queue<Note> notes;
      
      public Melody(Queue<Note> song)
            {
               notes = song;
            }
         
      public Queue<Note> getNotes()
            {
               return notes;
            }
         
      public String toString()
            {
               String s = "";
               for (int i = 0; i < notes.size(); i++)
                  {
                     Note n = notes.poll();
                     s = "" + n.toString() + "/n";
                     notes.offer(n);
                  }
               return s;
            }
         
       public double getTotalDuration()
            {
               Queue<Note> repeatedQ = new LinkedList<Note>();
               double total = 0.0;
               boolean isRepeat = false;
               for (int i = 0; i < notes.size(); i++)
                  {
                     Note n = notes.poll();
                     total += n.getDuration();
                     notes.offer(n);
                     if(n.isRepeat() == true)
                        {
                           if(isRepeat == true)
                              {
                                 isRepeat = false;
                              }
                           else
                              {
                                 isRepeat = true;
                              }
                        }
                     if (isRepeat == true || n.isRepeat() == true)
                        {
                           repeatedQ.offer(n);
                        }
                     if (isRepeat == false)
                        {
                           if (n.isRepeat() == true)
                              {
                                 while (!repeatedQ.isEmpty())
                                   {
                                       total += repeatedQ.poll().getDuration();
                                   }
                                 repeatedQ = new LinkedList<Note>();
                              }
                        }     
                  }
               return total;
            }
         
       public void changeTempo(double factor)
            {
               for (int i = 0; i < notes.size(); i++)
                  {
                     Note n = notes.poll();
                     double tempo = n.getDuration();
                     double changedTempo = tempo*factor;
                     n.setDuration(changedTempo);
                     notes.offer(n);
                  }
            }
         
        public void reverse()
            {
               Stack<Note> reverse = new Stack<>();
               
               while(!notes.isEmpty())
                  {
                     reverse.push(notes.poll());
                  }
               
               while(!reverse.isEmpty())
                  {
                     notes.offer(reverse.pop()); 
                  }
            }
         
        public void append(Melody other)
            {
               Queue<Note> combine = new LinkedList<Note>();
               
               while(!this.notes.isEmpty())
                  {
                     combine.offer(this.notes.poll());
                  }
                  
               for (int i = 0; i < other.notes.size(); i++)
                  {
                     Note n = other.notes.poll();
                     combine.offer(n);
                     other.notes.offer(n);
                  }
                  
                notes = combine;
            }
         
        public void play()
            {  
               Queue<Note> repeatedQ = new LinkedList<Note>();
               boolean isRepeat = false;
               for (int i = 0; i < notes.size(); i++)
                  {
                     Note n = notes.poll();
                     n.play();
                     notes.offer(n);
                     if(n.isRepeat() == true)
                        {
                           if(isRepeat == true)
                              {
                                 isRepeat = false;
                              }
                           else
                              {
                                 isRepeat = true;
                              }
                        }
                     if (isRepeat == true || n.isRepeat() == true)
                        {
                           repeatedQ.offer(n);
                        }
                     if (isRepeat == false)
                        {
                           if (n.isRepeat() == true)
                              {
                                 while (!repeatedQ.isEmpty())
                                   {
                                       repeatedQ.poll().play();
                                   }
                                 repeatedQ = new LinkedList<Note>();
                              }
                        }     
                  }
            }
}      