import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


// Vertex의 개수가 많아질 경우, PQ로 해결하는 것이 좋은듯하다.(O(n^2)이 시간초과가 날때)
public class Main_1647 {
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
	static class Vertex implements Comparable<Vertex>{
		int no;
		int minDist;
		
		public Vertex(int no, int minDist) {
			this.no = no;
			this.minDist = minDist;
		}

		@Override
		public int compareTo(Vertex o) {
			return this.minDist-o.minDist;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int maxDist = 0; //가장 가중치가  큰 길을 자른다.
		
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
		PriorityQueue<Vertex> pq = new PriorityQueue<>();
		pq.offer(new Vertex(0,0));
		int result = 0;
		while(!pq.isEmpty()) {
			Vertex currentV = pq.poll();
			int min = currentV.minDist;
			int current = currentV.no;
			if(visited[current]) continue;
			result += min;
			visited[current] = true;
			maxDist = Math.max(maxDist, min);
			
			for (Node temp = adjList[current];temp!=null;temp=temp.link) {
				if(!visited[temp.vertex]) {
					pq.offer(new Vertex(temp.vertex,temp.weight));
				}
			}
		}
		result -= maxDist;
		System.out.println(result);
	}

}
