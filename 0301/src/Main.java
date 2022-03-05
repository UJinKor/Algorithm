import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static class Node{
		int vertex;
		Node link;
		int weight;
		
		public Node(int vertex, Node link, int weight) {
			this.vertex = vertex;
			this.link = link;
			this.weight = weight;
		}
		
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int V,E;
		st = new StringTokenizer(br.readLine()," ");
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		Node[] adjList = new Node[V];
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int from = Integer.parseInt(st.nextToken())-1;
			int to = Integer.parseInt(st.nextToken())-1;
			int weight = Integer.parseInt(st.nextToken());
			adjList[from] = new Node(to,adjList[from],weight);
			adjList[to] = new Node(from,adjList[to],weight);
		}
		
		int start = 0;
		boolean[] visited = new boolean[V];
		int[] minDist = new int[V];
		Arrays.fill(minDist, Integer.MAX_VALUE);
		minDist[start] = 0;
		
		int result = 0;
		for (int c = 0; c < V; c++) {
			int min = Integer.MAX_VALUE;
			int current = -1;
			for (int i = 0; i < V; i++) {
				if(min>minDist[i]&&!visited[i]) {
					min = minDist[i];
					current = i;
				}
			}
			visited[current] = true;
			result += min;
			for(Node temp = adjList[current];temp!=null;temp = temp.link) {
				if(!visited[temp.vertex]&&minDist[temp.vertex]>temp.weight) {
					minDist[temp.vertex] = temp.weight;
				}
			}
		}
		System.out.println(result);
		
	}

}
