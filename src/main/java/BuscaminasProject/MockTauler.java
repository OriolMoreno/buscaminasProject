package BuscaminasProject;

public class MockTauler implements Tauler {
	
	
	private int tauler[][]= {
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

	
	public MockTauler(){
		tauler = this.generateTauler();
	}
	
	public int getWidth() {
		return 8;
	}
	
	public int getHeight() {
		return 9;
	}
	
	public int getCasella(int x, int y) {
		try {
			return tauler[y][x];	
		}catch(IndexOutOfBoundsException e) {
			return -1;
		}
		
	}
	
	public int[][] generateTauler() {
		return tauler;
	}
	
	public int getNumeroBombesAdjecents(int x, int y) {
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
		try {
			return adj[y][x];
		}catch (IndexOutOfBoundsException e) {
			return -1;
		}
		
	}

}
