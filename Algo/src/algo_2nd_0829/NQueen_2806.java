package algo_2nd_0829;

import java.util.Scanner;

public class NQueen_2806 {

	static int N, cnt;
	static int[] Qu;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			cnt = 0;
			N = sc.nextInt();
			Qu = new int[N];
			put(0, N);
			System.out.println("#" + tc + " " + cnt);
		}
	}

	static void put(int row, int N) {
		if (row == N) {
			cnt++;
			return;
		}
		
		for (int col = 0; col < N; col++) {
			if (check(row, col)) {
				Qu[row] = col;
				put(row+1, N);
			} 
		}
	}
	
	static boolean check(int row, int col) {
		for (int i = 0; i < row; i++) {
			if (Qu[i] == col || Math.abs(Qu[i] - col) == Math.abs(i - row)) {
				return false;
			}
		}
		return true;
	}
	
}
