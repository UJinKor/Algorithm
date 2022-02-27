import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2644_촌수계산 {

	static class Node{
		int vertex;
		Node link;
		
		public Node(int vertex, Node link) {
			this.vertex = vertex;
			this.link = link;
		}
		
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int V = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine()," ");
		int start = Integer.parseInt(st.nextToken())-1;
		int target = Integer.parseInt(st.nextToken())-1;
		int E = Integer.parseInt(br.readLine());
		Node[] adjList = new Node[V];
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int from = Integer.parseInt(st.nextToken())-1;
			int to = Integer.parseInt(st.nextToken())-1;
			
			adjList[from] = new Node(to,adjList[from]);
			adjList[to] = new Node(from,adjList[to]);
		}
		
		System.out.println(bfs(start,new boolean[V],adjList,target));
	}
	public static int bfs(int start,boolean[] visited, Node[] adjList, int target) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		visited[start] = true;
		int level = 0;
		while(!queue.isEmpty()) {
			int size = queue.size();
			while(size-->0) {
				int current = queue.poll();
				if(current==target) return level;
				for(Node temp = adjList[current];temp!=null;temp = temp.link) {
					if(!visited[temp.vertex]) {
						visited[temp.vertex] = true;
						queue.offer(temp.vertex);
					}
				}
			}
			level++;
		}
		return -1;
	}

}
