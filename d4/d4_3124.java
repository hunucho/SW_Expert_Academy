package d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class d4_3124 {
	static int[] nodes;
	static int v, e;
	static boolean[] chk;

	public static void init() {
		for (int i = 0; i <= v; i++)
			nodes[i] = i;
	}

	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if (x > y)
			nodes[y] = x;
		else if (x < y)
			nodes[x] = y;
	}

	public static int find(int x) {
		if (x == nodes[x])
			return x;
		return nodes[x] = find(nodes[x]);
	}

	public static boolean isSameParent(int x, int y) {
		x = find(x);
		y = find(y);
		if (x == y)
			return true;
		return false;
	}

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			PriorityQueue<Node3124> q = new PriorityQueue<Node3124>();
			v = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			nodes = new int[v + 1];
			chk = new boolean[v + 1];
			init();
			long sum = 0;
			for (int i = 0; i < e; i++) {
				st = new StringTokenizer(br.readLine());
				Node3124 node = new Node3124();
				node.S = Integer.parseInt(st.nextToken());
				node.E = Integer.parseInt(st.nextToken());
				node.W = Integer.parseInt(st.nextToken());
				q.add(node);
			}
			while (q.size() > 0) {
				Node3124 node = q.poll();
				if (!isSameParent(node.S, node.E)) {
					union(node.S, node.E);
					sum += node.W;
				}
			}
			System.out.printf("#%d %d\n", test_case, sum);
		}
	}
}

class Node3124 implements Comparable<Node3124> {
	int S, E, W;

	@Override
	public int compareTo(Node3124 o) {

		return this.W - o.W;
	}
}