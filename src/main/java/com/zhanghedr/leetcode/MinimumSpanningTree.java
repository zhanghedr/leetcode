package com.ge.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

class Connection {
	String node1;
	String node2;
	int cost;

	public Connection(String a, String b, int c) {
		node1 = a;
		node2 = b;
		cost = c;
	}
	
	public String toString() {
		return String.format("%s %s %s", node1, node2, cost);
	}
}

public class MinimumSpanningTree {

	public static void main(String[] args) {
		ArrayList<Connection> connections = new ArrayList<>();
		connections.add(new Connection("A","C",1));
		connections.add(new Connection("A","B",2));
		connections.add(new Connection("B","C",3));
		System.out.println(minimumSpanningTree(connections));
	}

	private static int unionNum = 0;

	public static ArrayList<Connection> minimumSpanningTree(
			ArrayList<Connection> connections) {
		if (connections == null || connections.size() == 0) 
			return new ArrayList<>();

		ArrayList<Connection> result = new ArrayList<>();
		Map<String, Integer> nodeUnionMap = new HashMap<>();

		Collections.sort(connections, new Comparator<Connection>() {
			@Override
			public int compare(Connection o1, Connection o2) {
				return o1.cost - o2.cost;
			}
		});

		for (Connection c : connections) {
			String a = c.node1;
			String b = c.node2;
			if (union(nodeUnionMap, a, b)) {
				result.add(c);
			}
		}

		String find = connections.get(0).node1;
		int union = nodeUnionMap.get(find);
		for (String node : nodeUnionMap.keySet()) {
			if (nodeUnionMap.get(node) != union) 
				return new ArrayList<>();
		}

		Collections.sort(result, new Comparator<Connection>() {
			@Override
			public int compare(Connection o1, Connection o2) {
				if (o1.node1.equals(o2.node1)) {
					return o1.node2.compareTo(o2.node2);
				}
				return o1.node1.compareTo(o2.node1);
			}
		});
		return result;
	}

	private static boolean union(Map<String, Integer> map, String a, String b) {
		if (!map.containsKey(a) && !map.containsKey(b)) {
			map.put(a, unionNum);
			map.put(b, unionNum);
			unionNum++;
			return true;
		}

		if (map.containsKey(a) && !map.containsKey(b)) {
			int aU = map.get(a);
			map.put(b, aU);
			return true;
		}
		if (!map.containsKey(a) && map.containsKey(b)) {
			int bU = map.get(b);
			map.put(a, bU);
			return true;
		}

		int aU = map.get(a);
		int bU = map.get(b);
		if (aU == bU)
			return false;
		for (String s : map.keySet()) {
			if (map.get(s) == bU)
				map.put(s, aU);
		}
		return true;
	}

}
