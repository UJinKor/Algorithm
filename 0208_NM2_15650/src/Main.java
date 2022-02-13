import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//	11596kb	80ms
public class Main {
	static int N,M;
	static StringBuffer sb = new StringBuffer();
	static int[] numbers, input;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		numbers = new int[M];
		input = new int[N];
		for (int i = 0; i < N; i++) {
			input[i] = i+1;
		}
		combination(0,0);
		System.out.println(sb);
	}
	
	public static void combination(int cnt,int start) {
		if(cnt==M) {
			for (int num : numbers) {
				sb.append(num+" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = start; i < N; i++) {
			numbers[cnt] = input[i];
			combination(cnt+1,i+1);
		}
	}

}
