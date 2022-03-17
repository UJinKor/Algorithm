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
	static int N;
	static Node[] adjList;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		adjList = new Node[N];
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int from = Integer.parseInt(st.nextToken())-1;
			int to = Integer.parseInt(st.nextToken())-1;
			int weight = Integer.parseInt(st.nextToken());
			
			adjList[from] = new Node(to,adjList[from],weight);
			adjList[to] = new Node(from,adjList[to],weight);
		}
		st = new StringTokenizer(br.readLine()," ");
		int n1 = Integer.parseInt(st.nextToken())-1; // 거쳐가야하는 점
		int n2 = Integer.parseInt(st.nextToken())-1; // 거쳐가야하는 점
		
		int result1 = 0;
		
		int a1= dijkstra(0,n1);
		int b = dijkstra(n1,n2);
		int c1 = dijkstra(n2,N-1);
		if(b == -1) {
			System.out.println(-1);
			return;
		}
		else if(a1 == -1 && c1 == -1) {
			result1 = Integer.MAX_VALUE;
		}
		else {
			result1 = a1+b+c1;
		}
		
		int result2 = 0;
		int a2 = dijkstra(0,n2);
		int c2 = dijkstra(n1,N-1);
		if(a1 == -1 && c1 == -1) {
			result2 = Integer.MAX_VALUE;
		}
		else {
			result2 = a2+b+c2;
		}
		int max = Math.min(result1, result2);
//		System.out.println(result1+' '+result2);
		if(max==Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(max);
		}
	}
	public static int dijkstra(int start,int end) {
		int minDist[] = new int[N];
		boolean visited[] = new boolean[N];
		Arrays.fill(minDist, Integer.MAX_VALUE);
		minDist[start] = 0;
		
		for (int c = 0; c < N; c++) {
			int min = Integer.MAX_VALUE;
			int current = 0;
			for (int i = 0; i < N; i++) {
				if(!visited[i] && min>minDist[i]) {
					min = minDist[i];
					current = i;
				}
			}
			visited[current] = true;
			
			if(current==end) {
				return min;
			}
			for (Node temp=adjList[current];temp!=null;temp=temp.link) {
				if(!visited[temp.vertex] && minDist[temp.vertex]>minDist[current]+temp.weight) {
					minDist[temp.vertex] = minDist[current]+temp.weight;
				}
			}
		}
		return -1;
	}

}
