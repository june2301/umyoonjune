package im;

import java.util.Scanner;

public class 숫자배열회전_1961 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[][] nums = new int[N][N];
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					nums[r][c] = sc.nextInt();
				}
			}
			
			int[][] ans1 = new int[N][N];
			int[][] ans2 = new int[N][N];
			int[][] ans3 = new int[N][N];
			
			for (int c = 0; c < N; c++) {
				for (int r = 0; r < N; r++) { 
					// c랑 r 바꿔서 넣어주니 
					// 담을때도 c랑r 바꿔서 담기
					ans1[c][r] = nums[N-1-r][c];
				}
			}
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					ans2[r][c] = nums[N-1-r][N-1-c];
				}
			}
			for (int c = 0; c < N; c++) {
				for (int r = 0; r < N; r++) {
					ans3[c][r] = nums[r][N-1-c];
				}
			}
			
			System.out.println("#" + tc);
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					System.out.print(ans1[r][c]);
				}
				System.out.print(" ");
				for (int c = 0; c < N; c++) {
					System.out.print(ans2[r][c]);
				}
				System.out.print(" ");
				for (int c = 0; c < N; c++) {
					System.out.print(ans3[r][c]);
				}
				System.out.println();
			}
		}
	}
}
