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
		MockTauler t = new MockTauler();
		assertEquals(t.getCasella(0, 0), 0);
		assertEquals(t.getCasella(0, 3), 0);
		assertEquals(t.getCasella(3, 0), 0);
		assertEquals(t.getCasella(1, 3), 1);
		assertEquals(t.getCasella(6, 2), 1);
	}
	
	
	@Test 
	public void testGetNumeroBombesAdjecents() {
		MockTauler t = new MockTauler();
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
		int res_9 = t.getNumeroBombesAdjecents(7, 8); // cantonada baix-dreta
		assertEquals(res_9, 0);
		int res_11 = t.getNumeroBombesAdjecents(0, 7); // contorn esquerre
		assertEquals(res_11, 2);
		int res_10 = t.getNumeroBombesAdjecents(7, 7); // contorn dreta
		assertEquals(res_10, 0);

	}

}
