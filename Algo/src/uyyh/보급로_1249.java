package uyyh;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class 보급로_1249 {

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
	
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
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
		int N = map.length;
		
		// 각 칸의 최소값을 계산하기 위한 2차원 배열 생성
		// 및 Integer의 가장 큰 값을 초기화
		int[][] minCost = new int[N][N];
		for (int i = 0; i < minCost.length; i++) {
			Arrays.fill(minCost[i], Integer.MAX_VALUE);
		}
		
		// pq 생성 및 출발지점 add
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(0, 0, map[0][0]));
		
		while (!pq.isEmpty()) {
			Node save = pq.poll();
			
			// 출발지점으로부터 각 칸의 최소값 계산 및 저장
			for (int i = 0; i < 4; i++) {
				int nr = save.r + dr[i];
				int nc = save.c + dc[i];
				
				if (nr >= 0 && nc >= 0 && nr < N && nc < N) {
					
					if (minCost[nr][nc] > save.cost + map[nr][nc]) {
						minCost[nr][nc] = save.cost + map[nr][nc];
						pq.add(new Node(nr, nc, minCost[nr][nc]));
					}
					
				}
				
			}
			
		}
		return minCost[N-1][N-1];
	}

}
