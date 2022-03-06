import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_2406 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] direct = new int[M][2];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			direct[i][0] = Integer.parseInt(st.nextToken())-1;
			direct[i][1] = Integer.parseInt(st.nextToken())-1;
		}
		int[][] adjMatrix = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < N; j++) {
				adjMatrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < M; i++) {//이미 연결된 간선 가중치 0으로 만듬
			adjMatrix[direct[i][0]][direct[i][1]] = 0;
			adjMatrix[direct[i][1]][direct[i][0]] = 0;
		}
		StringBuilder sb = new StringBuilder();
		//adjMatrix MST 구하기
		boolean[] visited = new boolean[N];
		int[] minDist = new int[N];
		int[] conIndex = new int[N];
		Arrays.fill(minDist,Integer.MAX_VALUE);
		int result = 0;
		int cnt = 0;
		List<Integer[]> ansList = new ArrayList<>();
		minDist[1] = 0;//1컴은 무조건 메인컴퓨터
		conIndex[1] = 1;
		for (int c = 1; c < N; c++) {
			int min = Integer.MAX_VALUE;
			int current = -1;
			for (int i = 1; i < N; i++) {
				if(!visited[i]&&min>minDist[i]) {
					min = minDist[i];
					current = i;
				}
			}
			if(min!=0) {
				ansList.add(new Integer[] {current+1, conIndex[current]+1});
				cnt++;
			}
			visited[current] = true;
			result += min;
			for (int i = 1; i < N; i++) {
				if(!visited[i]&&minDist[i]>adjMatrix[current][i]) {
					minDist[i] = adjMatrix[current][i];
					conIndex[i] = current;
				}
			}
		}
		sb.append(result).append(" ").append(cnt).append("\n");
		for (Integer[] ans : ansList) {
			sb.append(ans[0]).append(" ").append(ans[1]).append("\n");
		}
		System.out.println(sb);
	}
}
