import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_9205_맥주_마시면서_걸어가기 {
	static int N,arr[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 0; tc < T; tc++) {
			N = Integer.parseInt(br.readLine());
			N+=2;
			arr = new int[N][2];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine()," ");
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
			}
			if(bfs(0,new boolean[N])) {
				sb.append("happy");
			} else {
				sb.append("sad");
			}
			sb.append("\n");
		}
		System.out.println(sb);
		
	}
	public static boolean bfs(int start,boolean[] visited) {
		Queue<Integer> queue = new LinkedList<>();
		visited[start] = true;
		queue.offer(start);
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			if(current==N-1) {//인덱스가 페스티벌이면
				return true;
			}
			for (int i = 0; i < N; i++) {
				int dist = getDist(arr[current],arr[i]);
				if(i!=current&&!visited[i]&&dist<=1000) {
					visited[i] = true;
					queue.offer(i);
				}
			}
		}
		return false;
	}
	
	public static int getDist(int[] xy, int[] xy2) {
		return Math.abs(xy[0]-xy2[0])+Math.abs(xy[1]-xy2[1]);
	}
}
