import static org.junit.Assert.*;

import org.junit.Test;

/** Perform tests of the DoubleChain class
 */

public class TestDoubleChain {

    /** Tests the constructor of DoubleChain */
    @Test
    public void testConstructor() {
        DoubleChain d = new DoubleChain(5);
        assertEquals(5,d.getFront().val, 1e-6);
        assertEquals(null, d.getFront().prev);
        assertEquals(null, d.getFront().next);
    }

    /** Tests some basic DoubleChain operations. */
    @Test
    public void testBasicOperations() {
        DoubleChain d = new DoubleChain(5);
        assertEquals(5, d.getFront().val, 1e-11);
        assertEquals(5, d.getBack().val, 1e-11);

        d.insertFront(2);
        d.insertFront(1);
        d.insertBack(7);
        d.insertBack(8);
        assertEquals(1, d.getFront().val, 1e-11);
        assertEquals(8, d.getBack().val, 1e-11);
    }
    /** Tests some advanced DoubleChain operations. */
    @Test
    public void testAdvancedOperations() {
        DoubleChain d = new DoubleChain(5);
        assertEquals(5, d.deleteBack().val, 1e-11);
        assertEquals(null, d.deleteBack());
    }

    public static void main(String[] args) {
    	TestDoubleChain t= new TestDoubleChain();
    	t.testConstructor();
    	t.testBasicOperations();
    	t.testAdvancedOperations();
    }
}
