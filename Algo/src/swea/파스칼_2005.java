package swea;

import java.util.Scanner;

public class 파스칼_2005 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			// 예외처리 대신 배열+1로 생성
			int[][] nums = new int[N+1][N+1];
			
			// 배열에 숫자 저장
			nums[1][1] = 1;
			for (int r = 1; r < N; r++) {
				for (int c = 0; c < N; c++) {
					nums[1 + r][1 + c] = nums[r][c] + nums[r][c+1];
				}
			}
			
			// 배열 출력
			System.out.println("#" + tc);
			for (int i = 1; i < nums.length; i++) {
				for (int j = 1; j < nums.length; j++) {
					if (nums[i][j] != 0) {
						System.out.print(nums[i][j] + " ");
					}
				}
				System.out.println();
			}
			
		}
		
	}

}
