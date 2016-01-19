import java.util.HashMap;
import java.util.regex.*;
public class UsernameBank {

    // Instance variables (remember, they should be private!)
    // YOUR CODE HERE
	private HashMap<Username,String> h;
	private HashMap<String,Integer> badmails;
	private HashMap<Username,String> badusernames;

    public UsernameBank() {
        // YOUR CODE HERE
    	h = new HashMap<Username,String>();
    }
    private static boolean isinvalid(String username) {
    	String regex = "[^0-9a-zA-Z]";
    	Pattern p = Pattern.compile(regex);
    	return p.matcher(username).find();
    }

    public void generateUsername(String username, String email) {
        // YOUR CODE HERE

    }

    public String getEmail(String username) {
        // YOUR CODE HERE
    	if (username == null) {
    		throw new NullPointerException();
    	}else if (isinvalid(username)){
    		return null;
    	}else {
    		return h.get(username);
    	}
    }

    public String getUsername(String userEmail)  {
        // YOUR CODE HERE
        return null;
    }

    public Map<String, Integer> getBadEmails() {
        // YOUR CODE HERE
        return null;
    }

    public Map<String, Integer> getBadUsernames() {
        // YOUR CODE HERE
        return null;
    }

    public String suggestUsername() {
        // YOUR CODE HERE
        return null;
    }

    // The answer is somewhere in between 3 and 1000.
    public static final int followUp() {
        // YOUR CODE HERE
        return 0;
    }

    // Optional, suggested method. Use or delete as you prefer.
    private void recordBadUsername(String username) {
        Username u = new Username(username);
        if ()
    }

    // Optional, suggested method. Use or delete as you prefer.
    private void recordBadEmail(String email) {
    	if (badmails.containsKey(email)) {
    		badmails.put(email, badmails.get(email)+1);
    	}else{
    		badmails.put(email, 1);
    	}
    }
}