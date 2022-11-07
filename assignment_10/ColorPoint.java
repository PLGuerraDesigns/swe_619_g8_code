package assignment_10;

// Assignment 10.2
// Consider Bloch's Point/ColorPoint example. For today, ignore the hashCode() issue.

public class Point {  // routine code
   private int x; private int y;    
   ...
   @Override public boolean equals(Object obj) {  // Standard recipe
      if (!(obj instanceof Point)) return false;

      Point p = (Point) obj;
      return p.x == x && p.y == y;
   }
}

public class ColorPoint extends Point {  // First attempt: Standard recipe
   private COLOR color;
   ...
  @Override public boolean equals(Object obj) {
      if (!(obj instanceof ColorPoint)) return false;

      ColorPoint cp = (ColorPoint) obj;
      return super.equals(obj) && cp.color == color;
   }
}

public class ColorPoint extends Point {  // Second attempt: DON'T DO THIS!
   private COLOR color;
   ...
   @Override public boolean equals(Object obj) {
      if (!(obj instanceof Point)) return false;

      // If obj is a normal Point, be colorblind
      if (!(obj instanceof ColorPoint)) return obj.equals(this);

      ColorPoint cp = (ColorPoint) obj;
      return super.equals(obj) && cp.color == color;
   }
}

// 1. What is the equals() contract? What is the standard recipe? (pg. 46, Bloch)
/* From the JavaDocs The equals method implements an equivalence relation on non-null object references:
   * It is reflexive: for any non-null reference value x, x.equals(x) should return true.
   * It is symmetric: for any non-null reference values x and y, x.equals(y) should return true if and only if y.equals(x) returns true.
   * It is transitive: for any non-null reference values x, y, and z, if x.equals(y) returns true and y.equals(z) returns true, then x.equals(z) should return true.
   * It is consistent: for any non-null reference values x and y, multiple invocations of x.equals(y) consistently return true or consistently return false, provided no information used in equals comparisons on the objects is modified.
   * For any non-null reference value x, x.equals(null) should return false.
   The equals method for class Object implements the most discriminating possible equivalence relation on objects; that is, for any non-null reference values x and y, this method returns true if and only if x and y refer to the same object (x == y has the value true). 

   The standard recipe for a high quality equals method is: 
   1. Use the == operator to check if the argument is a reference to this object. If so, return true. This is just a performance optimization but sometimes very valuable.
   2. Use the instanceof operator to check if the argument has the correct type. If not, return false. 
   3. Cast the argument to the correct type. Because this cast was preceded by an instanceof test, it is guaranteed to succeed.
   4. For each “significant” field in the class, check if that field of the argument matches the corresponding field of this object. If all these tests succeed, return true; otherwise, return false. 

   The equals() method in the standard recipe meets the equals() contract in the JavaDocs.
*/

// 2. Why does Bloch use the instanceof operator in the standard recipe? (Bloch, pg. 42-43)
// Bloch uses the instanceof operator to identify if the two objects being compared have the same Object type, or if it's a subclass of an Object. 
// Using getClass() as an alternative would not preserve the ability to equate a subclass object to its parent object, additionally violating the Liskov substitution principle

// 3. Write client code that shows a contract problem with the first attempt at ColorPoint. //Violates contract clause of symmetry
   ColorPoint cp = new ColorPoint();
   cp.x = 3;
   cp.y = 4;
   Point p = new Point();
   p.x = 3;
   p.y = 4;
   System.out.println(p.equals(cp)); //returns true
   System.out.println(cp.equals(p)); //returns false because cp2 is not considered to be an instance of ColorPoint (line 21)

// 4. Write client code that shows a contract problem with the second attempt at ColorPoint.  //Issue with symmetry
   Point cp = new ColorPoint();
   cp.x = 3;
   cp.y = 4;
   Point sp = new SizePoint();
   sp.x = 3;
   sp.y = 4;
   System.out.println("Example of symmetry, expected answer false: " + sp.equals(cp) == cp.equals(sp)); 
   // Assume that another class (SizePoint) extends from Point and is being checked for equality against ColorPoint.
   // Since the second attempt at ColorPoint uses the equals method of the object argument, an arbitrary class that 
   // inherits from Point could have an equals method that wildly differs from an implementation that compares the x and y values.


// 5. Some authors recommend solving this problem by using a different standard recipe for equals().
// a) What's the key difference?
//      InstanceOf - tests if the object being checked for equivalency is the same type or of a subtype of that Object
//      getClass() - tests if the object types are identical
// b) Which approach do you want in the following code: we prefer the instanceOf approach
   public class CounterPoint extends Point{
      private static final AtomicInteger counter =
         new AtomicInteger();
 
      public CounterPoint(int x, int y) {
         super (x, y);
         counter.incrementAndGet();
      }
      public int numberCreated() { return counter.get(); }

      @Override 
      public boolean equals (Object obj) { ... }
   }
    // Client code:
    Point p = PointFactory.getPoint();   // either a Point or a CounterPoint
    Set<Point> importantPoints =   // a set of important points
    boolean b = PointUtilities.isImportant(p);  // value?


