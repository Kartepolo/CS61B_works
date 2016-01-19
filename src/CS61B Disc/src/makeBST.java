
public class makeBST {
	public BSTNode root;
	public static int[] slice(int[] array, int start, int end){
		int[] r = new int[end-start];
		if (start==end) return null;
		for (int k=start;k<end;k++){
			r[k-start] = array[k];
		}
		return r;
	}
	public static class BSTNode{
		public BSTNode left,right;
		public int value;
		public BSTNode(int n){
			this.value = n;
		}
	}
	public static BSTNode make(int[] nums) {
		BSTNode subroot;
		int mid = (nums.length - 1) / 2 ;
		subroot = new BSTNode(nums[mid]);
		int[] left = slice(nums, 0, mid);
		int[] right = slice(nums, mid + 1, nums.length);
		if (left != null) {
			subroot.left = make(left);
			subroot.right = make(right);
		}
		return subroot;
	}
	public makeBST(int[] nums){
		root= make(nums);
	}

}
