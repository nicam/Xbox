package ch.zhaw.ads;

import java.util.*;

public class MyHashtable<K,V> implements java.util.Map<K,V> {
	private K[] keys;
	private V[] values;
	private int count = 0;
	private float loadFactor = 0.75f;
	boolean autogrow = false;

	private int hash(Object k) {
		int h = Math.abs(k.hashCode());
		return h % keys.length;
	}
	
	public MyHashtable(int size) {
		keys =   (K[]) new Object[size];
		values = (V[]) new Object[size];
	}

	public MyHashtable() {
		this(16);
		autogrow = true;
	}
	//  Removes all mappings from this map (optional operation). 
	public void clear() {
		throw new UnsupportedOperationException();
	}    
	//  Returns true if this map contains a mapping for the specified key. 
	public boolean containsKey(Object key) {
		return keys[hash(key)] != null;
	}
	//  Returns true if this map maps one or more keys to the specified value. 
	public boolean containsValue(Object value)  {
		for (V v : values) {
			if (v.equals(value)) {
				return true;
			}
		}
		return false;
	}
	//  Returns a set view of the mappings contained in this map. 
	public Set entrySet() {
		throw new UnsupportedOperationException();
	}
	//  Compares the specified object with this map for equality. 
	public boolean equals(Object o) {
		throw new UnsupportedOperationException();
	}
	//  Returns the value to which this map maps the specified key. 
	public V get(Object key) {
		int h = findPos(key);
		if (keys[h].equals(key)) {
			return values[h];
		}
		return null;
	}
	//  Returns the hash code value for this map. 
	public int hashCode() {
		throw new UnsupportedOperationException();
	}
	//  Returns true if this map contains no key-value mappings. 
	public boolean isEmpty() {
		return count == 0;
	}
	//  Returns a set view of the keys contained in this map. 
	public Set keySet() {
		throw new UnsupportedOperationException();
	}

	int findPos(Object key) {
		int collisionNum = 0;
		int currentPos = hash(key);
		while (keys[currentPos] != null && !keys[currentPos].equals(key)) {
			currentPos += 2 * ++collisionNum - 1;
			currentPos = hash(currentPos);
		}
		return currentPos;
	}

	private void extendMap() {
		if (!autogrow) {
			return;
		}
		System.out.println("Extending Map from " + keys.length + " to double capacity");
		long startTime = System.currentTimeMillis();
		changeMapSize(keys.length * 2);
		System.out.println("Total grow time " + (System.currentTimeMillis() - startTime) + "ms");
	}

	private void shrinkMap() {
		if (!autogrow) {
			return;
		}
		System.out.println("Shrinking Map from " + keys.length + " to half capacity");
		changeMapSize(keys.length / 2);
	}

	private void changeMapSize(int newSize) {
		Object[] oldKeys = keys;
		Object[] oldValues = values;

		keys =   (K[]) new Object[newSize];
		values = (V[]) new Object[newSize]; 

		for (int i = 0; i < oldKeys.length; i++) {
			if (oldKeys[i] != null) {
				put((K) oldKeys[i], (V) oldValues[i]);
			}
		}
	}

	//  Associates the specified value with the specified key in this map (optional operation).
	public V put(K key, V value) {
		int h = findPos(key);
		keys[h] = key;
		values[h] = value;
		count++;
		if (count >= keys.length * loadFactor) { // 0.75 -> load factor
			extendMap();
		}
		return value;
	}
	//  Copies all of the mappings from the specified map to this map (optional operation). 
	public void putAll(Map t) {
		throw new UnsupportedOperationException();
	}
	//  Removes the mapping for this key from this map if present (optional operation). 
	public V remove(Object key) {
		V v = this.get(key);
		int hash = this.hash(key);
		keys[hash] = null;
		values[hash] = null;
		count--;

		int collisionNum = 0;
		int currentPos = hash;
		int lastHash = 0;
		do {
			lastHash = currentPos;
			currentPos += 2 * ++collisionNum - 1;
			currentPos = hash(currentPos);
		} while (keys[currentPos] != null);

		if(lastHash != hash){
			keys[hash] = keys[lastHash];
			values[hash] = values[lastHash];
			System.out.println("Moved: " + lastHash + " to " + hash);
		}
		keys[lastHash] = null;
		values[lastHash] = null;
		
		if (count <= keys.length * (1 - loadFactor)) { // Weniger als 25% voll -> kleiner machen
			shrinkMap();
		}
		
		return v;
	}

	//  Returns the number of key-value mappings in this map. 
	public int size() {
		return count;
	}
	//  Returns a collection view of the values contained in this map. 
	public Collection values() {
		throw new UnsupportedOperationException();
	}

}