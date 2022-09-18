
import java.util.*;

public class Queue<E> {

    private final List<E> elements;
    private final int size;

    private Queue() {
        this.elements = new ArrayList<E>();
        this.size = 0;
    }

    private Queue(E e, List<E> elements) {
        if (e != null)
            elements.add(e);
        this.elements = elements;
        this.size = elements.size();
    }

    public Queue<E> enQueue(E e) {
        return new Queue<E>(e, this.elements);
    }

    public E top() {
        return this.elements.get(0);
    }

    public Queue<E> deQueue() {
        if (size == 0)
            throw new IllegalStateException("Queue.deQueue");
        return new Queue<E>(null, this.elements.subList(1, this.size));
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        // Simple exercise to enQueue/deQueue cmd line args
        // Usage: java Queue item1 item2 item3 ...

        Queue<String> q = new Queue<String>();

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