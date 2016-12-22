package topTenAlgorithm;

import java.util.Arrays;
import static java.lang.System.out;

public class GreedyAlgorithm {
	public static void main(String[] args) {
		int[][] graph = { { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
				{ 4, 0, 8, 0, 0, 0, 0, 11, 0 }, { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
				{ 0, 0, 7, 0, 9, 14, 0, 0, 0 }, { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
				{ 0, 0, 4, 14, 10, 0, 2, 0, 0 }, { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
				{ 8, 11, 0, 0, 0, 0, 1, 0, 7 }, { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };

		ShortestPath sp = new ShortestPath();
		sp.GreedyAlg(graph, 0);

	}

}

class ShortestPath {
	static final int V = 9;

	int min_dist(int[] dist, boolean[] sptSet) {
		int min = Integer.MAX_VALUE;
		int min_index = -1;
		for (int i = 0; i < V; i++) {
			if (!sptSet[i] && dist[i] < min) {
				min = dist[i];
				min_index = i;
			}
		}
		out.printf("min_index = %d\n", min_index);
		return min_index;
	}

	void PrintSolution(int[] dist) {
		out.println("Start from 0");
		out.println("Vertex\t Distance");
		for (int i = 0; i < V; i++) {
			out.printf("%d,\t %d\n", i, dist[i]);
		}

	}

	void GreedyAlg(int graph[][], int src) {
		int dist[] = new int[V];
		boolean[] sptSet = new boolean[V];

		for (int i = 0; i < V; i++) {
			dist[i] = Integer.MAX_VALUE;
			sptSet[i] = false;
		}
		dist[src] = 0;

		for (int c = 0; c < V; c++) {
			int min_index = min_dist(dist, sptSet);
			sptSet[min_index] = true;
			for (int next = 0; next < V; next++) {
				if (!sptSet[next] && graph[min_index][next] != 0
						&& graph[min_index][next]+dist[min_index] < dist[next]) {
					dist[next] = dist[min_index] + graph[min_index][next];
				}
			}
			out.println(Arrays.toString(sptSet));
			out.println(Arrays.toString(dist));
		}

		PrintSolution(dist);
	}

}