package algo_self.boj.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class 중량제한_1939 {
	
	static int N;
	static List<int[]>[] graph;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] NM = br.readLine().split(" ");
		
		N = Integer.parseInt(NM[0]);
		int M = Integer.parseInt(NM[1]);
		
		graph = new ArrayList[N+1];
		for (int i = 0; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			String[] input = br.readLine().split(" ");
			int A = Integer.parseInt(input[0]);
			int B = Integer.parseInt(input[1]);
			int C = Integer.parseInt(input[2]);
			graph[A].add(new int[] {B, C});
			graph[B].add(new int[] {A, C});
		}
		
		String[] AB = br.readLine().split(" ");
		int start = Integer.parseInt(AB[0]);
		int end = Integer.parseInt(AB[1]);
		
		System.out.println(dijkstra(start, end));
		
	}
	
	static int dijkstra(int start, int end) {
		PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {return b[1] - a[1];});
		int[] dist = new int[N+1];
		boolean[] visited = new boolean[N+1];
		
		dist[start] = Integer.MAX_VALUE;
		pq.add(new int[] {start, dist[start]});
		
		while (!pq.isEmpty()) {
			int[] curr = pq.poll();
			int from = curr[0];
			int cost1 = curr[1];
			
			if (visited[from]) continue;
			visited[from] = true;
			
			if (from == end) return cost1;
			
			for (int[] next : graph[from]) {
				int to = next[0];
				int cost2 = next[1];
				
				if (visited[to]) continue;
				
				int min = Math.min(cost1, cost2);
				if (min > dist[to]) {
					dist[to] = min;
					pq.add(new int[] {to, dist[to]});
				}
			}
		}
		
		return dist[end];
		
	}

}

/**
 * 다익스트라
 * [문제]
 * N개의 섬을 연결하는 M개의 다리가 주어진다.
 * from to cost 형태로 주어지며, 각 다리마다 중량 제한값이 주어지고,
 * 시작점과 도착점이 주어질 때 최대 비용으로 통과할 수 있는 값을 구하시오.
 * 
 * 기본적으로 그래프가 양방향이기 때문에 A<->B 에 대한 간선 정보를 인접리스트로 저장
 * 
 * 다익스트라 구현
 * dist를 통해 시작 지점에서 각 지점까지의 최대값을 기록
 * 현재 지점에서 연결된 그래프를 통해 다음 지점들을 탐색하며
 * dist에 저장된 값을 갱신
 * 
 * 이후 다음 지점을 pq에서 꺼내는 시점에 방문처리를 통해 중복 방문 방지 및 최대값 확정
 */

