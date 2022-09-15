/**
  * Generic Queue example
  * Immutable Version
  * SWE 619-002
  * @author Paul Ammann, modified by Group 8: Katherine Soltani, Justin Yang, Pablo Guerra
  */

import java.util.*;

public class Queue <E> {

    /*
     * How to make a class immutable
     * 1. Don't provide any mutators
     * 2. Make all fields private and final
     * 3. Make the class final so it can't be extended, or make all the getters final to prevent overriding
     * 4. Use defensive copying
     * 
     */

    /*
     * Step 2: Make all fields private and final
     */
   private final List<E> elements;
   private final int size;
   //thought about defensive copying
        //1. should the copy be an instance variable? bc if we have to enqueue multiple times...
        //2. should we make an accessor that copies the current arraylist and then adds to that (seems like prof wants this one?)
   private List<E> elementsCopy; 

   public Queue() {   
      this.elements = new ArrayList<E>();
      this.size=0;
      for(int i=0; i<this.size; i++){
        elementsCopy.add(elements.get(i));
      }
   }

   /*
    * Steps 1, 3, and 4: Split enQueue method into an observer and producer. This gets rid of the mutator.
    * The observer/getter will be made final to prevent overriding, and defensive copying will be used to 
    * ensure that changes are only made to the copy
    */
   public void enQueue (E e) {

    //make a copy of the existing Queue with getQueue()
    queueCopy=getQueue();

    //add to the copy of the Queue and return the copy
     queueCopy.elements.add(e);
     queueCopy.size++;
   }

   public E deQueue () {
     if (size == 0) throw new IllegalStateException("Queue.deQueue");
     E result = elements.get(0);
     elements.remove(0);
     size--;
     return result;
   }

   public boolean isEmpty() {
      return size == 0;
   }

   /*
    * Step 3: Make Observer/Accessor/Getter final to prevent modifications. Use defensive copying to protect original
    */
   public final Queue<E> getQueue(){
    Queue <E> copy = new Queue<E>(this.clone());
    return copy;
   }
   

  public static void main(String[] args) {
     // Simple exercise to enQueue/deQueue cmd line args
     // Usage:  java Queue item1 item2 item3 ...
     Queue <String> q = new Queue <String>();
     for (String arg : args)
        q.enQueue(arg);
     while (!q.isEmpty() )
        System.out.println(q.deQueue());

  }

}