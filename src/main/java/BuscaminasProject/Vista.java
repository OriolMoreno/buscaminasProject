package BuscaminasProject;

public class Vista {

	
	public void menu() {
		
		System.out.println("--------- MENU --------- ");
		System.out.println("\n");
		System.out.println("	1. Jugar");
		System.out.println("\n");
		System.out.println("	2. Sortir");
		System.out.println("\n\n");
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
		System.out.println(sb.toString());
	}
	
	public void escriuMessage(int tipusMissatge) {
		switch (tipusMissatge) {
			case -1:
				System.out.println("Has perdut la partida perque has seleccionat una bomba. \n");
				break;
			case 0:
				System.out.println("Has introduit un input incorrecte.\n");
				break;
			case 2:
				System.out.println("ENHORABONA MAQUINA! Has guanyat la partida.\n");
			default:
				
		}
	}
	
	public void messageInputPartida() {
		System.out.println("Selecciona una coordenada i si vols posar-hi flag o no. \n"
						+ "El programa capta valors en aquest ordre:\n"
						+ "		Coordenada Y(files): un valor entre A i Z\n"
						+ "		Coordenada X(columnes): un valor entre 1 i 9\n"
						+ "		Flag: / (opcional, per si vols marcar que la casella te una bomba)\n"
						+ "Exemple �A1� (cas sense flag) o �A1/� (cas amb flag)");
	}
	
	public void messageInputMenu() {
		System.out.println("Escriu �1� si vols jugar una nova partida o �exit� si vols sortir del programa.");
	}
}