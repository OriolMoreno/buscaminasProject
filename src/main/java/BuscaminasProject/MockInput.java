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
		fileName = file;
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			String line;
			while((line = br.readLine()) != null) {
				inputs.add(line);
			}
			br.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String readNextMoviment() {
		if(nMoviment < this.getNumeroMoviments()) {
			return inputs.get(nMoviment++);
		}else {
			return null;
		}
				
	}
	
	public int getNumeroMoviments() {
		return inputs.size();
	}

}
