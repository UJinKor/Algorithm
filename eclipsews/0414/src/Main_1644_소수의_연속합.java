import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
// 메모리: 	26132kb
// 수행시간: 	312kb
public class Main_1644_소수의_연속합 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		List<Integer> prime = new ArrayList<>();
		
		boolean[] che = new boolean[N+1];
		for (int i = 2; i <= N; i++) {
			if(!che[i]) prime.add(i);
			for (int j = i; j <= N; j+=i) {
				che[j] = true;
			}
		}
		
		int index;
		int answer = 0;
		int size = prime.size();
		for(int i=0;i<size;i++){ 
			if(prime.get(i)>N) break;//구하고자 하는 구간합보다 start인덱스 위치의 소수가 작거나 같을때
			int sum = 0;
			index = i;
			while(sum<N) {
				if(index>=size) break;
				sum+=prime.get(index++);
			}
			if(sum==N) answer++;
		}
		System.out.println(answer);
	}

}
