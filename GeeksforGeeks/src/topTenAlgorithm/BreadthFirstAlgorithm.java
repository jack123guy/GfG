package topTenAlgorithm;

import java.util.Iterator;
import java.util.LinkedList;
import static java.lang.System.*;

public class BreadthFirstAlgorithm {
	public static void main(String args[]) {
		Graph g = new Graph(4);

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);

		System.out.println("Following is Breadth First Traversal " + "(starting from vertex 2)");
		g.BFS(2);
	}
}

class Graph {
	private int V; // No. of vertices
	private LinkedList<Integer> adj[]; // Adjacency Lists

	// Constructor
	Graph(int v) {
		V = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; ++i)
			adj[i] = new LinkedList();
	}

	// Function to add an edge into the graph
	void addEdge(int v, int w) {
		adj[v].add(w);
	}

	void BFS(int num) {

		boolean[] Visited = new boolean[V];
		LinkedList<Integer> queue = new LinkedList();
		queue.add(num);
		Visited[num] = true;
		while (!queue.isEmpty()) {
			num = queue.poll();
			out.print(num + " ");
			Iterator<Integer> iter = adj[num].listIterator();
			while (iter.hasNext()) {
				num = iter.next();
				if (!Visited[num]) {
					Visited[num] = true;
					queue.add(num);
				}
			}
		}
	}
}