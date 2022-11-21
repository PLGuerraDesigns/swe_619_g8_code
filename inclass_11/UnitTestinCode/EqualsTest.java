import org.junit.*;
import org.junit.runner.RunWith;

import inclass_11.src.ColorPoint;
import inclass_11.src.Point;

import static org.junit.Assert.*;
import static org.junit.Assume.*;

import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;

import java.util.*;

@RunWith(Theories.class)
public class EqualsTest {

  // Create @DataPoints from Bloch's Point, ColorPoint classes. So that we're all
  // on the same page, create
  // 1 null reference, 1 Point object and 2 ColorPoint objects.
  //
  // How many combinations are considered by the theory?
  // How many combinations make it past the preconditions of the theory?
  // How many combinations make it to the postcondition of the theory?
  @DataPoints
  public static Set<Point> set = new HashSet<Point>() {
    {
      add(null);
      add(new Point(1, 2));
      add(new ColorPoint(1, 2, "red"));
      add(new ColorPoint(1, 2, "blue"));
    }
  };

  // write a JUnit Theory that captures the symmetry property of the equals()
  // method.
  // Is symmetry satisfied?
  @Theory
  public void testEqualsSymmetry(Object a, Object b) {
    System.out.println("Entry a, b: " + a + " | " + b);

    assumeTrue(a != null);
    assumeTrue(b != null);

    assertTrue(a.equals(b) == b.equals(a));
  }

  // Write a JUnit theory that captures the transitivity property of the equals()
  // method.
  // Is transitivity satisfied?
  @Theory
  public void testEqualsTransitivity(Object a, Object b, Object c) {
    System.out.println("Entry a, b, c: " + a + " | " + b + " | " + c);

    assumeTrue(a != null);
    assumeTrue(b != null);
    assumeTrue(c != null);

    assertTrue(a.equals(b) == b.equals(c) == a.equals(c));
  }

  public void removeThenAddDoesNotChangeSet(Set<String> set, String string) {
    assumeTrue(set != null); // Assume
    assumeTrue(set.contains(string)); // Assume
    // Uncomment the following line to see which tests that pass the precondition
    System.out.println("Set, string: " + set + ", " + string);
    Set<String> copy = new HashSet<String>(set); // Act
    copy.remove(string);
    copy.add(string);
    assertTrue(set.equals(copy)); // Assert
  }

}