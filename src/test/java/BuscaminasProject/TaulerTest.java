package BuscaminasProject;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TaulerTest {

	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void testGenerateTaulerNoMock() {
		Tauler t = new Tauler();

		int n_bombes=0,acumulador=0;
		for (int i=0; i<t.getHeight();i++){
			for (int j=0; j<t.getWidth();j++){
				
				if( t.getCasella(j, i)==1){
					n_bombes=n_bombes+1;
				}
				if( t.getCasella(j, i)==0){
					acumulador++;
				}
			}
		}
		assertEquals(n_bombes,15);
		assertEquals(acumulador,72-15);

	}
	
	
	@Test
	public void testGenerateAdjMatrix() {
		MockTauler t = new MockTauler();
		int taulerBuit[][] = {{}};
		t.setMockTauler(t.mockGenerateTauler(), taulerBuit);
		
		int result[][] = t.generateAdjMatrix();
		int expectedResult[][] = t.mockGenerateAdjMatrix();
		for(int y = 0; y < result.length; y++) {
			for(int x = 0; x < result[0].length; x++) {
				assertEquals(result[y][x], expectedResult[y][x]);
			}
		}
	}
	
	@Test
	public void testGetWidth() {
		MockTauler t = new MockTauler();
		int res = t.getWidth();
		assertEquals(res, 8);
	}
	
	@Test
	public void testGetHeight() {
		MockTauler t = new MockTauler();
		int res = t.getHeight();
		assertEquals(res, 9);
	}
	
	@Test
	public void testGetCasella() {
		MockTauler t = new MockTauler();
		//VALOR FRONTERA X = min i Y = min
		int res = t.getCasella(0, 0);
		assertEquals(res, 0);
		//VALOR FRONTERA X = max i Y = max
		int res_1 = t.getCasella(7, 8);
		assertEquals(res_1, 0);
		//VALOR VALID min < X < max i min < Y < max
		int res_3 = t.getCasella(3, 3);
		assertEquals(res_3, 1);
		//VALOR INVALID X < min, VALID min < Y < max
		int res_4 = t.getCasella(-1, 3);
		assertEquals(res_4, -11);
		//VALOR VALID min < X < max, INVALID Y > max
		int res_5 = t.getCasella(3, 10);
		assertEquals(res_5, -11);
		//VALOR INVALID X > max, INVALID Y < min
		int res_6 = t.getCasella(15, -3);
		assertEquals(res_6, -11);
	}
		
	
	
	
	@Test
	public void testGetValorAdjMatrix(){
		MockTauler t = new MockTauler();
		//VALOR FRONTERA X = min i Y = min
		int res = t.getValorAdjMatrix(0, 0);
		assertEquals(res, 1);
		//VALOR FRONTERA X = max i Y = max
		int res_1 = t.getValorAdjMatrix(8,7);
		assertEquals(res_1, 0);
		//VALOR VALID min < X < max i min < Y < max
		int res_3 = t.getValorAdjMatrix(3, 3);
		assertEquals(res_3, -1);
		//VALOR INVALID X < min, VALID min < Y < max
		int res_4 = t.getValorAdjMatrix(3,-1);
		assertEquals(res_4, -11);
		//VALOR VALID min < X < max, INVALID Y > max
		int res_5 = t.getValorAdjMatrix(10,3);
		assertEquals(res_5, -11);
		//VALOR INVALID X > max, INVALID Y < min
		int res_6 = t.getValorAdjMatrix(-3,15);
		assertEquals(res_6, -11);	

	}
	
	
	@Test
	public void testGenerateTaulerMock() {
		MockTauler t = new MockTauler();
		//valors frontera
		assertEquals(t.getCasella(0, 0), 0);
		assertEquals(t.getCasella(7,8), 0);
		assertEquals(t.getCasella(7,0), 0);
		assertEquals(t.getCasella(0,8), 0);
		
		//Valors ràndom
		assertEquals(t.getCasella(0, 3), 0);
		assertEquals(t.getCasella(3, 0), 0);
		assertEquals(t.getCasella(1, 3), 1);
		assertEquals(t.getCasella(6, 2), 1);
	}

	
	@Test
	public void testCountBombes() {
		MockTauler t = new MockTauler();
		int res = t.countBombes();
		assertEquals(res, 20);
	}
	
	
	@Test 
	public void testGetNumeroBombesAdjecents() {
		MockTauler t = new MockTauler();
		//BOMBA a la casella
		int res_1 = t.getNumeroBombesAdjecents(1, 0);
		assertEquals(res_1, -1);
		//casella central(en cap marge)
		int res_2 = t.getNumeroBombesAdjecents(4, 7);
		assertEquals(res_2, 4);
		//cantonada dalt-esquerra
		int res_3 = t.getNumeroBombesAdjecents(0, 0); 
		assertEquals(res_3, 1);
		// cantonada baix-esquerra
		int res_4 = t.getNumeroBombesAdjecents(0, 8); 
		assertEquals(res_4, 1);
		// contonada dalt-dreta
		int res_5 = t.getNumeroBombesAdjecents(7, 0); 
		assertEquals(res_5, 0);
		// cantonada baix-dreta
		int res_6 = t.getNumeroBombesAdjecents(7, 8); 
		assertEquals(res_6, 0);
		// contorn esquerre
		int res_7 = t.getNumeroBombesAdjecents(0, 3); 
		assertEquals(res_7, 1);
		//contorn dret
		int res_8 = t.getNumeroBombesAdjecents(7, 7); 
		assertEquals(res_8, 0);
		// contorn dalt
		int res_9 = t.getNumeroBombesAdjecents(2, 0); 
		assertEquals(res_9, 2);
		// contorn baix
		int res_10 = t.getNumeroBombesAdjecents(2, 8); 
		assertEquals(res_10, 2);

	}

}
