import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1045 {
	
	static int[] parents;
	static int N;
	
	public static void makeSet(){
		parents = new int[N];
		for (int i = 0; i < N; i++) {
			parents[i] = i;
		}
	}
	public static int findSet(int a){//루트찾기
		if(parents[a]==a) return a;
		return parents[a] = findSet(parents[a]);
	}
	public static boolean union(int a,int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if(aRoot==bRoot) return false;
		parents[bRoot] = aRoot;
		return true;
	}
	static class Edge{
		int from,to;

		public Edge(int from, int to) {
			this.from = from;
			this.to = to;
		}

	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char input[][] = new char[N][];
		for (int i = 0; i < N; i++) {
			input[i] = br.readLine().toCharArray();
		}
		
		List<Edge> edgeList = new ArrayList<>();
		//숫자가 낮을수록 우선순위가 높음
		for (int i = 0; i < N; i++) {
			for (int j = i+1; j < N; j++) {
				if(input[i][j]!='N') edgeList.add(new Edge(i,j));
			}
		}
		
		makeSet();
		int[] counter = new int[N];
		int cnt = 0;
		Queue<Edge> remain = new LinkedList<>();
		for (Edge edge : edgeList) {
			if(union(edge.from,edge.to)) {
				counter[edge.from] ++;
				counter[edge.to] ++;
				cnt++;
			} else {
				remain.offer(edge);//사이클이 생기는 여분의 edge는 보관
			}
			
		}
		if(cnt!=N-1) {//cnt가 N-1이면 모든 요소가 연결된거, 모든edge 검사했음에도 불구, 연결안되면 -1 리턴
			System.out.println(-1);
			return;
		}
		for (int i = N-1; i < M; i++) {//연결된거 확인하고, 현재 N-1의 edge가 count된 상태이므로, M개가 될때가지 잔여 edge 카운트
			if(remain.isEmpty()) {//m개만큼 엣지가 없다면
				System.out.println(-1);
				return;
			}
			Edge current = remain.poll();
			counter[current.from]++;
			counter[current.to]++;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < counter.length; i++) {
			sb.append(counter[i]+" ");
		}
		System.out.println(sb);
	}

}
