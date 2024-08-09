package algo_w2_day4;

import java.util.Scanner;

public class swea2805 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = Integer.parseInt(sc.nextLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(sc.nextLine());
			
			int[][] land = new int[N][N];
			
			for (int r = 0; r < N; r++) {
				char[] input = sc.nextLine().toCharArray();
				for (int c = 0; c < N; c++) {
					land[r][c] = (int)(input[c] - '0');
				}
			}
			
			int sum = 0;
			
			int start = N / 2;
			int end = N / 2;
			
			for (int r = 0; r < N; r++) {
				for (int c = start ; c <= end ; c++) {
					sum += land[r][c];
				}
				
				if (r < N/2) {
					start--;
					end++;
				} else {
					start++;
					end--;
				}
				
			}
			System.out.println("#" + tc + " " + sum);
		}
		
		
	}

}
