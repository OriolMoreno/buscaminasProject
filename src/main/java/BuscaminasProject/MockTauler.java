package BuscaminasProject;

public class MockTauler implements Tauler {
	
	
	private int tauler[][];

	
	public MockTauler(){
		this.tauler = this.generateTauler();
	}
	
	public int getWidth() {
		return tauler[0].length;
	}
	
	public int getHeight() {
		return tauler.length;
	}
	
	public int getCasella(int x, int y) {
		return tauler[x][y];
	}
	
	public int[][] generateTauler() {
		int t[][] = {
				{0, 1, 0, 0, 0, 0, 0, 0},
				{0, 0, 1, 0, 1, 0, 0, 0},
				{0, 0, 0, 1, 0, 0, 1, 0},
				{0, 1, 0, 1, 0, 0, 1, 1},
				{0, 0, 0, 0, 0, 1, 0, 1},
				{0, 0, 1, 0, 1, 0, 1, 0},
				{0, 1, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 1, 0, 0},
				{0, 1, 0, 1, 1, 1, 0, 1}
		};
		return t;
	}
	
	public int getNumeroBombesAdjecents(int x, int y) {
		int total = 0;
		if(this.getCasella(x, y) == 0) {
			if(x > 0 && y > 0 && x < this.getWidth() && y < this.getHeight() { //no estem al contorn
				for(int i = -1; i < 2; i++) {
					for(int j = -1; j < 2; j++) {
						if(this.getCasella(x+i, y+j) == 1) {
							total++;
						}
					}
				}
			}else {
				
			}	
		}else {
			total = -1;
		}
		return total;
	}

}
