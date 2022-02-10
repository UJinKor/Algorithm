import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int YMELON = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		int[] dir = new int[6];
		int[] len = new int[6]; 
		HashMap<Integer,Integer> count = new HashMap<>();
		for (int i = 0; i < 6; i++) {
			st = new StringTokenizer(br.readLine()," ");
			dir[i] = Integer.parseInt(st.nextToken());
			len[i] = Integer.parseInt(st.nextToken());
			if(!count.containsKey(dir[i])) count.put(dir[i], 1);
			else count.put(dir[i], count.get(dir[i])+1);
		}
		int start = 0;//긴변찾기
		for (int i = 0; i < 6; i++) {
			if(count.get(dir[i])==1) start = i;
		}
		int[] bigRectangle = new int[2];
		int bigP = 0;
		int countTwo = 0;//count가 2인 input 몇번째인지 카운트
		int[] smallRectangle = new int[2];
		int smallP = 0;
		for (int i = 0; i < 6; i++) {
			if(count.get(dir[start])==1) {
				bigRectangle[bigP++] = len[start];
			} else if(count.get(dir[start])==2) {
				countTwo++;
				if(countTwo==2||countTwo==3) {//가운데 값 추출
					smallRectangle[smallP++] = len[start];
					
				}
			}
			start=++start%6;
		}
		int ans = YMELON*((bigRectangle[0]*bigRectangle[1]) - (smallRectangle[0]*smallRectangle[1]));
		System.out.println(ans);
	}

}
