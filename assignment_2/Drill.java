import java.util.*;

public class Drill {

    public static boolean match(Map<String, String> m, String prompt, String answer) {
        // Requires: m, prompt, answer not null; prompt is a key in Map m, ignoring case
        // Effects: returns true iff the Map m maps prompt to answer, ignoring case

        // TODO: Modify so that it handles all of its preconditions with exceptions. Use
        // the standard exceptions recommended by Bloch. Document this with a revised
        // contract. You can use JavaDoc or you can simply identify the postconditions.

        if (m.get(prompt.toLowerCase()).equals(answer.toLowerCase())) {
            return true;
        }
        return false;
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
    }
}
