import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2606_바이러스 {
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
		int V = Integer.parseInt(br.readLine());
		int E = Integer.parseInt(br.readLine());
		Node[] adjList = new Node[V];
		StringTokenizer st = null;
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int from = Integer.parseInt(st.nextToken())-1;
			int to = Integer.parseInt(st.nextToken())-1;
			
			adjList[from] = new Node(to,adjList[from]);
			adjList[to] = new Node(from,adjList[to]);
		}
		dfs(0,new boolean[V],adjList);
		System.out.println(cnt);
	}
	static int cnt=-1;
	public static void dfs(int current,boolean[] visited,Node[] adjList) {
		cnt++;
		visited[current] = true;
		for(Node temp = adjList[current]; temp!=null; temp=temp.link) {
			if(!visited[temp.vertex]) dfs(temp.vertex, visited, adjList);
		}
	}

}
