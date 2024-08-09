package algo_w2_day2;

import java.util.Scanner;

public class swea1217 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		for (int tc = 1; tc <= 10; tc++) {
			int T = sc.nextInt();
			int N = Integer.parseInt(sc.next());
			int M = Integer.parseInt(sc.next());
			System.out.println("#" + T + " " + cal(N, M));
		}
		
	}
	
	static int cal(int N, int M) {
		int result = 1;
		for (int i = 1; i <= M; i++) {
			result *= N;
		}
		return result;
	}

}
