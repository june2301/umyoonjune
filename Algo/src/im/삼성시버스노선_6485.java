package im;

import java.util.Scanner;

public class 삼성시버스노선_6485 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[][] track = new int[N][N];
			for (int i = 0; i < N; i++) {
				track[i][0] = sc.nextInt();
				track[i][1] = sc.nextInt();
			}
			int P = sc.nextInt();
			int[] ans = new int[P];
			for (int c = 0; c < P; c++) {
				int C = sc.nextInt();
				int cnt = 0;
				for (int i = 0; i < N; i++) {
					if (C >= track[i][0] && C <= track[i][1]) {
						cnt++;
					}
				}
				ans[c] = cnt;
			}
			System.out.print("#" + tc + " ");
			for (int i = 0; i < P; i++) {
				System.out.print(ans[i] + " ");
			}
			System.out.println();
			
		}
		
	}

}
