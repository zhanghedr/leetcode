package com.ge.test;

import java.util.ArrayList;

class Node {
	int val;
	ArrayList<Node> children;

	public Node(int val) {
		this.val = val;
		children = new ArrayList<>();
	}
}

class SumCount {
	int sum;
	int count;

	public SumCount(int sum, int count) {
		this.sum = sum;
		this.count = count;
	}
}

public class MaximumSubtreeAverage {

	public static void main(String[] args) {
		Node root = new Node(1);
		Node l21 = new Node(2);
		Node l22 = new Node(3);
		Node l23 = new Node(4);
		Node l31 = new Node(5);
		Node l32 = new Node(5);
		Node l33 = new Node(5);
		Node l34 = new Node(5);
		Node l35 = new Node(5);
		Node l36 = new Node(5);

		l21.children.add(l31);
		l21.children.add(l32);

		l22.children.add(l33);
		l22.children.add(l34);

		l23.children.add(l35);
		l23.children.add(l36);

		root.children.add(l21);
		root.children.add(l22);
		root.children.add(l23);

		Node res = maximumSubtreeAverage(root);
		System.out.println(res.val + " " + resAve);
	}

	private static double resAve = Double.MIN_VALUE;
	private static Node result;

	public static Node maximumSubtreeAverage(Node root) {
		if (root == null)
			return null;
		dfs(root);
		return result;
	}

	private static SumCount dfs(Node root) {
		if (root.children == null || root.children.size() == 0)
			return new SumCount(root.val, 1);
		int sum = root.val;
		int count = 1;
		for (Node child : root.children) {
			SumCount cSC = dfs(child);
			sum += cSC.sum;
			count += cSC.count;
		}
		double avg = (double) sum / count;
		if (resAve <= avg) {
			resAve = avg;
			result = root;
		}
		return new SumCount(sum, count);
	}

}
