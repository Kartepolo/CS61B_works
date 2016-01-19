import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Tests {
    @Test
	public void SortedListTesters(){
		SortedComparableList sl = new SortedComparableList();
		sl.insert(0);
		sl.insert(0);
		sl.insert(0);
		sl.insert(0);
		sl.insert(1);
		sl.insert(1);
		sl.insert(3);
		sl.insert(3);
		sl.insert(3);
		sl.insert(4);
		sl.squish();
		sl.twin();
		System.out.println(sl.toString()); 
	}

	public static void main(String[] args) {
		jh61b.junit.textui.runClasses(Tests.class);

	}

}
