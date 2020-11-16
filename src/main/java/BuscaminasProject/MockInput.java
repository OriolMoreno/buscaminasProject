package BuscaminasProject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MockInput {
	
	private String fileName;
	private int nMoviment = 0;
	private ArrayList<String> inputs = new ArrayList<String>();
	
	public MockInput(String file) {
		/*fileName = file;
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			String line;
			while((line = br.readLine()) != null) {
				inputs.add(line);
			}
			br.close();
		}catch (IOException e) {
			e.printStackTrace();
		}*/
		switch (file) {
			case ".\\src\\test\\resources\\joc_buclePartida_1.txt":
				String[] in = { "1", "exit" };
				for(int i:in){
					inputs.add(in[i]);
				}
				break;
			case ".\\src\\test\\resources\\joc_buclePartida_moviments.txt":
				String[] in = { "a1", "exit" };
				for(int i:in){
					inputs.add(in[i]);
				}
				break;
			case ".\\src\\test\\resources\\joc_jugarPartida.txt":
				String[] in = { "a2" };
				for(int i:in){
					inputs.add(in[i]);
				}
				break;
			case ".\\src\\test\\resources\\joc_jugarPartida_victoria.txt":
				String[] in = { "A2/","B3/",	"B5/","C4/","C7/","D2/","D4/","D7/","D8/","E6/","E8/","F3/","F5/","F7/","G2/","H6/","I2/","I4/","I5/","I6/","a1","a3","a4","a5","a6","a7","a8","b1","b2","b4","b6","b7","b8","c1","c2","c3","c5","c6","c8","d1","d3","d5","d6","e1","e2","e3","e4","e5","e7","f1","f2","f4","f6","f8","g1","g3","g4","g5","g6","g7","g8","h1","h2","h3","h4","h5","h7","h8","i1","i3","i7","i8" };
				for(int i:in){
					inputs.add(in[i]);
				}
				break;
			case ".\\src\\test\\resources\\partida_1.txt":
				String[] in = { "A1", "A3", "I8", "H8", "I7", "I6" };
				for(int i:in){
					inputs.add(in[i]);
				}
				break;
		}
			
	}
	
	public String readNextMoviment() {
		if(nMoviment < this.getNumeroMoviments()) {
			return inputs.get(nMoviment++);
		}else {
			return "";
		}
				
	}
	
	public int getNumeroMoviments() {
		return inputs.size();
	}

}
