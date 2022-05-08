import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_13418_학교_탐방하기 {
	static class Node{
		int vertex;
		Node link;
		int weight;
		
		public Node(int vertex, Node link, int weight) {
			this.vertex = vertex;
			this.link = link;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "Node [vertex=" + vertex + ", link=" + link + ", weight=" + weight + "]";
		}
		
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Node[] adjList = new Node[N+1];
		for (int i = 0; i < M+1; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			adjList[from] = new Node(to,adjList[from],weight==1?0:1);//오르막:1 내리막:0 으로 바꿈
			adjList[to] = new Node(from,adjList[to],weight==1?0:1);//한 쪽이 오르막길이면 반대로 오면 내리막길
		}
		int start = 0;
		boolean[] visited = new boolean[N+1];
		int[] fatigue = new int[N+1];
		int minResult = 0;
		Arrays.fill(fatigue, Integer.MAX_VALUE);
		fatigue[start] = 0;
		for (int c = 0; c < N+1; c++) {
			int min = Integer.MAX_VALUE;
			int current = -1;
			for (int i = 0; i < N+1; i++) {
				if(!visited[i]&&min>fatigue[i]) {
					min = fatigue[i];
					current = i;
				}
			}
			minResult += min;
			visited[current] = true;
			
			for(Node temp = adjList[current];temp!=null;temp=temp.link) {
				if(!visited[temp.vertex]&&fatigue[temp.vertex]>temp.weight) {
					fatigue[temp.vertex] = temp.weight;
				}
			}
		}
		start = 0;
		Arrays.fill(visited, false);
		Arrays.fill(fatigue, -1);
		int maxResult = 0;
		fatigue[start] = 0;
		for (int c = 0; c < N+1; c++) {
			int max = -1;
			int current = -1;
			for (int i = 0; i < N+1; i++) {
				if(!visited[i]&&max<fatigue[i]) {
					max = fatigue[i];
					current = i;
				}
			}
			maxResult += max;
			visited[current] = true;
			
			for(Node temp = adjList[current];temp!=null;temp=temp.link) {
				if(!visited[temp.vertex]&&fatigue[temp.vertex]<temp.weight) {
					fatigue[temp.vertex] = temp.weight;
				}
			}
		}
		System.out.println((maxResult*maxResult)-(minResult*minResult));
	}

}
