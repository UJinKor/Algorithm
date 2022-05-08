import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
// 3190 뱀
public class Main_3190_뱀 {
	static class Direction{
		int x;
		char C;
		public Direction(int x, char c) {
			super();
			this.x = x;
			C = c;
		}
	}
	
	static int N, arr[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		
		arr = new int[N][N];
		
		StringTokenizer st = null;
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine()," ");
			arr[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1] = 2; // 사과 = 2
		}
		arr[0][0] = 1; // 뱀 = 1
		int L = Integer.parseInt(br.readLine());
		Queue<Direction> dirQueue = new LinkedList<>(); // 방향을 저장하는 큐
		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine()," ");
			dirQueue.offer(new Direction(Integer.parseInt(st.nextToken()),st.nextToken().charAt(0)));
		}
		
		System.out.println(move(dirQueue));
		
	}
	static int[] dr = {0,1,0,-1};//우 로 시작, 인덱스가 늘어나면 오른쪽, 줄어들면 왼쪽
	static int[] dc = {1,0,-1,0};
	public static int move(Queue<Direction> dirQueue) {
		int sec = 1;
		int dir = 0;
		Deque<int[]> snake = new LinkedList<>();
		snake.offerFirst(new int[] {0,0});
		Direction change= dirQueue.poll();
		while(true) {
			while(sec<=change.x) {
				int[] head = snake.getFirst();
				int nr = head[0]+dr[dir];
				int nc = head[1]+dc[dir];
				if(nr<0 || nc<0 || nr>=N || nc>=N || arr[nr][nc] == 1) {
					return sec;
				}
				snake.offerFirst(new int[] {nr,nc}); // head 변경
				if(arr[nr][nc] != 2) { // 사과 안먹으면 꼬리 이동
					int[] tail = snake.pollLast();
					arr[tail[0]][tail[1]] = 0;
				}
				arr[nr][nc] = 1;
//				System.out.println(sec+"초");
//				for (int i = 0; i < N; i++) {
//					System.out.println(Arrays.toString(arr[i]));
//				}
//				System.out.println(dir);
//				System.out.println("------------------");
				sec++;
			}
			if(change.C=='L') {
				dir = dir-1<0?3:dir-1;
			} else {
				dir = (dir+1)%4;
			}
			if(!dirQueue.isEmpty()) {
				change = dirQueue.poll();
			} else { // 더이상 방향전환이 없다.
				change = new Direction(Integer.MAX_VALUE,change.C);
			}
		}
	}
}
