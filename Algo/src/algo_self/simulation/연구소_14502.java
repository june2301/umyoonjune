package algo_self.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 연구소_14502 {
	
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static List<int[]> virus;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int ans;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] NM = br.readLine().split(" ");
		
		N = Integer.parseInt(NM[0]);
		M = Integer.parseInt(NM[1]);
		
		map = new int[N][M];
		
		virus = new ArrayList<int[]>();
		for (int r = 0; r < N; r++) {
			String[] input = br.readLine().split(" ");
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(input[c]);
				if (map[r][c] == 2) {
					virus.add(new int[] {r, c});
				}
			}
		}
		
		ans = 0;
		
		dfs(0);
		
		System.out.println(ans);
		
	}
	
	static void dfs(int wCnt) {
		if (wCnt == 3) {
			bfs();
			return;
		}
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (map[r][c] == 0) {
					map[r][c] = 1;
					dfs(wCnt + 1);
					map[r][c] = 0;
				}
			}
		}
	}
	
	static void bfs() {
		visited = new boolean[N][M];
		Queue<int[]> q = new LinkedList<int[]>();
		for (int i = 0; i < virus.size(); i++) {
			q.add(virus.get(i));
		}
		
		while (!q.isEmpty()) {
			int[] now = q.poll();
			int r = now[0];
			int c = now[1];
			
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (nr < 0 || nc < 0 || nr >= N || nc >= M || visited[nr][nc]) continue;
				if (map[nr][nc] == 0) {
					visited[nr][nc] = true;
					q.add(new int[] {nr, nc});
				}
			}
		}
		
		safeZone();
		
	}
	
	static void safeZone() {
		int cnt = 0;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (!visited[r][c] && map[r][c] == 0) {
					cnt++;
				}
			}
		}
		
		ans = Math.max(ans, cnt);
		
	}

}

/**
 * 구현 문제
 * 벽 3개를 반드시 설치해야하며,
 * 벽 위치에 따른 최대 안전 영역의 크기를 구해야 한다.
 * -> 완전 탐색(브루트포스)
 * 
 * dfs로 벽 설치가 가능한 모든 경우의 수 조회
 * 각 경우마다 bfs로 바이러스 퍼지는 구역 계산
 * safeZone()으로 안전 구역 크기 카운트
 * 
 * 초기 map을 입력받으면서 바이러스의 r,c값을 리스트에 저장 후
 * bfs 실행 시 마다 Queue에 넣어주며 바이러스 퍼지는 구역 visited로 계산
 * visited는 0인 구역만 지나가므로, 방문하지 않은 0 구역의 개수 = 안전 구역 개수
 * 
 */
