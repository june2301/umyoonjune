package algo_self.boj.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 말이되고픈원숭이_1600 {
	
	static int K, W, H;
	static int[][] map;
	static int[] dr = {0, 0, 1, -1};
	static int[] dc = {-1, 1, 0, 0};
	static int[] hr = {-2, -2, -1, -1, 1, 1, 2, 2};
	static int[] hc = {-1, 1, -2, 2, -2, 2, -1, 1};

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		K = Integer.parseInt(br.readLine());
		
		String[] WH = br.readLine().split(" ");
		W = Integer.parseInt(WH[0]);
		H = Integer.parseInt(WH[1]);
		
		map = new int[H][W];
		for (int r = 0; r < H; r++) {
			String[] input = br.readLine().split(" ");
			for (int c = 0; c < W; c++) {
				map[r][c] = Integer.parseInt(input[c]);
			}
		}
		
		if (W == 1 && H == 1) {
			System.out.println(0);
			return;
		}
		
		int ans = bfs();
		
		System.out.println(ans);
		
	}
	
	static int bfs() {
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[3] - b[3]);
		pq.add(new int[] {0, 0, K, 0});
		boolean[][][] visited = new boolean[H][W][K + 1];
		visited[0][0][K] = true;
		
		while (!pq.isEmpty()) {
			int[] curr = pq.poll();
			int r = curr[0];
			int c = curr[1];
			int horse = curr[2];
			int cnt = curr[3];
			
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (nr == H - 1 && nc == W - 1) return cnt + 1;
				if (nr < 0 || nc < 0 || nr >= H || nc >= W || visited[nr][nc][horse]) continue;
				if (map[nr][nc] == 0) {
					visited[nr][nc][horse] = true;
					pq.add(new int[] {nr, nc, horse, cnt + 1});
				}
			}
			
			if (horse > 0) {
				for (int i = 0; i < 8; i++) {
					int nr = r + hr[i];
					int nc = c + hc[i];
					if (nr == H - 1 && nc == W - 1) return cnt + 1;
					if (nr < 0 || nc < 0 || nr >= H || nc >= W || visited[nr][nc][horse - 1]) continue;
					if (map[nr][nc] == 0) {
						visited[nr][nc][horse - 1] = true;
						pq.add(new int[] {nr, nc, horse - 1, cnt + 1});
					}
				}
			}
			
		}
		
		return -1;
	}

}

/**
 * bfs (그치만 구현에 가까운 느낌)
 * 
 * 0,0 에서 출발하여 H-1,W-1까지 가는 최단경로를 구하는 문제
 * 체스 말의 움직임을 사용할 수 있으며 사용 횟수는 K개로 주어짐.
 * 
 * 4방탐색 및 말 움직임 8방탐색을 int배열로 만들어둔 후
 * bfs 과정에서 만약 말 사용횟수가 남아있다면 4방탐색 + 8방탐색 모두 진행
 * 
 * 이 때, visited배열을 3차원으로 생성하여, 
 * 말을 몇 번 사용했을 때 해당 위치에 도달했는지를 확인
 * (각각 다른 경우이기 때문) -> 말을 1번 사용해서 해당 위치 vs 말을 0번 사용해서 해당 위치
 * 
 * (+) cnt가 최소가 되는 경로를 계속 찾기 위해 pq를 사용하였지만 그냥 queue를 사용해도 아무 지장 없음.
 *     -> 보통 pq는 간선의 가중치가 다를 경우 사용!
 * (+) 문제가 96%에서 틀렸다고 나오는 것은 map 사이즈가 1인 경우를 체크
 */

