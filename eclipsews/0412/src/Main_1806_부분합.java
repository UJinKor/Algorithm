import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1806_부분합 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		
		int arr[] = new int[N];
		st = new StringTokenizer(br.readLine()," ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int start = 0;
		int end = 0;
		long sum = arr[start];
		int len = 1;
		int min = Integer.MAX_VALUE;
		while(start<N) {
			len = end-start+1;
			if(sum>=S) {
				min = Math.min(min, len);
				if(len==1) break;
				sum-=arr[start++];
			} else {
				if(end<N-1) sum+=arr[++end];
				else break;
			}
		}
		if(min==Integer.MAX_VALUE) min = 0;
		System.out.println(min);
	}

}
