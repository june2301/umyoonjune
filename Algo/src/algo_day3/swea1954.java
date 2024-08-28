package algo_day3;

import java.util.Scanner;

public class swea1954 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {

			int N = sc.nextInt();
			int[][] nums = new int[N][N];

			// 우 하 좌 상
			int[] dr = { 0, 1, 0, -1 };
			int[] dc = { 1, 0, -1, 0 };

			int num = 1;
			int d = 0;
			int nr = 0;
			int nc = 0;
			while (num < N * N + 1) {
				nums[nr][nc] = num++;
				nr += dr[d];
				nc += dc[d];
				if (nc >= N || nr >= N || nr < 0 || nc < 0 || nums[nr][nc] != 0) {
					nr -= dr[d];
					nc -= dc[d];
					d = (d + 1) % 4;
					nr += dr[d];
					nc += dc[d];
				}
			}
			System.out.println("#" + tc);
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					System.out.print(nums[r][c] + " ");
				}
				System.out.println();
			}

		}
		
	}

}
