import java.util.*;

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

}