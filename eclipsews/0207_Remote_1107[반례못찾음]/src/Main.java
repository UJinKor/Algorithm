import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
////반례:
/*
99933
2
3 9 
 */

public class Main {
	static int nearest = 500000;
	static int nearestNum;
	static List<Integer> buttons = new ArrayList<>();
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		StringTokenizer st = null;
		if (m != 0)
			st = new StringTokenizer(br.readLine(), " ");
		List<Integer> brokens = new ArrayList<>(m);
		for (int i = 0; i < m; i++) {
			brokens.add(Integer.parseInt(st.nextToken()));
		}

		for (int i = 0; i < 10; i++) {
			if (!brokens.contains(i))
				buttons.add(i);
		}
		int Nlen = intlen(N);
		permu(Nlen+1,false, 0);
		System.out.println(Math.min(nearest, Math.abs(100-N)));
	}

	public static void permu(int cnt, boolean prev, int num) {
		if (cnt == 0) {
			if(!prev&&num==0) return;
			
			nearest = Math.min(Math.abs(N - num) + intlen(num), nearest);
			System.out.println(num+" "+nearest);
			return;
		}
		if(!prev) permu(cnt-1,false,num);
		for (Integer b : buttons) {
			if(cnt==intlen(N)&&b==0&&intlen(N)!=1) continue;
			permu(cnt - 1,true, num * 10 + b);
		}
	}

	public static int intlen(int n) {
		if (n == 0) {
			return 1;
		} else {
			return (int) Math.log10(n) + 1;
		}
	}

}
