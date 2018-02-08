package berto;

import interfaces.ICollection;
import interfaces.IMap;
import interfaces.ISet;

public class CMap<K,V> implements IMap<K, V>{


	static class Node<K,V> {
		K key;
		V value;
		Node<K,V> next;
		Node(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}
	
	int sizeOfArray = 10;
	int timesOfPut = 0;
	
	private Node[] table = new Node[sizeOfArray];
	
	
	@Override
	public void put(K key, V value) {
		
		
		Node novo = new Node(key,value);
		int hash = key.hashCode();
		int index = hash % sizeOfArray;
		if(this.containsKey(key))
		
		this.table[index] = novo;
		

	}

	@Override
	public V get(K key) {
		// TODO Auto-generated method stub
		boolean find = false;
		if(this.containsKey(key))
		{
			for(int i = 0; i < sizeOfArray && !find; i++) {
				if(this.table[i].key == key) {
					find = true;
					return (V) this.table[i].value;
				}
			}
		}
		
		throw new IllegalArgumentException("Chave invalida");
		
	
	}
	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	

	@Override
	public boolean containsKey(K key) {
		boolean found = false;
		
		for(int i = 0; i < this.sizeOfArray && !found; i++) {
			if(this.table[i].key.equals(key)) {
				found = true;
			}
		}
		return found;
	}

	@Override
	public void remove(K key) {
		// TODO Auto-generated method stub

	}

	@Override
	public ISet<K> keySet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ICollection<V> values() {
		// TODO Auto-generated method stub
		return null;
	}

}
