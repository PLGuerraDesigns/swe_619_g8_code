import java.util.*;
/*
 * Liskov's IntSet example (called LiskovSet), with minor changes
 * This version doesn't include AF or RI
 */

public class MaxIntSet_05A extends IntSet {
    private int biggest; // biggest element of set if not empty

    public MaxIntSet_05A() {
        super();
    } // Why call super() ???

    public void insert(int x) {
        System.out.println("MaxIntSet.insert()");
        if (size() == 0 || x > biggest)
            biggest = x;
        super.insert(x);
        if (repOk() == false) {
            System.out.println("repOK=false in MaxIntSet.insert()");
            new Throwable().printStackTrace();
            System.exit(-1);
        }

    }

    public int max() throws Exception {
        if (size() == 0)
            throw new Exception("MaxIS.max");
        return biggest;
    }

    public void remove(int x) {
        System.out.println("MaxIntSet.remove()");
        super.remove(x);
        if (size() == 0 || x < biggest)
            return;

        Iterator g = elements().iterator(); // find the new biggest
        biggest = ((Integer) g.next()).intValue();
        while (g.hasNext()) {
            int z = ((Integer) g.next()).intValue();
            if (z > biggest)
                biggest = z;
        }
        if (repOk() == false) {
            System.out.println("repOK=false in MaxIntSet.remove()");
            new Throwable().printStackTrace();
            System.exit(-1);
        }
    }

    public boolean repOk() {
        System.out.println("MaxIntSet.repOk()");
        if (!super.repOk())
            return false; // all ints, no duplicates
        if (size() == 0)
            return true;
        boolean found = false;
        Iterator g = elements().iterator(); // biggest is actually the max
        while (g.hasNext()) {
            int z = ((Integer) g.next()).intValue();
            if (z > biggest)
                return false;
            if (z == biggest)
                found = true;
        }
        System.out.println("biggest = " + biggest);
        return found;
    }

    public String toString() {
        return elements().toString() + " biggest = " + biggest;
    }

    public static void main(String args[]) {
        MaxIntSet_05A s = new MaxIntSet_05A();
        System.out.println(s);

        System.out.println();
        System.out.println("s.insert(3)");
        s.insert(3);
        System.out.println(s);

        System.out.println();
        System.out.println("s.insert(5)");
        s.insert(5);
        System.out.println(s);

        System.out.println();
        System.out.println("s.remove(5)");
        s.remove(5);
        System.out.println(s);
    }

}