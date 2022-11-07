package inclass_9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

// 1. How should the equals() method be completed? 
//       * Completed below (line 40)
// 2. Analyze the following ways to implement hashCode()? If there is a problem, give a test case that shows the problem.
//       * Completed below (line 107)
// 3. What's the problem with clone() here? Give a test case that shows the problem. 
//       * See line 155
// 4. Fix clone() in two very different ways.
//       * Completed below

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

   // @Override
   // public int hashCode() {
   // 2. a)
   // see below

   // 2. b)
   // return 42;

   // 2. c)
   // return els.hashCode();

   // 2. d)
   // int sum = 0;
   // for (Integer i : els)
   // sum += i.hashCode();
   // return sum;
   // }

   // adding a private constructor
   private IntSet(List<Integer> list) {
      els = list;
   }

   @Override
   public IntSet clone() {
      // Original clone method body: 
      // return new IntSet(new ArrayList<Integer>(els));

      // 1. This approach uses the copy constructor of the IntSet to build the object. It also uses a clone of the els List so 
      //    that it's not referencing the same List in memory
      return new IntSet(els.clone());

      // 2. Uses the super class's clone method to return a deep copy of the parent class variables, uses the clone method for the 
      //    variable component unique to IntSet.
      try {
         IntSet newSet = (IntSet) super.clone();
         newSet.els = els.clone();
         return newSet;
      } catch (CloneNotSupportedException e) {
         throw new AssertionError();
      }
   }

   @Override
   public String toString() {
      String retString = "";
      for (Integer x : this.els) {
         retString = retString + x.toString() + ", ";
      }
      return retString;
   }

   public static void main(String args[]) {
      // 2. a) not overridden at all
      IntSet intSet2a = new IntSet();
      intSet2a.els.add(1);
      intSet2a.els.add(2);
      IntSet intSet2a2 = new IntSet();
      intSet2a2.els.add(1);
      intSet2a2.els.add(2);
      System.out.print("2. a) Expecting true as correct value: ");
      System.out.println((intSet2a.hashCode()) == (intSet2a2.hashCode()));
      // Since hashCode() is not overridden within IntSet, it defaults to the
      // hashCode()
      // of the parent class, Cloneable. The hashCode() in Cloneable is comparing the
      // hashes of the reference of each IntSet object rather than the values, which
      // is
      // why it returns different hash codes for two objects with the same values.

      // 2. b) return 42
      IntSet intSet2b = new IntSet();
      intSet2b.els.add(1);
      IntSet intSet2b2 = new IntSet();
      intSet2b2.els.add(2);
      System.out.print("2. b) Expecting false as correct value: ");
      System.out.println((intSet2b.hashCode()) == (intSet2b2.hashCode()));
      // returns equal hashCode values for intSets with different List elements

      // 2. c) return els.hashCode
      IntSet intSet2c = new IntSet();
      intSet2c.els.add(1);
      intSet2c.els.add(2);
      IntSet intSet2c2 = new IntSet();
      intSet2c2.els.add(3);
      System.out.print("2. c) Expecting false as correct value: ");
      System.out.println((intSet2c.hashCode()) == (intSet2c2.hashCode()));
      // expected false because the two IntSets contain different values, but returned
      // true

      // 2. d) int sum = 0; for (Integer i : els) sum += i.hashCode(); return sum
      IntSet intSet2d = new IntSet();
      intSet2d.els.add(1);
      intSet2d.els.add(2);
      IntSet intSet2d2 = new IntSet();
      intSet2d2.els.add(5);
      intSet2d2.els.add(-2);
      System.out.print("2. d) Expecting false as correct value: ");
      System.out.println((intSet2d.hashCode()) == (intSet2d2.hashCode()));
      // expected false because the two IntSets contain different values, but returned
      // true

      // 3. What's the problem with clone() here? Give a test case that shows the
      // problem.
      List<Integer> linkList = new LinkedList<Integer>(Arrays.asList(1, 2, 3));
      IntSet intSetOrig = new IntSet(linkList);
      IntSet intSetClone = intSetOrig.clone();
      ((LinkedList<Integer>) intSetClone.getEls()).pop();
      // If a client uses different List than an ArrayList, for example a LinkedList,
      // and then uses a function
      // specific to the that different List type, then an error will occur. This is
      // because the implementation of clone()
      // types the List as an ArrayList as it uses the copy constructor without regard
      // to the type in use by the client.
   }
}
