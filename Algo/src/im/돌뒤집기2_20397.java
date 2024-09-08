package im;

import java.util.Scanner;

public class 돌뒤집기2_20397 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); // 돌 개수
			int M = sc.nextInt(); // 뒤집기 횟수
			
			int[] rock = new int[N];
			for (int i = 0; i < N; i++) {
				rock[i] = sc.nextInt();
			}
			
			for (int l = 0; l < M; l++) {
				int i = sc.nextInt()-1; // i번째 돌 기준
				int j = sc.nextInt(); // 마주보는 j개의 돌
				
				for (int t = 1; t <= j; t++) {
					if (i+t >= N || i-t < 0) {
						break;
					}
					if (rock[i-t] == rock[i+t]) {
						rock[i+t] = 1 - rock[i+t];
						rock[i-t] = 1 - rock[i-t];
					} 
				}
			}
			System.out.print("#" + tc + " ");
			for (int i = 0; i < N; i++) {
				System.out.print(rock[i] + " ");
			}
			System.out.println();
		}
	}
}
