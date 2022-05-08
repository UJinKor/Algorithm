import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_5014_스타트링크 {
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());
		int goal = Integer.parseInt(st.nextToken());
		int dir[] = {Integer.parseInt(st.nextToken()),-Integer.parseInt(st.nextToken())};
		bfs(start,goal,new boolean[1000001],dir);
	}
	
	public static void bfs(int start, int target, boolean[] visited,int[] dir) {
		
		Queue<Integer> queue = new LinkedList<>();
		visited[start] = true;
		queue.offer(start);
		int level = 0;
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			while(size-->0) {
				int current = queue.poll();
				if(current==target) {
					System.out.println(level);
					return;
				}
				for (int i = 0; i < 2; i++) {
					int next = current+dir[i];
					if(next<=N&&next>=1&&!visited[next]) {
						visited[next] = true;
						queue.offer(next);
					}
				}
			}
			level++;
		}
		System.out.println("use the stairs");
	}
}
