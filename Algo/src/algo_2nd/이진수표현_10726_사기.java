package algo_2nd;

import java.util.Scanner;

public class 이진수표현_10726_사기 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();

			String ans = "ON";

			for (int i = 0; i < N; i++) {
				if (M % 2 == 0) {
					ans = "OFF";
					break;
				}
				M /= 2;
			}
			System.out.println("#" + tc + " " + ans);
		}

	}
}
