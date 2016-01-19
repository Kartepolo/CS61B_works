package synthesizer;

public abstract class Harp_Guitar extends AbstractMusicString {

 public Harp_Guitar(double frequency,double sizefactor) {
	 super(frequency,sizefactor);
	 }  
 /* Advance the simulation one time step by performing one iteration of
  * the Karplus-Strong algorithm. 
  */
 public void tic() {
	 double num1 = buffer.dequeue();
	 double newnum = (num1+buffer.peek())/2*DECAY;
	 buffer.enqueue(newnum);
 }
}

