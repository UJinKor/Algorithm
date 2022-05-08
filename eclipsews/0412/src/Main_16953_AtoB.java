import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_16953_AtoB {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		long A = sc.nextLong();
		long B = sc.nextLong();
		
		System.out.println(findNum(A,B));
		
	}
	
	public static int findNum(long N,long target) {
		
		Queue<Long> queue = new LinkedList<>();
		queue.offer(N);
		int level=1;
		while(!queue.isEmpty()) {
			int size = queue.size();
			while(size-->0) {
				long current = queue.poll();
				if(current>target) continue;
				if(current==target) return level;
				queue.offer(current*2);
				queue.offer(current*10+1);
			}
			level++;
		}
		return -1;
	}
}
