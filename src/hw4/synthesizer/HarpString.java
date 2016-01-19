package synthesizer;

public class HarpString extends Harp_Guitar{
	 /* Create a harp string of the given frequency.  */
	 public HarpString(double frequency) {
		 super(frequency,2.0);
		 DECAY = -0.996;
		 }  
	}

