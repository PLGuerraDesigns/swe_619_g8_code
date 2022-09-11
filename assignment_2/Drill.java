import java.util.*;

public class Drill {

    public static boolean match(Map<String, String> m, String prompt, String answer) {
        // Requires: m, prompt, answer not null; prompt is a key in Map m, ignoring case
        // Effects: returns true iff the Map m maps prompt to answer, ignoring case

        //There is no case-insensitive exclusivity clause for the key in m, the result will be undeterministic:
        // If two keys “dog” and “DOG” both exist in m, this function will only return the value associated with one of them
        // Furthermore, if two keys "dog" and "DOG" both exist in m, "dog" is first to be compared, and "dog"'s corresponding value is different from answer, this will return false

        //Possible Courses of action
        //1. CURRENTLY USING THIS: Iterate through the map and manually compare the keys. https://www.baeldung.com/java-iterate-map
        //2. Use TreeMap w/ case insensitive comparator: https://codereview.stackexchange.com/questions/183127/map-with-case-insensitive-get-remove-and-containskey
            //Would this implementation be expected to work with all types of maps? If so, the above COA will not work.
        //3. Drill takes a Map<String,String> and creates a new copy constructor'd map that has each of the keys .toLowerCase()'ed.  O(n) construction time, O(1) lookup.
        for(Map.Entry<String,String> entry: m.entrySet()) {
            if(entry.getKey().equalsIgnoreCase(prompt)) {
                return entry.getValue().equalsIgnoreCase(answer);
            }
        }
        return false;
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
