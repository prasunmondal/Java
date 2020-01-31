package Graph;

import PrsnUtils.PrsnUtils;

public class BellmanFord {

	class Graph {
		int[][] graph;
		final int INF = 9999;

		public Graph(int vertex) {
			graph = new int[vertex][vertex];
			PrsnUtils.initiallizeArrayTo(graph, INF);
		}

		public void connectByDistance(int src, int dest, int distance) {
			this.graph[src][dest] = distance;
		}

		public void printGraphMatrix() {
			System.out.print("[");
			for (int i = 0; i < this.graph.length; i++) {
				for (int j = 0; j < this.graph[0].length; j++) {
					System.out.print((this.graph[i][j] != INF ? this.graph[i][j] : "-") + ", ");
				}
				System.out.println("]");
			}
		}

		public void printGraphMatrix(int[][] array) {
			System.out.print("[");
			for (int i = 0; i < array.length; i++) {
				for (int j = 0; j < array[0].length; j++) {
					System.out.print((array[i][j] != INF ? array[i][j] : "-") + ", ");
				}
				System.out.println("]");
			}
		}

		public int[] getShortestPathFromAVertex(int src) {
			// bellman ford
			int[] dist = new int[graph.length];
			PrsnUtils.initiallizeArrayTo(dist, INF);
			dist[src] = 0;

			for (int vertex = 0; vertex < graph.length; vertex++) {
				for (int u = 0; u < graph.length; u++) {
					for (int v = 0; v < graph.length; v++) {
						int weight = graph[u][v];
						if (dist[u] != INF && dist[u] + weight < dist[v])
							dist[v] = dist[u] + weight;
					}
				}
			}
			
			// check for negative weight - returns null if present
			for (int u = 0; u < graph.length; u++) {
				for (int v = 0; v < graph.length; v++) {
					int weight = graph[u][v];
					if (dist[u] != INF && dist[u] + weight < dist[v])
						return null;
				}
			}
			return dist;
		}
	}

	public static void main(String[] args) {
		BellmanFord bellmanFord = new BellmanFord();
		Graph g = bellmanFord.new Graph(5);
		g.connectByDistance(0, 1, -1);
		g.connectByDistance(0, 2, 4);

		g.connectByDistance(1, 2, 3);
		g.connectByDistance(1, 3, 2);
		g.connectByDistance(1, 4, 2);

		g.connectByDistance(3, 1, 1);
		g.connectByDistance(3, 2, 5);

		g.connectByDistance(4, 3, -3);

//		g.printGraphMatrix();
		
		PrsnUtils.printArray(g.getShortestPathFromAVertex(0));	// without negative cycle
		
		g.connectByDistance(1, 0, -3);							// introducing negative cycle
		PrsnUtils.printArray(g.getShortestPathFromAVertex(0));	
	}
}
