package algo_self.boj.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 다리만들기_2146 {
	
	static int N;
	static int[][] map;
	static int[] dr = {0, 0, 1, -1};
	static int[] dc = {1, -1, 0, 0};
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		for (int r = 0; r < N; r++) {
			String[] input = br.readLine().split(" ");
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(input[c]);
			}
		}
		
		int num = 2;
		visited = new boolean[N][N];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (map[r][c] == 1 && !visited[r][c]) {
					land(r, c, num);
					num++;
				}
			}
		}
		
		int ans = 200;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (map[r][c] > 0) {
					int dist = bridge(r, c);
					if (dist == -1) continue;
					if (dist < ans) {
						ans = dist;
					}
				}
			}
		}
		
		System.out.println(ans);
		
	}
	
	static int bridge(int r, int c) {
		visited = new boolean[N][N];
		visited[r][c] = true;
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] {r, c, 0});
		
		while (!q.isEmpty()) {
			int[] now = q.poll();
			for (int i = 0; i < 4; i++) {
				int nr = now[0] + dr[i];
				int nc = now[1] + dc[i];
				int dist = now[2];
				if (nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc] || map[nr][nc] == map[r][c]) continue;
				if (map[nr][nc] > 0) {
					return dist;
				}
				q.add(new int[] {nr, nc, dist + 1});
				visited[nr][nc] = true;
			}
		}
		
		return -1;
	}
	
	static void land(int r, int c, int num) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] {r, c});
		map[r][c] = num;
		visited[r][c] = true;
		
		while (!q.isEmpty()) {
			int[] now = q.poll();
			for (int i = 0; i < 4; i++) {
				int nr = now[0] + dr[i];
				int nc = now[1] + dc[i];
				if (nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc]) continue;
				if (map[nr][nc] == 1) {
					map[nr][nc] = num;
					q.add(new int[] {nr, nc});
					visited[nr][nc] = true;
				}
			}
		}
	}

}

/**
 * BFS
 * 2번의 bfs를 사용하는 문제(dfs도 가능)
 * bfs1 : 섬을 구분하기 위해 연결된 1을 같은 숫자로 바꾸기
 * bfs2 : 각 섬에서 다른 섬까지의 최단거리 구하기
 * 
 * 방문처리를 빼먹어서 메모리 초과가 발생했다.
 * visited 깜빡하지 말 것.
 * +) bfs1에서 visited 사용하고 bfs2에서 매 실행마다 경로 확인용으로 초기화하면서 사용하였음
 */

