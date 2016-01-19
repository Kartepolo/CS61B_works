
public class Disc03_2 {
	public class SNode {
		public SNode next;
		public double val;
		public SNode(double val, SNode next) {
		this.next = next;
		this.val = val;
		}
	}
	public class SList{
		private SNode head;
		public SList(){
		}
		public SList(int val){
			head = new SNode(val,null);
		}
		public void S_insert(double val, int position){
			SNode p = head;
			int n = 1;
			while(p!=null && n<position){
				p = p.next;
				n++;
			}
			p.next = new SNode(val,p.next);
			
		}
		
		
	}

}
