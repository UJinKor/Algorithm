import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
//	11496	80
public class Main {
	static int[] trueDwarf;
	static StringBuilder sb = new StringBuilder();
	static int[] dwarf;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		dwarf = new int[9];
		trueDwarf = new int[7];
		for (int i = 0; i < 9; i++) {
			dwarf[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(dwarf);
		combination(0,0,0);
		System.out.println(sb);
		
	}
	
	public static void combination(int cnt,int start,int sum) {
		if(sum>100) return;
		if(sb.length()!=0) return;
		if(cnt==7) {
			if(sum==100) {
				for (int i = 0; i < trueDwarf.length; i++) {
					sb.append(trueDwarf[i]+"\n");
				}
			}
			return;
		}
		for (int i = start; i < 9; i++) {
			trueDwarf[cnt] = dwarf[i];
			combination(cnt+1,i+1,sum+dwarf[i]);
		}
	}

}
