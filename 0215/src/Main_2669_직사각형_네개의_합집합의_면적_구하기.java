import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main_2669_직사각형_네개의_합집합의_면적_구하기 {
	static boolean[][] arr = new boolean[101][101];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine()," ");
			addSquare(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		int cnt = 0;
		for (int i = 0; i < 101; i++) {
			for (int j = 0; j < 101; j++) {
				if(arr[i][j]) cnt++;
			}
		}
		System.out.println(cnt);
	}
	
	public static void addSquare(int sc,int sr,int ec,int er) {
		for (int i = sr; i < er; i++) {
			for (int j = sc; j < ec; j++) {
				arr[i][j] = true;
			}
		}
	}

}
