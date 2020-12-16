package BuscaminasProject;

import static org.junit.Assert.*;

import org.junit.Test;

public class EcenarisTaulerTest {

	@Test
	public void testGetCasella() {
		MockTauler t = new MockTauler();
		
		int res_0 = t.getCasella(0, 0);
		assertEquals(res_0, 0);
		
		int res_1 = t.getCasella(7, 8);
		assertEquals(res_1, 0);
		
		int res_2 = t.getCasella(8, 7);
		assertEquals(res_2, -11);
		
		int res_3 = t.getCasella(7, 9);
		assertEquals(res_3, -11);
		
		int res_4 = t.getCasella(0, 8);
		assertEquals(res_4, 0);
		
		int res_5 = t.getCasella(3, 3);
		assertEquals(res_5, 1);
		
	}

	@Test
	public void testGetValorAdjMatrix() {
		
		MockTauler t = new MockTauler();
		
		int res_0 = t.getValorAdjMatrix(2, 1);
		assertEquals(res_0, 2);
		
		int res_1 = t.getValorAdjMatrix(1, 2);
		assertEquals(res_1, -1);
		
		int res_3 = t.getValorAdjMatrix(8, 7);
		assertEquals(res_3, 0);
		
		int res_4 = t.getValorAdjMatrix(0, 7);
		assertEquals(res_4, 0);
		
		int res_5 = t.getValorAdjMatrix(12,13);
		assertEquals(res_5, -11);
		
		int res_6 = t.getValorAdjMatrix(-3,-1);
		assertEquals(res_6, -11);	
	}

	@Test
	public void testGenerateTaulerMock() {
		MockTauler t = new MockTauler();
		
		// Cantonades
		assertEquals(t.getCasella(0, 0), 0);
		assertEquals(t.getCasella(0,8), 0);
		assertEquals(t.getCasella(7,0), 0);
		assertEquals(t.getCasella(7,8), 0);
		
		
		assertEquals(t.getCasella(1, 3), 1); // Bomba
		assertEquals(t.getCasella(5, 6), 0); 
	}
	
	@Test
	public void testGetNumeroBombesAdjecents() {
		
		MockTauler t = new MockTauler();
		
		int res_0 = t.getNumeroBombesAdjecents(2, 1);
		assertEquals(res_0, -1);
		
		int res_1 = t.getNumeroBombesAdjecents(7, 8); 
		assertEquals(res_1, 0);
		
		int res_2 = t.getNumeroBombesAdjecents(0, 0);
		assertEquals(res_2, 1);
		
		int res_3 = t.getNumeroBombesAdjecents(1, 7);
		assertEquals(res_3, 2);
		
		int res_4 = t.getNumeroBombesAdjecents(5, 6); 
		assertEquals(res_4, 3);
		
		int res_5 = t.getNumeroBombesAdjecents(2, 2); 
		assertEquals(res_5, 4);
		
		
	}

}
