//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.HashSet;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Queue;
//import java.util.StringTokenizer;
///*
//5 5 3
//1 1 1 0 1
//0 1 1 0 0
//1 1 1 0 0
//0 1 1 0 0
//1 1 1 0 0
//
//
//5 5 2
//1 0 1 1 1 
//0 1 1 1 1 
//1 0 1 0 1 
//1 1 0 1 0 
//1 0 1 0 1 
//
// */
//public class Main {
//	static int[][] arr;
//	static int[] input;
//	static int N,M,range;
//	static int[] hunters = new int[3];
//	static int answer = 0;
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine()," ");
//		N = Integer.parseInt(st.nextToken());
//		M = Integer.parseInt(st.nextToken());
//		range = Integer.parseInt(st.nextToken());
//		arr = new int[N][M];
//		for (int i = 0; i < N; i++) {
//			st = new StringTokenizer(br.readLine()," ");
//			for (int j = 0; j < M; j++) {
//				arr[i][j] = Integer.parseInt(st.nextToken());
//			}
//		}
//		input = new int[M];
//		for (int i = 0; i < M; i++) {
//			input[i] = i;
//		}
//		combination(0,0);
//		
//		System.out.println(answer);
//	}
//	
//	public static void combination(int cnt,int start) { //궁수의 위치 조합으로 뽑아줌
//		if(cnt==3) {
////			System.out.println("=====================");
//			System.out.println(Arrays.toString(hunters));
//			int n = 0;
//			int[][] temp = new int[N][M];//배열복사
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < M; j++) { 
//					temp[i][j] = arr[i][j];
//				}
//
//			}
//			for (int i = 0; i < N; i++) {
//				n += turn(new int[] {N-1,N-1,N-1},hunters);
//			}
//			answer = Math.max(answer, n);
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < M; j++) { //배열 되돌리기
//					arr[i][j] = temp[i][j];
//				}
//			}
////			System.out.println("cnt: "+n);
////			System.out.println("=====================");
//			return;
//		}
//		for (int i = start; i < M; i++) {
//			hunters[cnt] = input[i];
//			combination(cnt+1,i+1);
//		}
//	}
//
//	public static int turn(int[] y,int[] x) {
//		int n = bfs(y,x);
//		int[][] temp = new int[N][M];
////		System.out.println("before");
////		for (int i = 0; i < temp.length; i++) {
////			System.out.println(Arrays.toString(arr[i]));
////		}
////		System.out.println("------------------------------");
//		for (int i = 0; i < N-1; i++) {
//			temp[i+1] = arr[i];
//		}
//		
//		arr = temp;
////		System.out.println("after");
////		for (int i = 0; i < temp.length; i++) {
////			System.out.println(Arrays.toString(arr[i]));
////		}
////		System.out.println("n: "+n);
////		System.out.println("-------------------------");
//		return n;
//	}
//	static int[] r = {0,-1,0};//좌,상,우
//	static int[] c = {-1,0,1};
//	public static int bfs(int[] y,int[] x) {
//		int cnt = 0;
//		Queue<Integer[]> queue = new LinkedList<>();
//		for (int i = 0; i < 3; i++) {
//			queue.offer(new Integer[] {y[i],x[i],i});
//		}
//		int lvl = 0;
//		boolean[] hunters = new boolean[3];
//		ArrayList<Integer[]> list = new ArrayList<>();
//		loop:while(!queue.isEmpty()) {
//			if(lvl==range) {
//				break;
//			}
//			int size = queue.size()/3;
//			while(size-->0) {
//				Integer[][] current = new Integer[3][];
//				boolean[] Invalid = new boolean[3];
//				
//				
//				for (int i = 0; i < 3; i++) {
//					current[i] = queue.poll();
//					if(current[i][0]==-1) {
//						Invalid[i] = true;
//					}
//				}
//				
//				for (int i = 0; i < 3; i++) {
//					if(Invalid[i]) continue;
//					if(arr[current[i][0]][current[i][1]]==1&&!hunters[current[i][2]]) {//이미 쏜 궁수는 cnt하지 않음
//						list.add(new Integer[] {current[i][0],current[i][1]});
//						hunters[current[i][2]] = true;
//						cnt++;
//						if(cnt==3) {
//							
//							break loop;
//						}
//					}
//				}
//				
//				for (int i = 0; i < 3; i++) { //방향
//					for (int j = 0; j < 3; j++) { // 사수
//						int nr = current[j][0]+r[i];
//						int nc = current[j][1]+c[i];
//						if(nr>=0&&nc>=0&&nr<N&&nc<M&&!hunters[current[j][2]]&&!Invalid[j]) {
//							queue.offer(new Integer[] {nr,nc,current[j][2]});
//						} else {
//							queue.offer(new Integer[] {-1,-1,0});
//						}
//					}
//				}
//			}
//			lvl++;
//		}
//		for (int i = 0; i < list.size(); i++) {
//			for (int j = i+1; j < list.size(); j++) {
//				if(list.get(i)[0]==list.get(j)[0] && list.get(i)[1]==list.get(j)[1]) cnt--;
//			}
//			arr[list.get(i)[0]][list.get(i)[1]] = 0;
//		}
//		return cnt;
//	}
//}
