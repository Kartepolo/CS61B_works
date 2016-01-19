package synthesizer;

public class GuitarString extends Harp_Guitar {

 /* Create a guitar string of the given frequency.  */
 public GuitarString(double frequency) {
	 super(frequency,1.0);
	 DECAY = .996;
	 }  
}

