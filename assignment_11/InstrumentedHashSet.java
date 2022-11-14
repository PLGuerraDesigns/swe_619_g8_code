import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class InstrumentedHashSet<E> extends HashSet<E>{
    private int addCount = 0;	
    public InstrumentedHashSet() {}
 
    @Override public boolean add(E e){ 
       addCount++; 
       return super.add(e); 
    }
    @Override public boolean addAll(Collection<? extends E> c){ 
        // What to do with addCount?
        return super.addAll(c); 
    }
    public int getAddCount(){ return addCount; }
 }





 /*
 1)  How do you think the addCount variable should be updated in the addAll() method in InstrumentedHashSet?


2) What does the answer say about inheritance?


2) Does equals() behave correctly in InstrumentedHashSet?


4) Given your previous answer, what is the value of sh.addCount at the end of the computation?


5) Consider the InstrumentedSet solution. Besides being correct why is it more general than the InstrumentedHashSet solution?


6) At the end of the computation, what are the values of: r, s, and t?


7) What would a call to s.getAddCount() return at the end of the computation?


8) At the end of the computation, what are the values of: r.equals(s), s.equals(t), and t.equals(s)?


9) Are there any problems with the equals() contract?


10) Would this still work if you globally replaced sets with lists?


11) Would this still work if you globally replaced sets with collections?

*/