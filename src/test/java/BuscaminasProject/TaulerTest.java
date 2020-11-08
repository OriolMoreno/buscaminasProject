package BuscaminasProject;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TaulerTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetWidth() {
		Tauler t = new Tauler();
		int res = t.getWidth();
		assertEquals(res, 8);
	}
	
	@Test
	public void testGetHeight() {
		Tauler t = new Tauler();
		int res = t.getHeight();
		assertEquals(res, 9);
	}
	
	@Test
	public void testGetCasella() {
		Tauler t = new Tauler();
		int res = t.getCasella(0, 0);
		assertEquals(res, 0);
		int res_1 = t.getCasella(1, 0);
		assertEquals(res_1, 1);
		int res_2 = t.getCasella(8, 8);
		assertEquals(res_2, -1);
		int res_3 = t.getCasella(3, 3);
		assertEquals(res_3, 1);
		int res_4 = t.getCasella(6, 8);
		assertEquals(res_4, 0);
	}
	
	@Test
	public void testGenerateTauler() {
		Tauler t = new Tauler();
		assertEquals(t.getCasella(0, 0), 0);
		assertEquals(t.getCasella(0, 3), 0);
		assertEquals(t.getCasella(3, 0), 0);
		assertEquals(t.getCasella(1, 3), 1);
		assertEquals(t.getCasella(6, 2), 1);
	}
	
	@Test
	public void testCountBombes() {
		Tauler t = new Tauler();
		int res = t.countBombes();
		assertEquals(res, 20);
	}
	
	
	@Test 
	public void testGetNumeroBombesAdjecents() {
		Tauler t = new Tauler();// Tauler t sense mock pero cridatn constructor Mock
		int res_1 = t.getNumeroBombesAdjecents(1, 0); // bomba
		assertEquals(res_1, -1);
		int res_2 = t.getNumeroBombesAdjecents(1, 1); // dos bombes adjacents
		assertEquals(res_2, 2);
		int res_3 = t.getNumeroBombesAdjecents(3, 1); // tres bombes adjacents
		assertEquals(res_3, 3);
		int res_4 = t.getNumeroBombesAdjecents(4, 7); // quatre bombes adjacents
		assertEquals(res_4, 4);
		int res_5 = t.getNumeroBombesAdjecents(6, 4); // cinc bombes adjacents
		assertEquals(res_5, 5);
		int res_6 = t.getNumeroBombesAdjecents(0, 0); // cantonada dalt-esquerra
		assertEquals(res_6, 1);
		int res_7 = t.getNumeroBombesAdjecents(0, 8); // cantonada baix-esquerra
		assertEquals(res_7, 1);
		int res_8 = t.getNumeroBombesAdjecents(7, 0); // contonada dalt-dreta
		assertEquals(res_8, 0);
		int res_88 = t.getNumeroBombesAdjecents(0, 3); // contonada dalt-dreta
		assertEquals(res_88, 1);
		int res_11 = t.getNumeroBombesAdjecents(0, 7); // contorn esquerre
		assertEquals(res_11, 2);
		int res_10 = t.getNumeroBombesAdjecents(7, 7); // contorn dreta
		assertEquals(res_10, 0);
		int res_9 = t.getNumeroBombesAdjecents(7, 8); // cantonada baix-dreta
		assertEquals(res_9, 0);
		int res_12 = t.getNumeroBombesAdjecents(2, 0); // contorn dreta
		assertEquals(res_12, 2);
		int res_13 = t.getNumeroBombesAdjecents(2, 8); // cantonada baix-dreta
		assertEquals(res_13, 2);


	}

}
