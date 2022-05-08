import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;
//41424	568
public class Main {
	static int N,M;
	static StringBuffer sb = new StringBuffer();
	static int[] numbers, input;
	static String[] str;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		boolean[] isCalled = new boolean[N];
		input = new int[N];
		numbers = new int[M];
		st= new StringTokenizer(br.readLine()," ");
		for (int i = 0; i < N; i++) {
			input[i]=Integer.parseInt(st.nextToken());
		}

		
		permutation(0,isCalled);
		HashSet<String> set = new HashSet<>();//set으로 중복제거
		
		st= new StringTokenizer(sb.toString(),"\n");
		while(st.hasMoreTokens()) {
			set.add(st.nextToken());
		}
		sb = new StringBuffer();
		List<String> list = new ArrayList<>(set);//list를 통해 정렬
		int[][]  arr = new int[list.size()][M];
		for (int i=0;i<list.size();i++) {
			st=new StringTokenizer(list.get(i)," ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		Arrays.sort(arr,(o1,o2)->{//list로 2차원배열 정렬 몰라서 arr로 바꿔서 정렬
			for(int i=0;i<M;i++) {
				if(o1[i] != o2[i]) return o1[i]-o2[i];
			}
			return o1[M-1]-o2[M-1];
		});
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
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

}
