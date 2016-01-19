
public class HugString {
	private CNode front;
	static class CNode {
		String head;
		CNode next;
		public CNode(String head, CNode next){
			this.head = head;
			this.next = next;
		}
	}
	public static CNode makeHugString(String s) {
		HugString h = new HugString();
		h.front = new CNode(""+s.charAt(0),null);
		CNode p = h.front;
		int i = 1;
		while (s.charAt(i)!='\0'){
			p.next = new CNode(""+s.charAt(i),null);
		}
		return h.front;
	}
	public void swapSpace(CNode in) {
		while (in!=null){
			if (in.head == " "){
				in = new CNode("61B",in.next);
			}
			in = in.next;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
