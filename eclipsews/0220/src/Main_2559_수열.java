import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
//22480	228
public class Main_2559_수열 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int temperature[] = new int[N];
		st = new StringTokenizer(br.readLine()," ");
		for (int i = 0; i < N; i++) {
			temperature[i] = Integer.parseInt(st.nextToken());
		}
		int max=Integer.MIN_VALUE; 
		int prevSum=0;
		int sum;
		for (int i = 0; i < N-K+1; i++) {
			if(i==0) { //처음 시작할때는 다 더함
				sum = 0;
				for (int j = 0; j < K; j++) {
					sum+=temperature[j];
				}
				prevSum = sum;
				max = sum;
			} else {
				sum = prevSum-temperature[i-1]+temperature[i+K-1];//슬라이딩 윈도우
				max = Math.max(max,sum);
				prevSum = sum;
			}
		}
		
		System.out.println(max);
		
	}

}
