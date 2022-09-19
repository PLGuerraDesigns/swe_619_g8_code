
/**
  * Generic Queue example
  * Immutable Version
  * SWE 619-002
  * @author Paul Ammann, modified by Group 8: Pablo Guerra, Justin Yang, Katherine Soltani
  */

import java.util.*;

public class Queue_g8<E> {

    /*
    * How to make a class immutable:
    * 1. Don't provide any mutators
    * 2. Make all fields private and final
    * 3. Make the class final so it can't be extended, or make all the getters final to prevent overriding
    * 4. Use defensive copying
    */

   
    /* First, we made all the instance variables private and final */
    private final List<E> elements;
    private final int size;


    /* Next, we created three constructors: a default constructor, and a private constructor that would be used for
     * creating defensive copies
     */
    private Queue_g8() {
        this.elements = new ArrayList<E>();
        this.size = 0;
    }

    private Queue_g8(E e, List<E> elements) {
        if (e != null)
            elements.add(e);
        this.elements = elements;
        this.size = elements.size();
    }

    /* This method is used to add elements to a defensive copy of the Queue. The new Queue is returned */
    public Queue_g8<E> enQueue(E e) {
        if (e==null){
            throw new IllegalArgumentException("Elements to be added are null");
        }
        return new Queue_g8<E>(e, this.elements);
    }

    /* This method returns the top element of the queue as a defensive copy (Observer)*/
    public final E top() {

        /* We realize this isn't actually a defensive copy, we believe that we would need to implement the 
        Clonable class for every object we want to use with this queue. However, since we're using java generics, 
        the scope may be too large without knowing what specific classes would be used. */

        E copy = this.elements.get(0); 
        return copy;
    }

    /* This method dequeues from the queue, returning it as a defensive copy (Producer) */
    public Queue_g8<E> deQueue() {
        if (size == 0)
            throw new IllegalStateException("Queue.deQueue");
        return new Queue_g8<E>(null, this.elements.subList(1, this.size));
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        // Simple exercise to enQueue/deQueue cmd line args
        // Usage: java Queue item1 item2 item3 ...

        Queue_g8<String> q = new Queue_g8<String>();

        //Add elements to the Queue
        for (String arg : args) {
            q = q.enQueue(arg);
        }
        
        //For dequeue-ing, the top element is printed, then the dequeued queue is reassigned to the q variable
        while (!q.isEmpty()) {
            //Observer
            System.out.println(q.top());
            //Producer
            q = q.deQueue();
        }
    }

}