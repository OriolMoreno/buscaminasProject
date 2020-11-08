package BuscaminasProject;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MockInputTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testReadNextMoviment() {
		MockInput io = new MockInput("C:\\Users\\Oriol\\Desktop\\Test\\buscaminasProject\\src\\test\\resources\\partida_1.txt");
		String s = io.readNextMoviment();
		assertEquals(s, "A1");
		s = io.readNextMoviment();
		assertEquals(s, "A3");
		s = io.readNextMoviment();
		assertEquals(s, "I8");
		s = io.readNextMoviment();
		assertEquals(s, "H8");
		s = io.readNextMoviment();
		assertEquals(s, "I7");
		s = io.readNextMoviment();
		assertEquals(s, "I6");
		s = io.readNextMoviment();
		assertEquals(s, null);
	}
	
	@Test
	public void testGetNumeroMoviments() {
		MockInput io = new MockInput("C:\\Users\\Oriol\\Desktop\\Test\\buscaminasProject\\src\\test\\resources\\partida_1.txt");
		int res = io.getNumeroMoviments();
		assertEquals(6, res);
		
		
	}

}
