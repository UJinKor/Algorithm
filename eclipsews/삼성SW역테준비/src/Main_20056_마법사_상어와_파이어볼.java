import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_20056_마법사_상어와_파이어볼 {
	static class Fireball{
		int m,s,d;

		public Fireball(int m, int s, int d) {
			super();
			this.m = m;
			this.s = s;
			this.d = d;
		}
		
	}
	static int N,M,K;
	static Fireball[][] arr;
	static int[][] cntFireballs;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		cntFireballs = new int[N][N];
		arr = new Fireball[N][N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			arr[r][c] = new Fireball(m,s,d);
			cntFireballs[r][c]++;
		}
		for (int i = 0; i < K; i++) {
			turn();
		}
		int answer = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(arr[i][j]==null) continue;
				if(cntFireballs[i][j]>=2) {
					answer += (arr[i][j].m/5)*4;
				} else {
					answer += arr[i][j].m;
				}
			}
		}
		System.out.println(answer);
	}
	
	static int[] dr = {-1,-1,0,1,1,1,0,-1};
	static int[] dc = {0,1,1,1,0,-1,-1,-1};
	public static void turn() {
		Fireball[][] temp = new Fireball[N][N];
		int[][] tempCntFireballs = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(arr[i][j]==null) continue;
				if(cntFireballs[i][j]>=2) {
					if(arr[i][j].m/5==0) continue;
					int flag;
					if(arr[i][j].d==8) {
						flag = 1;
					} else {
						flag = 0;
					}
					for (int k = 0; k < 4; k++) {
						Fireball fire = new Fireball(arr[i][j].m/5,arr[i][j].s/cntFireballs[i][j],2*k+flag);
						move(fire,i,j,temp,tempCntFireballs);
					}
				} else {
					Fireball fire = arr[i][j];
					move(fire,i,j,temp,tempCntFireballs);
				}
			}
		}
		arr = temp;
		cntFireballs = tempCntFireballs;
	}
	public static void move(Fireball fire,int i, int j, Fireball[][] temp,int[][] tempCntFireballs) {
		int dir = fire.d;
		int nr = i;
		int nc = j;
		for (int k = 0; k < fire.s; k++) {
			nr += dr[dir];
			nc += dc[dir];
			if(nr<0) 
				nr = N-1;
			if(nc<0) 
				nc = N-1;
			if(nr>=N) 
				nr = 0;
			if(nc>=N) 
				nc = 0;
		}
		tempCntFireballs[nr][nc]++;
		if(temp[nr][nc]!=null) { // 파이어볼 합체
			temp[nr][nc].m += fire.m; //질량
			temp[nr][nc].s += fire.s; //속도
			if(temp[nr][nc].d != 8 && (temp[nr][nc].d%2) != (fire.d%2)) { //방향이 8 : 1,3,5,7 아니면, 0,2,4,6
				temp[nr][nc].d = 8;
			}
		} else {
			temp[nr][nc] = fire;
		}
	}
}
