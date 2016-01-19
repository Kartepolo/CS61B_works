
import list.EquationList;

public class Calculator {
    // YOU MAY WISH TO ADD SOME FIELDS
	EquationList el;
	int hsize = 0;
    /**
     * TASK 2: ADDING WITH BIT OPERATIONS
     * add() is a method which computes the sum of two integers x and y using 
     * only bitwise operators.
     * @param x is an integer which is one of two addends
     * @param y is an integer which is the other of the two addends
     * @return the sum of x and y
     **/
    public int add(int x, int y) {
    	int bin_unchanged,bin_changed;
    	bin_unchanged = x^y;
		bin_changed = (x&y)<<1;
    	if (bin_changed == 0){
    		return bin_unchanged | bin_changed;
    	}else{
    		return add(bin_unchanged,bin_changed);
    	}
    }

    /**
     * TASK 3: MULTIPLYING WITH BIT OPERATIONS
     * multiply() is a method which computes the product of two integers x and 
     * y using only bitwise operators.
     * @param x is an integer which is one of the two numbers to multiply
     * @param y is an integer which is the other of the two numbers to multiply
     * @return the product of x and y
     **/
    public int multiply(int x, int y) {
    	int digit;
    	if (y==1){
    		return x;
    	}
    	digit = y & 1;
    	if (digit == 1){
    		return add(x,multiply(x<<1,y>>>1));
    	}else{
    		return multiply(x<<1,y>>>1);
    	}
        // YOUR CODE HERE
    }

    /**
     * TASK 5A: CALCULATOR HISTORY - IMPLEMENTING THE HISTORY DATA STRUCTURE
     * saveEquation() updates calculator history by storing the equation and 
     * the corresponding result.
     * Note: You only need to save equations, not other commands.  See spec for 
     * details.
     * @param equation is a String representation of the equation, ex. "1 + 2"
     * @param result is an integer corresponding to the result of the equation
     **/
    public void saveEquation(String equation, int result) {
        // YOUR CODE HERE
    	if (el == null){
    		el = new EquationList(equation,result,null);
    	}else{
    		el = new EquationList(equation,result,el);
    	}
    	hsize++;
    }

    /**
     * TASK 5B: CALCULATOR HISTORY - PRINT HISTORY HELPER METHODS
     * printAllHistory() prints each equation (and its corresponding result), 
     * most recent equation first with one equation per line.  Please print in 
     * the following format:
     * Ex   "1 + 2 = 3"
     **/
    public void printAllHistory() {
        // YOUR CODE HERE
    	printHistory(hsize);
    	
    }

    /**
     * TASK 5B: CALCULATOR HISTORY - PRINT HISTORY HELPER METHODS
     * printHistory() prints each equation (and its corresponding result), 
     * most recent equation first with one equation per line.  A maximum of n 
     * equations should be printed out.  Please print in the following format:
     * Ex   "1 + 2 = 3"
     **/
    public void printHistory(int n) {
        // YOUR CODE HERE
    	EquationList l = el;
    	int i = 0;
    	while (i<n){
    		if (l==null){
    			System.out.println("Out of History Bounds! Printing stops here.");
    			break;
    		}
    		System.out.println(l.equation+" = "+l.result);
    		l = l.next;
    		i++;
    	}
    }

    /**
     * TASK 6: CLEAR AND UNDO
     * undoEquation() removes the most recent equation we saved to our history.
    **/
    public void undoEquation() {
        // YOUR CODE HERE
    	el = el.next;
    	hsize--;
    }

    /**
     * TASK 6: CLEAR AND UNDO
     * clearHistory() removes all entries in our history.
     **/
    public void clearHistory() {
        // YOUR CODE HERE
    	el = null;
    	hsize = 0;
    }

    /**
     * TASK 7: ADVANCED CALCULATOR HISTORY COMMANDS
     * cumulativeSum() computes the sum over the result of each equation in our 
     * history.
     * @return the sum of all of the results in history
     **/
    public int cumulativeSum() {
        // YOUR CODE HERE
    	int sum = 0;
    	if (el!=null){
    	EquationList p = el;
    	while (p!=null){
    		sum+=p.result;
    		p = p.next;
    	   }
    	}
        return sum;
    }

    /**
     * TASK 7: ADVANCED CALCULATOR HISTORY COMMANDS
     * cumulativeProduct() computes the product over the result of each equation 
     * in history.
     * @return the product of all of the results in history
     **/
    public int cumulativeProduct() {
    	int product = 1;
    	if (el!=null){
    	EquationList p = el;
    	while (p!=null){
    		product*=p.result;
    		p = p.next;
    	   }
    	}
        return product;
    }
}