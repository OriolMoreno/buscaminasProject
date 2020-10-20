package BuscaminasProject;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class Historial {

	private HashMap<String, Integer> puntuacions = new HashMap<String, Integer>();
	
	public Historial() {
		
	}
	
	//https://stackoverflow.com/questions/8119366/sorting-hashmap-by-values
	public LinkedHashMap<String, Integer> getOrderedHistorial() {
		LinkedHashMap<String, Integer> r = new LinkedHashMap<String, Integer>();
		return r;
	}
	
	public boolean afegirPuntuacio(String nom, int puntuacio) {
		return false;
	}
	
	
}
