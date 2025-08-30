package algo_self.boj.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class 최소비용구하기_1916 {

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

	static List<Node>[] graph;
	static int[] dist;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		graph = new ArrayList[N+1];
		dist = new int[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);

		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			String[] input = br.readLine().split(" ");
			int from = Integer.parseInt(input[0]);
			int to = Integer.parseInt(input[1]);
			int cost = Integer.parseInt(input[2]);

			graph[from].add(new Node(to, cost));
		}

		String[] where = br.readLine().split(" ");
		int start = Integer.parseInt(where[0]);
		int end = Integer.parseInt(where[1]);

		dijkstra(start);

		System.out.println(dist[end]);
	}

	private static void dijkstra(int start) {
		Queue<Node> pq = new PriorityQueue<>();
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
	}
}

/**
 * 다익스트라 알고리즘
 * 
 * 인접리스트 형태로 그래프 구현
 * List배열을 사용하여 각 배열 번호가 출발점, 리스트 안의 Node에 도착점과 cost를 저장
 * 
 * dijkstra 진행 방식 - dist에 해당 위치까지의 최소 cost 저장
 * 1. pq에 시작할 위치(1)와 cost 0 저장
 * 2. 시작 위치에서 이동 가능한 Node 정보 탐색
 * 3. (이동 가능한 Node의 dist) 가 (현재 Node의 dist + 이동하려는 cost) 보다 크면 dist 갱신
 * 4. 다음 위치에서 경로 탐색을 위해 pq.add(new Node(next.to, dist[next.to])) 추가
 * 
 */

