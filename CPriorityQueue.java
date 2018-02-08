package Dia4;

import java.util.Comparator;

import interfaces.IQueue;

public class CPriorityQueue<T> implements IQueue<T> {

	private T[] elements;
	private int last;
	private Comparator<T> comparator;

	public CPriorityQueue(Comparator<T> comparator) {
		this.elements = (T[]) new Object[16];
		this.comparator = comparator;
		this.last = 0;
	
	}

	public T[] getElements() {
		return elements;
	}

	public void setElements(T[] elements) {
		this.elements = elements;
	}

	@Override
	public int size() {
		return this.last;
	}

	@Override
	public void clear() {
		for (int i = 0; i < this.size(); i++) {
			this.elements[i] = null;
		}
		this.last = 0;

	}

	@Override
	public void enqueue(T e) {
		
			int indexNovoElemento = this.size() + 1;
			int indexPai = indexNovoElemento / 2;
	
			this.last++;
			
			this.elements[indexNovoElemento] = e;
	
			while (indexNovoElemento > 1
					&& comparator.compare(this.elements[indexPai], this.elements[indexNovoElemento]) < 0) {
	
				T temp = this.elements[indexPai];
				this.elements[indexPai] = this.elements[indexNovoElemento];
				this.elements[indexNovoElemento] = temp;
	
				indexNovoElemento = indexPai;
				indexPai = indexPai / 2;
			}
		
		
		
	}

	@Override
	public void poll() {

		this.elements[1] = this.elements[this.last];
		int indexAtual = 1;
		int indexMelhor = indexAtual;
		int indexFilhoEsq = 2;
		int indexFilhoDir = 3;
		boolean trocou;
		
		// Diminuindo o vetor
		
		this.elements[this.last] = null;
		this.last--;
		
		do {

			if (indexFilhoEsq <= this.last) {
				if (this.comparator.compare(this.elements[indexMelhor], this.elements[indexFilhoEsq]) < 0) 
					indexMelhor = indexFilhoEsq;
			}

			if (indexFilhoDir <= this.last) {
				if (this.comparator.compare(this.elements[indexMelhor], this.elements[indexFilhoDir]) < 0)
					indexMelhor = indexFilhoDir;
			}
			
			// Realizando a troca
			
			if(indexAtual != indexMelhor) {
				T temp = this.elements[indexAtual];
				this.elements[indexAtual] = this.elements[indexMelhor];
				this.elements[indexMelhor] = temp;
				indexAtual = indexMelhor;
				indexMelhor = indexAtual;
				indexFilhoEsq = indexAtual * 2;
				indexFilhoDir = indexAtual * 2 + 1;
				trocou = true;
			}else {
				trocou = false;
			}
			
		}while(trocou);
	}
	

	@Override
	public T head() {

		return this.elements[1];
	}

}
