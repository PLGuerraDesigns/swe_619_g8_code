package assignment_8;

import java.util.ArrayList;
import java.util.List;

/* 1) Modify it into a fully generic implementation (no compiler warnings).
 * This was done by replacing Object type with Generic type in lines 6, 38, and 48

 * 2) Replace the array with a List (doing so will eliminate the need for many of the instance variables).
 * This was done by creating a List of Generics wherever there was an array. The put() and get() functions had to be updated
   to match ArrayList functions

 * 3) Change the behavior of the methods to include exception handling for all cases not on the happy path.
 * 
 */
public class BoundedQueue<T> {

    protected List<T> rep;
    protected int front = 0;
    protected int back = -1;
    protected int size = 0;
    protected int count = 0;

    public BoundedQueue(int size) {
        if (size > 0) {
            this.size = size;
            rep = new ArrayList<T>(size);
            back = size - 1;
        }
    }

    public boolean isEmpty() {
        return (count == 0);
    }

    public boolean isFull() {
        return (count == size);
    }

    public int getCount() {
        return count;
    }

    public int getSize() {
        return size;
    }

    public void put(T e) {
        if (e != null && !isFull()) {
            back++;
            if (back >= size)
                back = 0;
            rep.add(e);
            count++;
        }
    }

    public T get() {
        T result = null;
        if (!isEmpty()) {
            result = rep.get(front);
            rep.set(front, null);
            // exception handling
            front++;
            if (front >= size)
                front = 0;
            count--;
        }
        return result;
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
    }
}
