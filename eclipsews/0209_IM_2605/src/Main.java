import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		LinkedList<Integer> list = new LinkedList<>();//끼어들기엔 링크드리스트가 체고
		int numSheet; // 뽑은 번호표
		
		for (int i = 0; i < n; i++) {
			numSheet = Integer.parseInt(st.nextToken());
			list.add(i-numSheet,i+1);//각 학생의 번호-1-번호표가 들어갈 자리
		}
		for (Integer l : list) {
			sb.append(l).append(" ");
		}
		System.out.println(sb);
	}
}
