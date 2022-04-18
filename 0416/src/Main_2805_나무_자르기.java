import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2805_나무_자르기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] trees = new int[N];
		st = new StringTokenizer(br.readLine()," ");
		for (int i = 0; i < N; i++) {
			trees[i] = Integer.parseInt(st.nextToken());
		}
		long start = 0;
		long end = 2000000000;
		long mid = (start+end)/2;
		long sum = 0;
		long ans = 0;
		
		while(start<end) {
			mid = (start+end)/2;
			sum = 0;
			for (int i = 0; i < N; i++) {
				if(mid<trees[i]) {
					sum+=trees[i]-mid;
				}
			}
			if(sum<M) { // 목표량보다 적으면 높이를 낮추기
				end = mid;
			} else { // 목표량보다 많거나 같으면 높이를 높히기
				ans = mid;
				start = mid+1;
			}
		}
		System.out.println(ans);
	}

}
