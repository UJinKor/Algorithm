import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_20055_컨베이어_벨트_위의_로봇 {
	static int N,K,belt[],zeroCount;
	static Queue<Integer> robots;
	static boolean[] isRobot;
	
 	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		belt = new int[N*2];
		st = new StringTokenizer(br.readLine()," ");
		for (int i = 0; i < N*2; i++) {
			belt[i] = Integer.parseInt(st.nextToken());
		}
		robots = new LinkedList<>();
		isRobot = new boolean[N*2];
		zeroCount = 0;
		int round = 0;
		while(true) {
			round++;
			rotate();
			moveRobots();
			setRobot();
			if(chkEnd()) 
				break;
		}
		System.out.println(round);
	}
	
	public static void rotate() { // 1단계
		int[] temp = new int[N*2];
		boolean[] temp2 = new boolean[N*2];
		for (int i = 1; i < N*2; i++) {
			temp[i] = belt[i-1];
		}
		temp[0] = belt[N*2-1];
		Queue<Integer> tempRobots = new LinkedList<>();
		while(!robots.isEmpty()) {
			int nextIndex = (robots.poll()+1)%(2*N);
			if(nextIndex!=N-1) { // 내리는 위치
				tempRobots.offer(nextIndex);
				temp2[nextIndex] = true;
			}
		}
		belt = temp;
		robots = tempRobots;
		isRobot = temp2;
		
	}
	
	public static void moveRobots() { // 로봇이동
		Queue<Integer> tempRobots = new LinkedList<>();
		while(!robots.isEmpty()) {
			int index = robots.poll();
			int nextIndex = (index+1)%(2*N);
			if(!isRobot[nextIndex] && belt[nextIndex]>0) {
				if(--belt[nextIndex]==0) {
					zeroCount++;
				}	
				if(nextIndex!=N-1) { // 내리는 위치
					tempRobots.offer(nextIndex);
					isRobot[nextIndex] = true;
				}
				isRobot[index] = false;
			} else {
				tempRobots.offer(index);
			}
		}
		robots = tempRobots;
	}
	
	public static void setRobot() {
		if(!isRobot[0] && belt[0]>0) {
			robots.offer(0);
			isRobot[0] = true;
			if(--belt[0]==0) {
				zeroCount++;
			}
		}
	}
	
	public static boolean chkEnd() {
		if(zeroCount>=K) return true;
		return false;
		
	}

}
