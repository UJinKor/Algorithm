import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
// 3190 뱀
public class Main {
	static class Direction{
		int x;
		char C;
		public Direction(int x, char c) {
			super();
			this.x = x;
			C = c;
		}
	}
	
	int[] dr = {0,1,0,-1};//우 로 시작, 인덱스가 늘어나면 오른쪽, 줄어들면 왼쪽
	int[] dc = {1,0,-1,0};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		
		
		int[][] arr = new int[N][N];
		
		StringTokenizer st = null;
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine()," ");
			arr[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1; // 사과 = 1
		}
		int L = Integer.parseInt(br.readLine());
		Queue<Direction> dirQueue = new LinkedList<>(); // 방향을 저장하는 큐
		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine()," ");
			dirQueue.offer(new Direction(Integer.parseInt(st.nextToken()),st.nextToken().charAt(0)));
		}
	}
}
