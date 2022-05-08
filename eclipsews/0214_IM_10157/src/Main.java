import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine()," ");
		int M = Integer.parseInt(st.nextToken());//가로
		int N = Integer.parseInt(st.nextToken());//세로
		
		int k = Integer.parseInt(br.readLine());
		
		if(N*M<k) {
			System.out.println("0");
		} else {
			int[][] theater = new int[N][M];
			int[] r = {1,0,-1,0};
			int[] c = {0,1,0,-1};
			int dir = 0;
			int curR=0;
			int curC=0;
			int cnt=1;
			int nr,nc;
			while(cnt<k) {
				theater[curR][curC] = cnt;
				nc = curC+c[dir];
				nr = curR+r[dir];
				
				if(nr>=N||nc>=M||nr<0||nc<0) {
					dir = ++dir%4;
					continue;
				}
				if(theater[nr][nc]!=0) {
					dir = ++dir%4;
					continue;
				}
				curR = nr;
				curC = nc;
				cnt++;
			}
			System.out.println((curC+1)+" "+(curR+1));
		}
	}

}
