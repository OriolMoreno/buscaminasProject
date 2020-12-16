package BuscaminasProject;

import java.util.Scanner;

public class MockJoc3 { //CONTROLADOR
	
	private MockPartida3 partida;
	private Vista vista;
	private Scanner scanner;
	
	public MockJoc3() {
		scanner = new Scanner(System.in);
		vista = new Vista();
		this.partida = new MockPartida3();
	}
	
	public void jugarPartida(String partidaFile) {
		this.partida = new MockPartida3();
		//vista.pintaPartidaMock(this.partida);
		int estatJoc = 1;
		String input = "";
		MockInput io = new MockInput(partidaFile);
		do {
			input = io.readNextMoviment(); //get input escriu com ha de ser l'input
			if(!input.equals("exit")) {
				estatJoc = partida.processaMoviment(input);
				//vista.pintaPartidaMock(this.partida);
				vista.escriuMessage(estatJoc);	
			}else {
				estatJoc = -1;
			}
		}while (estatJoc == 1 || estatJoc == 0); // input incorrecte = 0, tot be = 1
	}
	
	public void bucleJoc(String partidaFile, String moviments) {
		MockInput io = new MockInput(partidaFile);
		String inputMenu = "";
		while(!inputMenu.equals("exit")) {
			//vista.menu();
			inputMenu = io.readNextMoviment();
			if(inputMenu.equals("1")) {
				this.jugarPartida(moviments);
			}
		}
		System.out.print("Joc finalitzat. \n");
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