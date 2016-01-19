
public class mystack {
	private Node head;
	class Node{
		int val;
		public Node next;
		public Node(int i,Node n){
			val = i;
			next = n;
		}
	}
	public mystack(){
		head = null;
	}
	public mystack(int t){
		head = new Node(t,null);
	}
		public void push(int item){
		head = new Node(item,head);
		}
		public int pop(){
			if (this.is_empty()){
				return 99999;
			}
			int p = head.val;
			head = head.next;
			return p;
		}
	public boolean is_empty(){
		if (head==null){
			return true;
		}return false;
	}

}
