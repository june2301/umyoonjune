package uyych_study.uyych;

import java.util.Scanner;

public class 활주로건설_4014 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int X = sc.nextInt();
		int[][] map = new int[N][N];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				map[r][c] = sc.nextInt();
			}
		}
		int ans = 0;
		// 가로
		for (int r = 0; r < N; r++) {
			int max = 0;
			for (int c = 0; c < N; c++) {
				if (map[r][c] > max) {
					max = map[r][c];
				}
			}
			int cnt = 0;
			for (int c = 0; c < N; c++) {
				if (max - map[r][c] == 1) {
					cnt++;
				}
			}
			if (cnt >= X) {
				ans++;
			}
		}
		// 세로
		for (int c = 0; c < N; c++) {
			int max = 0;
			for (int r = 0; r < N; r++) {
				if (map[r][c] > max) {
					max = map[r][c];
				}
			}
			int cnt = 0;
			for (int r = 0; r < N; r++) {
				if (max - map[c][r] == 1) {
					cnt++;
				}
			}
			if (cnt >= X) {
				ans++;
			}
		}
		System.out.println(ans);
		
		
	}

}
