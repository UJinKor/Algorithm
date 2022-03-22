import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Solution_1 {
	
	public static void main(String[] args) {
		String[] goods={"pencil","cilicon","contrabase","picturelist"};
		String[] answer = new String[goods.length];
		
		HashMap<String,Integer[]> hmap = new HashMap<>(); // Integer[2] = index,count
		
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < goods.length; i++) { 
			for (int j = 1; j <= goods[i].length(); j++) { // 부문자열의 길이
				int start = 0;
				while(start+j<=goods[i].length()) {
					for (int j2 = start; j2 < start+j; j2++) { //부문자열 만들기
						s.append(goods[i].charAt(j2));
					}
					start++;
					if(!hmap.containsKey(s.toString())) {
						hmap.put(s.toString(), new Integer[] {i,1}); // 1 이면 사용가능한 검색어
					} else {
						if(hmap.get(s.toString())[0] != i) {
							hmap.replace(s.toString(), new Integer[] {i,2}); // 2면 사용불가능한 검색어
						}
					}
//					System.out.println(s);
					s.delete(0, s.length());
				}
			}
		}
		
		int[] minLen = new int[goods.length];
		Arrays.fill(minLen, 101);
		ArrayList<ArrayList<String>> anslist = new ArrayList<>();
		for (int i = 0; i < goods.length; i++) {
			anslist.add(new ArrayList<String>());
		}
		for (String key : hmap.keySet()) {
			Integer[] val = hmap.get(key);
			if(val[1]==1 && minLen[val[0]]>=key.length()) {
				if(minLen[val[0]]>key.length()) {
					anslist.get(val[0]).clear();
				}
				anslist.get(val[0]).add(key);
				minLen[val[0]] = key.length();
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < goods.length; i++) {
			if(anslist.get(i).size() == 0) {
				answer[i] = "None";
			} else {
				Collections.sort(anslist.get(i));
				for (String ans : anslist.get(i)) {
					sb.append(ans+" ");
				}
				sb.setLength(sb.length()-1);
				answer[i] = sb.toString();
				sb.delete(0, sb.length());
			}
		}
//		for (int i = 0; i < goods.length; i++) {
//			System.out.println(answer[i]);
//		}
		
	}

}
