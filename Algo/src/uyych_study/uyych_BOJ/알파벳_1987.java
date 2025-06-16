package uyych_study.uyych_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 알파벳_1987 {

	static int R, C, ans;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static char[][] map;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] RC = br.readLine().split(" ");
		R = Integer.parseInt(RC[0]);
		C = Integer.parseInt(RC[1]);

		map = new char[R][C];
		for (int r = 0; r < R; r++) {
			char[] input = br.readLine().toCharArray();
			for (int c = 0; c < C; c++) {
				map[r][c] = input[c];
			}
		}

		boolean[] visited = new boolean[26]; 
		dfs(0, 0, 1, visited);
		
		System.out.println(ans);
	}

	public static void dfs(int r, int c, int cnt, boolean[] visited) {
		ans = Math.max(ans, cnt);

		visited[map[r][c] - 'A'] = true;

		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (nr < 0 || nc < 0 || nr >= R || nc >= C)continue;

			char ch = map[nr][nc];
			if (!visited[ch - 'A']) {
				dfs(nr, nc, cnt + 1, visited);
			}
		}
		
		visited[map[r][c] - 'A'] = false;

	}

}
