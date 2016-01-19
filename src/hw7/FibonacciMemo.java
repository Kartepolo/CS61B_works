import java.util.HashMap; // Import Java's HashMap so we can use it

public class FibonacciMemo {

    /**
     * The classic recursive implementation with no memoization. Don't care
     * about graceful error catching, we're only interested in performance.
     * 
     * @param n
     * @return The nth fibonacci number
     */
    public static int fibNoMemo(int n) {
        if (n <= 1) {
            return n;
        }
        return fibNoMemo(n - 2) + fibNoMemo(n - 1);
    }

    /**
     * Your optimized recursive implementation with memoization. 
     * You may assume that n is non-negative.
     * 
     * @param n
     * @return The nth fibonacci number
     */
    private static int[] Mem = {0, 1};
    
    private static int fib(int n) {
        if(n <= 1) {
            return Mem[n];
        } else {
            int temp=Mem[n];
            if(temp==-1)  temp=fibMemo(n-1)+fibMemo(n-2);
            Mem[n]=temp;
            return Mem[n];
        }
}

    public static int fibMemo(int n) {
    	if (n>=Mem.length){
    		int[] Memo = new int[n+1];
    		System.arraycopy(Mem, 0, Memo, 0, Mem.length);
    		for (int k = Mem.length;k<Memo.length;k++){
    			Memo[k]=-1;
    		}
    		Mem = Memo;
    	}
    	return fib(n);
    }


    /**
     * Answer the following question as a returned String in this method:
     * Why does even a correctly implemented fibMemo not return 2,971,215,073
     * as the 47th Fibonacci number?
     */
    public static String why47() {
        String answer = "potatoes";
        answer += ", " + answer + " and tapioca";
        return answer;
    }

    public static void main(String[] args) {
        // Optional testing here        
        String m = "Fibonacci's real name was Leonardo Pisano Bigollo.";
        m += "\n" + "He was the son of a wealthy merchant.\n";
        System.out.println(m);
        //System.out.println("0: " + FibonacciMemo.fibMemo(0));
       // System.out.println("1: " + FibonacciMemo.fibNoMemo(1));
       // System.out.println("1: " + FibonacciMemo.fibMemo(1));
        System.out.println("2: " + FibonacciMemo.fibNoMemo(2));
        System.out.println("2: " + FibonacciMemo.fibMemo(2));
        System.out.println("3: " + FibonacciMemo.fibNoMemo(3));
        System.out.println("3: " + FibonacciMemo.fibMemo(3));
        System.out.println("4: " + FibonacciMemo.fibNoMemo(4));
          System.out.println("4: " + FibonacciMemo.fibMemo(4));

        // 46th Fibonacci = 1,836,311,903
        // 47th Fibonacci = 2,971,215,073
    }
}
