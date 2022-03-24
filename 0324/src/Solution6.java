import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class Solution6 {

	public static void main(String[] args) {
		String[] prj = {"DBEX", "ACE", "CDX", "ABGX"};
		int n = 2;
		int k = 3;
		String answer = "";
		HashMap<Character,List<Character>> hmap = new HashMap<>();
		numbers = new int[n];
		//동료를 hmap에 저장
		for (String pr : prj) {
			char[] c = pr.toCharArray();
			for (int i = 0; i < c.length; i++) {
				for (int j = 0; j < c.length; j++) {
					if(c[i]==c[j]) continue;
					if(!hmap.containsKey(c[i])) {
						List<Character> list = new ArrayList<>();
						list.add(c[j]);
						hmap.put(c[i], list);
					} else {
						if(!hmap.get(c[i]).contains(c[j])) {
							hmap.get(c[i]).add(c[j]);
							hmap.replace(c[i], hmap.get(c[i]));
						}
					}
				}
			}
		}
		for (Entry<Character, List<Character>> entry : hmap.entrySet()) {
			Collections.sort(entry.getValue());
		}
		for (Entry<Character, List<Character>> entry : hmap.entrySet()) {
			System.out.println(entry.getKey()+" "+entry.getValue().toString());
		}
		
		
	}
	static int[] numbers;
	public static void combination(int cnt,int start,List<Character> list) {
		if(cnt==list.size()) {
			
			return;
		}
		for (int i = start; i < list.size(); i++) {
			numbers[cnt] = i;
			combination(cnt+1,i+1,list);
		}
	}

}
