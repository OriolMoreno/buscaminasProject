package BuscaminasProject;

java.lang.String

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
	
	public int processaMoviment(String input) { //return false if bomb is hit
				
		//method to sanitize input
		//change the input of string to int coordinates -------- inputToCoords(String input) 
		//check if there's a bomb, in the input of parameters in TaulerReal ----- getValueOfTauler(int coordx,int coordy)
		//update TaulerVista with the new info and returns 
		// check if the game its finish ore win ------- checkGameIsWin()
		//and return:
		//if in the input there is a bomb ==> return 0 
		//if in the input there is no bomb ==> return 1  
		//if in the input there is no bomb + there are no more bombs in the tauler ==> return 2 

		return 0;
	}
	
	private int[] inputToCoords(String input) 
	{
		
		//Method that change the input recibed to coords estandarized with the tauler 
		
		int coords[] = {0,0};
		return coords;
		
	}
	
	private int getValueOfTauler(int coordx,int coordy)
	{
		//Method that gets the value of tauler that the user has input recibed in coordx and coordy

		return 1;
	}
	
	private boolean checkGameIsWin()
	{
		//Method that analyzes if the game is win
		//if it's win returns true
		//is it's not still win returns false
		
		return true;
	}
	
	private void updateVistaTauler(int coordx,int coordy)
	{
		//Method that updates the taulr that sees the user
		
		//it have like to parts:
		
		//1st: show the coord that have been selected
		
		//2nd: show all the coords recursivly that have no bombs surround == that are zeros;  finishing when there is a number 


		
	}
	
	
	public int[][] getVistaTauler() {
		return taulerVista;
	}
	
	//public int getPuntuacio() {
	//	return -1;
	//}
	
	public int getBombesTotals() {
		return -1;
	}
	
	
}
