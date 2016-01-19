import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Iterator;

/** ULLMapTest. You should write additional tests.
 *  @author Josh Hug
 */

public class ULLMapTest {
    @Test
    public void testBasic() {
        ULLMap<String, String> um = new ULLMap<String, String>();
        um.put("Gracias", "Dios Basado");
        um.put("KARTE", "POLO");
        assertEquals(um.get("Gracias"), "Dios Basado");
        assertEquals(um.containsKey("Meow"), false);
        assertEquals(um.get("KARTE"), "POLO");
        um.remove("KARTE");
        assertEquals(um.get("KARTE"), null);
        um.put("KARTE", "POLO");
        assertEquals(um.get("KARTE"), "POLO");
        um.remove("KARTE","POLO");
        assertEquals(um.containsKey("KARTE"), false);
        ULLMap<String, String> invert_um = ULLMap.invert(um);
        assertEquals(invert_um.containsKey("Dios Basado"), true);
    }

    
    @Test
    public void testIterator() {
        ULLMap<Integer, String> um = new ULLMap<Integer, String>();
        um.put(0, "zero");
        um.put(1, "one");
        um.put(2, "two");
        Iterator<Integer> umi = um.iterator();
        System.out.println(umi.next());
    }
    

    /** Runs tests. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(ULLMapTest.class);
    }
} 