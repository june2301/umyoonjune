package algo_2nd_0903;

import java.util.Scanner;

public class BOJ섬의개수_4963 {

	static int N, M;
	static int[][] map;
	static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
	static int ans;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		while (N != 2 && M != 2) {
			N = sc.nextInt() + 2; // c
			M = sc.nextInt() + 2; // r
			// 상하좌우 1칸씩 더 생성
			if (N == 2 && M == 2) {
				break;
			}
			
			map = new int[M][N];
			for (int r = 1; r < M-1; r++) {
				for (int c = 1; c < N-1; c++) {
					map[r][c] = sc.nextInt();
				}
			}
			
			ans = 0;
			for (int r = 1; r < M-1; r++) {
				for (int c = 1; c < N-1; c++) {
					// 1이 나올경우 dfs실행
					// 연결된 모든 1 지우며 확인
					if (map[r][c] == 1) {
						dfs(r,c);
						
						// dfs 다 돌고와서 주변에 1 없으면 ans++
						int cnt = 0;
						for (int i = 0; i < 8; i++) {
							int nr = r + dr[i];
							int nc = c + dc[i];
							if (map[nr][nc] == 0) {
								cnt++;
							}
							if (cnt == 8) {
								ans++;
							}
						}
					}
				}
			}
			System.out.println(ans);
		}
		
	}
	
	static void dfs(int sr, int sc) {
		map[sr][sc] = 0;
		for (int i = 0; i < 8; i++) {
			int nr = sr + dr[i];
			int nc = sc + dc[i];
			if (map[nr][nc] == 1) {
				dfs(nr, nc);
			}
		}
	}
}
