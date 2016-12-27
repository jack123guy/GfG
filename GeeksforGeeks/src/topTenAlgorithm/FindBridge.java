package topTenAlgorithm;

import java.util.Iterator;
import java.util.LinkedList;

public class FindBridge {
	public static void main(String[] args) {
		Graph3 g3 = new Graph3(7);
		/*
		 * graph.add(1, 0); graph.add(0, 2); graph.add(2, 1); graph.add(0, 3);
		 * graph.add(3, 4);
		 */
		g3.add(0, 1);
		g3.add(1, 2);
		g3.add(2, 0);
		g3.add(1, 3);
		g3.add(1, 4);
		g3.add(1, 6);
		g3.add(3, 5);
		g3.add(4, 5);

		g3.isBridge();

	}
}

class Graph3 {
	int num, count = 0;
	LinkedList[] adj;
	LinkedList from, to;
	boolean[] Visited;

	Graph3(int N) {
		num = N;
		adj = new LinkedList[num];
		Visited = new boolean[num];
		from = new LinkedList<Integer>();
		to = new LinkedList<Integer>();
		for (int i = 0; i < num; i++) {
			Visited[i] = false;
			adj[i] = new LinkedList<Integer>();
		}
	}

	void add(int f, int t) {
		adj[f].add(t);
		adj[t].add(f);
		from.add(t);
		to.add(f);
		count++;
	}

	void DFS(int s) {
		LinkedList<Integer> queue = new LinkedList();
		Iterator<Integer> iter = adj[s].listIterator();
		Visited[s] = true;
		queue.add(s);
		while (!queue.isEmpty()) {
			s = queue.poll();
			System.out.print(s + " ");
			while (iter.hasNext()) {
				int n = iter.next();
				if (!Visited[n]) {
					Visited[n] = true;
					DFS(n);
				}
			}

		}
	}

	void isBridge() {
		int a, b;
		for (int i = 0; i < count; i++) {
			a = (int) from.poll();
			b = (int) to.poll();
			adj[a].remove();
			adj[b].remove();
			DFS(1);
			for (int c = 0; c < num; c++) {
				if (!Visited[c]) {
					System.out.printf("(%d, %d) is bridge.\n", a, b);
				}
				// Make Visited back to all false set;
				Visited[c] = false;
			}
			System.out.println();
			adj[a].add(b);
			adj[b].add(a);
		}
	}
}
