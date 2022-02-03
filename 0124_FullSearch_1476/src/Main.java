import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int E = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		while(E != S || S != M) {
			int i = findmin(E,S,M);
			switch(i) {
			case 0:
				E+=15;
				break;
			case 1:
				S+=28;
				break;
			case 2:
				M+=19;
				break;
			}
		}
		System.out.println(E);
	}
	public static int findmin(int e,int s,int m) {
		int min = Integer.MAX_VALUE;
		int mini = -1;
		int arr[] = {e,s,m};
		for (int i = 0; i < arr.length; i++) {
			if(min>arr[i]) {
				min = arr[i];
				mini = i;
			}
		}
		
		return mini;
	}
}
