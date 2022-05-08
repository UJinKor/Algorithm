import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String s;
		StringTokenizer st = null;
		Map<String,Integer> map = new HashMap<String,Integer>();
		while(n-->0) {
			s = br.readLine();
			st = new StringTokenizer(s," ");
			String name = st.nextToken();
			st.nextToken();
			if(map.containsKey(name)) map.put(name,map.get(name)+1);
			else map.put(name, 1);
		}
		List<String> list = new ArrayList<>();
		for(Entry<String,Integer> entry : map.entrySet()) {
			if(entry.getValue()%2==1) {
				list.add(entry.getKey());
			}
		}
		
		Collections.sort(list,Collections.reverseOrder());
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

}
