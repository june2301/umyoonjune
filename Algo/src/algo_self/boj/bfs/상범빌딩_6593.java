package algo_self.boj.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 상범빌딩_6593 {
	
	static int L, R, C;
	static char[][][] building;
	static int sl, sr, sc;
	static int[] dl = {1, -1, 0, 0, 0, 0};
	static int[] dr = {0, 0, 0, 0, 1, -1};
	static int[] dc = {0, 0, 1, -1, 0, 0};

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while (true) {
			String[] LRC = br.readLine().split(" ");
			L = Integer.parseInt(LRC[0]);
			R = Integer.parseInt(LRC[1]);
			C = Integer.parseInt(LRC[2]);
			
			if (L == 0 || R == 0 || C == 0) {
				break;
			}
			
			building = new char[L][R][C];
			for (int l = 0; l < L; l++) {
				for (int r = 0; r < R; r++) {
					building[l][r] = br.readLine().toCharArray();
					for (int c = 0; c < C; c++) {
						if (building[l][r][c] == 'S') {
							sl = l;
							sr = r;
							sc = c;
						}
					}
				}
				br.readLine();
			}
			
			int ans = bfs();
			if (ans < 0) {
				sb.append("Trapped!" + "\n");
			} else {
				sb.append("Escaped in " + ans + " minute(s)." + "\n");
			}
		}
		
		System.out.println(sb);
		
	}
	
	static int bfs() {
		boolean[][][] visited = new boolean[L][R][C];
		Queue<int[]> q = new LinkedList<int[]>();
		
		q.add(new int[] {sl, sr, sc, 0});
		visited[sl][sr][sc] = true;
		
		while (!q.isEmpty()) {
			int[] curr = q.poll();
			int l = curr[0];
			int r = curr[1];
			int c = curr[2];
			int d = curr[3];
			for (int i = 0; i < 6; i++) {
				int nl = l + dl[i];
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (nl < 0 || nl >= L || nr < 0 || nr >= R || nc < 0 || nc >= C 
						|| visited[nl][nr][nc] || building[nl][nr][nc] == '#') continue;
				if (building[nl][nr][nc] == 'E') {
					return d+1;
				}
				q.add(new int[] {nl, nr, nc, d+1});
				visited[nl][nr][nc] = true;
			}
		}
		
		return -1;
	}

}

/**
 * BFS
 * [문제]
 * 출발지점 'S' 와 도착지점 'E', 이동가능지점 '.' 과 벽 '#' 로 구성된 건물이
 * 층 L, 행 R, 열 C 만큼 이루어져 있다.
 * 동서남북상하 6방향으로 1칸씩 이동 가능하며 이동하는데 1분이 소요될 때
 * 몇 분 걸려 탈출 or 탈출 불가능한지 구하시오.
 * 
 * 기본적인 4방향 bfs에서 나아가 6방향 bfs 구현
 * 
 * 3차원 배열로 건물 형태를 입력받은 후
 * dl, dr, dc를 통해 6방향 이동 좌표 지정
 * 
 * 이후 bfs를 통해 범위 내에서 방문처리를 하며 탐색
 * 만약 E에 도달했다면 이동거리 return
 */

