import java.util.AbstractList;
public class ArrayList61B<ele> extends AbstractList<ele>{
	private ele[] array;
	private int number;
	
	public ArrayList61B(int initialCapacity){
		if (initialCapacity>=1){
		array = (ele[]) new Object[initialCapacity];
		number = 0;
		}
		throw new IllegalArgumentException();
	}
	public ArrayList61B(){
		array = (ele[]) new Object[1];
		number =0;
	}
	public ele get(int i){
		if (i>=0 && i<number){
			return array[i];
		}
		throw new IllegalArgumentException();
	}
	public boolean add(ele item){
		if (size()>=array.length){
			ele[] newarray = (ele[]) new Object[array.length*2];
			for(int i =0;i<size();i++){
				newarray[i] = array[i];
			}
			array = newarray;
		}
		array[size()] = item;
		number++;
		return true;
	}
	
	public int size(){
		return number;
	}

}
