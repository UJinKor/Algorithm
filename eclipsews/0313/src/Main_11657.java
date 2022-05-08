import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11657 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] ftw = new int[M][3];//from to weight 간선 리스트
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			ftw[i][0] = Integer.parseInt(st.nextToken())-1;
			ftw[i][1] = Integer.parseInt(st.nextToken())-1;
			ftw[i][2] = Integer.parseInt(st.nextToken());
		}
		boolean isLoop = false;
		long[] minDist = new long[N];
		Arrays.fill(minDist, Integer.MAX_VALUE);
		minDist[0] = 0;//시작점
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < M; j++) {
				int from = ftw[j][0];
				int to = ftw[j][1];
				int weight = ftw[j][2];
				if(minDist[from]!=Integer.MAX_VALUE && minDist[to] > minDist[from]+weight) {
					minDist[to] = minDist[from]+weight;
					if(i==N) {
						isLoop = true;
					}
				}
			}
		}
		if(isLoop) {
			System.out.println(-1);
			return;
		}
		StringBuffer sb = new StringBuffer();
		for (int i = 1; i < N; i++) {
			if(minDist[i]==Integer.MAX_VALUE) minDist[i] = -1;
			sb.append(minDist[i]).append("\n");
		}
		System.out.println(sb);
 	}

}
