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
	
	
	@Test
	public void testGenerateVista() { 
		Partida p = new Partida();
		
		assertEquals(p.taulerReal.tauler[0].length, p.taulerVista[0].length);
		assertEquals(p.taulerReal.tauler.length, p.taulerVista.length);
		
		for (int i=0; i<p.taulerReal.tauler.length;i++){
			for (int j=0; j<p.taulerReal.tauler[0].length;j++){
				assertEquals(p.taulerVista[i][j], -2);
			}
		}


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
	
	
	@Test
	public void  testUpdateVistaTaulerWithOutFlag() { 
		Partida p = new Partida();
		boolean bombaTrobada=false;
		//PARTICIÓ EQUIVALENT DE CASOS SENSE FLAG
		//TEST CASE CASELLA JA DESTAPADA SENSE FLAG
		int vistaInicial[][] = {
				{-2,-2,-2,-2, 1, 1, 0, 0},
				{-2,-2,-2,-2,-2,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2,-2,-2},	
				{-2,-2,-2,-2,-2,-2,-2,-2},				
				{-2,-2,-2,-2,-2,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2,-2,-2},
			};
		p.taulerVista= vistaInicial;
		
		int expectedTaulerVista[][] = {
				{-2,-2,-2,-2, 1, 1, 0, 0},
				{-2,-2,-2,-2,-2,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2,-2,-2},	
				{-2,-2,-2,-2,-2,-2,-2,-2},				
				{-2,-2,-2,-2,-2,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2,-2,-2},
		};
		
		
		bombaTrobada=p.updateVistaTauler(0, 6, 0);
		assertEquals(bombaTrobada, false);
		
		
		for (int i=0; i<p.taulerReal.tauler.length;i++){
			for (int j=0; j<p.taulerReal.tauler[0].length;j++){
				assertEquals(p.taulerVista[i][j], expectedTaulerVista[i][j]);
			}
		}

		
		
		//TEST CASE CASELLA SENSE ZEROS AL VOLTANT
		int vistaInicial2[][] = {
				{-2,-2,-2,-2, 1, 1, 0, 0},
				{-2,-2,-2,-2,-2,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2,-2,-2},	
				{-2,-2,-2,-2,-2,-2,-2,-2},				
				{-2,-2,-2,-2,-2,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2,-2,-2},
			};
		p.taulerVista= vistaInicial2;
		
		int expectedTaulerVista2[][] = {
				{-2,-1,-2,-2, 1, 1, 0, 0},
				{-2,-2,-2,-2,-2,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2,-2,-2},	
				{-2,-2,-2,-2,-2,-2,-2,-2},				
				{-2,-2,-2,-2,-2,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2,-2,-2},
		};
		
		
		bombaTrobada=p.updateVistaTauler(0, 1, 0);
		assertEquals(bombaTrobada, true);
		
		for (int i=0; i<p.taulerReal.tauler.length;i++){
			for (int j=0; j<p.taulerReal.tauler[0].length;j++){
				assertEquals(p.taulerVista[i][j], expectedTaulerVista2[i][j]);
			}
		}
		
		
		//TEST CASE AMB ZEROS AL VOLTANT ( SENSE SELECCIONAR CAP CASELLA A ZERO)
		int vistaInicial3[][] = {
				{-2,-2,-2,-2, 1, 1, 0, 0},
				{-2,-2,-2,-2,-2, 2, 1, 1},
				{-2,-2,-2,-2,-2,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2,-2,-2},	
				{-2,-2,-2,-2,-2,-2,-2,-2},				
				{-2,-2,-2,-2,-2,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2,-2,-2},
			};
		p.taulerVista= vistaInicial3;
		
		int expectedTaulerVista3[][] = {
				{-2,-2,-2,-2, 1, 1, 0, 0},
				{-2,-2,-2,-2,-2, 2, 1, 1},
				{-2,-2,-2,-2,-2,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2,-2,-2},	
				{-2,-2,-2,-2,-2,-2,-2,-2},				
				{-2,-2,-2,-2,-2,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2, 2,-2},
				{-2,-2,-2,-2,-2,-2,-2,-2},
		};
		
		bombaTrobada=p.updateVistaTauler(7, 6, 0);
		assertEquals(bombaTrobada, false);
		
		for (int i=0; i<p.taulerReal.tauler.length;i++){
			for (int j=0; j<p.taulerReal.tauler[0].length;j++){
				assertEquals(p.taulerVista[i][j], expectedTaulerVista3[i][j]);
			}
		}
		
		
		//TEST CASE AMB ZEROS AL VOLTANT ( SENSE SELECCIONAR CAP CASELLA A ZERO) 2
		int vistaInicial4[][] = {
				{-2,-2,-2,-2, 1,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2,-2,-2},	
				{-2,-2,-2,-2,-2,-2,-2,-2},				
				{-2,-2,-2,-2,-2,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2, 2, 0},
				{-2,-2,-2,-2,-2,-2,-2, 0},
			};
		p.taulerVista= vistaInicial4;
		
		int expectedTaulerVista4[][] = {
				{-2,-2,-2,-2, 1, 1, -2,-2},
				{-2,-2,-2,-2,-2,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2,-2,-2},	
				{-2,-2,-2,-2,-2,-2,-2,-2},				
				{-2,-2,-2,-2,-2,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2, 2, 0},
				{-2,-2,-2,-2,-2,-2,-2, 0},
		};
		
		
		bombaTrobada=p.updateVistaTauler(0, 5, 0);
		assertEquals(bombaTrobada, false);
		
		for (int i=0; i<p.taulerReal.tauler.length;i++){
			for (int j=0; j<p.taulerReal.tauler[0].length;j++){
				assertEquals(p.taulerVista[i][j], expectedTaulerVista4[i][j]);
			}
		}
		
		
		//TEST CASE AMB ZEROS AL VOLTANT SELECCIONANT NA CASELLA A ZERO
		int vistaInicial5[][] = {
				{-2,-2,-2,-2, 1,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2,-2,-2},	
				{-2,-2,-2,-2,-2,-2,-2,-2},				
				{-2,-2,-2,-2,-2,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2, 2, 0},
				{-2,-2,-2,-2,-2,-2,-2, 0},
			};
		p.taulerVista= vistaInicial5;
		
		int expectedTaulerVista5[][] = {
				{-2,-2,-2,-2, 1, 1, 0, 0},
				{-2,-2,-2,-2,-2, 2, 1, 1},
				{-2,-2,-2,-2,-2,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2,-2,-2},	
				{-2,-2,-2,-2,-2,-2,-2,-2},				
				{-2,-2,-2,-2,-2,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2, 2, 0},
				{-2,-2,-2,-2,-2,-2,-2, 0},
		};
		
		
		bombaTrobada=p.updateVistaTauler(0, 6, 0);
		assertEquals(bombaTrobada, false);
		
		for (int i=0; i<p.taulerReal.tauler.length;i++){
			for (int j=0; j<p.taulerReal.tauler[0].length;j++){
				assertEquals(p.taulerVista[i][j], expectedTaulerVista5[i][j]);
			}
		}
	}
	
	@Test
	public void  testUpdateVistaTaulerWithFlag() { 
		Partida p = new Partida();
		boolean bombaTrobada=false;
		//PARTICIÓ EQUIVALENT DE CASOS SENSE FLAG
		//TEST CASE CASELLA JA DESTAPADA SENSE FLAG
		int vistaInicial[][] = {
				{-2,-2,-2,-2, 1, 1, 0, 0},
				{-2,-2,-2,-2,-2,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2,-2,-2},	
				{-2,-2,-2,-2,-2,-2,-2,-2},				
				{-2,-2,-2,-2,-2,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2,-2,-2},
			};
		p.taulerVista= vistaInicial;
		
		int expectedTaulerVista[][] = {
				{-2,-2,-2,-2, 1, 1, 0, 0},
				{-2,-2,-2,-2,-2,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2,-2,-2},	
				{-2,-2,-2,-2,-2,-2,-2,-2},				
				{-2,-2,-2,-2,-2,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2,-2,-2},
		};
		
		
		bombaTrobada=p.updateVistaTauler(0, 6, 1);
		assertEquals(bombaTrobada, false);
		
		
		for (int i=0; i<p.taulerReal.tauler.length;i++){
			for (int j=0; j<p.taulerReal.tauler[0].length;j++){
				assertEquals(p.taulerVista[i][j], expectedTaulerVista[i][j]);
			}
		}

		
		
		//TEST CASE CASELLA SENSE ZEROS AL VOLTANT
		int vistaInicial2[][] = {
				{-2,-2,-2,-2, 1, 1, 0, 0},
				{-2,-2,-2,-2,-2,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2,-2,-2},	
				{-2,-2,-2,-2,-2,-2,-2,-2},				
				{-2,-2,-2,-2,-2,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2,-2,-2},
			};
		p.taulerVista= vistaInicial2;
		
		int expectedTaulerVista2[][] = {
				{-2, 9,-2,-2, 1, 1, 0, 0},
				{-2,-2,-2,-2,-2,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2,-2,-2},	
				{-2,-2,-2,-2,-2,-2,-2,-2},				
				{-2,-2,-2,-2,-2,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2,-2,-2},
		};
		
		
		bombaTrobada=p.updateVistaTauler(0, 1, 1);
		assertEquals(bombaTrobada, false);
		
		for (int i=0; i<p.taulerReal.tauler.length;i++){
			for (int j=0; j<p.taulerReal.tauler[0].length;j++){
				assertEquals(p.taulerVista[i][j], expectedTaulerVista2[i][j]);
			}
		}
		
		
		//TEST CASE AMB ZEROS AL VOLTANT ( SENSE SELECCIONAR CAP CASELLA A ZERO)
		int vistaInicial3[][] = {
				{-2,-2,-2,-2, 1, 1, 0, 0},
				{-2,-2,-2,-2,-2, 2, 1, 1},
				{-2,-2,-2,-2,-2,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2,-2,-2},	
				{-2,-2,-2,-2,-2,-2,-2,-2},				
				{-2,-2,-2,-2,-2,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2,-2,-2},
			};
		p.taulerVista= vistaInicial3;
		
		int expectedTaulerVista3[][] = {
				{-2,-2,-2,-2, 1, 1, 0, 0},
				{-2,-2,-2,-2,-2, 2, 1, 1},
				{-2,-2,-2,-2,-2,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2,-2,-2},	
				{-2,-2,-2,-2,-2,-2,-2,-2},				
				{-2,-2,-2,-2,-2,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2, 9,-2},
				{-2,-2,-2,-2,-2,-2,-2,-2},
		};
		
		bombaTrobada=p.updateVistaTauler(7, 6, 1);
		assertEquals(bombaTrobada, false);
		
		for (int i=0; i<p.taulerReal.tauler.length;i++){
			for (int j=0; j<p.taulerReal.tauler[0].length;j++){
				assertEquals(p.taulerVista[i][j], expectedTaulerVista3[i][j]);
			}
		}
		
		
		//TEST CASE AMB ZEROS AL VOLTANT ( SENSE SELECCIONAR CAP CASELLA A ZERO) 2
		int vistaInicial4[][] = {
				{-2,-2,-2,-2, 1,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2,-2,-2},	
				{-2,-2,-2,-2,-2,-2,-2,-2},				
				{-2,-2,-2,-2,-2,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2, 2, 0},
				{-2,-2,-2,-2,-2,-2,-2, 0},
			};
		p.taulerVista= vistaInicial4;
		
		int expectedTaulerVista4[][] = {
				{-2,-2,-2,-2, 1, 9, -2,-2},
				{-2,-2,-2,-2,-2,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2,-2,-2},	
				{-2,-2,-2,-2,-2,-2,-2,-2},				
				{-2,-2,-2,-2,-2,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2, 2, 0},
				{-2,-2,-2,-2,-2,-2,-2, 0},
		};
		
		
		bombaTrobada=p.updateVistaTauler(0, 5, 1);
		assertEquals(bombaTrobada, false);
		
		for (int i=0; i<p.taulerReal.tauler.length;i++){
			for (int j=0; j<p.taulerReal.tauler[0].length;j++){
				assertEquals(p.taulerVista[i][j], expectedTaulerVista4[i][j]);
			}
		}
		
		
		//TEST CASE AMB ZEROS AL VOLTANT SELECCIONANT NA CASELLA A ZERO
		int vistaInicial5[][] = {
				{-2,-2,-2,-2, 1,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2,-2,-2},	
				{-2,-2,-2,-2,-2,-2,-2,-2},				
				{-2,-2,-2,-2,-2,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2, 2, 0},
				{-2,-2,-2,-2,-2,-2,-2, 0},
			};
		p.taulerVista= vistaInicial5;
		
		int expectedTaulerVista5[][] = {
				{-2,-2,-2,-2, 1,-2, 9,-2},
				{-2,-2,-2,-2,-2,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2,-2,-2},	
				{-2,-2,-2,-2,-2,-2,-2,-2},				
				{-2,-2,-2,-2,-2,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2, 2, 0},
				{-2,-2,-2,-2,-2,-2,-2, 0},
		};
		
		
		bombaTrobada=p.updateVistaTauler(0, 6, 1);
		assertEquals(bombaTrobada, false);
		
		for (int i=0; i<p.taulerReal.tauler.length;i++){
			for (int j=0; j<p.taulerReal.tauler[0].length;j++){
				assertEquals(p.taulerVista[i][j], expectedTaulerVista5[i][j]);
			}
		}
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
