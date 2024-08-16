package uyyh;

import java.util.Scanner;

public class 두개의숫자열_1959 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int[] A = new int[N];
			int[] B = new int[M];
			
			for (int i = 0; i < N; i++) {
				A[i] = sc.nextInt();
			}
			
			for (int i = 0; i < M; i++) {
				B[i] = sc.nextInt();
			}
			int max = 0;
			int sum = 0;
			if (A.length >= B.length) {
				for (int i = 0; i < N-M+1; i++) {
					for (int j = 0; j < M; j++) {
						sum += A[j+i] * B[j];
					}
					if (sum > max) {
						max = sum;
					}
					sum = 0;
				}
			} else {
				for (int i = 0; i < M-N+1; i++) {
					for (int j = 0; j < N; j++) {
						sum += A[j] * B[j+i];
					}
					if (sum > max) {
						max = sum;
					}
					sum = 0;
				}
			}
			System.out.println("#" + tc + " " + max);
		}
		
	}

}
