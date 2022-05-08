import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
5 5
1 1 3
1 1 1 1 1
1 0 0 0 1
1 0 1 0 1
1 0 0 1 1
1 1 1 1 1
 */
public class Main_14503_로봇청소기 {
	static int N, M, arr[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = 3 - Integer.parseInt(st.nextToken());// 0:서,1:남,2:동,3:북
		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		boolean[][] visited = new boolean[N][M];
		dfs(r, c, d, visited);
		System.out.println(cnt);
	}

	static int[] r = { 0, 1, 0, -1 };// 서남동북
	static int[] c = { -1, 0, 1, 0 };
	static int cnt = 1;

	public static void dfs(int y, int x, int dir, boolean[][] visited) {

		visited[y][x] = true;

		int nr, nc;
		for (int i = 0; i < 4; i++) {
			dir = ++dir % 4;
			nr = y + r[dir];
			nc = x + c[dir];
			if (!visited[nr][nc] && arr[nr][nc] != 1) {// 벽이 아니며 청소가 되어있지 않음
				dfs(nr, nc, dir, visited);
				cnt++;
				return;//한번 청소할 위치 탐색 완료하면 그 위치로 이동하므로 return해주는거 필수
			}
		}
		nr = y - r[dir];
		nc = x - c[dir];
		if (arr[nr][nc] != 1) {// 벽이 아니면
			dfs(nr, nc, dir, visited);// 후진
		} else {// 벽이면
			return;
		}

	}

}
