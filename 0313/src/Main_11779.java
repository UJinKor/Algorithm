import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main_11779 {
	static class Node{
		int vertex,weight;
		Node link;
		
		public Node(int vertex, Node link,int weight) {
			this.vertex = vertex;
			this.link = link;
			this.weight = weight;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		Node[] adjList = new Node[N]; 
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int from = Integer.parseInt(st.nextToken())-1;
			int to = Integer.parseInt(st.nextToken())-1;
			int weight = Integer.parseInt(st.nextToken());
			adjList[from] = new Node(to,adjList[from],weight);
		}
		st = new StringTokenizer(br.readLine()," ");
		int start = Integer.parseInt(st.nextToken())-1;
		int end = Integer.parseInt(st.nextToken())-1;
		
		int[] minDist = new int[N];
		boolean[] visited = new boolean[N];
		Arrays.fill(minDist, Integer.MAX_VALUE);
		minDist[start] = 0;
		int answer = -1;
		
		List<List<Integer>> wayList = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			wayList.add(new ArrayList<>());
		}
		wayList.get(start).add(start); //시작 노드에 시작값 넣어줌
		for (int c = 0; c < N; c++) {
			int min = Integer.MAX_VALUE;
			int current = -1;
			for (int i = 0; i < N; i++) {
				if(!visited[i]&&min>minDist[i]) {
					min = minDist[i];
					current = i;
				}
			}
			visited[current] = true;
			if(current==end) {
				answer = min;
				break;
			}
			for (Node temp=adjList[current];temp!=null;temp=temp.link) {
				if(!visited[temp.vertex] && minDist[temp.vertex] > minDist[current]+temp.weight) {
					minDist[temp.vertex] = minDist[current]+temp.weight;
					
					wayList.get(temp.vertex).clear();
					for (Integer way : wayList.get(current)) {
						wayList.get(temp.vertex).add(way);
					}
					wayList.get(temp.vertex).add(temp.vertex);
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(answer).append("\n").append(wayList.get(end).size()).append("\n");
		for (Integer ints : wayList.get(end)) {
			sb.append(ints+1).append(" ");
		}
		System.out.println(sb);
	}

}
