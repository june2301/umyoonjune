package algo_2nd_0905;

import java.util.Scanner;

public class 보호필름_2112 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int D = sc.nextInt();
		int W = sc.nextInt();
		int K = sc.nextInt();
		int[][] film = new int[D][W];
		for (int r = 0; r < D; r++) {
			for (int c = 0; c < W; c++) {
				film[r][c] = sc.nextInt();
			}
		}
		
		int[] d = new int[K];
		for (int i = 1; i < K; i++) {
			d[i] = i;
		}
		
		int check = 0;
		while (check != W) {
			int[][] line = new int[D][W];
			for (int c = 0; c < W; c++) {
				for (int r = 0; r < D; r++) {
					
				}
			}
			
			
			
			
			
			
			// 정답 검사
			for (int c = 0; c < W; c++) {
				for (int r = 0; r < D; r++) {
					int cnt = 0;
					int save = film[r][c];
					for (int i = 1; i < K; i++) {
						if (r+K < D) {
							if (save == film[r+d[i]][c]) {
								cnt++;
							}
						}
					}
					if (cnt >= K) {
						check++;
					}
				}
			}
			
			
			
		}
		
		
		
	}

}
