package algo_2nd_0912;

import java.util.Scanner;

public class BOJ2096_내려가기 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[][] map = new int[N][3];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < 3; c++) {
				map[r][c] = sc.nextInt();
			}
		}
		
		int[][] dpMin = new int[N][3];
		int[][] dpMax = new int[N][3];
		for (int i = 0; i < 3; i++) {
			dpMin[0][i] = map[0][i];
			dpMax[0][i] = map[0][i];
		}
		
		for (int r = 1; r < N; r++) {
			dpMin[r][0] = map[r][0] + Math.min(dpMin[r-1][0], dpMin[r-1][1]);
			dpMin[r][1] = map[r][1] + Math.min(Math.min(dpMin[r-1][0], dpMin[r-1][1]), dpMin[r-1][2]);
			dpMin[r][2] = map[r][2] + Math.min(dpMin[r-1][1], dpMin[r-1][2]);
			
			dpMax[r][0] = map[r][0] + Math.max(dpMax[r-1][0], dpMax[r-1][1]);
			dpMax[r][1] = map[r][1] + Math.max(Math.max(dpMax[r-1][0], dpMax[r-1][1]), dpMax[r-1][2]);
			dpMax[r][2] = map[r][2] + Math.max(dpMax[r-1][1], dpMax[r-1][2]);
		}
		
		int minA = Math.min(Math.min(dpMin[N-1][0], dpMin[N-1][1]), dpMin[N-1][2]);
		int maxA = Math.max(Math.max(dpMax[N-1][0], dpMax[N-1][1]), dpMax[N-1][2]);
		
		System.out.println(maxA + " " + minA);
	}

}
