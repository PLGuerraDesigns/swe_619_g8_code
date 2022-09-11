package src;

import java.util.*;

public class Drill {

    public static boolean match(Map<String, String> m, String prompt, String answer) {
        // Requires: m, prompt, answer not null; prompt is a key in Map m, ignoring case
        // Effects: returns true iff the Map m maps prompt to answer, ignoring case

        //There is no case-insensitive exclusivity clause for the key in m, the result will be undeterministic:
        // If two keys “dog” and “DOG” both exist in m, this function will only return the value associated with one of them
        // Furthermore, if two keys "dog" and "DOG" both exist in m, "dog" is first to be compared,
            // and "dog"'s corresponding value is different from answer,
            // this will return false even though there may be a matching pair further down in the map

        for(Map.Entry<String,String> entry: m.entrySet()) {
            if(entry.getKey().equalsIgnoreCase(prompt)) {
                return entry.getValue().equalsIgnoreCase(answer);
            }
        }
        return false;
    }

    public static boolean matchExceptionized(Map<String, String> m, String prompt, String answer) {
        //Requires: m, prompt, answer not null; prompt is a key in Map m, ignoring case
        //Effects:  Throws NullPointerException if any inputs are null, Throws an IllegalArgumentException if prompt does not exist as a key in m, returns true iff the Map m maps prompt to answer, ignoring case

        if(m==null || prompt==null || answer==null) {
            throw new NullPointerException("All inputs must have non-null values.");
        }

        for(Map.Entry<String,String> entry: m.entrySet()) {
            if(entry.getKey().equalsIgnoreCase(prompt)) {
                return entry.getValue().equalsIgnoreCase(answer);
            }
        }

        throw new IllegalArgumentException("prompt is not a key in m.");
    }

    public static void main(String[] args) throws Exception {
        System.out.println("BEGINNING TESTS...");

        Map<String,String> testMap = new HashMap<String,String>();
        testMap.put("Dog","le chien");
        System.out.println("MAP CONSISTS OF: " + testMap);

        String prompt = "";
        String answer = "";

        //Case 1:
        prompt = "DoG";
        answer = "LE cHiEn";
        System.out.println("Case 1: Prompt = " + prompt + ", Answer = " + answer + ", Result = " + match(testMap,prompt, answer));

        System.out.println("-----------------------------------------------------");

        System.out.println("TESTING match() WITH EXCEPTIONS...");
        Map<String,String> testMapExceptions = new HashMap<String,String>();
        testMapExceptions.put("dog","le chien");
        System.out.println("MAP CONSISTS OF: " + testMapExceptions);

        String promptE = "";
        String answerE = "";

        //Case 1:
        promptE = "DoG";
        answerE = "LE cHiEn";
        System.out.println("Case 1: Prompt = " + promptE + ", Answer = " + answerE + ", Result = " + matchExceptionized(testMapExceptions,promptE, answerE));

        //Case 2:
        promptE = null;
        answerE = null;
        System.out.println("Case 2: Prompt = " + promptE + ", Answer = " + answerE + ", Result = " + matchExceptionized(testMapExceptions,promptE, answerE));

    }
}
