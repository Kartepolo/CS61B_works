package synthesizer;

public abstract class AbstractMusicString implements MusicString {
	private static int SR = 44100;
	static double DECAY;
	BoundedQueue buffer;
	
	public AbstractMusicString(double frequency, double sizefactor) {
	     // TODO: Create a buffer with capacity = SR / frequency. You'll need to
	     //       cast the result of this divsion operation into an int. For better
	     //       accuracy, use the Math.round() function before casting.
	     //       Your buffer should be initially filled with zeros.
		 double capacity = SR/frequency*sizefactor;
		 buffer = new ArrayRingBuffer((int) Math.round(capacity));
		 while(!buffer.isFull()){
			 buffer.enqueue(0); 
		 } 
		 }
	 
	 
	 /* Pluck the guitar string by replacing the buffer with white noise. */
	 public void pluck() {
	     // TODO: Dequeue everything in the buffer, and replace it with random numbers
	     //       between -0.5 and 0.5. You can get such a number by using:
	     //       double r = Math.random() - 0.5;
	     //
	     //       Make sure that your random numbers are different from each other.
		 double r;
		 for(int i =0;i<buffer.capacity();i++){
			 buffer.dequeue();
			 r = Math.random();
			 buffer.enqueue(r);
		 }	 
	 }	 
	 /* Return the double at the front of the buffer. */
	 public double sample() {
	     return buffer.peek();
	 }
}
