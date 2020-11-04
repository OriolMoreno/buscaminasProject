package BuscaminasProject;

public interface Tauler {

	//public int tauler[][];
	public int getWidth();
	public int getHeight();
	public int getCasella(int x, int y);
	public int[][] generateTauler();
	public int getNumeroBombesAdjecents(int x, int y);
}
