import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int money = k;
		int count = 0;
		List<Integer> coins = new ArrayList<>(n);
		for (int i = 0; i < n; i++)
			coins.add(Integer.parseInt(br.readLine()));
		for (int i=n-1;i>=0;i--) {
			if (coins.get(i)<= money) {
				while(coins.get(i)<=money) {
					if(money-coins.get(i)<0) break;
					money-=coins.get(i);
					count++;
				}
			}
		}
		
		System.out.println(count);
	}

}
