package BuscaminasProject;

import java.lang.String;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Partida {//MODEL

	private Tauler taulerReal;
	/**
	 * a taulerVista hi haura a cada casella el numero de bombes adjacents, res si no s'ha 'clickat'
	 * i algun simbol per marcar si hi ha posat una 'bandera' marcant que hi ha una bomba
	 */
	private int[][] taulerVista;
	private int bombesTotals;
	
	public Partida(){
		taulerReal = new Tauler();
		bombesTotals = taulerReal.countBombes();
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
	/**
	 * 
	 * @param input
	 * @return an int array of length 3, first element is x coordinate,
	 * 		   second element is y coordinate and third is input is to 
	 * 		   flag(1) or not(0)
	 */
	public int[] inputToCoords(String input) 
	{
		
		//Method that change the input recibed to coords estandarized with the tauler 
		int coords[] = { -1, -1, -1};
		Pattern patro = Pattern.compile("^([-]?[A-Za-z]{1}[1-9]{1}[/]{0,1})$"); //regex to accept only valid input
		Matcher coincideix = patro.matcher(input);
		if(coincideix.matches()) { //input en el format correcte
		
			boolean correctValue=true;
			
			int x = (int) input.toUpperCase().charAt(0) - 'A';
			
			
			
			int y = (int) input.toUpperCase().charAt(1) - '0' -1;
			if (x<0 || x>= taulerReal.getHeight()||y<0 || y>= taulerReal.getWidth()) {
				correctValue=false;
			}
			
			if(correctValue) 
			{
			
				coords[0] = x;
				coords[1] = y;
			
			
				if(input.length() == 3) 
				{ 
					// with flag
					coords[2] = 1;
				}else 
				{
					//not a flag
					coords[2] = 0;
				}
			
			}
		
		}
		return coords;
	}
	
	public int getValueOfTauler(int coordx,int coordy)
	{
		//Method that gets the value of tauler that the user has input recibed in coordx and coordy

		return 1;
	}
	
	public boolean checkGameIsWin()
	{
		//Method that analyzes if the game is win
		//if it's win returns true
		//is it's not still win returns false
		
		return true;
	}
	
	public void updateVistaTauler(int coordx,int coordy)
	{
		//Method that updates the taulr that sees the user
		
		//it have like to parts:
		
		//1st: show the coord that have been selected
		
		//2nd: show all the coords recursivly that have no bombs surround == that are zeros;  finishing when there is a number 


		
	}
	
	
	public int[][] getVistaTauler() {
		return taulerVista;
	}
	
	
	public int getBombesTotals() {
		return -1;
	}
	
	
}
