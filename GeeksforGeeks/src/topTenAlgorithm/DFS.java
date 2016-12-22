package topTenAlgorithm;

import java.util.Iterator;
import java.util.LinkedList;

public class DFS {
	public static void main(String[] args) {
		Graph2 g = new Graph2(4);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);

		g.DFS(2);
	}

}

class Graph2 {
	int N;
	LinkedList<Integer> adj[];
	boolean Visited[];

	Graph2(int n) {
		N = n;
		Visited = new boolean[N];
		adj = new LinkedList[N];
		for (int i = 0; i < N; i++) {
			adj[i] = new LinkedList<Integer>();
		}
	}

	void addEdge(int from, int to) {
		adj[from].add(to);
	}

	void DFS(int s) {
		LinkedList<Integer> queue = new LinkedList();

		Visited[s] = true;

		queue.add(s);

		while (!queue.isEmpty()) {
			Iterator<Integer> iter = adj[s].listIterator();
			s = queue.poll(); // 沒poll，queue不會empty，會進入infinite loop;
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
}