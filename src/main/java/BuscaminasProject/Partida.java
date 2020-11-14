package BuscaminasProject;

import java.lang.String;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.LinkedList; 
import java.util.Queue; 


public class Partida {//MODEL

	private Tauler taulerReal;
	/**
	 * a taulerVista hi haura a cada casella el numero de bombes adjacents, -2 si no s'ha 'clickat'
	 * i el valor 9 per marcar si hi ha posat una 'bandera' marcant que l'usuari creu que hi ha una bomba
	 */
	private int[][] taulerVista;
	private int bombesTotals;
	private int flagsUsades;

	
	public Partida(){
		taulerReal = new Tauler();
		bombesTotals = taulerReal.countBombes();
		flagsUsades=0;
		generateVista();
	}
	
	
	
	public int[][] getVistaTauler() {
		return taulerVista;
	}
	
	
	
	public void setMockVistaTauler(int[][] mockTaulerVista) {
		taulerVista=mockTaulerVista;
	}

	
	
	public int getWidth() {
		return taulerVista[0].length;
	}
	
	
	
	public int getHeight() {
		return taulerVista.length;
	}
	
	
	
	public int getCasellaTaulerVista(int x, int y) {
		try {
			return taulerVista[x][y];	
		}catch (IndexOutOfBoundsException e) {
			return -11;
		}
	}
	
	
	
	public void generateVista(){
		//is a method that creates a matrix of the same size of tauler and inicializes it to -2
		//This matrix will be actualized every time the player makes a movment
		
		taulerVista = new int[taulerReal.getHeight()][taulerReal.getWidth()];

		for (int i=0; i<getHeight();i++)
		{
			for (int j=0; j<getWidth();j++)
			{
				taulerVista[i][j] = -2;
			}
		}


	}
	
	 
	
	public int processaMoviment(String input) { //return false if bomb is hit
				
		//method to sanitize input
		//change the input of string to int coordinates -------- inputToCoords(String input) 
		//check if there's a bomb, in the input of parameters in TaulerReal ----- updateVistaTauler(int coordx,int coordy, int flag)
		//update TaulerVista with the new info and returns 
		// check if the game its finish ore win ------- checkGameIsWin()
		
		//and return:
		
		//if normal functioning ==> return 1  
		//if in the input there is no bomb + there are no more bombs in the tauler ==> return 2 
		//if trying to put more flags that game permits => return -2 
		//if bad input typing or out of límits  ==> return 0  
		//if is the end of the game ==> return -1 
		
		
		
		int gameState=0;
		
		int coords[]=inputToCoords(input);
		
		if (coords[0]!=-1 && coords[1]!=-1 && coords[2]!=-1 )
		{
			int aux=updateVistaTauler(coords[0], coords[1], coords[2]);
			if (aux!=-2)
			{
				if (aux!=-1)
				{
					if(checkGameIsWin()) {
						gameState=2;
					}
					else{gameState=1;}
				}
				else 
				{
					gameState=-1;
				}
			}
			else 
			{
				gameState=-2;
			}
		}
		
		return gameState;
	}
	
	public int[] inputToCoords(String input) 
	{
		
		//Method that change the input recibed to coords estandarized with the tauler 
		int coords[] = { -1, -1, -1};
		Pattern patro = Pattern.compile("^([A-Za-z]{1}[1-9]{1}[/]{0,1})$"); //regex to accept only valid input
		Matcher coincideix = patro.matcher(input);
		if(coincideix.matches()) { //input en el format correcte
		
			int x = (int) input.toUpperCase().charAt(0) - 'A';
			int y = (int) input.toUpperCase().charAt(1) - '0' -1;
			
			if (!(x<0 || x>= getHeight()||y<0 || y>= getWidth()) ){
				
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
		//The information taht recibes is in the ranges of the tauler content 
		//because this validation was done in the method inputToCords

		return taulerReal.getValorAdjMatrix(coordx,coordy);
	}
	
	public boolean checkGameIsWin()
	{
		//Method that analyzes if the game is win
		//if it's win returns true
		//is it's not still win returns false
		boolean gameIsWin=true;
		
		int i = 0;
		while (i < taulerVista.length && gameIsWin)
		{
			int j = 0;
			while (j < taulerVista[0].length && gameIsWin)
			{
				if (  taulerVista[i][j]==9 && taulerReal.getCasella(j,i)!=1|| taulerVista[i][j]==-2  )
				{
					gameIsWin= false;
				}
				j++;	
			}
			i++;	
		}
		
		return gameIsWin;
	}
	
	public int updateVistaTauler(int coordx,int coordy, int flag)
	{
		//Method that updates the taulr that sees the user
		
		//it have like to parts:
		
		//1st: show the coord that have been selected
		
		//2nd: show all the coords recursivly that have no bombs surround == that are zeros;  finishing when there is a number
		
		int estatPartida=0;
		
		if( taulerVista[coordx][coordy]==9||taulerVista[coordx][coordy]==-2  )
		{
			
			if (flag==0)
			{		
				//destapem la casella
			    taulerVista[coordx][coordy]=taulerReal.getValorAdjMatrix(coordx,coordy);
			    
				if (taulerReal.getValorAdjMatrix(coordx,coordy)==0) 
				{
					Queue< Integer > queueCoordsx = new LinkedList<>();
					Queue< Integer > queueCoordsy = new LinkedList<>();
					
					queueCoordsx.add(coordx); 
					queueCoordsy.add(coordy); 
		
					
				     while (!queueCoordsx.isEmpty()) 
				     {
						
		
						// extraemos el nodo u de la cola Q y exploramos todos sus nodos adyacentes
				    	 
				    	 int coordAuxX = queueCoordsx.remove(); 
				         int coordAuxY = queueCoordsy.remove(); 
		
				         
				         if(coordAuxX+1 < getHeight() && coordAuxY+1<getWidth()) {
					        
				        	 if (taulerVista[coordAuxX+1][coordAuxY+1]==-2) {
				        		 
				        		 if(taulerReal.getValorAdjMatrix(coordx+1,coordy+1)==0)
						         {
						        	 queueCoordsx.add(coordAuxX+1); 
						 			 queueCoordsy.add(coordAuxY+1); 
						         }
					 			 taulerVista[coordAuxX+1][coordAuxY+1]=taulerReal.getValorAdjMatrix(coordx+1,coordy+1);
				        	 }
				         }
				         
				         
				         
				         if(coordAuxX+1<getHeight()) {

			        	 	if (taulerVista[coordAuxX+1][coordAuxY]==-2 ) {
				        		 
				        		 if(taulerReal.getValorAdjMatrix(coordx+1,coordy)==0)
						         {
						        	 queueCoordsx.add(coordAuxX+1); 
						        	 queueCoordsy.add(coordAuxY);
						         }
					 			 taulerVista[coordAuxX+1][coordAuxY]=taulerReal.getValorAdjMatrix(coordx+1,coordy);
			        	 	}
				         }
				         
				         
				         if(coordAuxX+1<getHeight() && coordAuxY-1>=0) {
					         if (taulerVista[coordAuxX+1][coordAuxY-1]==-2) {
				        		 
				        		 if(taulerReal.getValorAdjMatrix(coordx+1,coordy-1)==0)
						         {
						        	 queueCoordsx.add(coordAuxX+1); 
						        	 queueCoordsy.add(coordAuxY-1);
						         }
					 			 taulerVista[coordAuxX+1][coordAuxY-1]=taulerReal.getValorAdjMatrix(coordx+1,coordy-1); 
					         }
				         }
				         
				         
				         if(coordAuxY+1<getWidth()) {
					         if (taulerVista[coordAuxX][coordAuxY+1]==-2 && taulerReal.getValorAdjMatrix(coordx,coordy+1)==0)
					         {
					        	 queueCoordsx.add(coordAuxX); 
					        	 queueCoordsy.add(coordAuxY+1); 
					         }
					 			 taulerVista[coordAuxX][coordAuxY+1]=taulerReal.getValorAdjMatrix(coordx,coordy+1) ;
					     }
				         
				         
				         if( coordAuxY-1>=0) {
				        	 
				        	 if (taulerVista[coordAuxX][coordAuxY-1]==-2) {
				        		 
				        		 if(taulerReal.getValorAdjMatrix(coordx,coordy-1)==0)
						         {
						        	 queueCoordsx.add(coordAuxX); 
						        	 queueCoordsy.add(coordAuxY-1);
						         }
					 			 taulerVista[coordAuxX][coordAuxY-1]=taulerReal.getValorAdjMatrix(coordx,coordy-1); 
				         
				        	 }
			        	 }
				         
				         if(coordAuxX-1>=0 && coordAuxY+1<getWidth()) {
				        	 
				        	 if (taulerVista[coordAuxX-1][coordAuxY+1]==-2) {
				        		 
				        		 if(taulerReal.getValorAdjMatrix(coordx-1,coordy+1)==0)
			        			 {
						        	 queueCoordsx.add(coordAuxX-1); 
						        	 queueCoordsy.add(coordAuxY+1); 
						         }
					 			 taulerVista[coordAuxX-1][coordAuxY+1]=taulerReal.getValorAdjMatrix(coordx-1,coordy+1);
				        	 }	         
				         }
				         
				         
				         if(coordAuxX-1>=0 && coordAuxY-1>=0) {
				        	 
					         if (taulerVista[coordAuxX-1][coordAuxY-1]==-2) {
				        		 
				        		 if(taulerReal.getValorAdjMatrix(coordx-1,coordy-1)==0)
						         {
						        	 queueCoordsx.add(coordAuxX-1); 
						        	 queueCoordsy.add(coordAuxY-1); 
						         }
					 			 taulerVista[coordAuxX-1][coordAuxY-1]=taulerReal.getValorAdjMatrix(coordx-1,coordy-1);
					         }	
				         }
				         
				         if(coordAuxX-1>=0 ) {   
					         if (taulerVista[coordAuxX-1][coordAuxY]==-2) {
				        		 
				        		 if(taulerReal.getValorAdjMatrix(coordx-1,coordy)==0)
						         {
						        	 queueCoordsx.add(coordAuxX-1); 
						        	 queueCoordsy.add(coordAuxY); 
						         }
					 			 taulerVista[coordAuxX-1][coordAuxY]=taulerReal.getValorAdjMatrix(coordx-1,coordy);
					         }
				         }
				     } 
				}
				else
				{
					if (taulerReal.getValorAdjMatrix(coordx,coordy)==-1)
					{
						//cas bomba trobada (-1)
						estatPartida= -1;
					}
				}
			}
			else 
			{
				if (taulerVista[coordx][coordy]!=9)
				{
					if(flagsUsades<bombesTotals) 
					{
					
						taulerVista[coordx][coordy]=9;
					}
					else 
					{
						estatPartida= -2;

					}
					
				}
				else
				{
					
					taulerVista[coordx][coordy]=-2;
				}
			}
		}
		
		return estatPartida;
	}
	
	public int getBombesTotals() {
		return taulerReal.countBombes();
	}
	
	
	
	public void setMockTaulerPartida(Tauler mockTauler) {
		this.taulerReal=mockTauler;
	}
	
}
