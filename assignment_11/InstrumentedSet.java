package assignment_11;

public class InstrumentedSet<E> extends ForwardingSet<E>{
    private int addCount = 0;	
 
    public InstrumentedSet(Set<E> s){ super(s); }
    @Override public boolean add(E e){ addCount++; return super.add(e); }
    public int getAddCount(){ return addCount; }
 }