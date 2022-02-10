import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int max = 1;
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		getMax(arr);
		int[] reverseArr = new int[N];
		for (int i = 0;i<N;i++) {
			reverseArr[N-i-1] = arr[i];
		}
		getMax(reverseArr);
		System.out.println(max);
	}

	public static void getMax(int[] arr) {
		int cnt = 1;
		int index = 0;
		while (true) {
			if (index == N - 1) {
				max = Math.max(max, cnt);
				break;
			}
			if (arr[index] <= arr[index + 1]) {
				cnt++;
				index++;
			} else {
				index++;
				max = Math.max(max, cnt);
				cnt = 1;
			}

		}
	}

}
