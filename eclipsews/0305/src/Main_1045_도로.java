import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1045_도로 {
	static class Point{
		long x,y;

		public Point(long x, long y) {
			this.x = x;
			this.y = y;
		}
		
	}
	static class Node{
		int vertex;
		Node link;
		
		
		public Node(int vertex, Node link) {
			this.vertex = vertex;
			this.link = link;
		}
		
	}
	static double[] minDist;
	static boolean[] visited;
	static double result;
	static Point[] gods;
	static int N,M;
	static int cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		gods = new Point[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			gods[i] = new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		
		Node[] adjList = new Node[N]; // 이미 연결된 우주신들의 정보를 연결리스트로 저장
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int from,to;
			from = Integer.parseInt(st.nextToken())-1;
			to = Integer.parseInt(st.nextToken())-1;
			
			adjList[from] = new Node(to,adjList[from]);
			adjList[to] = new Node(from,adjList[to]);
		}
		
		minDist = new double[N];
		visited = new boolean[N];
		Arrays.fill(minDist, Integer.MAX_VALUE);
		minDist[0] = 0;
		result = 0;
		cnt=N;
		while(cnt>0) {
			double min = Double.MAX_VALUE;
			int current = -1;
			for (int i = 0; i < N; i++) {
				if(!visited[i]&&min>minDist[i]) {
					min = minDist[i];
					current = i;
				}
			}
			
			result += min;
			//선택된 우주신과 이미 연결되어 있는 다른 우주신들도 연결
			dfs(current,adjList);
		}
		
		System.out.printf("%.2f",(double) Math.round(result * 100) / 100);
		
	}
	public static void dfs(int current, Node[] adjList) {
		cnt--;
		visited[current] = true;
		for (int i = 0; i < N; i++) { 
			if(!visited[i]&&minDist[i]>getDist(gods[current],gods[i])) { //minDist 최단거리로 초기화
				minDist[i] = getDist(gods[current],gods[i]);
			}
		}
		
		for (Node temp = adjList[current];temp!=null;temp=temp.link) { //dfs 탐색
			if(!visited[temp.vertex]) {
				dfs(temp.vertex, adjList);
			}
		}
	}
	
	public static double getDist(Point p1,Point p2) {
		return Math.sqrt(((p1.x-p2.x)*(p1.x-p2.x))+((p1.y-p2.y)*(p1.y-p2.y)));
	}

}