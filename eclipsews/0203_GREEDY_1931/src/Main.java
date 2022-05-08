import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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
		
		Arrays.sort(startEnd, (o1,o2) -> {
			if(o1[1]==o2[1]) return o1[0]-o2[0];
			else return o1[1]-o2[1];
		}); //2차원 배열 end순 오름차순 정렬
		
		int end=startEnd[0][1];
		int cnt=1;
		for (int i = 1; i < n; i++) {
			if(startEnd[i][0]>=end) {
				end = startEnd[i][1];
				cnt++;
			}
		}
		System.out.println(cnt);
	}

}
