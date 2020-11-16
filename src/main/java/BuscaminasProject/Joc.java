package BuscaminasProject;

import java.util.Scanner;

public class Joc { //CONTROLADOR
	
	private Partida partida;
	private Vista vista;
	private Scanner scanner;
	
	public static void main(String args[]) {
		Joc j = new Joc();
		j.bucleJoc();
		System.out.println("Programa finalitzat");
	}
	
	public Joc() {
		scanner = new Scanner(System.in);
		vista = new Vista();
		this.partida = new Partida();
	}
	
	public void jugarPartida() {
		this.partida = new Partida();
		vista.pintaPartida(this.partida);
		int estatJoc = 1;
		String input = "";
		do {
			input = this.getInput(false); //get input escriu com ha de ser l'input
			if(!input.equals("exit")) {
				estatJoc = partida.processaMoviment(input);
				vista.pintaPartida(this.partida);
				vista.escriuMessage(estatJoc);	
			}else {
				estatJoc = -1;
			}
		}while (estatJoc == 1 || estatJoc == 0); // input incorrecte = 0, tot be = 1
	}
	
	public void bucleJoc() {
		String inputMenu = "";
		while(!inputMenu.equals("exit")) {
			vista.menu();
			inputMenu = this.getInput(true);
			if(inputMenu.equals("1")) {
				this.jugarPartida();
			}
		}
		
	}
	
	public String getInput(boolean opcioMenuOrPartida) {
		if(opcioMenuOrPartida) {
			vista.messageInputMenu();
		}else {
			vista.messageInputPartida();
		}		
		return scanner.nextLine();
	}
}