package BuscaminasProject;

public interface Tauler {

	//public int tauler[][];
	public int getWidth();
	public int getHeight();
	public int getCasella(int x, int y);
	public int[][] generateTauler();
	//mockGeneratetauler() nomes el metode com a mock
	public int getNumeroBombesAdjecents(int x, int y);
}
