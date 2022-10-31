package inclass_9;

public class IntSet implements Cloneable {
   private List<Integer> els;

   public IntSet() {
      els = new ArrayList<Integer>();
   }...

   @Override 
    public boolean equals(Object obj) { 
       if (!(obj instanceof IntSet)) return false;
 
       IntSet s = (IntSet) obj;
       return ???
    }

   @Override
   public int hashCode() {
      // see below
   }

   // adding a private constructor
   private IntSet(List<Integer> list) {
      els = list;
   }

   @Override
   public IntSet clone() {
      return new IntSet(new ArrayList<Integer>(els));
   }
}

// How should the equals() method be completed?
// Analyze the following ways to implement hashCode()? If there is a problem,
// give a test case that shows the problem.
// not overridden at all
// return 42;
// return els.hashCode();
// int sum = 0; for (Integer i : els) sum += i.hashCode(); return sum;
// What's the problem

// with clone() here? Give a test case that shows the problem.
// Fix clone() in two very different ways.