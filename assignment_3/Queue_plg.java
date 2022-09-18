
import java.util.*;

public class Queue_plg<E> {

    private final List<E> elements;
    private final int size;

    private Queue_plg() {
        this.elements = new ArrayList<E>();
        this.size = 0;
    }

    private Queue_plg(E e, List<E> elements) {
        if (e != null)
            elements.add(e);
        this.elements = elements;
        this.size = elements.size();
    }

    public Queue_plg<E> enQueue(E e) {
        return new Queue_plg<E>(e, this.elements);
    }

    public E top() {
        return this.elements.get(0);
    }

    public Queue_plg<E> deQueue() {
        if (size == 0)
            throw new IllegalStateException("Queue.deQueue");
        return new Queue_plg<E>(null, this.elements.subList(1, this.size));
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        // Simple exercise to enQueue/deQueue cmd line args
        // Usage: java Queue item1 item2 item3 ...

        Queue_plg<String> q = new Queue_plg<String>();

        // for (String arg : args)
        // q.enQueue(arg);
        for (String arg : args) {
            q = q.enQueue(arg);
        }

        // while (!q.isEmpty())
        // System.out.println(q.deQueue());
        while (!q.isEmpty()) {
            System.out.println(q.top());
            q = q.deQueue();
        }
    }

}