package src;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class InstrumentedHashSet<E> extends HashSet<E> {
    private int addCount = 0;

    public InstrumentedHashSet() {
    }

    @Override
    public boolean add(E e) {
        addCount++;
        return super.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        // What to do with addCount?
        return super.addAll(c);
    }

    public int getAddCount() {
        return addCount;
    }

    public static void main(String[] args) {
        Set<String> r = new HashSet<String>();
        r.add("ant");
        r.add("bee");

        Set<String> sh = new InstrumentedHashSet<String>();
        sh.addAll(r);

        Set<String> s = new InstrumentedSet<String>(r);
        s.add("ant");
        s.add("cat");

        Set<String> t = new InstrumentedSet<String>(s);
        t.add("dog");

        r.remove("bee");
        s.remove("ant");
        r.equals(s);
    }
}
