package BuscaminasProject;


import static org.junit.Assert.*;

import org.junit.Test;

public class PartidaTest {

	@Test
	public void testGenerateVista() { 
		MockPartida p = new MockPartida();
		int[][]aux=p.getVistaTauler();
		assertEquals(p.getWidth(), aux[0].length);
		assertEquals(p.getHeight(), aux.length);

		
		for (int i=0; i<p.getHeight();i++){
			for (int j=0; j<p.getWidth();j++){
				assertEquals(aux[i][j], -2);
			}
		}
	}
	
	
	@Test
	public void testGetCasellaTaulerVista(){

		MockPartida p = new MockPartida();
		
		int adj[][] = {
				{1, -1,  2,  2,  1,  1,  0,  0},
				{1,  2, -1,  3, -1,  2,  1,  1},
				{1,  2,  4, -1,  3,  3, -1,  3},
				{1, -1,  3, -1,  3,  3, -1, -1},
				{1,  2,  3,  3,  3, -1,  5, -1},
				{1,  2, -1,  2, -1,  3, -1,  2},
				{1, -1,  2,  2,  2,  3,  2,  1},
				{2,  2,  3,  2,  4, -1,  2,  0},
				{1, -1,  2, -1, -1, -1,  2,  0}
		};
		p.setMockVistaTauler(adj);
		
		int res = p.getCasellaTaulerVista(0, 0);
		assertEquals(res, 1);
		int res_1 = p.getCasellaTaulerVista(1, 0);
		assertEquals(res_1, 1);
		int res_2 = p.getCasellaTaulerVista(8, 8);
		assertEquals(res_2, -11);
		int res_3 = p.getCasellaTaulerVista(3, 3);
		assertEquals(res_3, -1);
		int res_4 = p.getCasellaTaulerVista(8, 6);
		assertEquals(res_4, 2);
		

	}
	
	
	@Test
	public void testProcessaMovimentCheckParticionsEquivalents() {
		//Este testeo esta divido segun los possibles erores que podria tener la función dependiendo d elos outputs
		
		//TEST CASE BAD INPUTS
		MockPartida p = new MockPartida();
		String listAuxInput1[]= {"J1","Z1","$1","€1","1A","3D","4B","6F","1A1","A11","11A","AA1","A1A","1AA","A0","A-4","A10","A100","1111111111111111111111111111111111111111111111111111111111111111111","AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA", "$$$$$$$$$$$$$$$$$$$$$$$$"," ",""};

		for (int i = 0; i < listAuxInput1.length; i++) 
		{
			assertEquals(p.processaMoviment(listAuxInput1[i]),0);
		}
		
		//TEST CASE GAME CONTINUE
		assertEquals(p.processaMoviment("A1"),1);
		assertEquals(p.processaMoviment("A2/"),1);
		assertEquals(p.processaMoviment("A1/"),1);
		assertEquals(p.processaMoviment("A7"),1);
		
		//TEST CASE GAME LOSE (with cas frontera when just one bomb left)
		int vistaMockActual[][] = {
				{-2,-2,-2,-2,-2,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2,-2,-2},	
				{-2,-2,-2,-2,-2,-2,-2,-2},				
				{-2,-2,-2,-2,-2,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2,-2,-2},
			};
		p.setMockVistaTauler(vistaMockActual); 
		assertEquals(p.processaMoviment("A2"),-1);
		
		int vistaMockActual2[][] = {
				{1,  9,  2,  2,  1,  1,  0,  0},
				{1,  2, -1,  3, -2,  2,  1,  1},
				{1,  2,  4, -1,  3,  3, -2,  3},
				{1,  9,  3, -1,  3,  3, -2, -1},
				{1,  2,  3,  3,  3, -2,  5, -1},
				{1,  2,  9,  2,  9,  3, -2,  2},
				{1,  9,  2,  2,  2,  3,  2,  1},
				{2,  2,  3,  2,  4,  9,  2,  0},
				{1,  9,  2,  9,  9,  9,  2,  0}
		};
		
		p.setMockVistaTauler(vistaMockActual2 );
		assertEquals(p.processaMoviment("F7"),-1);
		
		int vistaMockActual3[][] = {
				{1,  9,  2,  2,  1,  1,  0,  0},
				{1,  2,  9,  3,  9,  2,  1,  1},
				{1,  2,  4,  9,  3,  3, -2,  3},
				{1,  9,  3,  9,  3,  3,  9,  9},
				{1,  2,  3,  3,  3,  9,  5,  9},
				{1,  2,  9,  2,  9,  3,  9,  2},
				{1,  9,  2,  2,  2,  3,  2,  1},
				{2,  2,  3,  2,  4,  9,  2,  0},
				{1,  9,  2,  9,  9,  9,  2,  0}
		};
		p.setMockVistaTauler(vistaMockActual3 );
		assertEquals(p.processaMoviment("C7"),-1);
		
		
		//TEST CASE LAST CASELLA CHECK TO WIN
		 int vistaMockActual4[][] = {
				{1,  9,  2,  2,  1,  1,  0,  0},
				{1,  2,  9,  3,  9,  2,  1,  1},
				{1,  2,  4,  9,  3,  3, -2,  3},
				{1,  9,  3,  9,  3,  3,  9,  9},
				{1,  2,  3,  3,  3,  9,  5,  9},
				{1,  2,  9,  2,  9,  3,  9,  2},
				{1,  9,  2,  2,  2,  3,  2,  1},
				{2,  2,  3,  2,  4,  9,  2,  0},
				{1,  9,  2,  9,  9,  9,  2,  0}
		};		
		p.setMockVistaTauler(vistaMockActual4 );
		assertEquals(p.processaMoviment("C7/"),2);
		
	}
	
	
	@Test
	public void testProcessaMovimentRandomMovments() {
		//TEST CASE RANDOM MOVMENTS AND CORRECT MATRIX DEVELOPING
		MockPartida p=new MockPartida();
		MockInput io = new MockInput(".\\src\\test\\resources\\partida_1.txt");
		String s = io.readNextMoviment();
		assertEquals(p.processaMoviment(s), 1);
		s = io.readNextMoviment();
		assertEquals(p.processaMoviment(s), 1);
		s = io.readNextMoviment();
		assertEquals(p.processaMoviment(s), 1);
		s = io.readNextMoviment();
		assertEquals(p.processaMoviment(s), 1);
		s = io.readNextMoviment();
		assertEquals(p.processaMoviment(s), 1);
		s = io.readNextMoviment();
		assertEquals(p.processaMoviment(s), -1);
		
		
		
	}
	
		
	@Test
	public void testInputToCoordsWithoutFlag() { 
		MockPartida p = new MockPartida();
		
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
		MockPartida p = new MockPartida();
		
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
		MockPartida p = new MockPartida();
		
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
	
	
	@Test
	public void testCheckGameIsWin() { 
		MockPartida p = new MockPartida();
		
		//TEST CASE ANY BOMB WITH FLAG
		int vistaMockActual[][] = {
				{-2,-2,-2,-2,-2,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2,-2,-2},	
				{-2,-2,-2,-2,-2,-2,-2,-2},				
				{-2,-2,-2,-2,-2,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2,-2,-2},
			};
		p.setMockVistaTauler(vistaMockActual); 
		assertEquals(p.checkGameIsWin(),false);

		
		//TEST CASE SOME BOMBS WITH FLAG
		int vistaMockActual2[][] = {
				{1,  9,  2,  2,  1,  1,  0,  0},
				{1,  2, -1,  3, -2,  2,  1,  1},
				{1,  2,  4, -1,  3,  3, -2,  3},
				{1,  9,  3, -1,  3,  3, -2, -1},
				{1,  2,  3,  3,  3, -2,  5, -1},
				{1,  2,  9,  2,  9,  3, -2,  2},
				{1,  9,  2,  2,  2,  3,  2,  1},
				{2,  2,  3,  2,  4,  9,  2,  0},
				{1,  9,  2,  9,  9,  9,  2,  0}
		};
		
		p.setMockVistaTauler(vistaMockActual2 );
		assertEquals(p.checkGameIsWin(),false);
		
		//TEST CASE ALL BOMBS WITH FLAG MINUS ONE
		int vistaMockActual3[][] = {
				{1,  9,  2,  2,  1,  1,  0,  0},
				{1,  2,  9,  3,  9,  2,  1,  1},
				{1,  2,  4,  9,  3,  3, -2,  3},
				{1,  9,  3,  9,  3,  3,  9,  9},
				{1,  2,  3,  3,  3,  9,  5,  9},
				{1,  2,  9,  2,  9,  3,  9,  2},
				{1,  9,  2,  2,  2,  3,  2,  1},
				{2,  2,  3,  2,  4,  9,  2,  0},
				{1,  9,  2,  9,  9,  9,  2,  0}
		};
		p.setMockVistaTauler(vistaMockActual3 );
		assertEquals(p.checkGameIsWin(),false);
		
		
		
		//TEST CASE ALL BOMBS WITH FLAG MINUS ONE 2nd part
		int vistaMockActual4[][] = {
				{-2,-2,-2,-2,-2,-2,-2,-2},
				{1,  2,  9,  3,  9,  2,  1,  1},
				{1,  2,  4,  9,  3,  3,  9,  3},
				{1,  9,  3,  9,  3,  3,  9,  9},
				{1,  2,  3,  3,  3,  9,  5,  9},
				{1,  2,  9,  2,  9,  3,  9,  2},
				{1,  9,  2,  2,  2,  3,  2,  1},
				{2,  2,  3,  2,  4,  9,  2,  0},
				{1,  9,  2,  9,  9,  9,  2,  0}
		};
		p.setMockVistaTauler(vistaMockActual4 );
		assertEquals(p.checkGameIsWin(),false);
		
		//TEST CASE ALL BOMBS WITH FLAG
		int vistaMockActual5[][] = {
				{1,  9,  2,  2,  1,  1,  0,  0},
				{1,  2,  9,  3,  9,  2,  1,  1},
				{1,  2,  4,  9,  3,  3,  9,  3},
				{1,  9,  3,  9,  3,  3,  9,  9},
				{1,  2,  3,  3,  3,  9,  5,  9},
				{1,  2,  9,  2,  9,  3,  9,  2},
				{1,  9,  2,  2,  2,  3,  2,  1},
				{2,  2,  3,  2,  4,  9,  2,  0},
				{1,  9,  2,  9,  9,  9,  2,  0}
		};
		p.setMockVistaTauler(vistaMockActual5 );
		assertEquals(p.checkGameIsWin(),true);
		
		int vistaMockActual6[][] = {
				{9,  9,  2,  2,  1,  1,  0,  0},
				{1,  2, -1,  3, -2,  2,  1,  1},
				{1,  2,  4, -1,  3,  3, -2,  3},
				{1,  9,  3, -1,  3,  3, -2, -1},
				{1,  2,  3,  3,  3, -2,  5, -1},
				{1,  2,  9,  2,  9,  3, -2,  2},
				{1,  9,  2,  2,  2,  3,  2,  1},
				{2,  2,  3,  2,  4,  9,  2,  0},
				{1,  9,  2,  9,  9,  9,  2,  0}
		};
		
		p.setMockVistaTauler(vistaMockActual6 );
		assertEquals(p.checkGameIsWin(),false);
		
	}
	
	
	@Test
	public void  testUpdateVistaTaulerWithOutFlag() { 
		MockPartida p = new MockPartida();
		int returnUpdate=0;
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
		p.setMockVistaTauler(vistaInicial );
		
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
		
		
		returnUpdate=p.updateVistaTauler(0, 6, 0);
		assertEquals(returnUpdate, 0);
		
		int[][]aux=p.getVistaTauler();
		
		for (int i=0; i<p.getHeight();i++){
			for (int j=0; j<p.getWidth();j++){
				assertEquals(aux[i][j], expectedTaulerVista[i][j]);
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
		p.setMockVistaTauler(vistaInicial2 );
		
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
		
		
		returnUpdate=p.updateVistaTauler(0, 1, 0);
		assertEquals(returnUpdate, -1);
		
		aux=p.getVistaTauler();
		for (int i=0; i<p.getHeight();i++){
			for (int j=0; j<p.getWidth();j++){
				assertEquals(aux[i][j], expectedTaulerVista2[i][j]);
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
		p.setMockVistaTauler(vistaInicial3 );
		
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
		
		returnUpdate=p.updateVistaTauler(7, 6, 0);
		assertEquals(returnUpdate, 0);
		
		aux=p.getVistaTauler();
		for (int i=0; i<p.getHeight();i++){
			for (int j=0; j<p.getWidth();j++){
				assertEquals(aux[i][j], expectedTaulerVista3[i][j]);
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
		p.setMockVistaTauler(vistaInicial4 );
		
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
		
		
		returnUpdate=p.updateVistaTauler(0, 5, 0);
		assertEquals(returnUpdate, 0);
		
		
		aux=p.getVistaTauler();
		for (int i=0; i<p.getHeight();i++){
			for (int j=0; j<p.getWidth();j++){
				assertEquals(aux[i][j], expectedTaulerVista4[i][j]);
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
		p.setMockVistaTauler(vistaInicial5 );
		
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
		
		
		returnUpdate=p.updateVistaTauler(0, 6, 0);
		assertEquals(returnUpdate, 0);
		
		
		aux=p.getVistaTauler();
		for (int i=0; i<p.getHeight();i++){
			for (int j=0; j<p.getWidth();j++){
				assertEquals(aux[i][j], expectedTaulerVista5[i][j]);
			}
		}
		
		
		
		//TEST CASE MOLTS ZEROS AL VOLTANT SELECCIONANT UNA CASELLA A ZERO
		int taulerMockAux[][]= {
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0},
		};
		int adjMatrixMockAux[][]={
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0},
		};
		MockTauler mockTauler= new MockTauler();
		
		mockTauler.setMockTauler(taulerMockAux,adjMatrixMockAux);
		
		p.setMockTaulerPartida(mockTauler);
		
		
		int vistaInicial6[][] = {
				{-2,-2,-2,-2,-2,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2,-2,-2},	
				{-2,-2,-2,-2,-2,-2,-2,-2},				
				{-2,-2,-2,-2,-2,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2,-2,-2},
			};
		p.setMockVistaTauler(vistaInicial6 );
		
		int expectedTaulerVista6[][] = {
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0},
		};
		
		
		
		returnUpdate=p.updateVistaTauler(5, 5, 0);
		assertEquals(returnUpdate, 0);
		
		
		aux=p.getVistaTauler();
		for (int i=0; i<p.getHeight();i++){
			for (int j=0; j<p.getWidth();j++){
				assertEquals(aux[i][j], expectedTaulerVista6[i][j]);
			}
		}
	
	
	
	}
	
	
	@Test
	public void  testUpdateVistaTaulerWithFlag() { 
		MockPartida p = new MockPartida();
		int returnUpdate=0;
		//PARTICIÓ EQUIVALENT DE CASOS AMB FLAG
		//TEST CASE CASELLA JA DESTAPADA AMB FLAG
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
		p.setMockVistaTauler(vistaInicial );
		
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
		
		
		returnUpdate=p.updateVistaTauler(0, 6, 1);
		assertEquals(returnUpdate, 0);
		
		//assertEquals(assertEquals);
		
		int [][]aux=p.getVistaTauler();
		for (int i=0; i<p.getHeight();i++){
			for (int j=0; j<p.getWidth();j++){
				assertEquals(aux[i][j], expectedTaulerVista[i][j]);
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
		p.setMockVistaTauler(vistaInicial2 );
		
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
		
		
		returnUpdate=p.updateVistaTauler(0, 1, 1);
		assertEquals(returnUpdate, 0);
		
		
		aux=p.getVistaTauler();
		for (int i=0; i<p.getHeight();i++){
			for (int j=0; j<p.getWidth();j++){
				assertEquals(aux[i][j], expectedTaulerVista2[i][j]);
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
		p.setMockVistaTauler(vistaInicial3 );
		
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
		
		returnUpdate=p.updateVistaTauler(7, 6, 1);
		assertEquals(returnUpdate, 0);
		
		
		aux=p.getVistaTauler();
		for (int i=0; i<p.getHeight();i++){
			for (int j=0; j<p.getWidth();j++){
				assertEquals(aux[i][j], expectedTaulerVista3[i][j]);
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
		p.setMockVistaTauler(vistaInicial4 );
		
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
		
		
		returnUpdate=p.updateVistaTauler(0, 5, 1);
		assertEquals(returnUpdate, 0);
		
		
		aux=p.getVistaTauler();
		for (int i=0; i<p.getHeight();i++){
			for (int j=0; j<p.getWidth();j++){
				assertEquals(aux[i][j], expectedTaulerVista4[i][j]);
			}
		}
		
		
		//TEST CASE AMB ZEROS AL VOLTANT SELECCIONANT UNA CASELLA A ZERO
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
		
		p.setMockVistaTauler(vistaInicial5 );
		
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
		
		
		returnUpdate=p.updateVistaTauler(0, 6, 1);
		assertEquals(returnUpdate, 0);
		
		aux=p.getVistaTauler();
		for (int i=0; i<p.getHeight();i++){
			for (int j=0; j<p.getWidth();j++){
				assertEquals(aux[i][j], expectedTaulerVista5[i][j]);
			}
		}
	}
	
	
	public void testUpdateVistaTaulerFlagsTest() {
		MockPartida p = new MockPartida();
		int returnUpdate=0;
		
		//POSAR UN FLAG QUAN HI HAN 0 COLOCATS
		int vistaInicial[][] = {
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
		p.setMockVistaTauler(vistaInicial );
		
		int expectedTaulerVista[][] = {
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
		returnUpdate=p.updateVistaTauler(0, 1, 1);
		assertEquals(returnUpdate, 0);
		
		
		int aux[][]=p.getVistaTauler();
		for (int i=0; i<p.getHeight();i++){
			for (int j=0; j<p.getWidth();j++){
				assertEquals(aux[i][j], expectedTaulerVista[i][j]);
			}
		}
	
		
		//POSAR L'ÚLTIM FLAG POSSIBLE
		int vistaInicial2[][] = {
				{-2, 9, 9, 9, 9, 9, 9, 9},
				{ 9, 9, 9, 9, 9, 9, 9, 9},
				{ 9, 9, 9, 9,-2,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2,-2,-2},	
				{-2,-2,-2,-2,-2,-2,-2,-2},				
				{-2,-2,-2,-2,-2,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2, 2, 0},
				{-2,-2,-2,-2,-2,-2,-2, 0},
			};

		p.setMockVistaTauler(vistaInicial2 );
		
		int expectedTaulerVista2[][] = {
				{9, 9, 9, 9, 9, 9, 9, 9},
				{ 9, 9, 9, 9, 9, 9, 9, 9},
				{ 9, 9, 9, 9,-2,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2,-2,-2},	
				{-2,-2,-2,-2,-2,-2,-2,-2},				
				{-2,-2,-2,-2,-2,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2, 2, 0},
				{-2,-2,-2,-2,-2,-2,-2, 0},
		};
		returnUpdate=p.updateVistaTauler(0, 1, 1);
		assertEquals(returnUpdate, 0);
		
		
		aux=p.getVistaTauler();
		for (int i=0; i<p.getHeight();i++){
			for (int j=0; j<p.getWidth();j++){
				assertEquals(aux[i][j], expectedTaulerVista2[i][j]);
			}
		}
		
		
		//TREURE FLAG QUAN HI HAN ELS MÀXMIS FLAGS COLOCATS
		int vistaInicial3[][] = {
				{ 9, 9, 9, 9, 9, 9, 9, 9},
				{ 9, 9, 9, 9, 9, 9, 9, 9},
				{ 9, 9, 9, 9,-2,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2,-2,-2},	
				{-2,-2,-2,-2,-2,-2,-2,-2},				
				{-2,-2,-2,-2,-2,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2, 2, 0},
				{-2,-2,-2,-2,-2,-2,-2, 0},
			};

		p.setMockVistaTauler(vistaInicial3 );
		
		int expectedTaulerVista3[][] = {
				{-2, 9, 9, 9, 9, 9, 9, 9},
				{ 9, 9, 9, 9, 9, 9, 9, 9},
				{ 9, 9, 9, 9,-2,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2,-2,-2},	
				{-2,-2,-2,-2,-2,-2,-2,-2},				
				{-2,-2,-2,-2,-2,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2, 2, 0},
				{-2,-2,-2,-2,-2,-2,-2, 0},
		};
		
		returnUpdate=p.updateVistaTauler(0, 0, 1);
		assertEquals(returnUpdate, 0);
		
		
		aux=p.getVistaTauler();
		for (int i=0; i<p.getHeight();i++){
			for (int j=0; j<p.getWidth();j++){
				assertEquals(aux[i][j], expectedTaulerVista3[i][j]);
			}
		}
		
		//INTENTAR SPERAR FLAGS MÀXIMS
		int vistaInicial4[][] = {
				{ 9, 9, 9, 9, 9, 9, 9, 9},
				{ 9, 9, 9, 9, 9, 9, 9, 9},
				{ 9, 9, 9, 9,-2,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2,-2,-2},	
				{-2,-2,-2,-2,-2,-2,-2,-2},				
				{-2,-2,-2,-2,-2,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2, 2, 0},
				{-2,-2,-2,-2,-2,-2,-2, 0},
			};

		p.setMockVistaTauler(vistaInicial4 );
		
		int expectedTaulerVista4[][] = {
				{ 9, 9, 9, 9, 9, 9, 9, 9},
				{ 9, 9, 9, 9, 9, 9, 9, 9},
				{ 9, 9, 9, 9,-2,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2,-2,-2},	
				{-2,-2,-2,-2,-2,-2,-2,-2},				
				{-2,-2,-2,-2,-2,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2,-2,-2},
				{-2,-2,-2,-2,-2,-2, 2, 0},
				{-2,-2,-2,-2,-2,-2,-2, 0},
		};
		
		returnUpdate=p.updateVistaTauler(5,5, 1);
		assertEquals(returnUpdate, -2);
		
		
		aux=p.getVistaTauler();
		for (int i=0; i<p.getHeight();i++){
			for (int j=0; j<p.getWidth();j++){
				assertEquals(aux[i][j], expectedTaulerVista4[i][j]);
			}
		}
		
		
	}


	@Test
	public void testCountBombes() {
		MockPartida p = new MockPartida();
		int res = p.getBombesTotals();
		assertEquals(res, 20);
	}
	
}
