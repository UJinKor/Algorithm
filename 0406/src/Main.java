import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] adjMatrix;
	static int[] population;
	static int min;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		population = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			population[i] = Integer.parseInt(st.nextToken());
		}
		adjMatrix = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			for (int j = 0; j < n; j++) {
				int to = Integer.parseInt(st.nextToken()) - 1;
				adjMatrix[i][to] = 1;
				adjMatrix[to][i] = 1;
			}
		}
		min = Integer.MAX_VALUE;
		selected = new boolean[N];
		selectCity(0);
		if (min == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(min);
		}
	}

	static boolean[] selected;

	public static void selectCity(int cnt) {

		if (cnt == N) {
			int startT=-1;
			int startF=-1;
			for (int i = 0; i < N; i++) {
				if(selected[i]) {
					startT = i;
					break;
				}
			}
			for (int i = 0; i < N; i++) {
				if(!selected[i]) {
					startF = i;
					break;
				}
			}
			
			boolean[] visited = new boolean[N];
			if(startT<0) return;
			if(startF<0) return;
			isConnect(startT,selected, visited,true);
			
			isConnect(startF,selected, visited,false);
			for (int i = 0; i < N; i++) {
				if (!visited[i])
					return;
			}
			int selSum = 0;
			int noSelSum = 0;
			for (int i = 0; i < N; i++) {
				if (selected[i]) {
					selSum += population[i];
				} else {
					noSelSum += population[i];
				}
			}
			int diff = Math.abs(selSum - noSelSum);
			min = Math.min(diff, min);
			return;
		}

		selected[cnt] = true;
		selectCity(cnt + 1);
		selected[cnt] = false;
		selectCity(cnt + 1);
	}

	public static void isConnect(int current, boolean[] select, boolean[] visited,boolean flag) {
		visited[current] = true;
		if(flag) {
			for (int j = 0; j < N; j++) {
				if (select[j] && !visited[j] && adjMatrix[current][j] == 1) {
					isConnect(j, select, visited,flag);
				}
			}
		} else {
			for (int j = 0; j < N; j++) {
				if (!select[j] && !visited[j] && adjMatrix[current][j] == 1) {
					isConnect(j, select, visited,flag);
				}
			}
		}


	}
}
