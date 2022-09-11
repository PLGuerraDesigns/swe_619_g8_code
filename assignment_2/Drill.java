import java.util.*;

public class Drill {

    public static boolean match(Map<String, String> m, String prompt, String answer) {
        // Requires: m, prompt, answer not null; prompt is a key in Map m, ignoring case
        // Effects: returns true iff the Map m maps prompt to answer, ignoring case

        if (m == null || prompt == null || answer == null) {
            throw new NullPointerException("All inputs must have non-null values.");
        }
        if (!m.containsKey(prompt.toLowerCase())) {
            throw new IllegalArgumentException("prompt is not a key in m.");
        }

        return m.get(prompt.toLowerCase()).equals(answer.toLowerCase());
    }

    public static void main(String[] args) throws Exception {

        // Creating new map and populating with content
        Map<String, String> m = new HashMap<String, String>();
        m.put("dog", "chien");
        m.put("cat", "chat");
        m.put("bird", "oiseau");
        m.put("pig", "porc");

        // Tests
        boolean result = match(m, "pig", "oiseau");
        System.out.println("pig = oiseau: " + result);

        result = match(m, "dog", "chien");
        System.out.println("dog = chien: " + result);

        result = match(m, "DoG", "CHieN");
        System.out.println("DoG = CHieN: " + result);

        result = match(m, "rat", "porc");
        System.out.println("rat = porc: " + result);
    }
}
