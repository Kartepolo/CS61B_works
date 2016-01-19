
public class DoubleChain {
	
	private DNode head;
	
	public DoubleChain(){
	}
	
	public DoubleChain(double val) {
		/* your code here. */
		head = new DNode(val);
	}

	public DNode getFront() {
		return head;
	}

	/** Returns the last item in the DoubleChain. */		
	public DNode getBack() {
		/* your code here */
		DNode p = head;
		while(p.next!=null){
			p = p.next;
		}
		return p;
	}
	
	/** Adds D to the front of the DoubleChain. */	
	public void insertFront(double d) {
		/* your code here */
		DNode oldF = head;
		head = new DNode(d);
		head.next = oldF;
		oldF.prev = head;
	}
	
	/** Adds D to the back of the DoubleChain. */	
	public void insertBack(double d) {
		/* your code here */
		DNode p = head;
		while (p.next!=null){
			p = p.next;
		}
		DNode back = new DNode(p,d,null);
		p.next = back;
	}
	
	/** Removes the last item in the DoubleChain and returns it. 
	  * This is an extra challenge problem. */
	public DNode deleteBack() {
		/* your code here */
		DNode p = head;
		if (p != null){
		while (p.next!=null){
			p = p.next;
		}
		if (p.prev == null){
			head = null;
		}else{
		p.prev.next = null;
		}
		return p;
		}
		return null;
	}
	
	/** Returns a string representation of the DoubleChain. 
	  * This is an extra challenge problem. */
	public String toString() {
		/* your code here */
		DNode p = head;
		String r = "";
		while (p.next!=null){
			r += ""+p.val;
		}
		return r;
	}

	public static class DNode {
		public DNode prev;
		public DNode next;
		public double val;
		
		private DNode(double val) {
			this(null, val, null);
		}
		
		private DNode(DNode prev, double val, DNode next) {
			this.prev = prev;
			this.val = val;
			this.next =next;
		}
	}
	
}
