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
		
		
		//배열생성해서 뒷자리부터 M만큼 0이 아닌수로 채우기
		int[] p = new int[N];
		int cnt=0;
		while(++cnt<=M) p[N-cnt] = 1;
		
		do {
			for (int i = 0; i < N; i++) {
				if(p[i] != 0) {
					System.out.print(input[i]+" ");
				}
			}
			System.out.println();
		} while(np(p));
		
//		combination(0,0);
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
	
	private static boolean np(int[] p) {
		
		//꼭대기 찾기
		int i=N-1;
		while(i>0&&p[i-1]>=p[i]) --i;
		
		if(i==0) return false; //i는 꼭대기 0이란건 다음 순열이 없다는 뜻
		
		//교환 위치 찾기
		int j=N-1;
		while(p[i-1]>=p[j]) --j;
		
		//교환하기
		swap(i-1,j,p);
		
		//꼭대기~끝까지 오름차순
		int k=N-1;
		while(i<k) {
			swap(i++,k--,p);
		}
		
		return true;
	
	}
	
	private static void swap(int i,int j,int[] p) {
		int temp = p[i];
		p[i] = p[j];
		p[j] = temp;
	}

}
