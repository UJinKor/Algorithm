import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2508 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		for (int tc = 0; tc < t; tc++) {
			br.readLine();
			st = new StringTokenizer(br.readLine()," ");
			
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			char[][] arr = new char[r][];
			for (int i = 0; i < r; i++) {
				String s = br.readLine();
				arr[i] = s.toCharArray();
			}
			int answer = 0;
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					if(arr[i][j]=='>') {
						if(j<c-2 && arr[i][j+1] == 'o' && arr[i][j+2] == '<') {
							answer++;
						}
					} else if(arr[i][j] == 'v') {
						if(i<r-2 && arr[i+1][j] == 'o' && arr[i+2][j] == '^') {
							answer++;
						}
					}
				}
			}
			
			System.out.println(answer);
			
		}
	}

}
