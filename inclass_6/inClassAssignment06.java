import java.util.*;

public class inClassAssignment06 {

    public static void main(String args[]) {
        Set<List<String>> s = new HashSet<List<String>>();
        System.out.println(s);

        List<String> x = new ArrayList<String>();
        System.out.println(x);

        List<String> y = new ArrayList<String>();
        System.out.println(y);

        s.add(x);
        System.out.println(s);

        s.add(y);
        System.out.println(s);

        boolean b = s.contains(y);
        System.out.println(b);

        y.add("cat");

        System.out.println(y);
        System.out.println(s);

        b = s.contains(y);
        System.out.println(b);

        s.add(y);
        System.out.println(s);

        y.remove("cat");
        System.out.println(s);

        s.remove(y);
        System.out.println(s);

        b = s.contains(y);
        System.out.println(b);

        b = s.contains(x);
        System.out.println(b);
    }

}
