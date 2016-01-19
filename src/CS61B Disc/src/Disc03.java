
public class Disc03 {

	public static void main(String[] args) {
		int[] x = {5,9,14,15};
		int[] r = insert(x,6,2);
		int[] expected = {5,9,6,14,15};
        org.junit.Assert.assertArrayEquals(expected, r);
        SList s = new SList(5);
        s.S_insert(6,3);
        s.S_insert(2,2);
        org.junit.Assert.assertEquals(6.0, s.head.next.val, 1e-10);
        s.S_insert(10,1);
        org.junit.Assert.assertEquals(10.0, s.head.next.val, 1e-10);
        SentinelSList s1 = new SentinelSList();
        s1.insert(5, 2);
        org.junit.Assert.assertEquals(5.0, s1.front.next.val, 1e-10);
        s1.insert(10,0);
        s1.insert(15,0);
        org.junit.Assert.assertEquals(15.0, s1.front.next.val, 1e-10);
        int[] test = {3,2,1};
        int[] xifys = xify(test);
        int[] expectedxy = {3,3,3,2,2,1};
        org.junit.Assert.assertArrayEquals(expectedxy, xifys);
	}
	
	public static int[] insert(int[] x, int val, int position) {
		int l = x.length;
			int[] newArray = new int[l+1];
			for(int n =0;n<position;n++){
				newArray[n] = x[n];
			}
			newArray[position] = val;
			for(int n =position+1;n<l+1;n++){
				newArray[n] = x[n-1];
			}
			return newArray;
		}
	public static class SNode {
		public SNode next;
		public double val;
		public SNode(double val, SNode next) {
		this.next = next;
		this.val = val;
		}
	}
	public static class SList{
		private SNode head;
		public SList(){
		}
		public SList(int val){
			head = new SNode(val,null);
		}
		public void S_insert(double val, int position){
			SNode p = head;
			if (p == null){
				head = new SNode(val,null);
			}else{
			int n = 1;
			while(p.next!=null && n<position){
				p = p.next;
				n++;
			}
			p.next = new SNode(val,p.next);
			}	
		}
		
	}
	
	
	public static class SentinelSList {
		private SNode front;
		private SNode back;
		public SentinelSList() {
		this.back = new SNode(0, null);
		this.front = new SNode(0, back);
		}
		public void insert(double val, int position) {
			SNode p = front;
			int n = 0;
			while (p.next!=back && n <position){
				p = p.next;
				n++;
			}
			p.next = new SNode(val,p.next);
		}
	}
	public static int[] xify(int[] x){
		int newl = 0 ;
		int count = 0;
		for(int i=0;i<x.length;i++){
			newl+= x[i];
		}
		int[] res = new int[newl];
		for(int i=0;i<x.length;i++){
			for(int n=0;n<x[i];n++){
				res[count]=x[i];
				count++;
			}
			
		}
		return res;
	}

}


