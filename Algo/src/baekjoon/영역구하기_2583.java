package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

public class 영역구하기_2583 {
	
	static int M, N;
	static int[][] map;
	static int[] dr = {1, 0, -1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int size;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] MNK = br.readLine().split(" ");
		M = Integer.parseInt(MNK[0]);
		N = Integer.parseInt(MNK[1]);
		int K = Integer.parseInt(MNK[2]);
		
		map = new int[M][N];
		for (int i = 0; i < K; i++) {
			String[] input = br.readLine().split(" ");
			int sc = Integer.parseInt(input[0]);
			int sr = Integer.parseInt(input[1]);
			int ec = Integer.parseInt(input[2]);
			int er = Integer.parseInt(input[3]);
			
			// 입력받기 - 사각형 있는 지역은 1
			for (int r = sr; r < er; r++) {
				for (int c = sc; c < ec; c++) {
					map[r][c] = 1;
				}
			}
		}
		
		// pq를 통해 알아서 오름차순 정렬
		Queue<Integer> pq = new PriorityQueue<Integer>();
		for (int r = 0; r < M; r++) {
			for (int c = 0; c < N; c++) {
				// 0인 영역 찾기
				if (map[r][c] == 0) {
					// size 1로 줘놓고 dfs시작
					size = 1;
					dfs(r, c);
					pq.add(size);
				}
			}
		}
		// pq 사이즈로 영역 개수 카운트
		int ans = pq.size();
		System.out.println(ans);
		for (int i = 0; i < ans; i++) {
			System.out.print(pq.poll() + " ");
		}
	}
	
	public static void dfs(int r, int c) {
		map[r][c] = 1;
		
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			// 4방탐색하며 인접한 0인 영역 size++
			if (nr >= 0 && nc >= 0 && nr < M && nc < N && map[nr][nc] == 0) {
				size++;
				dfs(nr, nc);
			}
		}
	}
}
