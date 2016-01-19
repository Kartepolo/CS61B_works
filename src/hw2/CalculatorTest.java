import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class CalculatorTest {
    /* Do not change this to be private. For silly testing reasons it is public. */
    public Calculator tester;

    /**
     * setUp() performs setup work for your Calculator.  In short, we 
     * initialize the appropriate Calculator for you to work with.
     * By default, we have set up the Staff Calculator for you to test your 
     * tests.  To use your unit tests for your own implementation, comment 
     * out the StaffCalculator() line and uncomment the Calculator() line.
     **/
    @Before
    public void setUp() {
        //tester = new StaffCalculator(); // Comment me out to test your Calculator
        tester = new Calculator();   // Un-comment me to test your Calculator
    }

    // TASK 1: WRITE JUNIT TESTS
    // YOUR CODE HERE
    @Test
    public void CalculatorTester() {
        assertEquals(3,tester.add(1, 2)); 
        assertEquals(8,tester.add(7, 1));
        assertEquals(25,tester.add(13, 12));
        assertEquals(0,tester.add(2, -2)); 
        assertEquals(7,tester.add(-11, 18)); 
        assertEquals(-2,tester.add(-1, -1));// end of all addition tests
        assertEquals(8,tester.multiply(4, 2));
        assertEquals(35,tester.multiply(5, 7));//end of multiplication tests
    }

    /* Run the unit tests in this file. */
    public static void main(String... args) {
        jh61b.junit.textui.runClasses(CalculatorTest.class);
    }       
}