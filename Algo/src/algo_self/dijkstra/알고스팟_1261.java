package algo_self.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.PriorityQueue;

public class 알고스팟_1261 {
	
	static int N, M;
	static int[][] map;
	static int[] dr = {0, 0, -1, 1};
	static int[] dc = {1, -1, 0, 0};

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] NM = br.readLine().split(" ");
		
		N = Integer.parseInt(NM[0]);
		M = Integer.parseInt(NM[1]);
		
		map = new int[M][N];
		for (int r = 0; r < M; r++) {
			String[] input = br.readLine().split("");
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(input[c]);
			}
		}
		
//		int ans = bfs();
//		int ans = dijkstra();
		int ans = zoBfs();
		
		System.out.println(ans);
		
	}
	
	static int bfs() {
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> {return a[2]-b[2];});
		pq.add(new int[] {0, 0, 0});
		boolean[][] visited = new boolean[M][N];
		visited[0][0] = true;
		
		int wall = 10000;
		
		while (!pq.isEmpty()) {
			int[] curr = pq.poll();
			int r = curr[0];
			int c = curr[1];
			int w = curr[2];
			
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (nr < 0 || nr >= M || nc < 0 || nc >= N || visited[nr][nc]) continue;
				if (nr == M-1 && nc == N-1) {
					wall = Math.min(wall, w);
					continue;
				}
				if (map[nr][nc] == 0) {
					pq.add(new int[] {nr, nc, w});
					visited[nr][nc] = true;
				} else if (map[nr][nc] == 1) {
					pq.add(new int[] {nr, nc, w+1});
					visited[nr][nc] = true;
				}
				
			}
		}
		
		return wall == 10000 ? 0 : wall;
		
	}
	
	static int dijkstra() {
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> {return a[2]-b[2];});
		pq.add(new int[] {0, 0, 0});
		
		int[][] dist = new int[M][N];
		for (int i = 0; i < M; i++) {
			Arrays.fill(dist[i], Integer.MAX_VALUE);
		}
		dist[0][0] = 0;
		
		while (!pq.isEmpty()) {
			int[] curr = pq.poll();
			int r = curr[0];
			int c = curr[1];
			int w = curr[2];
			
			if (w != dist[r][c]) continue;
			
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (nr < 0 || nr >= M || nc < 0 || nc >= N) continue;
				
				int nw = w + map[nr][nc];
				if (nw < dist[nr][nc]) {
					dist[nr][nc] = nw;
					pq.add(new int[] {nr, nc, nw});
				}
				
			}
		}
		
		return dist[M-1][N-1];
		
	}

	static int zoBfs() {
		Deque<int[]> dq = new ArrayDeque<int[]>();
		dq.add(new int[] {0, 0});
		
		int[][] dist = new int[M][N];
		for (int i = 0; i < M; i++) {
			Arrays.fill(dist[i], Integer.MAX_VALUE);
		}
		dist[0][0] = 0;
		
		while (!dq.isEmpty()) {
			int[] curr = dq.pollFirst();
			int r = curr[0];
			int c = curr[1];
			int w = dist[r][c];
			
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (nr < 0 || nr >= M || nc < 0 || nc >= N) continue;
				
				int nw = w + map[nr][nc];
				if (nw < dist[nr][nc]) {
					dist[nr][nc] = nw;
					if (w == 0) {
						dq.addFirst(new int[] {nr, nc});
					} else {
						dq.addLast(new int[] {nr, nc});
					}
				}
				
			}
		}
		
		return dist[M-1][N-1];
		
	}
	
}

/**
 * [문제]
 * N*M 크기의 빈 방 0과 벽 1로 이루어진 미로가 주어짐.
 * 0,0에서 출발하여 N-1,M-1 까지 가는데 부수어야 하는 최소 벽의 개수 출력
 * 
 * **3가지 알고리즘으로 풀어보았음**
 * (정점 수 V = N * M , 간선 수 E ≈ 4 * N * M = O(V))
 * 1. 유사 다익스트라 - [pq + visited]
 * int값을 선언해두고 pq를 이용해 탐색을 진행하며,
 * N-1,M-1에 도착했을 때 뚫고 온 벽의 수 최소값을 계속 초기화
 * - 시간 복잡도 : O(E log V)
 * - 잘못 구현된 다익스트라
 * 
 * 2. 정석 다익스트라 - [pq + dist]
 * dist[][] 를 선언 후 최대값으로 초기화
 * 이후 pq를 통해 탐색해가며 map[nr][nc] 값을 더해서 dist값 초기화
 * - 시간 복잡도 : O(E log V)
 * 
 * 3. 0-1 bfs
 * dist[][] 를 선언 후 최대값으로 초기화
 * Deque을 통해 탐색을 진행하며 다음 지역이 0인 경우 addFirst, 1인 경우 addLast
 * - 시간 복잡도 : O(V+E)
 * - 다익스트라와 유사하지만 Deque를 사용해서 0/1에 따라 선택적으로 탐색 위치 지정
 * 
 */

