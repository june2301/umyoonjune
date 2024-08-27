package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 영역구하기_2583 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] MNK = br.readLine().split(" ");
		int M = Integer.parseInt(MNK[0]);
		int N = Integer.parseInt(MNK[1]);
		int K = Integer.parseInt(MNK[2]);
		
		int[][] map = new int[M][N];
		
		for (int i = 0; i < K; i++) {
			String[] input = br.readLine().split(" ");
			int sc = Integer.parseInt(input[0]);
			int sr = Integer.parseInt(input[1]);
			int ec = Integer.parseInt(input[2]);
			int er = Integer.parseInt(input[3]);
			for (int r = sr; r < er; r++) {
				for (int c = sc; c < ec; c++) {
					map[r][c] = 1;
				}
			}
		}
		
		for (int r = 0; r < M; r++) {
			for (int c = 0; c < N; c++) {
				System.out.print(map[r][c] + " ");
			}
			System.out.println();
		}
		
		
	}
	
	public static void bfs(int[][] map) {
		
	}

}
