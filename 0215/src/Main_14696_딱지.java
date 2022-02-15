import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_14696_딱지 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		Integer[] arr1,arr2;
		int n,m;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			n = Integer.parseInt(st.nextToken());
			arr1 = new Integer[n];
			for (int j = 0; j < n; j++) {
				arr1[j] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine()," ");
			m = Integer.parseInt(st.nextToken());
			arr2 = new Integer[m];
			for (int j = 0; j < m; j++) {
				arr2[j] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr1,Collections.reverseOrder());
			Arrays.sort(arr2,Collections.reverseOrder());
			sb.append(compare(arr1,arr2)).append("\n");
		}
		System.out.println(sb);
	}
	
	public static char compare(Integer[] me, Integer[] you) { //정렬된 값만 들어와야함
		char winner;
		int n;
		if(me.length>you.length) {
			n = you.length;
			winner = 'A';
		} else if(me.length<you.length) {
			n = me.length;
			winner = 'B';
		} else {
			n = me.length;
			winner = 'D';
		}
		for (int i = 0; i < n; i++) {
			if(me[i]>you[i]) {
				winner = 'A';
				break;
			}
			else if(me[i]<you[i]) {
				winner = 'B';
				break;
			}
		}
		return winner;
	}

}
