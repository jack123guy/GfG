/*
 * http://www.geeksforgeeks.org/dynamic-programming-set-16-floyd-warshall-algorithm/
 */

package topTenAlgorithm;

import java.util.Arrays;
import java.util.Iterator;

public class Floyd_Warshall_Algorithm {
    public static void main(String[] args){
    	int INF = Integer.MAX_VALUE;
    	int graph[][] = { {0,   5,  INF, 10},
                {INF,  0,  3,  INF},
                {INF, INF, 0,   1},
                {INF, INF, INF, 0} };
    	FWA fwa = new FWA(graph);
        
    	fwa.findPath(graph);
    	fwa.PrintSolution();
    }
}

class FWA{
	static final int V = 4;
	int min = Integer.MAX_VALUE,dist;
	int sp[][] = new int[V][V];
	
	FWA(int graph[][]){
		//Arrays.fill(sp,Integer.MAX_VALUE);
		sp = graph;
	}
	
	int[][] findPath(int graph[][]){
		for(int i=0;i<V;i++){
			dist = 0;
			int point = i;
			for(int to=0;to<V;to++){
				if(graph[point][to]<min){
					dist += graph[point][to];
					//System.out.printf("point: %d, to: %d, dist: %d\n",point,to, dist);
				}
				//System.out.printf("dist:%d, sp[i][to]:%d\n",dist,sp[i][to]);
				if(dist!=0 && dist<=sp[i][to]){
					sp[i][to] = dist;
					point = to;
					//System.out.printf("point:%d, to:%d\n",point,to);
				}
			}
		}
		return sp;
	}
	
	void PrintSolution(){
		System.out.println("Vertex\tDistance");
		for(int i=0;i<V;i++){
			System.out.printf("%d\t",i);
			for(int j=0;j<V;j++){
				if(sp[i][j] == Integer.MAX_VALUE)
					System.out.print("INF\t");
				else
					System.out.printf("%d\t", sp[i][j]);
			}
			System.out.println();
		}
	}
}