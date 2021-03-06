import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		
		List<Integer> queue = new ArrayList<>(n);
		for (int i = 0; i < n; i++) {
			queue.add(i+1);
		}
		
		st = new StringTokenizer(br.readLine()," ");
		int total = 0;
		int k;
		int point = 0;
		for (int i = 0; i < m; i++) {
			k = Integer.parseInt(st.nextToken());
			int n1,n2;
			int indexk = queue.indexOf(k);
			if(indexk == point) {
				
			} else if(indexk > point) {
				n1 = indexk-point;
				n2 = point+queue.size()-indexk;
				
				if(n1 > n2) {
					total+=n2;
				}
				else {
					total+=n1;
				}
				
			} else {
				n1 = point-indexk;
				n2 = indexk+queue.size()-point;
				if(n1 > n2) {
					total+=n2;
				}
				else {
					total+=n1;
				}
				
			}
			queue.remove(indexk);
			if(queue.size()!=0)
				point = indexk%queue.size();
			
		}
		System.out.println(total);
	}

}
