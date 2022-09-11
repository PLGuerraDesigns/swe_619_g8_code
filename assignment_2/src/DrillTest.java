package src;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DrillTest {
    @Test
    void testDrill(){
        //define default map
        Map<String, String>testMap = new HashMap<String, String>();
        testMap.put("dog", "chien");
        testMap.put("cat", "chat");
        testMap.put("bird", "oiseau");
        testMap.put("pig", "porc");

        //test correct test cases
        assertTrue(Drill.matchExceptionized(testMap, "dog", "chien"));
        assertTrue(Drill.matchExceptionized(testMap, "cat", "chat"));
        assertTrue(Drill.matchExceptionized(testMap, "bIRd", "oISeau"));
        assertTrue(Drill.matchExceptionized(testMap, "pIG", "pOrC"));

        //test illegal argument exceptions
        assertThrows(NullPointerException.class, () -> Drill.matchExceptionized(testMap, null, null),"test");
        assertThrows(IllegalArgumentException.class, () -> Drill.matchExceptionized(testMap, "horse", "chat"),"test");
    }
}
