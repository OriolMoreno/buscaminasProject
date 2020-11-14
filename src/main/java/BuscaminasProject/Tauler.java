package BuscaminasProject;

import java.util.Random; 

public class Tauler {//MODEL

	private int tauler[][];
	private int adjMatrix[][];
	
	Tauler(){
		generateTauler();
		this.mockGenerateAdjMatrix();
	}
	
	public int getWidth() {
		return tauler[0].length;
	}
	
	public int getHeight() {
		return tauler.length;
	}
	
	public int getCasella(int x, int y) {
		try {
			return tauler[y][x];	
		}catch (IndexOutOfBoundsException e) {
			return -1;
		}
	}
	
	public int getValorAdjMatrix(int x, int y) {
		try {
			return adjMatrix[x][y];	
		}catch (IndexOutOfBoundsException e) {
			return -11;
		}
	}
	
	public void generateTauler(){
		//TODO
		this.tauler = new int[9][8];
		
		for (int i=0; i<getHeight();i++){
			for (int j=0; j<getWidth();j++){
				this.tauler[i][j]=0;
			}
		}
		
		int n_bombes=15;
		int x, y;
		while(n_bombes!=0)
		{
			x=(int)Math.random() * ( getHeight() - 0 );
			y=(int)Math.random() * ( getWidth() - 0 );
			
			if (this.tauler[x][y]!=-1){
				this.tauler[x][y]=-1;
				n_bombes=n_bombes-1;
			}
			
		}
		
	}
	
	public int[][] mockGeneratetauler(){
		int t[][] = {
				{0, 1, 0, 0, 0, 0, 0, 0},
				{0, 0, 1, 0, 1, 0, 0, 0},
				{0, 0, 0, 1, 0, 0, 1, 0},
				{0, 1, 0, 1, 0, 0, 1, 1},
				{0, 0, 0, 0, 0, 1, 0, 1},
				{0, 0, 1, 0, 1, 0, 1, 0},
				{0, 1, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 1, 0, 0},
				{0, 1, 0, 1, 1, 1, 0, 0}
		};
		return t;
	}
	
	public void generateAdjMatrix(){
		//TO DO
		
	}
	
	public void mockGenerateAdjMatrix(){
		int adj[][] = {
				{1, -1,  2,  2,  1,  1,  0,  0},
				{1,  2, -1,  3, -1,  2,  1,  1},
				{1,  2,  4, -1,  3,  3, -1,  3},
				{1, -1,  3, -1,  3,  3, -1, -1},
				{1,  2,  3,  3,  3, -1,  5, -1},
				{1,  2, -1,  2, -1,  3, -1,  2},
				{1, -1,  2,  2,  2,  3,  2,  1},
				{2,  2,  3,  2,  4, -1,  2,  0},
				{1, -1,  2, -1, -1, -1,  2,  0}
		};
		adjMatrix=(adj);
	}
	
	
	public int countBombes() {
		int nBombes = 0;
		for(int i = 0; i < this.getWidth(); i++) {
			for(int j = 0; j < this.getHeight(); j++) {
				nBombes += this.getCasella(i, j);
			}
		}
		return nBombes;
	}
	
	public int getNumeroBombesAdjecents(int x, int y) {
		int total = 0;
		if(this.getCasella(x, y) == 1) { //en la casella hi ha una bomba
			total = -1;
		}else { //en la casella NO hi ha bomba
			if(x > 0 && y > 0 && x < this.getWidth() - 1 && y < this.getHeight() - 1) { // no estem al contorn
				total += this.getCasella(x+1, y+1);
				total += this.getCasella(x+1, y);
				total += this.getCasella(x+1, y-1);
				total += this.getCasella(x, y+1);
				total += this.getCasella(x, y-1);
				total += this.getCasella(x-1, y+1);
				total += this.getCasella(x-1, y);
				total += this.getCasella(x-1, y-1);
			}else {
				if(x == 0) { //contorn esquerre
					if(y == 0) { //contorn dalt --> cantonada dalt-esquerre
						total += this.getCasella(x+1, y+1);
						total += this.getCasella(x+1, y);
						total += this.getCasella(x,   y+1);
					}else if(y == this.getHeight() - 1) {//contorn inferior --> cantonada baix-esquerre
						total += this.getCasella(x+1, y);
						total += this.getCasella(x+1, y-1);
						total += this.getCasella(x,   y-1);
					}else { //contorn esquerra
						total += this.getCasella(x+1, y+1);
						total += this.getCasella(x+1, y);
						total += this.getCasella(x+1, y-1);
						total += this.getCasella(x,   y+1);
						total += this.getCasella(x,   y-1);
					}
				}else if(x == this.getWidth() - 1) { // contorn dret
					if(y == 0) { //contorn dalt --> cantonada dalt-dreta
						total += this.getCasella(x,   y+1);
						total += this.getCasella(x-1, y);
						total += this.getCasella(x-1, y+1);
					}else if(y == this.getHeight() - 1) {//contorn inferior --> cantonada baix-dreta
						total += this.getCasella(x,   y-1);
						total += this.getCasella(x-1, y);
						total += this.getCasella(x-1, y-1);
					}else { //contorn dreta
						total += this.getCasella(x, y+1);
						total += this.getCasella(x, y-1);
						total += this.getCasella(x-1, y+1);
						total += this.getCasella(x-1, y);
						total += this.getCasella(x-1, y-1);
					}
				}else if(y == 0) { //contorn superior
					total += this.getCasella(x+1, y);
					total += this.getCasella(x-1, y);
					total += this.getCasella(x-1, y+1);
					total += this.getCasella(x,   y+1);
					total += this.getCasella(x+1, y+1);
				}else { //contorn inferior
					total += this.getCasella(x+1, y);
					total += this.getCasella(x-1, y);
					total += this.getCasella(x-1, y-1);
					total += this.getCasella(x,   y-1);
					total += this.getCasella(x+1, y-1);
				}
			}
		}
		return total;
	}
	
	public void setMockTauler(int[][]mockTaulerEspecific, int[][] adjMatrixEspecífic) {
        tauler=mockTaulerEspecific;
        adjMatrix=adjMatrixEspecífic;
   }

	
}
