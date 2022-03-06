import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class Main_2211 {
	static class Node{
		int vertex;
		Node link;
		int weight;
		public Node(int vertex, Node link, int weight) {
			this.vertex = vertex;
			this.link = link;
			this.weight = weight;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Node[] adjList = new Node[N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int from = Integer.parseInt(st.nextToken())-1;
			int to = Integer.parseInt(st.nextToken())-1;
			int weight = Integer.parseInt(st.nextToken());
			adjList[from] = new Node(to,adjList[from],weight);
			adjList[to] = new Node(from,adjList[to],weight);
		}
		int start = 0;
		int[] minDist = new int[N];
		boolean[] visited = new boolean[N];
		HashMap<Integer,List<Integer[]>> edgeList = new HashMap<>();
		edgeList.put(0,new ArrayList<Integer[]>());
		Arrays.fill(minDist, Integer.MAX_VALUE);
		minDist[start] = 0;
		
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
			for (Node temp = adjList[current]; temp != null; temp = temp.link) {
				if(!visited[temp.vertex]&&minDist[temp.vertex]>minDist[current]+temp.weight) {
					minDist[temp.vertex] = minDist[current]+temp.weight;
					// 갱신될때마다 경로를 저장하는 해시맵도 갱신
					List<Integer[]> newList =  new ArrayList<>();
					for (Integer[] integers : edgeList.get(current)) {
						newList.add(integers);
					}
					newList.add(new Integer[] {current,temp.vertex});
					if(edgeList.containsKey(temp.vertex)) {
						edgeList.replace(temp.vertex, newList);
					} else {
						edgeList.put(temp.vertex, newList);
					}
				}
			}
		}
		List<Integer[]> ans = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		for (Entry<Integer,List<Integer[]>> edges : edgeList.entrySet()) {
			for (Integer[] edge : edges.getValue()) {
				boolean isDup = false;
				for (Integer[] integers : ans) {//정답 리스트에 중복 있을시
					if((integers[0]==edge[0]&&integers[1]==edge[1])||(integers[0]==edge[1]&&integers[1]==edge[0])) {
						isDup = true;
						break;
					}
				}
				if(!isDup) ans.add(edge);
			}
		}
		sb.append(ans.size()).append("\n");
		for (Integer[] integers : ans) {
			sb.append(integers[0]+1).append(" ").append(integers[1]+1).append("\n");
		}
		System.out.println(sb);
	}

}
