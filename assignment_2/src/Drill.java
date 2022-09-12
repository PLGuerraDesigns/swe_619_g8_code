package src;

import java.util.*;

/*
    SWE 619, Assignment 2
    Group8: Pablo Leandro Guerra, Katherine Soltani, Justin Yang
    All members contributed equally to the assignment.
 */
public class Drill {

    //PART 1
    public static boolean match(Map<String, String> m, String prompt, String answer) {
        // Requires: m, prompt, answer not null; prompt is a key in Map m, ignoring case
        // Effects: returns true iff the Map m maps prompt to answer, ignoring case

        //There is no case-insensitive exclusivity clause for the key in m, the result will be underdetermined:
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

    //PART 2
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
}
