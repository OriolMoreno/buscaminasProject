package BuscaminasProject;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PartidaTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testPartida() { 
		fail("Not yet implemented");
	}
	
	@Test
	public void testProcessaMoviment() {
		MockInput io = new MockInput(".\\src\\test\\resources\\partida_1.txt");
		Partida p = new Partida();
		
	}
	
	
	
	

	
	@Test
	public void testInputToCoords() 
	{ 
		Partida p = new Partida();
		
		
		String listAuxInput[]= {"1A","3D","4B","6F"};
		int listAuxCoorectResult[][]= {{0,0},{2,3},{3,2},{5,5}};
		
		for (int i = 0; i < listAuxInput.length; i++) 
		{
			assertEquals(p.inputToCoords(listAuxInput(i), listAuxCoorectResult[i]));
		}
		
		
		int errorReturn[]= {-1,-1};
		
		//ERRORS PER COORD ALFABET
		String listAuxInput2[]= {"1J","1Z","1$","1€","0A","-4A","1a","3d","4b","6f"};
		
		for (int i = 0; i < listAuxInput2.length; i++) 
		{
			assertEquals(p.inputToCoords(listAuxInput2(i), errorReturn));
		}
		
		//ERRORS PER COORD NUMERICA	
		String listAuxInput2[]= {"0A","-4A","10A","100A"};
		
		for (int i = 0; i < listAuxInput2.length; i++) 
		{
			assertEquals(p.inputToCoords(listAuxInput2(i), errorReturn));
		}
		
		//ERRORS PER VALORS MOLT EXTRANYS
		String listAuxInput2[]= {"11111111111111111111111","AAAAAAAAAAAAAAAAAAAAAAAA"};
		
		for (int i = 0; i < listAuxInput2.length; i++) 
		{
			assertEquals(p.inputToCoords(listAuxInput2(i), errorReturn));
		}
		
		//ERRORS PER INERCANVI DE COORDS 	
		String listAuxInput2[]= {"1A","DR","B4","6F"};
		
		for (int i = 0; i < listAuxInput2.length; i++) 
		{
			assertEquals(p.inputToCoords(listAuxInput2(i), errorReturn));
		}
				
		//ERRORS PER CASSOS EXTRANGS
		String listAuxInput2[]= {"1A1","A11","11A","AA1","A1A","1AA"};
		
		for (int i = 0; i < listAuxInput2.length; i++) 
		{
			assertEquals(p.inputToCoords(listAuxInput2(i), errorReturn));
		}
		
		
		
	}
	
	
	@Test
	public void testGetValueOfTauler() { 
		fail("Not yet implemented");
	}
	
	
	
	@Test
	public void testCheckGameIsWin() { 
		fail("Not yet implemented");
	}
	
	
	@Test
	public void  testUpdateVistaTauler() { 
		fail("Not yet implemented");
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
