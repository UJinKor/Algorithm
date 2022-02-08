import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//11596kb	80ms
public class Main {
	static int N,M;
	static StringBuffer sb = new StringBuffer();
	static int[] numbers, input;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		boolean[] isCalled = new boolean[N];
		input = new int[N];
		numbers = new int[M];
		for (int i = 0; i < N; i++) {
			input[i]=i;
		}
		permutation(0,isCalled);
		System.out.println(sb);
	}
	
	public static void permutation(int cnt,boolean[] isCalled) {
		if(cnt==M) {
			for (int i = 0; i < cnt; i++) {
				sb.append(numbers[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = 0; i < N; i++) {
			if(!isCalled[i]) {
				numbers[cnt] = input[i]+1;
				isCalled[i] = true;
				permutation(cnt+1,isCalled);
				isCalled[i] = false;
			}
			
		}
	}

}
