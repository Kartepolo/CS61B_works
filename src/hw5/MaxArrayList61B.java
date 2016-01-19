
public class MaxArrayList61B<T> extends ArrayList61B<T>{
	private class T implements Comparable<T>{
		public int compareTo(T item){
			return this.toString().compareTo(item.toString());
		}
	}
	public int compareTo(T item){
		return this.
	}
	private boolean add(T item){
		if (item.compareTo(this.get(size()))){
			super.add(item);
		}
		return false;
	}

}
