import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1865 {
	static class Edge {
		int from,to,weight;

		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		for (int tc = 0; tc < TC; tc++) {
			st = new StringTokenizer(br.readLine()," ");
			int N = Integer.parseInt(st.nextToken()); // 지점의 수
			int M = Integer.parseInt(st.nextToken()); // 도로의 수
			int W = Integer.parseInt(st.nextToken()); // 웜홀의 수
			Edge[] edges = new Edge[2*M+W];
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine()," ");
				int from = Integer.parseInt(st.nextToken())-1;
				int to = Integer.parseInt(st.nextToken())-1;
				int weight = Integer.parseInt(st.nextToken());
				edges[2*i] = new Edge(from,to,weight);
				edges[2*i+1] = new Edge(to,from,weight);
			}
			for (int i = M*2; i < M*2+W; i++) {
				st = new StringTokenizer(br.readLine()," ");
				edges[i] = new Edge(Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken())-1,-Integer.parseInt(st.nextToken()));
			}
			
			long minDist[] = new long[N];
			boolean isMinus = false;
			minDist[0] = 0;
			loop:for (int i = 1; i <= N; i++) {
				for (int j = 0; j < 2*M+W; j++) {
					int from = edges[j].from;
					int to = edges[j].to;
					int weight = edges[j].weight;
					if(minDist[from]!=Long.MAX_VALUE && minDist[to]>minDist[from]+weight) {
						minDist[to] = minDist[from]+weight;
						if(i==N) {
							isMinus = true;
							break loop;
						}
					}
				}
			}
			
			
			if(isMinus) {
				sb.append("YES");
			} else {
				sb.append("NO");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
