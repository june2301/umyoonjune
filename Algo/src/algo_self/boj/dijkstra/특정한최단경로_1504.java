package algo_self.boj.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class 특정한최단경로_1504 {
	
	static class Node implements Comparable<Node> {
		int to;
		int cost;
		
		public Node(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}
	
	static int N,E;
	static List<Node>[] graph;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] NE = br.readLine().split(" ");
		
		N = Integer.parseInt(NE[0]);
		E = Integer.parseInt(NE[1]);
		
		graph = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<Node>();
		}
		
		for (int i = 0; i < E; i++) {
			String[] input = br.readLine().split(" ");
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);
			int c = Integer.parseInt(input[2]);
			graph[a].add(new Node(b, c));
			graph[b].add(new Node(a, c));
		}
		
		String[] v1v2 = br.readLine().split(" ");
		int v1 = Integer.parseInt(v1v2[0]);
		int v2 = Integer.parseInt(v1v2[1]);
		
		int a = dijkstra(1, v1);
		int b = dijkstra(v1, v2);
		int c = dijkstra(v2, N);
		
		int d = dijkstra(1, v2);
		int e = dijkstra(v2, v1);
		int f = dijkstra(v1, N);

		int r1 = (a == Integer.MAX_VALUE || b == Integer.MAX_VALUE || c == Integer.MAX_VALUE) ? Integer.MAX_VALUE : a + b + c;
		int r2 = (d == Integer.MAX_VALUE || e == Integer.MAX_VALUE || f == Integer.MAX_VALUE) ? Integer.MAX_VALUE : d + e + f;

		int ans = Math.min(r1, r2);
		System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
	}
	
	static int dijkstra(int start, int end) {
		int[] dist = new int[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		Queue<Node> pq = new PriorityQueue<Node>();
		pq.add(new Node(start, 0));
		dist[start] = 0;
		
		while (!pq.isEmpty()) {
			Node curr = pq.poll();
			
			if (dist[curr.to] < curr.cost) continue;
			
			for (Node next : graph[curr.to]) {
				if (dist[next.to] > dist[curr.to] + next.cost) {
					dist[next.to] = dist[curr.to] + next.cost;
					pq.add(new Node(next.to, dist[next.to]));
				}
			}
			
		}
		
		return dist[end];
	}

}

/**
 * 다익스트라 알고리즘
 * 
 * 인접 리스트 형태로 풀이
 * 
 * 문제에서,
 * 방향성이 없는 그래프 = 양방향 모두 추가
 * v1과 v2를 반드시 지나야 함
 * 
 * 1-v1-v2-N or 1-v2-v1-N 둘 중 더 최단 경로를 찾아야 함.
 * 여기서 갈 수 없는 경우 Integer.MAX_VALUE가 나오는 것을 통해 추적
 * 
 * 각 경우마다 시작, 도착 지점이 다르므로 int값을 반환하는 dijkstra 구현
 * 
 */

