import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int[][] paper = new int[1001][1001];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine()," ");
			post(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),i+1);
		}
		int cnt = 0;
		int ans[] = new int[n];
		for (int i = 0; i < 1001; i++) {
			for (int j = 0; j < 1001; j++) {
				if(paper[i][j]!=0) {//칠해져 있으면 무슨색
					ans[paper[i][j]-1] ++;
				}
			}
		}
		for (int i = 0; i < n; i++) {
			System.out.println(ans[i]);
		}
	}
	
	public static void post(int m,int n,int w,int h,int cnt) {//cnt의 값에 따라 종이의 색깔이 다름을 나타냄
		for (int i = n; i < n+h; i++) {
			for (int j = m; j < m+w; j++) {
				paper[i][j] = cnt;
			}
		}
	}

}
