package BuscaminasProject;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PartidaTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testPartida() { //preguntar si s'ha de fer test dels constructors
		fail("Not yet implemented");
	}
	
	@Test
	public void testJugarPartida() {
		MockInput io = new MockInput(".\\src\\test\\resources\\partida_1.txt");
		Partida p = new Partida();
		
	}
	
	@Test
	public void testGetTauler() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testGetPuntuacio() {
		fail("Not yet implemented");
	}

}
