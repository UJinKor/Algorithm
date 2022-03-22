import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main_1920 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
//		//해시셋
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int N = Integer.parseInt(br.readLine());
//		
//		StringTokenizer st = new StringTokenizer(br.readLine()," ");
//		HashSet<Integer> set = new HashSet<>();
//		
//		for (int i = 0; i < N; i++) {
//			set.add(Integer.parseInt(st.nextToken()));
//			
//		}
//		int M = Integer.parseInt(br.readLine());
//		st = new StringTokenizer(br.readLine()," ");
//		int A[] = new int[M];
//		for (int i = 0; i < M; i++) {
//			A[i] = Integer.parseInt(st.nextToken());
//		}
//		
//		StringBuilder sb = new StringBuilder();
//		for (int i : A) {
//			if(set.contains(i)) sb.append(1+"\n");
//			else sb.append(0+"\n");
//		}
//		System.out.println(sb);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int A[] = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		Arrays.sort(A);
		for (int i = 0; i < M; i++) {
			int n = Integer.parseInt(st.nextToken());
			if(Arrays.binarySearch(A, n)>=0) {
				sb.append(1+"\n");
			} else {
				sb.append(0+"\n");
			}
		}
		System.out.println(sb);
	}
}
