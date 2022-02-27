import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7569_토마토 {
	static int N,M,H;
	static int[][][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		arr = new int[H][N][M];
		int zero =0;
		List<Integer[]> list = new ArrayList<>();//i,j,j2 정보 저장
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine()," ");
				for (int j2 = 0; j2 < M; j2++) {
					arr[i][j][j2] = Integer.parseInt(st.nextToken());
					if(arr[i][j][j2]==0) zero ++;
					if(arr[i][j][j2]==1) list.add(new Integer[] {i,j,j2});
				}
			}
		}
		int ans[] = bfs(list);//ans[0] : 0 에서 1로 바뀐 카운트 , ans[1] : 걸린 일수
		if(ans[0]!=zero) {
			System.out.println(-1);
		} else {
			System.out.println(ans[1]);
		}
	}
	static int r[] = {-1,0,1,0};
	static int c[] = {0,1,0,-1};
	static int h[] = {-1,1};
	public static int[] bfs(List<Integer[]> start) {
		int cnt = 0;
		int level = -1;
		Queue<Integer[]> queue = new LinkedList<>();
		for (Integer[] integers : start) {
			queue.offer(integers);
		}
		while(!queue.isEmpty()) {
			int size = queue.size();
			while(size-->0) {
				Integer[] current = queue.poll();
				for (int i = 0; i < 4; i++) {//사방
					int nr = current[1]+r[i];
					int nc = current[2]+c[i];
					if(nr>=0&&nc>=0&&nr<N&&nc<M&&arr[current[0]][nr][nc]==0) {
						arr[current[0]][nr][nc] =1;
						cnt++;
						queue.offer(new Integer[] {current[0],nr,nc});
					}
				}
				for (int i = 0; i < 2; i++) {//상하
					int nh = current[0]+h[i];
					if(nh>=0&&nh<H&&arr[nh][current[1]][current[2]]==0) {
						arr[nh][current[1]][current[2]] = 1;
						cnt++;
						queue.offer(new Integer[] {nh,current[1],current[2]});
					}
				}
			}
			level++;
		}
		return new int[] {cnt,level};
	} 

}
