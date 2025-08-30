package algo_self.boj.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 빙산_2573 {
	
	static int N, M;
	static int[][] map;
	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, 1, -1};
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] NM = br.readLine().split(" ");
		
		N = Integer.parseInt(NM[0]);
		M = Integer.parseInt(NM[1]);
		
		map = new int[N][M];
		for (int r = 0; r < N; r++) {
			String[] input = br.readLine().split(" ");
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(input[c]);
			}
		}
		
		int year = 0;
		
		while (true) {
			int div = check();
			
			if (div == 0) {
				System.out.println(0);
				break;
			} else if (div > 1) {
				System.out.println(year);
				break;
			}
			
			year++;
			
			int[][] newMap = new int[N][M];
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					if (map[r][c] > 0) {
						int cnt = 0;
						for (int d = 0; d < 4; d++) {
							int nr = r + dr[d];
							int nc = c + dc[d];
							if (nr >= 0 && nc >= 0 && nr < N && nc < M && map[nr][nc] == 0) {
								cnt++;
							}
						}
						newMap[r][c] = Math.max(0, map[r][c] - cnt);
					}
				}
			}
			map = newMap;
			
		}
		
	}
	
	static void bfs(int r, int c) {
		
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] {r, c});
		visited[r][c] = true;
		
		while (!q.isEmpty()) {
			int[] curr = q.poll();
			int cr = curr[0];
			int cc = curr[1];
			
			for (int i = 0; i < 4; i++) {
				int nr = cr + dr[i];
				int nc = cc + dc[i];
				
				if (nr < 0 || nc < 0 || nr >= N || nc >= M || visited[nr][nc]) continue;
				if (map[nr][nc] > 0) {
					q.add(new int[] {nr, nc});
					visited[nr][nc] = true;
				}
			}
		}
		
		
	}
	
	static int check() {
		visited = new boolean[N][M];
		int cnt = 0;
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (map[r][c] > 0 && !visited[r][c]) {
					bfs(r,c);
					cnt++;
				}
			}
		}
		
		return cnt;
	}

}

/**
bfs 문제
답을 확인하는 연결된 빙산의 개수를 카운트하는 용도로 bfs사용

이 문제의 핵심은 빙산이 동시에 녹는 것을 적용하기 위해 newMap을 사용
map을 기준으로 녹은 빙산들을 newMap으로 체크해둔 후 한번에 map에 적용

 */
