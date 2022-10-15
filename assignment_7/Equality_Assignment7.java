import java.util.*;

// Download and run Equality_Assignment7.java. 
// TODO: Execute its code and provide a "detailed/convincing" explanation of its behavior.

public class Equality_Assignment7 {

    public static void main(String args[]) {
        Set<List<String>> s = new HashSet<List<String>>(); // AF(s) = ___
        System.out.println(s);

        List<String> x = new ArrayList<String>(); // AF(x) = ___
        System.out.println(x);

        List<String> y = new ArrayList<String>(); // AF(y) = ___
        System.out.println(y);

        s.add(x); // AF(s) = ____
        System.out.println(s);

        s.add(y); // AF(s) = ____
        System.out.println(s);

        boolean b = s.contains(y); // true or false?
        System.out.println(b);

        y.add("cat"); // AF(y) = ____

        System.out.println(y);
        System.out.println(s);

        b = s.contains(y); // true or false?
        System.out.println(b);

        s.add(y); // AF(s) = ____
        System.out.println(s);

        y.remove("cat"); // AF(s) = ____
        System.out.println(s);

        s.remove(y); // AF(s) = ____
        System.out.println(s);

        b = s.contains(y); // true, false, or something else?
        System.out.println(b);

        b = s.contains(x); // true, false, or something else?
        System.out.println(b);
    }

}
