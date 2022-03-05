import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_2887_행성터널_Prim {
	static class Planet{
		int x,y,z,index;
		
		public Planet(int x, int y, int z,int index) {
			this.x = x;
			this.y = y;
			this.z = z;
			this.index = index;
		}

		@Override
		public String toString() {
			return "Planet [x=" + x + ", y=" + y + ", z=" + z + ", index=" + index + "]";
		}
		
		
	}
	static class Vertex implements Comparable<Vertex>{
		int index, minDist;

		public Vertex(int index, int minDist) {
			this.index = index;
			this.minDist = minDist;
		}

		@Override
		public int compareTo(Vertex o) {
			return this.minDist-o.minDist;
		}

		@Override
		public String toString() {
			return "Vertex [index=" + index + ", minDist=" + minDist + "]";
		}
		
	}
	
	static class Node{
		int vertex;
		Node link;
		int weight;
		public Node(int vertex, Node link,int weight) {
			this.vertex = vertex;
			this.link = link;
			this.weight = weight;
		}
		@Override
		public String toString() {
			return "Node [vertex=" + vertex + ", link=" + link + "]";
		}
		
		
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		Planet[] planets = new Planet[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			planets[i] = new Planet(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),i);
		}
		Node[] adjList = new Node[N];
		Arrays.sort(planets,(o1,o2)->o1.x-o2.x);
		for (int i = 0; i < N-1; i++) {
			adjList[planets[i].index] = new Node(planets[i+1].index,adjList[planets[i].index],planets[i+1].x-planets[i].x);
			adjList[planets[i+1].index] = new Node(planets[i].index,adjList[planets[i+1].index],planets[i+1].x-planets[i].x);
		}
		Arrays.sort(planets,(o1,o2)->o1.y-o2.y);
		for (int i = 0; i < N-1; i++) {
			adjList[planets[i].index] = new Node(planets[i+1].index,adjList[planets[i].index],planets[i+1].y-planets[i].y);
			adjList[planets[i+1].index] = new Node(planets[i].index,adjList[planets[i+1].index],planets[i+1].y-planets[i].y);
		}
		Arrays.sort(planets,(o1,o2)->o1.z-o2.z);
		for (int i = 0; i < N-1; i++) {
			adjList[planets[i].index] = new Node(planets[i+1].index,adjList[planets[i].index],planets[i+1].z-planets[i].z);
			adjList[planets[i+1].index] = new Node(planets[i].index,adjList[planets[i+1].index],planets[i+1].z-planets[i].z);
		}
		Arrays.sort(planets,(o1,o2)->o1.index-o2.index);//복구
		
//		for (int i = 0; i < N; i++) {
//			System.out.println(adjList[i].toString());
//		}
		boolean visited[] = new boolean[N];
		int result = 0;
		PriorityQueue<Vertex> pq = new PriorityQueue<>();
		pq.offer(new Vertex(0,0));
		while(!pq.isEmpty()) {
			
			Vertex current = pq.poll();
			
			if(visited[current.index]) continue;
			visited[current.index] = true;
			result += current.minDist;
			for (Node temp = adjList[current.index]; temp != null; temp = temp.link) {
				if(!visited[temp.vertex])
					pq.offer(new Vertex(temp.vertex,temp.weight));
			}
		}
		System.out.println(result);
	}
	
	public static int dist(Planet p1, Planet p2) {
		int min = Math.min(Math.abs(p1.x-p2.x), Math.abs(p1.y-p2.y));
		min = Math.min(min, Math.abs(p1.z-p2.z));
		return min;
	}


}
