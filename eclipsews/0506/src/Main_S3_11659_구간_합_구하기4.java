import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S3_11659_구간_합_구하기4 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] sumArr = new int[N];
		st = new StringTokenizer(br.readLine());
		sumArr[0] = Integer.parseInt(st.nextToken());
		for (int i = 1; i < N; i++) { // 0~i까지의 합 저장
			sumArr[i] = sumArr[i-1]+Integer.parseInt(st.nextToken());
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken())-1;
			int end = Integer.parseInt(st.nextToken())-1;
			int n = sumArr[end];
			if(start!=0)
				n -= sumArr[start-1];
			sb.append(n).append("\n");
		}
		System.out.println(sb);
	}

}
