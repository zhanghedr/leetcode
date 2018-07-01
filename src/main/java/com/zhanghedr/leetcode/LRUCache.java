package com.ge.test;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LRUCache {

	public static void main(String[] args) {
		int[] array = {2, 1, 2, 5, 7, 5};
		System.out.println(cacheMissCount(array, 3));
	}

	public static int cacheMissCount(int[] array, int capacity) {
		if (array == null)
			return 0;
		List<Integer> cache = new LinkedList<>();
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			int index = cache.indexOf(array[i]);
			if (index >= 0) {
				cache.remove(index);
			} else {
				count++;
				if (cache.size() == capacity)
					cache.remove(0);
			}
			cache.add(array[i]);
		}
		return count;
	}
	
	public static int cacheMissCount1(int[] array, final int capacity) {
		if (array == null)
			return 0;
		int count = 0;
		LinkedHashMap<Integer, Integer> map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
			@Override
			protected boolean removeEldestEntry(
					Map.Entry<Integer, Integer> eldest) {
				return size() > capacity;
			}
		};
		for (int i = 0; i < array.length; i++) {
			if(!map.containsKey(array[i])) count++;
			map.put(array[i], 0);
		}
		return count;
	}

	
	
	private LinkedHashMap<Integer, Integer> map;

	public LRUCache(final int capacity) {
		map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
			@Override
			protected boolean removeEldestEntry(
					Map.Entry<Integer, Integer> eldest) {
				return size() > capacity;
			}
		};
	}

	public int get(int key) {
		Integer value = map.get(key);
		return value == null ? -1 : value;
	}

	public void set(int key, int value) {
		map.put(key, value);
	}
}
