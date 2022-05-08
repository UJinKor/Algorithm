import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1697_숨바꼭질 {
	static boolean[] checked = new boolean[100001];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		if(N>=K) {
			System.out.println(N-K);
		} else {
			System.out.println(bfs(N,K));
		}
		
	}
	public static int bfs(int start,int target) {
		Queue<Integer> queue = new LinkedList<>();
		int level = 0;
		queue.offer(start);
		checked[start] =true;
		while(!queue.isEmpty()) {
			int size = queue.size();
			while(size-->0) {
				int current = queue.poll();
				if(current==target) {
					return level;
				}
				int[] next = {current+1,current-1,current*2};
				for (int i = 0; i < 3; i++) {
					if(next[i]<=100000&&next[i]>=0&&!checked[next[i]]) {
						queue.offer(next[i]);
						checked[next[i]] = true;
					}
				}
			}
			level++;
		}
		return -1;
	}
}