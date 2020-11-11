package BuscaminasProject;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PartidaTest {

	//@Before
	public void setUp() throws Exception {
	}

	//@Test
	public void testPartida() { 
		fail("Not yet implemented");
	}
	
	//@Test
	public void testProcessaMoviment() {
		MockInput io = new MockInput(".\\src\\test\\resources\\partida_1.txt");
		Partida p = new Partida();
		fail("Not yet implemented");
	}
	
	
	
	

	
	@Test
	public void testInputToCoordsWithoutFlag() { 
		Partida p = new Partida();
		
		//CONJUNT DE TESTOS SENSE FLAG
		//Test de resultats esperats
		int aux[]= {-1,-1,-1};

		aux=p.inputToCoords("A1");
		assertEquals(aux[0], 0);
		assertEquals(aux[1], 0);
		assertEquals(aux[2], 0);
		
		aux=p.inputToCoords("D3");
		assertEquals(aux[0], 3);
		assertEquals(aux[1], 2);
		assertEquals(aux[2], 0);
		
		aux=p.inputToCoords("B4");
		assertEquals(aux[0], 1);
		assertEquals(aux[1], 3);
		assertEquals(aux[2], 0);
		
		aux=p.inputToCoords("F6");
		assertEquals(aux[0], 5);
		assertEquals(aux[1], 5);
		assertEquals(aux[2], 0);
		
		
		//PARTICIÓ EQUIVALENT RESULTATS CORRECTES MINÚSUCLAS
		String listAuxInput1[]= {"a1","d3","b4","f6","i8"};
		int expectedResult[][]= {{0,0},{3,2},{1,3},{5,5},{8,7}};

		for (int i = 0; i < listAuxInput1.length; i++) 
		{
			aux=p.inputToCoords(listAuxInput1[i]);
			assertEquals(aux[0], expectedResult[i][0]);
			assertEquals(aux[1], expectedResult[i][1]);
			assertEquals(aux[2], 0);
		}
		
		int errorReturn[]= {-1,-1,-1};
		
		//PARTICIÓ EQUIVALENT ERROR EN COORD ALFABET (amb valors límits  i frontera)
		String listAuxInput2[]= {"J1","Z1","$1","€1"};
		
		for (int i = 0; i < listAuxInput2.length; i++) 
		{
			aux=p.inputToCoords(listAuxInput2[i]);
			assertEquals(aux[0], -1);
			assertEquals(aux[1], -1);
			assertEquals(aux[2], -1);
		}

		//PARTICIÓ EQUIVALENT ERROR EN COORD NUMERICA (amb valors límits  i frontera)
		String listAuxInput3[]= {"A0","A-4","A10","A100"};
		
		for (int i = 0; i < listAuxInput3.length; i++) 
		{
			aux=p.inputToCoords(listAuxInput3[i]);
			assertEquals(aux[0], -1);
			assertEquals(aux[1], -1);
			assertEquals(aux[2], -1);
		}

		//PARTICIÓ EQUIVALENT ERRORS PER VALORS MOLT GRANS O MOLT PETITS 	(amb valors límits  i frontera)
		String listAuxInput4[]= {"1111111111111111111111111111111111111111111111111111111111111111111","AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA", "$$$$$$$$$$$$$$$$$$$$$$$$"," ",""};
		
		for (int i = 0; i < listAuxInput4.length; i++) 
		{
			aux=p.inputToCoords(listAuxInput4[i]);
			assertEquals(aux[0], -1);
			assertEquals(aux[1], -1);
			assertEquals(aux[2], -1);
		}
		
		//PARTICIÓ EQUIVALENT INERCANVI DE COORDS 
		String listAuxInput5[]= {"1A","3D","4B","6F"};
		
		for (int i = 0; i < listAuxInput5.length; i++) 
		{
			aux=p.inputToCoords(listAuxInput5[i]);
			assertEquals(aux[0], -1);
			assertEquals(aux[1], -1);
			assertEquals(aux[2], -1);
		}
				
	
		//ERRORS PER CASSOS EXTRANGS
		String listAuxInput6[]= {"1A1","A11","11A","AA1","A1A","1AA"};
		
		for (int i = 0; i < listAuxInput6.length; i++) 
		{
			aux=p.inputToCoords(listAuxInput6[i]);
			assertEquals(aux[0], -1);
			assertEquals(aux[1], -1);
			assertEquals(aux[2], -1);
		}
		
		
		
	}
	

	@Test
	public void testInputToCoordsWithFlag() { 
		Partida p = new Partida();
		
		//CONJUNT DE TESTOS AMB FLAG
		//Test de resultats correctes
		int aux[]= {-1,-1,-1};

		aux=p.inputToCoords("A1/");
		assertEquals(aux[0], 0);
		assertEquals(aux[1], 0);
		assertEquals(aux[2], 1);
		
		aux=p.inputToCoords("D3/");
		assertEquals(aux[0], 3);
		assertEquals(aux[1], 2);
		assertEquals(aux[2], 1);
		
		aux=p.inputToCoords("B4/");
		assertEquals(aux[0], 1);
		assertEquals(aux[1], 3);
		assertEquals(aux[2], 1);
		
		aux=p.inputToCoords("F6/");
		assertEquals(aux[0], 5);
		assertEquals(aux[1], 5);
		assertEquals(aux[2], 1);

		//PARTICIÓ EQUIVALENT RESULTATS CORRECTES MINÚSUCLAS
		String listAuxInput1[]= {"a1/","d3/","b4/","f6/"};
		int expectedResult[][]= {{0,0},{3,2},{1,3},{5,5}};

		for (int i = 0; i < listAuxInput1.length; i++) 
		{
			aux=p.inputToCoords(listAuxInput1[i]);
			assertEquals(aux[0], expectedResult[i][0]);
			assertEquals(aux[1], expectedResult[i][1]);
			assertEquals(aux[2], 1);
		}
		
		int errorReturn[]= {-1,-1,-1};
		
		//PARTICIÓ EQUIVALENT ERROR EN COORD ALFABET (amb valors límits  i frontera)
		String listAuxInput2[]= {"J1/","Z1/","$1/","€1/"};
		
		for (int i = 0; i < listAuxInput2.length; i++) 
		{
			aux=p.inputToCoords(listAuxInput2[i]);
			assertEquals(aux[0], -1);
			assertEquals(aux[1], -1);
			assertEquals(aux[2], -1);
		}

		//PARTICIÓ EQUIVALENT ERROR EN COORD NUMERICA (amb valors límits  i frontera)
		String listAuxInput3[]= {"A0/","-A4/","A9/","A10/","A100/"};
		
		for (int i = 0; i < listAuxInput3.length; i++) 
		{
			aux=p.inputToCoords(listAuxInput3[i]);
			assertEquals(aux[0], -1);
			assertEquals(aux[1], -1);
			assertEquals(aux[2], -1);
		}

		//PARTICIÓ EQUIVALENT ERRORS PER VALORS MOLT GRANS O MOLT PETITS 	(amb valors límits  i frontera)
		String listAuxInput4[]= {"1111111111111111111111111111111111111111111111111111111111111111111/","AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA/", "$$$$$$$$$$$$$$$$$$$$$$$$/"," /","/"};
		
		for (int i = 0; i < listAuxInput4.length; i++) 
		{
			aux=p.inputToCoords(listAuxInput4[i]);
			assertEquals(aux[0], -1);
			assertEquals(aux[1], -1);
			assertEquals(aux[2], -1);
		}
		
		//PARTICIÓ EQUIVALENT INERCANVI DE COORDS 
		String listAuxInput5[]= {"1A/","3D/","4B/","6F/"};
		
		for (int i = 0; i < listAuxInput5.length; i++) 
		{
			aux=p.inputToCoords(listAuxInput5[i]);
			assertEquals(aux[0], -1);
			assertEquals(aux[1], -1);
			assertEquals(aux[2], -1);
		}
				
	
		//ERRORS PER CASSOS EXTRANGS
		String listAuxInput6[]= {"1A1/","A11/","11A/","AA1/","A1A/","1AA/"};
		
		for (int i = 0; i < listAuxInput6.length; i++) 
		{
			aux=p.inputToCoords(listAuxInput6[i]);
			assertEquals(aux[0], -1);
			assertEquals(aux[1], -1);
			assertEquals(aux[2], -1);
		}
	}
	@Test
	public void testGetValueOfTauler() { 
		Partida p = new Partida();
		
		//La única partició son els cassos de proba amb valors coorectes ja que en el metode inputToCords ja 
		// s'ha validat que les coordenades siguin pertanyents al tauler de la partida
		
		//Values frontera i possibles values problemàtics del mig
		assertEquals(p.getValueOfTauler(0, 0), 1);
		assertEquals(p.getValueOfTauler(8, 7), 0);
		assertEquals(p.getValueOfTauler(0, 4), 1);
		assertEquals(p.getValueOfTauler(3, 7), -1);
		assertEquals(p.getValueOfTauler(5, 6), -1);
		
		//THE MOCK TAULER
		//		{1, -1,  2,  2,  1,  1,  0,  0},
		//		{1,  2, -1,  3, -1,  2,  1,  1},
		//		{1,  2,  4, -1,  3,  3, -1,  3},
		//		{1, -1,  3, -1,  3,  3, -1, -1},
		//		{1,  2,  3,  3,  3, -1,  5, -1},
		//		{1,  2, -1,  2, -1,  3, -1,  2},
		//		{1, -1,  2,  2,  2,  3,  2,  1},
		//		{2,  2,  3,  2,  4, -1,  2,  0},
		//		{1, -1,  2, -1, -1, -1,  2,  0}
				
	}
	
	
	
	//@Test
	public void testCheckGameIsWin() { 
		fail("Not yet implemented");
	}
	
	
	//@Test
	public void  testUpdateVistaTauler() { 
		fail("Not yet implemented");
	}
	
	
	//@Test
	public void testGetTauler() {
		fail("Not yet implemented");
	}
	
	//@Test
	public void testGetPuntuacio() {
		fail("Not yet implemented");
	}

}
