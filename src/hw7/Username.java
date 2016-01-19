import java.util.regex.*;
public class Username {

    // Potentially useless note: (int) '0' == 48, (int) 'a' == 97

    // Instance Variables (remember, they should be private!)
    // YOUR CODE HERE
	private String name;
	private final static int[] c = {10,26,26};

    public Username() {
    	name = "";
    	int l = (int)(Math.random()*3+1);
    	int rnd;
    	for (int i=0; i < l; i++) {
    		rnd = (int) (Math.random() * 62);
    		if (rnd<c[0]) {
    			rnd = rnd + 48;
    		}else if (rnd<c[0]+c[1]) {
    			rnd = rnd + 55;
    		}else {
    			rnd = rnd + 61;
    		}
    		name = name + (char) rnd;
    	}
    	name = name.toLowerCase();
    }

    public Username(String reqName) {
    	char w;
    	String regex = "[^0-9a-zA-Z]";
    	Pattern p = Pattern.compile(regex);
    	if (reqName == null) {
    		System.out.println("Requested username is null!");
        	throw new NullPointerException();
        	}else{
    	if (reqName.length() > 3) {
    	    	System.out.println("Requested username is too long!");
        	throw new IllegalArgumentException();
        	}else if (p.matcher(reqName).find()) {
        	throw new IllegalArgumentException();
    } else {
    	name = reqName;
    }
        	
        }
    }

    @Override
    public boolean equals(Object o) {
        // YOUR CODE HERE
    	if (o instanceof Username) {
    		Username u = (Username) o;
    		return this.hashCode() == u.hashCode();
    	}
        return false;
    }

    @Override
    public int hashCode() { 
    	char c;
    int hash = 0;
    	for (int i = 0; i < name.length(); i ++) {
    		c = name.charAt(i);
    		hash = hash * 31 + (int) c;
    	}
    	return hash;
    	
    }

    public static void main(String[] args) {
        Username u = new Username();
        System.out.println(u.hashCode()+" "+u.name);
        Username u1 = new Username("%ca");
        System.out.println(u1.hashCode()+" "+u1.name);
    }
}