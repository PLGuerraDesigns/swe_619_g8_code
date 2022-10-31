package inclass_9;

import java.util.ArrayList;
import java.util.List;

// How should the equals() method be completed?
// Analyze the following ways to implement hashCode()? If there is a problem,
// give a test case that shows the problem.
//       not overridden at all- error: missing return statement
//       return 42:  Will give equal values for unequal values of IntSet objects (prints 42)
//       return els.hashCode(): hashCode is the same if values are the same, different if values are different
//       int sum = 0; for (Integer i : els) sum += i.hashCode(); return sum: Would potentially return equal values for unequal values of List<Integer>. Assume the following: (1).hashCode() == 5, and (6).hashCode ==10. Then the list [1,1] hashCode would be equal to the list [6] 
// What's the problem with clone() here? Give a test case that shows the problem. Does not create a deep copy of the els List object.  It would give the same reference to that object and potentially cause race conditions
// Fix clone() in two very different ways.

public class IntSet implements Cloneable {
   private List<Integer> els;

   public IntSet() {
      els = new ArrayList<Integer>();
   }

   private boolean intSetComp(IntSet first, IntSet second) {
      List<Integer> firstEls = first.getEls();
      List<Integer> secondEls = second.getEls();
      if (firstEls.size() != secondEls.size())
         return false;
      for (int i = 0; i < firstEls.size(); i++) {
         if (firstEls.get(i) != secondEls.get(i)) {
            return false;
         }
      }
      return true;
   }

   @Override
   public boolean equals(Object obj) {
      if (!(obj instanceof IntSet))
         return false;

      IntSet s = (IntSet) obj;
      return intSetComp(this, s);
   }

   public List<Integer> getEls() {
      return this.els;
   }

   @Override
   public int hashCode() {
      // see below
      return els.hashCode();
   }

   // adding a private constructor
   private IntSet(List<Integer> list) {
      els = list;
   }

   @Override
   public IntSet clone() {
      // Method 1: Deep Copy of els
      // Method 2:
      return new IntSet(new ArrayList<Integer>(els));
   }

   public static void main(String args[]) {
      IntSet intSet = new IntSet();
      IntSet intSet2 = new IntSet();
      intSet.els.add(1);
      intSet.els.add(2);
      intSet.els.add(3);

      intSet2.els.add(1);
      intSet2.els.add(2);

      System.out.println(intSet.equals(intSet2));
      intSet2.els.add(3);
      System.out.println(intSet.equals(intSet2));

      System.out.println(intSet.hashCode());
      System.out.println(intSet2.hashCode());

   }
}
