package algo_2nd_0903;

import java.util.Scanner;

public class 치즈도둑_7733 {
	
	static int N;
	static int[][] map;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static boolean[][] visited;
	static int ans;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			map = new int[N][N];
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					map[r][c] = sc.nextInt();
				}
			}
			
			ans = 0;
			for (int cz = 0; cz <= 100; cz++) {
				
				for (int r = 0; r < N; r++) {
					for (int c = 0; c < N; c++) {
						if (map[r][c] <= cz) {
							map[r][c] = 0;
						}
					}
				}
				
				int cnt = 0;
				visited = new boolean[N][N];
				
				for (int r = 0; r < N; r++) {
					for (int c = 0; c < N; c++) {
						if (map[r][c] > 0 && !visited[r][c]) {
							dfs(r,c);
							cnt++;
						}
					}
				}
				
				if (cnt > ans) {
					ans = cnt;
				}
			}
			System.out.println("#" + tc + " " + ans);
		}
	}
	
	static void dfs(int sr, int sc) {
		visited[sr][sc] = true;
		for (int i = 0; i < 4; i++) {
			int nr = sr + dr[i];
			int nc = sc + dc[i];
			if (nr >= 0 && nc >= 0 && nr < N && nc < N) {
				if (map[nr][nc] > 0 && !visited[nr][nc]) {
					dfs(nr, nc);
				}
			}
		}
	}

}
