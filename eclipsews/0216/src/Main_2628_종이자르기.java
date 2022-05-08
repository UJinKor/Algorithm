import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main_2628_종이자르기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine()," ");
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		List<Integer> wList = new ArrayList<>();
		List<Integer> hList = new ArrayList<>();
		int N = Integer.parseInt(br.readLine());
		int flag;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			flag = Integer.parseInt(st.nextToken());
			if(flag==1) {//가로
				wList.add(Integer.parseInt(st.nextToken()));//자르는 부위 저장
			} else if(flag==0) {//세로
				hList.add(Integer.parseInt(st.nextToken()));
			}
		}
		
		//정렬
		Collections.sort(wList);
		Collections.sort(hList);
		int cur = 0;
		int maxw = 0;
		for (Integer wIndex : wList) {//최대 가로길이 찾기
			maxw = Math.max(maxw, wIndex-cur);
			cur = wIndex;
		}
		maxw = Math.max(maxw, w-cur);
		cur = 0;
		int maxh = 0;
		for (Integer hIndex : hList) {//최대 세로길이 찾기
			maxh = Math.max(maxh, hIndex-cur);
			cur = hIndex;
		}
		maxh = Math.max(maxh, h-cur);
		System.out.println(maxw*maxh);
	}

}
