import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class DrillTest {
    @Test
    public static void testDrill(){

        //define default map
        Map<String, String>testMap = new HashMap<String, String>();
        testMap.put("dog", "chien");
        testMap.put("cat", "chat");
        testMap.put("bird", "oiseau");
        testMap.put("pig", "porc");

        //test correct test cases
        AssertEquals(true, matchExceptionized(testMap, "dog", "chien"));
        AssertEquals(true, matchExceptionized(testMap, "cat", "chat"));
        AssertEquals(true, matchExceptionized(testMap, "bIRd", "oISeau"));
        AssertEquals(true, matchExceptionized(testMap, "pIG", "pOrC"));

        //test illegal argument exceptions
        AssertThrows(IllegalArgumentException.class, matchExceptionized(testMap, null, null));
        AssertThrows(IllegalArgumentException.class, matchExceptionized(testMap, "horse", "chat"));


    }
}
