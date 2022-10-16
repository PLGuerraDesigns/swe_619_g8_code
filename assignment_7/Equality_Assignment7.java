import java.util.*;

// Download and run Equality_Assignment7.java. 
// TODO: Execute its code and provide a "detailed/convincing" explanation of its behavior.

public class Equality_Assignment7 {

    public static void main(String args[]) {
        Set<List<String>> s = new HashSet<List<String>>(); // AF(s) = {} because upon initialization, no values are
                                                           // present in the set

        System.out.println("Step 1: Set<List<String>> s = new HashSet<List<String>>();");
        System.out.println(s);
        System.out.println("----------------------------------------------");

        List<String> x = new ArrayList<String>(); // AF(x) = [] because upon initialization, no values are present in
                                                  // the list
        System.out.println("Step 2:  List<String> x = new ArrayList<String>();");
        System.out.println(x);
        System.out.println("----------------------------------------------");

        List<String> y = new ArrayList<String>(); // AF(y) = [] because upon initialization, no values are present in
                                                  // the list
        System.out.println("Step 3: List<String> y = new ArrayList<String>();");
        System.out.println(y);
        System.out.println("----------------------------------------------");

        s.add(x); // AF(s) = {[]}. This is because the add() function adds the specified element
                  // to the set if it's not already in the set
        System.out.println("Step 4: s.add(x); ");
        System.out.println(s);
        System.out.println("----------------------------------------------");

        s.add(y); // AF(s) = {[]}. This is because on line 34, an empty list was already added.
                  // The spec for the add() function states that it adds the specified element to
                  // the set if it's not already in the set
        System.out.println("Step 5: s.add(y);");
        System.out.println(s);
        System.out.println("----------------------------------------------");

        boolean b = s.contains(y); // True. This is because the contains() method specs mentions that true should
                                   // be returned if the set contains the specified element
        System.out.println("Step 6: boolean b = s.contains(y);");
        System.out.println(b);
        System.out.println("----------------------------------------------");

        y.add("cat"); // AF(y) = ["cat"]. This is because the add() spec for lists appends the
                      // specified element to the end of the list
        System.out.println("Step 7: y.add('cat');");
        System.out.println(y);
        System.out.println(s);
        System.out.println("----------------------------------------------");

        b = s.contains(y); // False. The list y is not an empty list anymore. The set s only contains an
                           // empty list, so in following the spec for contains(), list y does not equal
                           // any of the elements in the set s
        System.out.println("Step 8: b = s.contains(y);");
        System.out.println(b);
        System.out.println("----------------------------------------------");

        s.add(y); // AF(s) = {[], ["cat"]}. Now that the y List is not an empty list, it is not
                  // considered to already be in the set so it is added to the set, in addition to
                  // the empty list
        System.out.println("Step 9: s.add(y);");
        System.out.println(s);
        System.out.println("----------------------------------------------");

        y.remove("cat"); // AF(s) = {[], ["cat"]}. Although the element "cat" is removed from the List y,
                         // the Set s still has ["cat"] appended to it. So, the Set s remains unchanged,
                         // but the List y no longer contains "cat" and is an empty list
        System.out.println("Step 10: y.remove('cat');");
        System.out.println(s);
        System.out.println("----------------------------------------------");

        s.remove(y); // AF(s) = {["cat"]}. The List y is now an empty list. So, when removing y from
                     // the Set s, the empty list will be removed the list ["cat"] remains
        System.out.println("Step 11:  s.remove(y);");
        System.out.println(s);
        System.out.println("----------------------------------------------");

        b = s.contains(y); // False. The List y is an empty list, and the Set s does not contains empty
                           // lists
        System.out.println("Step 12: b = s.contains(y);");
        System.out.println(b);
        System.out.println("----------------------------------------------");

        b = s.contains(x); // False. The List x is an empty list, and the Set s does not contains empty
                           // lists
        System.out.println("Step 13: b = s.contains(x)");
        System.out.println(b);
        System.out.println("----------------------------------------------");
    }

}
