package assignment_8;

import java.util.ArrayList;
import java.util.List;

/* 1) Modify it into a fully generic implementation (no compiler warnings).
   This was done by replacing Object type with Generic type in lines 6, 38, and 48

 * 2) Replace the array with a List (doing so will eliminate the need for many of the instance variables).
   This was done by creating a List of Generics wherever there was an array. The put() and get() functions had to be updated
   to match ArrayList functions. We were only able to remove back as an instance variable

 * 3) Change the behavior of the methods to include exception handling for all cases not on the happy path.
   This was done by throwing exceptions on lines 26, 50, 53, and 62

 * 4) Document the methods with Javadocs and preconditions/postconditions (provide both).
 
 * 5) Add two new methods: putAll() and getAll(). Define the method signatures carefully. Use exception-handling consistent 
   with that for get() and put(). Use bounded wildcards as appropriate. Note that putAll() has a special case where there isn't 
   sufficient space in the bounded queue. (For this part, Bloch5-Item31 might be helpful).
   Implementation beginning on Line 159. For putAll(), we did not find it necessary to use Bounded Wildcards
 * 
 */
public class BoundedQueue<T> {

    protected List<T> rep;
    protected int count = 0;
    protected int initializedSize = 0;
    protected int front = 0;

    /**
     * 
     * Creates the BoundedQueue object
     * 
     * @param size Capacity of the BoundedQueue object
     * 
     *             PRECONDITION: size is not null
     *             POSTCONDITION:
     *             IllegalArgumentException if size <=0
     *             else, BoundedQueue object with capacity size is created
     * 
     */
    public BoundedQueue(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("List initialization size must be greater than zero");
        }
        rep = new ArrayList<T>(size);
        initializedSize = size;
    }

    /**
     * 
     * Checks if the BoundedQueue object is empty
     * 
     * PRECONDITION: none
     * POSTCONDITION: returns boolean stating if List rep is empty
     * 
     */
    public boolean isEmpty() {
        return (count == 0);
    }

    /**
     * 
     * Checks if the BoundedQueue object is full
     * 
     * PRECONDITION: none
     * POSTCONDITION: returns boolean stating if List rep is full
     * 
     */
    public boolean isFull() {
        return (count == initializedSize);
    }

    /**
     * 
     * Returns an integer describing the number of elements inside the
     * List rep.
     * 
     * PRECONDITION: none
     * POSTCONDITION: returns integer describing the number of elements inside the
     * List rep
     * 
     */
    public int getCount() {
        return count;
    }

    /**
     * 
     * Returns an integer describing the overall size of the List rep.
     * 
     * PRECONDITION: none
     * POSTCONDITION: returns integer describing the overall size of the List rep
     * 
     */
    public int getSize() {
        return initializedSize;
    }

    /**
     * 
     * Adds an user-specified element to the BoundedQueue
     * 
     * @param e Object to add to BoundedQueue
     * 
     *          PRECONDITION: Input is of same type as List elements.
     *          POSTCONDITION:
     *          IllegalArgumentException if e is null
     *          ArrayIndexOutOfBoundsException if List rep is full
     * 
     */
    public void put(T e) {
        if (e == null) {
            throw new IllegalArgumentException("Element is null");
        }
        if (isFull()) {
            throw new ArrayIndexOutOfBoundsException("List is full");
        }
        rep.add(e);
        count++;
    }

    /**
     * 
     * Returns first element in Queue
     * 
     * PRECONDITION: none
     * POSTCONDITION:
     * ArrayIndexOutOfBoundsException if List is empty
     * First element in Queue (element at index front in List rep)
     * 
     */
    public T get() {
        T result = null;
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("List is empty");
        }
        result = rep.get(front);
        rep.set(front, null);
        front++;
        if (front >= initializedSize)
            front = 0;
        count--;
        return result;
    }

    /**
     * 
     * Inserts an ArrayList of items into the BoundedQueue
     * 
     * @param arrayList ArrayList of items to be inserted into BoundedQueue
     * 
     *                  PRECONDITION: none
     *                  POSTCONDITION:
     *                  ArrayIndexOutOfBoundsException if List is empty
     *                  First element in Queue (element at index front in List rep)
     * 
     */
    public void putAll(List<? extends T> arrayList) {
        if (initializedSize - count >= arrayList.size()) {
            for (T element : arrayList) {
                put(element);
            }
        } else {
            int emptySpace = initializedSize - count;
            int remainder = arrayList.size() - emptySpace;

            List<T> repCopy = new ArrayList<T>(getSize());
            for (T element : rep) {
                if (element != null) {
                    repCopy.add(element);
                }
            }

            rep = new ArrayList<T>(remainder + initializedSize);
            for (T element : repCopy) {
                rep.add(element);
            }
            for (T element : arrayList) {
                rep.add(element);
            }
        }

    }

    /**
     * 
     * Returns all elements in BoundedQueue
     * 
     * PRECONDITION: none
     * POSTCONDITION:
     * ArrayIndexOutOfBoundsException if List is empty
     * else, return a deep copy of the List rep
     * 
     * 
     */
    public List<T> getAll() {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("List is empty");
        }
        List<T> repCopy = new ArrayList<T>(getSize());

        while (!isEmpty()) {
            repCopy.add(this.get());
        }
        return repCopy;
    }

    public static void main(String args[]) {
        BoundedQueue queue = new BoundedQueue(10);

        for (int i = 0; !queue.isFull(); i++) {
            queue.put(new Integer(i));
            System.out.println("put: " + i);
        }

        while (!queue.isEmpty()) {
            System.out.println("get: " + queue.get());
        }

        // GET ALL TEST;
        BoundedQueue queueGetAll = new BoundedQueue(10);
        for (int i = 0; !queueGetAll.isFull(); i++) {
            queueGetAll.put(new Integer(i));
            System.out.println("put: " + i);
        }
        List allQueueList = queueGetAll.getAll();

        // PUT ALL TESTS
        BoundedQueue newQueue = new BoundedQueue(20);
        newQueue.putAll(allQueueList);
    }
}
