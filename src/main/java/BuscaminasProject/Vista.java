package BuscaminasProject;

public class Vista {

	
	public void menu() {
		
		System.out.print("--------- MENU --------- ");
		System.out.print("\n");
		System.out.print("	1. Jugar");
		System.out.print("\n");
		System.out.print("	2. Sortir");
		System.out.print("\n\n");
	}
	
	public String transformaVista(int casella) {
		String ret = "";
		switch (casella) {
			case -2:
				ret = "?";
				break;
			case -11:
				ret = "x";
				break;
			case 9:
				ret = "$";
				break;
			case -1:
				ret = "B";
				break;
			case 0:
				ret = " ";
				break;
			default:
				ret = String.valueOf(casella);
				
		}
		return ret;
	}
	
	public void pintaPartida(Partida p) {
		
		StringBuilder sb = new StringBuilder();
		for(int y = 0; y < p.getHeight(); y++) {
			sb.append("A |");
			for(int x = 0; x < p.getWidth(); x++) {
				sb.append("_" + this.transformaVista(p.getCasellaTaulerVista(y, x)) + "_|");
			}	
			sb.append("\n");
		}
		System.out.print(sb.toString());
	}
	
	public void pintaPartidaMock(MockPartida p) {
		
		StringBuilder sb = new StringBuilder();
		for(int y = 0; y < p.getHeight(); y++) {
			sb.append("A |");
			for(int x = 0; x < p.getWidth(); x++) {
				sb.append("_" + this.transformaVista(p.getCasellaTaulerVista(y, x)) + "_|");
			}	
			sb.append("\n");
		}
		System.out.print(sb.toString());
	}
	
	public void escriuMessage(int tipusMissatge) {
		switch (tipusMissatge) {
			case -1:
				System.out.print("Has perdut la partida perque has seleccionat una bomba. \n");
				break;
			case 0:
				System.out.print("Has introduit un input incorrecte.\n");
				break;
			case 2:
				System.out.print("ENHORABONA MAQUINA! Has guanyat la partida.\n");
			default:
				
		}
	}
	
	public void messageInputPartida() {
		System.out.print("Selecciona una coordenada i si vols posar-hi flag o no. \n"
						+ "El programa capta valors en aquest ordre:\n"
						+ "		Coordenada Y(files): un valor entre A i Z\n"
						+ "		Coordenada X(columnes): un valor entre 1 i 9\n"
						+ "		Flag: / (opcional, per si vols marcar que la casella te una bomba)\n"
						+ "Exemple 'A1' (cas sense flag) o 'A1/' (cas amb flag)");
	}
	
	public void messageInputMenu() {
		System.out.print("Escriu '1' si vols jugar una nova partida o 'exit' si vols sortir del programa.");
	}
}