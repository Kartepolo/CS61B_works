
public class Board {
	private Piece pieces[][];
	private int Fires,Waters;
	private String[] sides = {"-fire","-water"};
	private Piece selection;
	private int selectedx,selectedy;
	private boolean notmoved;
	private boolean Fire_turn;
	
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x,y;
		Board b = new Board(false);
        while(b.winner()==null){
        	if (StdDrawPlus.isNPressed()) b = new Board(false); 
            b.drawBoard();
            b.drawCheckers(false);
        	if (StdDrawPlus.mousePressed()) {
                x = (int)StdDrawPlus.mouseX();
                y = (int)StdDrawPlus.mouseY();
                if (b.canSelect(x,y)) b.select(x,y);
                System.out.println("Fires: "+b.Fires +" Waters: "+b.Waters);
        	}
            if (b.canEndTurn()){
             	if(StdDrawPlus.isSpacePressed()) b.endTurn();
            }
            StdDrawPlus.show(10);
        }
        System.out.println(b.winner()+" wins!");
	}
	public Board(boolean shouldBeEmpty){
        StdDrawPlus.setXscale(0, 8);
        StdDrawPlus.setYscale(0, 8);
        notmoved  = true;
        selection = null;
        Fire_turn = true;
    	pieces = new Piece[8][8];
    	selectedx = selectedy =999;
    	Fires = Waters = 12;
		if (shouldBeEmpty){
			return;
		}
    	drawBoard();
    	drawCheckers(true);
    }
	private void drawBoard(){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
            	if (selectedx==i && selectedy==j) StdDrawPlus.setPenColor(StdDrawPlus.WHITE);
            	else if ((i + j) % 2 == 0) StdDrawPlus.setPenColor(StdDrawPlus.GRAY);
                else                  StdDrawPlus.setPenColor(StdDrawPlus.RED);
                StdDrawPlus.filledSquare(i + .5, j + .5, .5);
            }
        }
	}
    private void drawCheckers(boolean start) {
		int side,tmp;
		String type;
		Piece p;
		for (int j = 0; j < 8; j++) {
        	for (int i = 0; i < 8; i++) {
            	if(start){
                	side = j /4;
                	if (j>3){
                		tmp = 7-j;
                	}else{
                		tmp = j;
                	}
                    if ((i + j) % 2 == 0) {
                    	if (tmp==0){
                    		type = "pawn";
                    	}else if(tmp==1){
                    		type = "shield";
                    	}else if (tmp ==2){
                    		type = "bomb";
                    	}else{
                    		type = "";
                    	}
                    	if (type!=""){
                    	pieces[i][j] = new Piece(side==0,this,i,j,type);
                    	}
                    	}
                    }
            	p = pieces[i][j];
                if (p!=null)  place(pieces[i][j],i,j);
            }
    	}

    }
	public Piece PieceAt(int x,int y){
		if (x<0 || x>7 || y<0 || y>8){
			return null;
		}
		return pieces[x][y];
	}
	public void place(Piece p, int x, int y){
		// this method moves Piece p to position x,y, overriding any piece that is placed at x,y;
		// p must exist
			if (PieceAt(x,y)==null){
			if (selection!=null){ 
				p.move(x, y);
			}
			pieces[x][y] = p;
			if (p.isFire()){
				Fires++;
			}else{
				Waters++;
			}
			}
			drawPiece(p,x,y);
	}
	private void drawPiece(Piece p,int x,int y){
		String path;
		if (p!=null){
		path = "img/"+p.type+sides[p.side()];
		if (p.isKing()){
			path = path+"-crowned";
		}
    	StdDrawPlus.picture(x+ .5, y + .5,path+".png",1,1);
		}
	}
	public Piece remove(int x,int y){
		Piece p = PieceAt(x,y);
		if (p!=null){
			if (p.isFire()){
				Fires--;
			}else{
				Waters--;
			}
			pieces[x][y] = null;
            if ((x + y) % 2 == 0) {
            	StdDrawPlus.setPenColor(StdDrawPlus.GRAY);
            }else{
            	StdDrawPlus.setPenColor(StdDrawPlus.RED);
            }
            StdDrawPlus.filledSquare(x + .5, y + .5, .5);
		}
		return p;
	}
	private static int modifier(Piece p){
		if (!p.isKing()){
			return 1-2*p.side();
		}else{
			return 0;
		}
	}
	private boolean readytocapture(int x,int y){
		Piece p = pieces[x][y];
		Piece tmp;
		int modifier = modifier(p);
		int[][] candidates = {{x+1,y+modifier},{x-1,y+modifier}};
		if (modifier ==0) candidates = new int[][] {{x+1,y+1},{x-1,y+1},{x-1,y-1},{x-1,y-1}};
		for (int[] c : candidates){
			tmp = PieceAt(c[0],c[1]);
			if (tmp!=null){
			if (PieceAt(c[0],c[1]).side()!=p.side()){
				return true;
			}
			}
		}
		return false;
	}
	private boolean validmove(int xi,int yi,int xf,int yf){
		Piece p = PieceAt(xi,yi);
		int diffx,diffy;
		diffx = xf-xi;
		diffy = yf-yi;
		if (diffy*modifier(p)>=0 && Math.abs(diffx)==Math.abs(diffy) && Math.abs(diffy)<=2){
			if (PieceAt(diffx/2+xi,diffy/2+yi)!=null) return true;
			}
		return false;
	}
	public void select(int x, int y){
		Piece p = PieceAt(x,y);
		if (p==null){
		place(selection, x, y);
		notmoved = false;
		}
		updateselect(x,y);
	}
	private void updateselect(int x,int y){
		selection = pieces[x][y];
		selectedx = x;
		selectedy = y;
	}
	public boolean canSelect(int x, int y){
		boolean condition1,condition2;
		Piece p = PieceAt(x,y);
			if (p!=null && !p.equals(selection)){
				if (p.isFire()==Fire_turn){
				return selection==null || notmoved;
				}
			}else{
				if (selection!=null){
					condition1 = notmoved && validmove(selectedx,selectedy,x,y);
					condition2 = selection.hasCaptured() && validmove(selectedx,selectedy,x,y) && selection.type =="pawn" && readytocapture(selectedx,selectedy);
					return condition1 || condition2;
				}
			}
		return false;
	}
	public boolean canEndTurn(){
		if (selection!=null){
			return !notmoved || selection.hasCaptured();
		}
		return false;
	}
	public void endTurn(){
		Fire_turn = !Fire_turn;
		selection.doneCapturing();
		selection = null;
    	selectedx = selectedy =999;
		notmoved = true;
	}
	public String winner(){
		String message;
		if (Fires> 0 && Waters>0){
			return null;
		}
		if (Fires==0){
			message = "Water";
		}else if (Waters==0){
			message = "Fire";
		}else{
			message = "No one";
		}
		return message;
	}

}
