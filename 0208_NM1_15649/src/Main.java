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
		for (int i = 1; i <= N; i++) {
			input[i-1]=i;
		}
		permutation2(0,0);
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
				numbers[cnt] = input[i];
				isCalled[i] = true;
				permutation(cnt+1,isCalled);
				isCalled[i] = false;
			}
		}
	}
	
	public static void permutation2(int cnt,int flag) {
		if(cnt==M) {
			for (int i = 0; i < cnt; i++) {
				sb.append(numbers[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		//입력받은 모든 수를 현재 자리에 넣어보기
		for (int i = 0; i < N; i++) {
			//기존 자리의 수들과 중복되는지 체크
			if((flag & 1<<i) != 0) continue;
			numbers[cnt] = input[i];
			permutation2(cnt+1,flag|1<<i);
		}
	}

}
