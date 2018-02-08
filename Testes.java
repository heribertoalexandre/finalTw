package Dia4;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import dia1TrueWind.Comparador;

class Testes {

	@Test
	void test() {
		Comparador comparador = new Comparador();
		CPriorityQueue<Integer> teste = new CPriorityQueue<Integer>(comparador);

		Integer obj1 = 10;
		Integer obj2 = 3;
		Integer obj3 = 7;
		Integer obj4 = 1;
		Integer obj5 = 5;
		Integer obj6 = 12;
		Integer obj7 = 15;
		Integer obj8 = 14;
		Integer obj9 = 0;
		

		teste.enqueue(obj1);
		teste.enqueue(obj2);
		teste.enqueue(obj3);
		teste.enqueue(obj4);
		teste.enqueue(obj5);
		teste.enqueue(obj6);
		teste.enqueue(obj7);
		teste.enqueue(obj8);
		teste.enqueue(obj9);
		
		teste.poll();
		assertEquals(teste.head(),obj8);
		teste.poll();
		assertEquals(teste.head(),obj6);
		teste.poll();
		assertEquals(teste.head(),obj1);
		
		
	
	}

}
