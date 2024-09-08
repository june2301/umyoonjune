package algo_2nd_0905;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class 보급로_pq_1249 {

	// 우선순위 큐에서 가장 작은값 정렬시키기 위해 Comparable 구현
	static class Node implements Comparable<Node> {
		int r;
		int c;
		int cost;
		
		public Node(int r, int c, int cost) {
			super();
			this.r = r;
			this.c = c;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.cost, o.cost);
		}
	}
	
	static int N;
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	static boolean[][] visited;
	static int[][] minCost;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			int[][] map = new int[N][N];
			for (int r = 0; r < N; r++) {
				char[] input = br.readLine().toCharArray();
				for (int c = 0; c < N; c++) {
					map[r][c] = input[c]-'0';
				}
			}
			
			System.out.println("#" + tc + " " + dijkstra(map));
		}
	}
	
	static int dijkstra(int[][] map) {
		visited = new boolean[N][N];
		minCost = new int[N][N];
		for (int i = 0; i < N; i++) {
			Arrays.fill(minCost[i], Integer.MAX_VALUE);
		}
		
		Queue<Node> pq = new PriorityQueue<>();
		// 시작지점 정보들 초기화
		pq.add(new Node(0, 0, 0));
		visited[0][0] = true;
		minCost[0][0] = 0;
		
		// 모든 지점까지 갈 수 있는 최소 cost 계산
		while (!pq.isEmpty()) {
			Node n = pq.poll();
			
			// 사방탐색하며 더 작은값 pq에 넣기
			for (int i = 0; i < 4; i++) {
				int nr = n.r + dr[i];
				int nc = n.c + dc[i];
				
				if (nr >= 0 && nc >= 0 && nr < N && nc < N) {
					if (!visited[nr][nc] && 
							minCost[nr][nc] > n.cost + map[nr][nc]) {
						minCost[nr][nc] = n.cost + map[nr][nc];
						pq.add(new Node(nr, nc, minCost[nr][nc]));
					}
					
				}
				
			}
			
		}
		return minCost[N-1][N-1];
	}

}
