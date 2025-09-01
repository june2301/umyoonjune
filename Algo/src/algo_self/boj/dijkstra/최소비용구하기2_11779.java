package algo_self.boj.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class 최소비용구하기2_11779 {
	
	static class Edge implements Comparable<Edge>{
		int to;
		int cost;
		
		public Edge(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Edge e) {
			return this.cost - e.cost;
		}
	}
	
	static int N;
	static List<Edge>[] edges;
	static int start, end;
	static int[] path;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		edges = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			edges[i] = new ArrayList<Edge>();
		}
		
		for (int i = 0; i < M; i++) {
			String[] input = br.readLine().split(" ");
			int from = Integer.parseInt(input[0]);
			int to = Integer.parseInt(input[1]);
			int cost = Integer.parseInt(input[2]);
			
			edges[from].add(new Edge(to, cost));
		}
		
		String[] where = br.readLine().split(" ");
		start = Integer.parseInt(where[0]);
		end = Integer.parseInt(where[1]);
		
		int ans = dijkstra();
		List<Integer> ansPath = new ArrayList<Integer>();
		int e = end;
		ansPath.add(e);
		while (true) {
			if (e == start) {
				break;
			}
			
			e = path[e];
			ansPath.add(e);
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(ans + "\n");
		sb.append(ansPath.size() + "\n");
		for (int i = ansPath.size()-1; i >= 0; i--) {
			sb.append(ansPath.get(i) + " ");
		}
		
		System.out.println(sb);
	}
	
	static int dijkstra() {
		int[] dist = new int[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;
		
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
		pq.add(new Edge(start, 0));
		
		path = new int[N+1];
		
		while (!pq.isEmpty()) {
			Edge curr = pq.poll();
			
			if (dist[curr.to] < curr.cost) continue;
			
			for (Edge next : edges[curr.to]) {
				if (dist[next.to] > dist[curr.to] + next.cost) {
					dist[next.to] = dist[curr.to] + next.cost;
					pq.add(new Edge(next.to, dist[next.to]));
					path[next.to] = curr.to; 
				}
			}
		}
		
		return dist[end];
	}

}

/**
 * 다익스트라
 * [문제]
 * 도시 수 N과 버스 수 M이 주어지고, A에서 B로 가는 버스 비용 C가 주어지고, 시작점과 도착점이 주어졌을 때,
 * 도착점까지 가는 최단거리와 거치는 도시의 수와 거치는 도시들을 출력하시오.
 * 
 * 경로 Edge를 저장하기 위해 Edge클래스를 만든 후 PQ에 정렬되어 담기기 위해 Comparable 적용
 * 인접 리스트 생성 후 edges[from].add(new Edge(to, cost)) 로 모든 간선 추가
 * 다익스트라 함수 생성 후 최단거리 계산을 위한 dist배열 생성 후 최대값으로 초기화
 * pq에 시작점과 비용 0을 넣고 탐색 시작
 * curr : 현재 위치, 누적 비용
 * next : 다음 위치, 이동 비용
 * dist에 기록된 다음 위치의 비용 > dist에 기록된 현재 위치의 비용 + 다음 위치 이동 비용 => dist갱신
 * 
 * 경로 추적 - 역방향 추적
 * 다익스트라에 path배열을 추가한 후 
 * -> path[다음위치] = 이전위치 기록
 * 이 후 while문을 통해 end에서 시작하여 start에 도착할 때 까지 경로들 기록
 * size 및 경로들 출력
 */

