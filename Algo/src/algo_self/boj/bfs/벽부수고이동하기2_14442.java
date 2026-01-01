package algo_self.boj.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 벽부수고이동하기2_14442 {
	
	static int N, M, K;
	static int[][] map;
	static int[] dr = {0, 0, 1, -1};
	static int[] dc = {1, -1, 0, 0};

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] NMK = br.readLine().split(" ");
		
		N = Integer.parseInt(NMK[0]);
		M = Integer.parseInt(NMK[1]);
		K = Integer.parseInt(NMK[2]);
		
		map = new int[N][M];
		
		for (int r = 0; r < N; r++) {
			char[] input = br.readLine().toCharArray();
			for (int c = 0; c < M; c++) {
				map[r][c] = input[c] - '0';
			}
		}
		if (N == 1 && M == 1) {
			System.out.println(1);
			return;
		}
		System.out.println(bfs());
		
	}
	
	static int bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {0, 0, K});
		int[][][] check = new int[N][M][K+1];
		check[0][0][K] = 1;
		
		while (!q.isEmpty()) {
			int[] curr = q.poll();
			int r = curr[0];
			int c = curr[1];
			int k = curr[2];
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
				
				if (nr == N-1 && nc == M-1) return check[r][c][k] + 1;
				
				if (map[nr][nc] == 1 && k > 0) {
					if (check[nr][nc][k-1] > 0) continue;
					
					q.add(new int[] {nr, nc, k-1});
					check[nr][nc][k-1] = check[r][c][k] + 1;
					
				} else if (map[nr][nc] == 0) {
					if (check[nr][nc][k] > 0) continue;
					
					q.add(new int[] {nr, nc, k});
					check[nr][nc][k] = check[r][c][k] + 1;
				}
				
			}
		}
		
		return -1;
	}

}

/**
 * bfs
 * [문제]
 * N*M 크기의 맵에서 0은 이동 가능하며 1은 이동 불가능한 지역이 주어진다.
 * 이 때 K번만큼 벽을 부술 수 있을 때, (1,1)에서 출발하여 (N,M)에 도착하는데 걸리는 최소비용을 구하시오.
 * 
 * 3차원 배열을 이용하여 각 칸마다 K번 내로 벽을 부수는 모든 이동 경우를 계산
 * check[r][c][k] 에 각 k마다 거리를 저장
 * 여기서 k는 남은 벽 부수기 횟수
 * 
 * 다음 이동하려는 칸이 0인 경우
 * 이동칸에 이미 해당 k값으로 다녀갔다면 패스
 * 
 * 다음 이동하려는 칸이 1인 경우
 * 이동칸을 부수기 떄문에 k-1값으로 다녀갔다면 패스
 * 
 * 이를 통해 각 칸에 대해 하나의 k값에 대한 방문처리를 구현
 * (해당 칸에 가장 먼저 방문하는게 가장 짧은 거리)
 * 
 * N-1,M-1에 제일 먼저 방문하는 것을 답으로 return
 * 만약 불가능하다면 -1 return
 * N과 M이 1이라면 답은 1로 return
 */

// 반례
//2 4 2
//0111
//0110