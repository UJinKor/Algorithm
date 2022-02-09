import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static boolean[][] paper = new boolean[100][100];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine()," ");
			post(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		int cnt = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if(paper[i][j]) cnt++;
			}
		}
		System.out.println(cnt);
	}
	
	public static void post(int m,int n) {
		for (int i = n; i < n+10; i++) {
			for (int j = m; j < m+10; j++) {
				paper[i][j] = true;
			}
		}
	}

}
