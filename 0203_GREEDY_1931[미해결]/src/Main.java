import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] startEnd = new int[n][2];
		StringTokenizer st = null;
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine()," ");
			startEnd[i][0] = Integer.parseInt(st.nextToken());
			startEnd[i][1] = Integer.parseInt(st.nextToken());
		}
		
		
	}

}
