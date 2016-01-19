// A client that uses the synthesizer package to replicate a plucked guitar string sound
public class GuitarHero {
      public static void main(String[] args) {
    	  String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
    	  synthesizer.HarpString[] keyStrings = new synthesizer.HarpString[keyboard.length()];
          // create two guitar strings, for concert A and C
          final double base = 440.0;
          double samples;
          for (int i=0;i<keyboard.length();i++){
        	  keyStrings[i] = new synthesizer.HarpString(base*Math.pow(2, (i-24)/12.0));
          }

          while (true) {
        	      samples =0;
              // check if the user has typed a key; if so, process it   
              if (StdDraw.hasNextKeyTyped()) {
                  char key = StdDraw.nextKeyTyped();
                  int index = keyboard.indexOf(key);
                  if (index!=-1){
                	  keyStrings[index].pluck();
                  }
              }

              // compute the superposition of samples
              for (synthesizer.HarpString s : keyStrings){
            	  samples+= s.sample();
              }
  
              // play the sample on standard audio
              // note: this is just playing the double value YOUR HarpString
              //       class is generating. 
              StdAudio.play(samples);
  
              // advance the simulation of each guitar string by one step   
              for (synthesizer.HarpString s : keyStrings){
            	  s.tic();
              }
          }
       }
  }

