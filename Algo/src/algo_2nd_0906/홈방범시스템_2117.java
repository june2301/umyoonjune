package algo_2nd_0906;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 홈방범시스템_2117 {
	
	static int N, M, ans;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			map = new int[N][N];
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					map[r][c] = sc.nextInt();
				}
			}
			
			ans = 0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
//					bfs(r, c);
					house(r, c);
				}
			}
			
			System.out.println("#" + tc + " " + ans);
		}
		
	}
	
	static void house(int r, int c) { // 마름모 그려서 구하기(여기선 더 좋음)
		
		for (int t = 0; t <= N; t++) {
			int cnt = 0;
			int range = 0;
			int cost = (t+1)*(t+1) + t*t;
			for (int i = -t; i <= t; i++) {
				for (int j = -range; j <= range; j++) {
					if (r+i >= 0 && c+j >= 0 && r+i < N && c+j < N) {
						if (map[r + i][c + j] == 1) {
							cnt++;
						}
					}
				}
				if (r + i < r) {
					range++;
				}else {
					range--;
				}
			}
			if ((cnt * M) - cost >= 0) {
				if (cnt >= ans) {
					ans = cnt;
				}
			}
			
		}
		
	}
	
	static void bfs(int r, int c) {
		
		for (int t = 1; t <= N+1; t++) { // 대각선으로 끝까지 탐색하려면 N+1 넣어야 됨
			Queue<int[]> q = new LinkedList<>();
			q.add(new int[] {r, c});
			visited = new boolean[N][N];
			visited[r][c] = true;
			int cnt = 0;
			if (map[r][c] == 1) {
				cnt++;
			}
			int cost = t*t + (t-1)*(t-1);
			
			for (int k = 1; k < t; k++) { // +t범위만큼씩만 진행하도록
				int size = q.size();
				while (size > 0) {
					int[] save = q.poll();
					int sr = save[0];
					int sc = save[1];
					
					for (int i = 0; i < 4; i++) {
						int nr = sr + dr[i];
						int nc = sc + dc[i];
						if (nr < 0 || nc < 0 || nr >= N || nc >= N || visited[nr][nc]) 
							continue;
						q.add(new int[] {nr, nc});
						visited[nr][nc] = true;
						if (map[nr][nc] == 1) {
							cnt++;
						}
					}
					
					size--;
				}
			}
			if ((cnt * M) - cost >= 0) {
				if (cnt >= ans) {
					ans = cnt;
				}
			}
		}
		
	}

}
