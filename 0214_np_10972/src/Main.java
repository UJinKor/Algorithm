import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int numbers[],N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		numbers = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		if(np()) {
			for (int i = 0; i < N; i++) {
				sb.append(numbers[i]+" ");
			}
			System.out.println(sb);
			
		}
		else {
			System.out.println(-1);
		}
	}
	
	
	private static boolean np() {
		//교환 위치 찾기 i : 꼭대기, i-1 : 교환위치
		int i = N-1;
		while(i>0&&numbers[i-1]>=numbers[i]) --i;
		if(i==0) return false;
		//끝에서부터 처음으로 교환위치보다 커지는 수 찾기
		int j = N-1;
		while(numbers[i-1]>=numbers[j]) --j;
		//교환
		swap(i-1,j);
		
		//꼭대기 ~ 끝까지 오름차순
		int k = N-1;
		while(i<k) {
			swap(i++,k--);
		}
		return true;
	}
	
	public static void swap(int i,int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}
	

}
