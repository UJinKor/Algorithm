import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1654 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int arr[] = new int[K];
		int max = 0;
		for (int i = 0; i < K; i++) {
			int n = Integer.parseInt(br.readLine());
			max = Math.max(max, n);
			arr[i] = n;
		}
		long start = 0;
		long end = max;
		
		while(start<=end) {
			int cnt = 0;
			long mid = (end+start)/2;
			if(mid==0) {
				end = 1;
				break;
			}
			for (int i = 0; i < K; i++) {
				cnt += arr[i]/mid;
			}
			if(cnt<N) {
				end = mid-1;
			} else {
				start = mid+1;
			}
		}
		
		System.out.println(end);
	}

}
/*
2 2
1
2147483647
*/ 
