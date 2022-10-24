package assignment_8;

public class BoundedQueue {

    protected Object rep[];
    protected int front = 0;
    protected int back = -1;
    protected int size = 0;
    protected int count = 0;

    public BoundedQueue(int size) {
        if (size > 0) {
            this.size = size;
            rep = new Object[size];
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

    public void put(Object e) {
        if (e != null && !isFull()) {
            back++;
            if (back >= size)
                back = 0;
            rep[back] = e;
            count++;
        }
    }

    public Object get() {
        Object result = null;
        if (!isEmpty()) {
            result = rep[front];
            rep[front] = null;
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
