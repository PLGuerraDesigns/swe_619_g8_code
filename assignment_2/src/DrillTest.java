package src;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.Map;

//Using JUnit 5
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DrillTest {

    //define default map
    private Map<String,String> testMap = new HashMap<String,String>();

    @BeforeAll
    void setup() {
        testMap.put("dog", "chien");
        testMap.put("cat", "chat");
        testMap.put("bIRd", "oISeau");
        testMap.put("PIG", "PORC");
    }

    @Test
    void testDrill(){
        //test correct test cases
        assertTrue(Drill.matchExceptionized(testMap, "dog", "chien"));
        assertTrue(Drill.matchExceptionized(testMap, "cat", "CHAT"));
        assertTrue(Drill.matchExceptionized(testMap, "bIRd", "oISeau"));
        assertTrue(Drill.matchExceptionized(testMap, "pIG", "pOrC"));
    }

    @Test
    //Testing when the map is null
    void testMNull() {
        assertThrows(NullPointerException.class, () -> Drill.matchExceptionized(null, "dog", "chien"),"test");
    }

    @Test
    //Testing when "prompt" input is null
    void testPromptNull() {
        assertThrows(NullPointerException.class, () -> Drill.matchExceptionized(testMap, null, "chien"),"test");
    }

    @Test
    //Testing when "answer" input is null
    void testAnswerNull() {
        assertThrows(NullPointerException.class, () -> Drill.matchExceptionized(testMap, "dog", null),"test");
    }

    @Test
    //Testing if "prompt" is not present in the keys of "m"
    void testKeyNotPresent() {
        assertThrows(IllegalArgumentException.class, () -> Drill.matchExceptionized(testMap, "horse", "chat"),"test");
    }
}
