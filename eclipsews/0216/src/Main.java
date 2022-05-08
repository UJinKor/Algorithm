import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		int[] switches = new int[N];
		st = new StringTokenizer(br.readLine()," ");
		for (int i = 0; i < N; i++) {
			switches[i] = Integer.parseInt(st.nextToken());
		}
		int M = Integer.parseInt(br.readLine());
		int gender;
		for (int i = 0; i < M; i++) {//학생수
			st = new StringTokenizer(br.readLine()," ");
			gender = Integer.parseInt(st.nextToken());
			if(gender==1) {//남
				manSwitching(switches,Integer.parseInt(st.nextToken()));
			} else if(gender==2) {//여
				womanSwitching(switches,Integer.parseInt(st.nextToken())-1);
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			if(i!=0&&i%20==0) sb.append("\n");
			sb.append(switches[i]+" ");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb.toString());
	}
	public static void manSwitching(int[] switches,int index) {
		for (int i = 1; i <= switches.length; i++) {
			if(i%index==0) {
				switches[i-1] = toggle(switches[i-1]);
			}
		}
	}
	public static void womanSwitching(int[] switches,int index) {
		int i=1;
		switches[index] = toggle(switches[index]);
		while(index-i>=0&&index+i<switches.length) {
			if(switches[index-i]==switches[index+i]) {
				switches[index-i] = toggle(switches[index-i]);
				switches[index+i] = toggle(switches[index+i]);
			} else break;
			i++;
		}
	}
	public static int toggle(int n) {
		if(n==0) return 1;
		else return 0;
	}

}
