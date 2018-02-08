package Dia4;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.Arrays;
import java.util.Comparator;

import dia1TrueWind.Aquecimento;
import dia1TrueWind.Comparador;

public class TesteCPriorityQueue {
	public static void main(String[] args) {
		Comparador comparador = new Comparador();
		
		Integer[] test =  {15,4,3,12,9,7,6,11,13,14,1,5,2,8,10};
		Integer[] vetorOrdenado = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
	
		long time = System.currentTimeMillis();
		
		heepSort(test);
		System.out.println(Arrays.toString(test));

	}
	
	public static void heepSort(Integer[] array) {
		
		Comparador comparador = new Comparador();
		CPriorityQueue<Integer> teste = new CPriorityQueue<Integer>(comparador);
		
		for(int i = 0; i < array.length; i++) {
			teste.enqueue(array[i]);
		}
		
		Integer[] vetorOrdenado = new Integer[array.length];
		
		for(int i = 0; i < array.length; i++) {
			array [i] = teste.head();
			teste.poll();
		}
	}
	
	
}
