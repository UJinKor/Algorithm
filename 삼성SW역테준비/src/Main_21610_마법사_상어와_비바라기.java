import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_21610_마법사_상어와_비바라기 {
	static int N,arr[][];
	static boolean prevCloud[][];
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][N];
		clouds = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		clouds.add(new int[] {N-1,0});
		clouds.add(new int[] {N-1,1});
		clouds.add(new int[] {N-2,0});
		clouds.add(new int[] {N-2,1});
		for (int i = 0; i < M; i++) {
			prevCloud = new boolean[N][N];
			st = new StringTokenizer(br.readLine()," ");
			int d = Integer.parseInt(st.nextToken())-1;
			int s = Integer.parseInt(st.nextToken())%N;
			move(d,s);
			copyWater();
			makeCloud();
		}
		System.out.println(countWater());
	}
	
	static int[] dr = {0,-1,-1,-1,0,1,1,1};
	static int[] dc = {-1,-1,0,1,1,1,0,-1};
	static List<int[]> clouds; // 구름의 좌표
	public static void move(int d, int s) { // 이동 후 물의 양 증가
		for (int i = 0; i < clouds.size(); i++) {
			int[] cloud = clouds.get(i);
			for (int j = 0; j < s; j++) {
				int nr = cloud[0]+dr[d];
				int nc = cloud[1]+dc[d];
				if(nr<0) {
					nr = N-1;
				}
				if(nc<0) {
					nc = N-1;
				}
				if(nr>=N) {
					nr = 0;
				}
				if(nc>=N) {
					nc = 0;
				}
				cloud[0] = nr;
				cloud[1] = nc;
			}
			arr[cloud[0]][cloud[1]]++;
			prevCloud[cloud[0]][cloud[1]] = true;
		}
	}
	
	public static void copyWater() { // 물복사 버그
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(prevCloud[i][j]) {
					for (int j2 = 0; j2 < 4; j2++) {
						int rChk = i+dr[j2*2+1];
						int cChk = j+dc[j2*2+1];
						if(rChk<0 || cChk<0 || rChk>=N || cChk>=N) continue;
						if(arr[rChk][cChk]>0) arr[i][j]++;
					}
				}
			}
		}
	}
	
	public static void makeCloud() {
		clouds.clear();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!prevCloud[i][j] && arr[i][j]>=2) {
					clouds.add(new int[] {i,j});
					arr[i][j] -= 2;
				}
			}
		}
	}
	public static int countWater() {
		int sum = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sum += arr[i][j];
			}
		}
		return sum;
	}
}
