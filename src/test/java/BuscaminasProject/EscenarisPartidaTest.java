package BuscaminasProject;

import static org.junit.Assert.*;

import org.junit.Test;

public class EscenarisPartidaTest {
	
	@Test
	public void testGetCasellaTaulerVista(){
		
		MockPartida p = new MockPartida();
		
		int vistaMockActualEscenaris[][] = {
				{1, -2,  2,  2,  1,  1,  0,  0},
				{1,  2,  9,  3,  9, -2,  1,  1},
				{1,  2,  4,  9,  3,  3, -2,  3},
				{1,  9,  3,  9,  3,  3,  9,  9},
				{1,  2,  3,  3,  3,  9,  5,  9},
				{1,  2,  9,  2,  9,  3,  9, -2},
				{1,  9,  2,  2,  2,  3,  2,  1},
				{2,  2,  3,  2,  4,  9,  2,  0},
				{1,  9,  2,  9,  9,  9,  2,  9}
		};
		
		p.setMockVistaTauler(vistaMockActualEscenaris);
		
		int res_0 = p.getCasellaTaulerVista(1, 2);
		assertEquals(res_0, 9);
		int res_1 = p.getCasellaTaulerVista(2, 2);
		assertEquals(res_1, 4);
		int res_2 = p.getCasellaTaulerVista(5, 7);
		assertEquals(res_2,-2);
		int res_3 = p.getCasellaTaulerVista(0, 6);
		assertEquals(res_3, 0);
		int res_4 = p.getCasellaTaulerVista(8, 0);
		assertEquals(res_4, 1);
		int res_5 = p.getCasellaTaulerVista(5, 3);
		assertEquals(res_5, 2);
		
	}
	
	@Test
	public void testProcessaMoviment() {
		
		MockPartida p = new MockPartida();
		
		int vistaMockActualEscenaris[][] = {
				{1, -2,  2,  2,  1,  1,  0,  0},
				{1,  2,  9,  3,  9, -2,  1,  1},
				{1,  2,  4,  9,  3,  3, -2,  3},
				{1,  9,  3,  9,  3,  3,  9,  9},
				{1,  2,  3,  3,  3,  9,  5,  9},
				{1,  2,  9,  2,  9,  3,  9, -2},
				{1,  9,  2,  2,  2,  3,  2,  1},
				{2,  2,  3,  2,  4,  9,  2,  0},
				{1,  9,  2,  9,  9,  9,  2,  9}
		};
		p.flagsUsades=20;
		p.setMockVistaTauler(vistaMockActualEscenaris);
		assertEquals(p.processaMoviment("C8"),1); // Normal
		assertEquals(p.processaMoviment("I1"),1);
		assertEquals(p.processaMoviment("A2"),-1); // Bomba
		assertEquals(p.processaMoviment("F8/"),-2); // No es permeten mes flags
		assertEquals(p.processaMoviment("G12"),0); // Fora del limit
		
		int vistaMockActualEscenaris2[][] = {
				{1,  9,  2,  2,  1,  1,  0,  0},
				{1,  2,  9,  3,  9,  1,  1,  0},
				{1,  2,  4,  9,  3,  2,  2,  2},
				{1, -2,  3,  9,  3,  3,  9,  9},
				{1,  2,  3,  3,  3,  9,  3,  2},
				{1,  2,  9,  2,  9,  2,  1,  0},
				{1,  9,  2,  2,  2,  2,  2,  0},
				{2,  2,  3,  2,  3,  9,  2,  0},
				{1,  9,  2,  9,  9,  2,  1,  0}
		};
		p.flagsUsades=0;
		p.setMockVistaTauler(vistaMockActualEscenaris2);
		assertEquals(p.processaMoviment("D2/"),2); // Guanya la partida
	}
	
	@Test
	public void testInputToCoordsWithoutFlag() { 
		MockPartida p = new MockPartida();
		
		int aux[]= {-1,-1,-1};
		
		aux=p.inputToCoords("A1");
		assertEquals(aux[0], 0);
		assertEquals(aux[1], 0);
		assertEquals(aux[2], 0);
		
		aux=p.inputToCoords("I8");
		assertEquals(aux[0], 8);
		assertEquals(aux[1], 7);
		assertEquals(aux[2], 0);
		
		aux=p.inputToCoords("F6");
		assertEquals(aux[0], 5);
		assertEquals(aux[1], 5);
		assertEquals(aux[2], 0);
		
		aux=p.inputToCoords("b1");
		assertEquals(aux[0], 1);
		assertEquals(aux[1], 0);
		assertEquals(aux[2], 0);
		
		aux=p.inputToCoords("d2");
		assertEquals(aux[0], 3);
		assertEquals(aux[1], 1);
		assertEquals(aux[2], 0);
		
		aux=p.inputToCoords("i1");
		assertEquals(aux[0], 8);
		assertEquals(aux[1], 0);
		assertEquals(aux[2], 0);
		
	}
	
	@Test
	public void testInputToCoordsWithFlag() { 
		MockPartida p = new MockPartida();
		
		int aux[]= {-1,-1,-1};
		
		aux=p.inputToCoords("A8/");
		assertEquals(aux[0], 0);
		assertEquals(aux[1], 7);
		assertEquals(aux[2], 1);
		
		aux=p.inputToCoords("I8/");
		assertEquals(aux[0], 8);
		assertEquals(aux[1], 7);
		assertEquals(aux[2], 1);
		
		aux=p.inputToCoords("A1/");
		assertEquals(aux[0], 0);
		assertEquals(aux[1], 0);
		assertEquals(aux[2], 1);
		
		aux=p.inputToCoords("I1/");
		assertEquals(aux[0], 8);
		assertEquals(aux[1], 0);
		assertEquals(aux[2], 1);
		
		aux=p.inputToCoords("E4/");
		assertEquals(aux[0], 4);
		assertEquals(aux[1], 3);
		assertEquals(aux[2], 1);
		
		aux=p.inputToCoords("g6/");
		assertEquals(aux[0], 6);
		assertEquals(aux[1], 5);
		assertEquals(aux[2], 1);
	}
	
	@Test
	public void testGetValueOfTauler() { 
		MockPartida p = new MockPartida();
		
		assertEquals(p.getValueOfTauler(0, 7), 0);
		assertEquals(p.getValueOfTauler(1, 6), 1);
		assertEquals(p.getValueOfTauler(7, 2), 3);
		assertEquals(p.getValueOfTauler(4, 6), 5);
	
		assertEquals(p.getValueOfTauler(7, 8), -11);
		assertEquals(p.getValueOfTauler(-5, -5), -11);

		assertEquals(p.getValueOfTauler(0, 0), 1);
		assertEquals(p.getValueOfTauler(0,7), 0);
		assertEquals(p.getValueOfTauler(8,0), 1);
		assertEquals(p.getValueOfTauler(8, 7), 0);
		
	}
}
