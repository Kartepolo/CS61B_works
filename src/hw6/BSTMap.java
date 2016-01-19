import java.util.Stack; 
import java.util.Set;
import java.util.HashSet;
public class BSTMap<K, V> implements Map61B<K, V>{
	private BSTNode root;
	private int size;
	private Stack<BSTNode> stack = new Stack<BSTNode>();
	private class BSTNode implements Comparable<K>{
		private K key;
		private V value;
		private BSTNode left;
		private BSTNode right;
		private int height;
		public BSTNode(K k,V v){
			key = k;
			value = v;
			height = 0;
		}
		public void setleft(BSTNode node){
			this.left = node;
		}
		public void setright(BSTNode node){
			this.right = node;
		}
		public int compareTo(K k){
			return this.key.toString().compareTo(k.toString());
		}
		public boolean isleaf(){
			return height==0;
		}
		public void update(){
			int l, r;
			if (this.left == null) l = 0;
			else l = left.height;
			if (this.right == null) r = 0;
			else r = right.height;
			height = l - r;
		}

	}
	public BSTMap(){
		root = null;
	}
	public BSTMap(K[] keys, V[] values){
		size =0;
		for (int i=0;i<keys.length;i++){
			put (keys[i], values[i]);
		}
	}
	public void put(K key, V val){
		if (root ==null) {
			root = new BSTNode(key,val);
		}else{
			BSTNode current = root;
			while (!current.isleaf()){
				stack.push(current);
				if (current.compareTo(key)<0) current = current.left;
				else current = current.right;
			}
			if (current.compareTo(key)<0) current.setleft(new BSTNode(key,val));
			else current.setright(new BSTNode(key,val));
			stack.push(current);
			while (!stack.isEmpty()){
				current = stack.pop();
				current.update();
				check(current, key);
			}
		}
		size++;
	}
	
	public int size() {
		return size;
	}
	
	public void clear() {
		root = null;
		size = 0;
	}

	public Set<K> keySet() {
		Stack<BSTNode> tmp = traverse(root);
		Set<K> s = new HashSet<K>();
		for (BSTNode n : tmp) {
			s.add(n.key);
		}
		return s;
	}
	
	public boolean containsKey(K key) {
		return keySet().contains(key);
	}
	public V get(K key) {
		Stack<BSTNode> tmp = traverse(root);
		for (BSTNode n : tmp) {
			if (n.key == key) return n.value;
		}
		return null;
	}
	public V remove(K key) {
		return null;
	}
	public V remove(K key, V value) {
		return null;
	}
	private Stack<BSTNode> traverse(BSTNode n) {
		Stack<BSTNode> s = new Stack<BSTNode>();
		if (n.isleaf()) {
			s.add(n);
		}else {
			s.addAll(traverse(n.left));
			s.addAll(traverse(n.right));
		}
		return s;
	}
	private void check(BSTNode node, K key){
		BSTNode next;
		if (node.height < -1) {
			next = node.left;
			if (next.compareTo(key)<0) LL(node);
			else LR(node);
		}else if (node.height > 1){
			next = node.right;
			if (next.compareTo(key)>0) RR(node);
			else RL(node);
		}
			
	}
	private void RR(BSTNode node) {
		BSTNode next = node.right;
		node.setright(next.left);
		next.setleft(node);
		assign_parent (next);
		node.update();
		next.update();
	}
	
	private void assign_parent(BSTNode next) {
		if (stack.isEmpty()) {
			root = next;
		} else {
		BSTNode parent = stack.peek();
		if (parent.compareTo(next.key) < 0) {
			parent.setleft(next);
		} else {
			parent.setright(next);
		}
		}
	}

	
	

	private void LL(BSTNode node){
		BSTNode next = node.left;
		node.setleft(next.right);
		next.setright(node);
		assign_parent (next);
		node.update();
		next.update();
	}
	
	private void LR(BSTNode node) {
		BSTNode next = node.left;
		BSTNode nnext = next.right;
		node.setleft(nnext.right);
		next.setright(nnext.left);
		nnext.setleft(next);
		nnext.setright(node);
		assign_parent (nnext);
		node.update();
		next.update();
		nnext.update();
	}
	
	private void RL(BSTNode node) {
		BSTNode next = node.right;
		BSTNode nnext = next.left;
		node.setright(nnext.right);
		next.setleft(nnext.left);
		nnext.setleft(node);
		nnext.setright(next);
		assign_parent (nnext);
		node.update();
		next.update();
		nnext.update();
	}

}
