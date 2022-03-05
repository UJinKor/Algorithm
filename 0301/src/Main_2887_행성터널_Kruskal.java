import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_2887_행성터널_Kruskal {
	static class Edge implements Comparable<Edge>{
		int from,to,weight;

		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight-o.weight;
		}
	}
	static int N;
	static int[] parents;
	
	public static void makeSet() {
		parents = new int[N];
		for (int i = 0; i < N; i++) {
			parents[i] = i;
		}
	}
	
	public static int findSet(int a) {
		if(a==parents[a]) return a;
		return parents[a] = findSet(parents[a]);
	}
	
	public static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		
		if(aRoot == bRoot) return false;
		
		parents[bRoot] = aRoot;
		return true;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		int arr[][] = new int[N][4];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
			arr[i][3] = i;//4번째 인자로 본래의 인덱스를 가지고있음
		}
		PriorityQueue<Edge> edges = new PriorityQueue<>();
		Arrays.sort(arr,(o1,o2)->o1[0]-o2[0]);
		for (int i = 0; i < N-1; i++) {
			edges.offer(new Edge(arr[i][3],arr[i+1][3],arr[i+1][0]-arr[i][0]));
		}
		Arrays.sort(arr,(o1,o2)->o1[1]-o2[1]);
		for (int i = 0; i < N-1; i++) {
			edges.offer(new Edge(arr[i][3],arr[i+1][3],arr[i+1][1]-arr[i][1]));
		}
		Arrays.sort(arr,(o1,o2)->o1[2]-o2[2]);
		for (int i = 0; i < N-1; i++) {
			edges.offer(new Edge(arr[i][3],arr[i+1][3],arr[i+1][2]-arr[i][2]));
		}
		
		makeSet();
		int result = 0, cnt = 0;
		while(!edges.isEmpty()) {
			Edge edge = edges.poll();
			if(union(edge.from,edge.to)) {
				result+=edge.weight;
				if(++cnt==N-1) break;
			}
		}
		System.out.println(result);
	}

}
