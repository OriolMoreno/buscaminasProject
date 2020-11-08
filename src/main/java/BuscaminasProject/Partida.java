package BuscaminasProject;

public class Partida {//MODEL

	private Tauler taulerReal;
	/**
	 * a taulerVista hi haura a cada casella el numero de bombes adjacents, res si no s'ha 'clickat'
	 * i algun simbol per marcar si hi ha posat una 'bandera' marcant que hi ha una bomba
	 */
	private int[][] taulerVista;
	private int puntuacio;
	private int bombesTotals;
	
	public Partida(){
		taulerReal = new Tauler();
		bombesTotals = taulerReal.countBombes();
		puntuacio = 0;
	}
	
	public boolean jugarPartida(String input) { //return false if bomb is hit
		//method to sanitize input
		//check if there's a bomb, if all bombs have been flagged, only bombs are left
		//if there is: return false
		//else: method to update taulerVista
		return false;
	}
	
	public int[][] getVistaTauler() {
		return taulerVista;
	}
	
	public int getPuntuacio() {
		return -1;
	}
	
	public int getBombesTotals() {
		return -1;
	}
	
	
}
