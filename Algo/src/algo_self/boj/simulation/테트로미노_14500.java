package algo_self.boj.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 테트로미노_14500 {
	
	static int N, M, ans;
	static int[][] map;
	static int[] dr = {0, 0, -1, 1};
	static int[] dc = {1, -1, 0, 0};
	static int[][][] dt = {
			{{0,0},{0,1},{0,2},{1,1}}, // ㅜ
			{{0,0},{1,0},{2,0},{1,1}}, // ㅏ
			{{0,0},{1,0},{1,-1},{1,1}}, // ㅗ
			{{0,0},{1,0},{2,0},{1,-1}} // ㅓ
			};
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
		
		ans = 0;
		visited = new boolean[N][M];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				visited[r][c] = true;
				LI(r, c, 1, map[r][c]);
				visited[r][c] = false;
				T(r, c);
				O(r, c);
			}
		}
		System.out.println(ans);
		
	}
	
	static void T(int r, int c) {
		for (int i = 0; i < 4; i++) {
		    int sum = 0;
		    boolean check = true;
		    for (int j = 0; j < 4; j++) {
		        int nr = r + dt[i][j][0];
		        int nc = c + dt[i][j][1];
		        if (nr < 0 || nr >= N || nc < 0 || nc >= M) {
		            check = false; 
		            break;
		        }
		        sum += map[nr][nc];
		    }
		    if (check) ans = Math.max(ans, sum);
		}
	}
	
	static void O(int r, int c) {
		if (r+1 < N && c+1 < M) {
		    int sum = map[r][c] + map[r][c+1] + map[r+1][c] + map[r+1][c+1];
		    ans = Math.max(ans, sum);
		}
	}
	
	static void LI(int r, int c, int cnt, int sum) {
		if (cnt == 4) {
			ans = Math.max(sum, ans);
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc]) continue;
			visited[nr][nc] = true;
			LI(nr, nc, cnt + 1, sum + map[nr][nc]);
			visited[nr][nc] = false;
		}
	}

}

/**
 * 구현
 * [문제]
 * 테트리스 도형 모양(ㅡ, L, ㅗ, ㅁ, ┗┓)에 맞게
 * 주어진 N*M크기의 종이에서 도형이 차지하는 칸의 숫자의 합의 최댓값을 구하시오.
 * 
 * bfs로 모든 r,c를 탐색하려 했지만 ㅗ모양과 ㅁ모양을 구할 수 없음
 * 
 * ㅗ모양 구하는 함수 / ㅁ모양 구하는 함수 / 나머지 3개 모양 구하는 함수 각각 구현
 * ㅗ모양 함수는 시작점 기준으로 ㅗ ㅏ ㅜ ㅓ 모양을 구현하도록 dt배열 생성 후
 * 범위를 초과하지 않았을 때 최댓값 갱신
 * 
 * ㅁ모양 함수는 범위 내에서 r,c/r+1,c/r,c+1/r+1,c+1 더해서 계산
 * 
 * 나머지 3개 함수는 dfs를 이용해서 탐색
 * r,c 좌표에 대해 dr,dc를 이용해 4방향으로 탐색을 진행하며 방문처리를 통해 같은 좌표 반복 X
 * 이후 4개가 모였을 때 최댓값 갱신
 */

