package list;

public class LockDList extends DList{
	
	protected LockDListNode newnode(Object item, DListNode prev, DListNode next) {
		return new LockDListNode(item, prev, next);
	}
	public void locknode(DListNode node) {
		if (node instanceof LockDListNode) ((LockDListNode)node).locked = true;
		else throw new IllegalArgumentException();
	}
	
	public void remove(DListNode node) {
		if (node instanceof LockDListNode && node!=null && !((LockDListNode) node).locked) {
			super.remove(node);
		}
	}

	public static void main(String[] args) {
		DList d = new LockDList();
		d.insertBack(1);
		d.insertBack(2);
		d.insertBack(3);
		DListNode n = new DListNode(2,d.front(),d.back());
		DListNode nt = new LockDListNode(2,d.front(),d.back());
		System.out.println(d.toString());
		((LockDList)d).locknode(n); //now it shall run!
		

	}

}
