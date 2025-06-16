package ssafy_1st.algo_2nd_0905;

import java.util.Scanner;

public class 등산로조성_1949 {
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int N, K, max, ans;
	static int[][] map;
	static boolean[][] visited;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			K = sc.nextInt();
			max = 0;
			ans = 0;
			map = new int[N][N];
			visited = new boolean[N][N];
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					map[r][c] = sc.nextInt();
					if (map[r][c] > max) {
						max = map[r][c];
					}
				}
			}
			
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (map[r][c] == max) {
						climb(r, c, map[r][c], 1, true);
					}
				}
			}
			
			System.out.println("#" + tc + " " + ans);
		}
		
	}
	
	static void climb(int r, int c, int h, int dist, boolean dig) {
		if (dist > ans) {
			ans = dist;
		}
		
		visited[r][c] = true;
		
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if (nr >= 0 && nc >= 0 && nr < N && nc < N && !visited[nr][nc]) {
				if (map[nr][nc] < h) {
					climb(nr, nc, map[nr][nc], dist + 1, dig);
				} else if (dig && map[nr][nc] - K < h) {
					climb(nr, nc, map[r][c] - 1, dist + 1, false);
					// map[r][c]-1을 높이로 보내는 이유
					// -> 몇 깎을지 생각안하고 그냥 이전보다 1 낮게 보내면 OK
					// -> 어차피 한번밖에 못깎음
				}
			}
		}
		
		visited[r][c] = false;
	}

}
