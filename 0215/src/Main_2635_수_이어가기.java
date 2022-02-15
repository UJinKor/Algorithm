import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2635_수_이어가기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int cnt;
		int max = 0;// 최대길이(정답)
		int maxNext = n;// 최대길이(정답) 배열의 맨 마지막 인덱스
		int maxFirst = n;// 최대길이(정답) 배열의 마지막에서 두번째 인덱스
		
		int next;
		for (int i = 1; i <= 30000; i++) {
			cnt=2;
			int first = n;
			next=i;
			while(true) {
				int temp = next;//next값을 임시저장
				next = first-next;//앞의 값과 뒤의 값을 뺀 것을 뒤의 값에 저장
				if(next<0) {
					next = temp;
					break;
				}
				first = temp;//앞의 값은 뒤에 값에 저장하고 반복
				cnt++;
			}
			if(max<cnt) {//max값 갱신
				max = cnt;
				maxFirst = first;
				maxNext = next;
			}
		}
		System.out.println(max);
		StringBuilder sb = new StringBuilder();
		int count =maxFirst+maxNext;
		int ans[] = new int[max];
		int index = max-1;
		ans[index--] = maxNext;//마지막 인덱스 대입
		ans[index--] = maxFirst;//마지막에서 두번째 인덱스 대입
		while(index>=0) {
			ans[index--] = count;//배열의 뒤부터 더해감
			int temp = count;//직전값 저장
			count += maxFirst;//배열로 치면 arr[i] = arr[i+1]+arr[i+2]
			maxFirst = temp;//직전값 다시 대입
		}
		for (int i = 0; i < max; i++) {
			sb.append(ans[i]+" ");
		}
		System.out.println(sb);
	}

}
