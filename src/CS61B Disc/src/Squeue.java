
public class Squeue {
	mystack main;
	mystack Buffer;
	boolean adding;
	public Squeue(){
		main = new mystack();
		Buffer = new mystack();
		adding = true;
	}
	public void enqueue(int item){
		if (!adding){
			swap(Buffer,main);
			adding = true;
		}
		main.push(item);
	}
	private void swap(mystack a,mystack b){
		while (!a.is_empty()){
			b.push(a.pop());
		}
	}
	public int dequeue(){
		if (adding){
			swap(main,Buffer);
			adding =false;
		}
		int r = Buffer.pop();
		return r;
	}
	public static void main(String[] args){
		Squeue s = new Squeue();
		s.enqueue(1);
		s.enqueue(2);
		s.enqueue(3);
		s.enqueue(4);
		s.enqueue(5);
		System.out.println(s.dequeue());
		System.out.println(s.dequeue());
	}

	
	

}
