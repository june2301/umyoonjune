package im;

import java.util.Scanner;

public class 어디에단어가_1979 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			int[][] map = new int[N][N];
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					map[r][c] = sc.nextInt();
				}
			}
			
			// 세로줄 검사
			int ans = 0;
			for (int r = 0; r < N; r++) {
				int cnt = 0;
				for (int c = 0; c < N; c++) {
					if (map[r][c] == 1) {
						cnt++;
						if (cnt == K && c == N-1) {
							ans++;
						}else if (cnt == K && c < N-1) {
							if (map[r][c+1] == 0) {
								ans++;
							}
						}
					}
					if (map[r][c] == 0) {
						cnt = 0;
					}
				}
			}
			// 가로줄 검사
			for (int c = 0; c < N; c++) {
				int cnt = 0;
				for (int r = 0; r < N; r++) {
					if (map[r][c] == 1) {
						cnt++;
						if (cnt == K && r == N-1) {
							ans++;
						}else if (cnt == K && r < N-1) {
							if (map[r+1][c] == 0) {
								ans++;
							}
						}
					}
					if (map[r][c] == 0) {
						cnt = 0;
					}
				}
			}
			System.out.println("#" + tc + " " + ans);
		}
		
	}

}
