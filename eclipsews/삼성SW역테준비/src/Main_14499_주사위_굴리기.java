import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14499_주사위_굴리기 {
	static int N,M,K;
	static int[] dice = {0,0,0,0,0,0};
	static int[] diceIndex = {6,5,3,4,2,1};
	static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < K; i++) {
			int dir = Integer.parseInt(st.nextToken());
			int nr = y+dr[dir-1];
			int nc = x+dc[dir-1];
			if(nr<0 || nc<0 || nr>= N || nc>=M) continue;
			changeDiceIndex(dir);
			int nextI = diceIndex[0]; // 굴린 후 주사위 바닥 인덱스
			if(map[nr][nc]==0) {
				map[nr][nc] = dice[nextI-1];
			} else {
				dice[nextI-1] = map[nr][nc];
				map[nr][nc] = 0;
			}
			sb.append(dice[7-nextI-1]).append("\n");
			y = nr;
			x = nc;
		}
		System.out.println(sb);
	}
	static int[] dr = {0,0,-1,1};
	static int[] dc = {1,-1,0,0};
	public static void changeDiceIndex(int dir) {
		int[] temp = new int[6];
		for (int i = 0; i < 6; i++) {
			temp[i] = diceIndex[i];
		}
		switch(dir) {
		case 1: // 동
			diceIndex[0] = temp[2];
			diceIndex[2] = temp[5];
			diceIndex[3] = temp[0];
			diceIndex[5] = temp[3];
			break;
		case 2: // 서
			diceIndex[0] = temp[3];
			diceIndex[2] = temp[0];
			diceIndex[3] = temp[5];
			diceIndex[5] = temp[2];
			break;
		case 3: // 남
			diceIndex[0] = temp[1];
			diceIndex[1] = temp[5];
			diceIndex[4] = temp[0];
			diceIndex[5] = temp[4];
			break;
		case 4: // 북
			diceIndex[0] = temp[4];
			diceIndex[1] = temp[0];
			diceIndex[4] = temp[5];
			diceIndex[5] = temp[1];
			break;
		}
	}
}
