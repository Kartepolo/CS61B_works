
public class Piece {
	private boolean isFire,hascaptured,isKing;
	private int x,y;
	private Board Board;
	String type;
	
	public Piece(boolean isFire,Board b,int x, int y,String type){
		this.isFire = isFire;
		this.Board = b;
		this.x = x;
		this.y = y;
		this.type = type;
		hascaptured = false;
	}
	public boolean isFire(){
		return isFire;
	}
	public int side(){
		if (isFire){
			return 0;
		}return 1;
	}
	public boolean isKing(){
		return isKing;
	}
	
	public boolean isbomb(){
		if (type=="bomb") return true;
		else return false;
	}
	public boolean isShield(){
		if (type=="shield") return true;
		else return false;
	}
	public void move(int x, int y) {
		Piece tmp,c;
		int interx = (x+this.x)/2;
		int intery = (y+this.y)/2;
		if (Math.abs(this.x-x)==1){
			interx = this.x;
			intery = this.y;
		}
		c = Board.PieceAt(interx,intery);
		if (c==null) return;
		if (c.side()!=side()){
		   Board.remove(interx,intery);
		   hascaptured = true;
		   if (isbomb()){
			   for (int i =x-1;i<x+2;i++){
				   for (int j =y-1;j<y+2;j++){
					   tmp = Board.PieceAt(i, j);
					   if (tmp!=null && tmp.side()==c.side() && !tmp.isShield()){
						   Board.remove(i,j);
					   }
				   }
			   }   
		   }
		}
		   Board.remove(this.x,this.y);
			this.x = x;
			this.y = y;
			if ((side()==0 && y==7) || (side()==1 && y==0)){
				isKing = true;
			}
	}
	public boolean hasCaptured(){
		return hascaptured;
	} 
	public void doneCapturing(){
		hascaptured = false;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
