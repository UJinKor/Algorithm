import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_10423 {
	
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
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());//도시의 개수
		int M = Integer.parseInt(st.nextToken());//케이블 수
		int K = Integer.parseInt(st.nextToken());//발전소 개수
		int[] start = new int[K];//시작을 배열로 줌
		st = new StringTokenizer(br.readLine()," ");
		for (int i = 0; i < K; i++) {
			start[i] = Integer.parseInt(st.nextToken())-1;
		}
		Node[] adjList = new Node[N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int from = Integer.parseInt(st.nextToken())-1;
			int to = Integer.parseInt(st.nextToken())-1;
			int weight = Integer.parseInt(st.nextToken());
			adjList[from] = new Node(to,adjList[from],weight);
			adjList[to] = new Node(from,adjList[to],weight);
		}
		
		boolean[] visited = new boolean[N];
		int[] minDist = new int[N];
		
		Arrays.fill(minDist, Integer.MAX_VALUE);
		for (int i = 0; i < K; i++) {//시작점을 세개로 만듬
			minDist[start[i]] = 0;
		}
		int result = 0;
		for (int c = 0; c < N; c++) {
			int min = Integer.MAX_VALUE;
			int current = -1;
			for (int i = 0; i < N; i++) {
				if(!visited[i]&&min>minDist[i]) {
					min = minDist[i];
					current = i;
				}
			}
			result+=min;
			visited[current] = true;
			
			for (Node temp=adjList[current];temp!=null;temp=temp.link) {
				if(!visited[temp.vertex]&&minDist[temp.vertex]>temp.weight) {
					minDist[temp.vertex] = temp.weight;
				}
			}
		}
		System.out.println(result);
	}

}
