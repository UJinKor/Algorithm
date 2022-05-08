import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main_2108 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] Pcounter = new int[4001]; //양수 카운터
		int[] Ncounter = new int[4001]; //음수 카운터
		double sum = 0;
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(br.readLine());
			sum += n;
			arr[i] = n;
			if(n>=0) {
				Pcounter[n]++;
			} else {
				Ncounter[-n]++;
			}
		}
		Arrays.sort(arr);
		List<Integer> list = new ArrayList<>(); //최빈값 후보
		int maxCnt = 0;
		for (int i = 0; i < Ncounter.length; i++) {
			if(maxCnt<Pcounter[i]) {
				list.clear();
				list.add(i);
				maxCnt = Pcounter[i];
			} else if(maxCnt==Pcounter[i]) {
				list.add(i);
			}
			if(maxCnt<Ncounter[i]) {
				list.clear();
				list.add(-i);
				maxCnt = Ncounter[i];
			} else if(maxCnt==Ncounter[i]) {
				list.add(-i);
			}
		}
		System.out.println(Math.round(sum/N));
		System.out.println(arr[N/2]);
		if(list.size()>=2) {
			Collections.sort(list);
			System.out.println(list.get(1));
		} else {
			System.out.println(list.get(0));
		}
		System.out.println(arr[N-1]-arr[0]);
	}

}
