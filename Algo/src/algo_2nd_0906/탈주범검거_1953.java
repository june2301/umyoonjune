package algo_2nd_0906;

import java.util.Scanner;

public class 탈주범검거_1953 {
	
	static int N, M, R, C, L, hour;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {-1, 1, 0, 0}; // 상 하 좌 우
	static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
//		int T = sc.nextInt();
//		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			R = sc.nextInt();
			C = sc.nextInt();
			L = sc.nextInt();
			
			map = new int[N][M];
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					map[r][c] = sc.nextInt();
				}
			}
			
			visited = new boolean[N][M];
			hour = 0;
			dfs(R, C, hour);
			int ans = 0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					if (visited[r][c]) {
						ans++;
					}
				}
			}
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					System.out.print(visited[r][c] + " ");
				}
				System.out.println();
			}
			System.out.println(ans);
//			System.out.println("#" + tc + " " + ans);
//		}
		
	}
	// bfs로 풀어야됨
	static void dfs(int r, int c, int hour) {
		if (hour == L) {
			return;
		}
		
		visited[r][c] = true;
		
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if (nr < 0 || nr >= N || nc < 0 || nc >= M) 
				continue;
			int save = map[nr][nc];
			if (!visited[nr][nc]) {
				if (i == 0 && (save == 1 || save == 2 || save == 6)) { // 상
					dfs(nr, nc, hour+1);
				}
				if (i == 1 && (save == 1 || save == 2 || save == 4)) { // 하
					dfs(nr, nc, hour+1);
				}
				if (i == 2 && (save == 1 || save == 3 || save == 5)) { // 좌
					dfs(nr, nc, hour+1);
				}
				if (i == 3 && (save == 1 || save == 3 || save == 7)) { // 우
					dfs(nr, nc, hour+1);
				}
			}
		}
		
	}

}
