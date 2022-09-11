import java.util.*;

public class Drill {

    public static boolean match(Map<String, String> m, String prompt, String answer) {
        // Requires: m, prompt, answer not null; prompt is a key in Map m, ignoring case
        // Effects: returns true iff the Map m maps prompt to answer, ignoring case

        //There is no exclusivity clause for the key in m, the result will be undeterministic:
        // If two keys “dog” and “DOG” both exist in m, this function will only return the value associated with one of them

        //THIS IMPLEMENTATION DOES NOT WORK.  It fails to case-desensitize the "prompt" input.
        //1. Iterate through the map and manually compare the keys
        //2. Use TreeMap w/ case insensitive comparator: https://codereview.stackexchange.com/questions/183127/map-with-case-insensitive-get-remove-and-containskey
            //Would this implementation be expected to work with all types of maps? If so, the above COA will not work.
        //3. Drill takes a Map<String,String> and creates a new copy constructor'd map that has each of the keys .toLowerCase()'ed.  O(n) construction time, O(1) lookup
        return m.get(prompt).equalsIgnoreCase(answer);
    }

    public static void main(String[] args) throws Exception {
        System.out.println("BEGINNING TESTS...");

        Map<String,String> testMap = new HashMap<String,String>();
        testMap.put("dog","le chien");

        String prompt = "";
        String answer = "";

        System.out.println("MAP CONSISTS OF: " + testMap);
        //Case 1:
        prompt = "DoG";
        answer = "LE cHiEn";
        System.out.println("Case 1: Prompt = " + prompt + ", Answer = " + answer + ", Result = " + match(testMap,prompt, answer));
    }
}
