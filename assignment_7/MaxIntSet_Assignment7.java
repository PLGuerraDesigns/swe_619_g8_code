import java.util.*;
/*
 * Liskov's IntSet example (called LiskovSet), with minor changes
 * This version doesn't include AF or RI
 */

// Download MaxIntSet_Assignment7.java
// Run it
// TODO: Provide a "detailed/convincing" explanation why repOK() is failing
/* In the MaxIntSet, element 5 is the biggest element. When 5 is removed from the MaxIntSet, super.remove() is called and repOk
is checked before the biggest element is reassigned. Therefore, when repOk() is called in MaxIntSet, the biggest value has already been
removed from the set so the boolean found is never set to true.

*/

class IntSet {

    // Overview: LiskovSets are unbounded, mutable sets of integers
    private List<Integer> els; // the rep

    // constructor
    // EFFECTS: Intitializes this to be empty
    public IntSet() {
        els = new ArrayList<Integer>();
    }

    // methods
    // MODIFIES this
    // EFFECTS: Adds x to the elements of this
    public void insert(int x) {
        System.out.println("IntSet.insert()");
        if (els.indexOf(x) < 0) // could also self-use isIn()
            els.add(x);
        if (repOk() == false) {
            System.out.println("repOK=false in IntSet.insert()");
            new Throwable().printStackTrace();
            System.exit(-1);
        }
    }

    protected List elements() {
        return els;
    }

    // MODIFIES this
    // EFFECTS: Removes x from this
    public void remove(int x) {
        System.out.println("IntSet.remove()");
        int index = els.indexOf(x);
        if (index < 0)
            return;
        els.set(index, els.get(els.size() - 1));
        els.remove(els.size() - 1);
        if (repOk() == false) {
            System.out.println("repOK=false in IntSet.remove()");
            new Throwable().printStackTrace();
            System.exit(-1);
        }
    }

    // EFFECTS: Returns true if x is in this else returns false
    public boolean isIn(int x) {
        return els.indexOf(x) >= 0; // could also use contains()
    }

    // EFFECTS: Returns the cardinality of this
    public int size() {
        return els.size();
    }

    // EFFECTS: If this is empty throw IllegalStateException
    // else returns an arbitrary element of this
    public int choose() {
        return els.get(els.size() - 1);
    }

    public boolean repOk() {
        System.out.println("IntSet.repOk()");
        if (els == null) {
            return false;
        }
        for (int i = 0; i < els.size(); i++) {
            Object x = els.get(i);
            if (!(x instanceof Integer)) {
                return false;
            }
            for (int j = i + 1; j < els.size(); j++)
                if (x.equals(els.get(j))) {
                    return false;
                }
        }
        return true;
    }

    public static void main(String args[]) {
        MaxIntSet_Assignment7 s = new MaxIntSet_Assignment7();
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

public class MaxIntSet_Assignment7 extends IntSet {
    private int biggest; // biggest element of set if not empty

    public MaxIntSet_Assignment7() {
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
        MaxIntSet_Assignment7 s = new MaxIntSet_Assignment7();
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