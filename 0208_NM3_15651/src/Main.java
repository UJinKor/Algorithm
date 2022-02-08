import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//113384	524
public class Main {
	static int N,M;
	static StringBuffer sb = new StringBuffer();
	static int[] numbers, input;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		input = new int[N];
		numbers = new int[M];
		for (int i = 0; i < N; i++) {
			input[i]=i+1;
		}
		permutation(0);
		System.out.println(sb);
	}
	
	public static void permutation(int cnt) {
		if(cnt==M) {
			for (int i = 0; i < cnt; i++) {
				sb.append(numbers[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = 0; i < N; i++) {
				numbers[cnt] = input[i];
				permutation(cnt+1);
			
		}
	}

}
