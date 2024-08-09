package algo_w2_day4;

import java.util.Scanner;

public class swea1974 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {

			int[][] land = new int[9][9];

			for (int r = 0; r < land.length; r++) {
				for (int c = 0; c < land.length; c++) {
					land[r][c] = sc.nextInt();
				}
			}
			
			int ans = 1;
			int[] check = new int[9];
			// 가로 확인
			for (int r = 0; r < 9; r++) {
				for (int c = 0; c < 9; c++) {
					check[land[r][c]-1]++;
				}
				for (int i = 0; i < 9; i++) {
					if (check[i] > 1 || check[i] < 0) {
						ans = 0;
						break;
					}
					check[i] = 0;
				}
			}
			// 세로 확인
			for (int c = 0; c < 9; c++) {
				for (int r = 0; r < 9; r++) {
					check[land[r][c]-1]++;
				}
				for (int i = 0; i < 9; i++) {
					if (check[i] > 1 || check[i] < 0) {
						ans = 0;
						break;
					}
					check[i] = 0;
				}
			}

			int[] dr = { -1, -1, -1, 0, 0, 0, 1, 1, 1 };
			int[] dc = { -1, 0, 1, -1, 0, 1, -1, 0, 1 };
			// 9칸 확인
			for (int r = 1; r <= 7; r += 3) {
				for (int c = 1; c <= 7; c += 3) {
					for (int d = 0; d < 9; d++) {
						int nr = r + dr[d];
						int nc = c + dc[d];
						check[land[nr][nc]-1]++;
					}
					for (int i = 0; i < 9; i++) {
						if (check[i] > 1 || check[i] < 0) {
							ans = 0;
							break;
						}
						check[i] = 0;
					}
				}
			}
			System.out.println("#" + tc + " " + ans);
		}
	}
}
