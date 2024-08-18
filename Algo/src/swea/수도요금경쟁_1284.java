package swea;

import java.util.Scanner;

public class 수도요금경쟁_1284 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			int P = sc.nextInt(); // A사 리터당 요금
			int Q = sc.nextInt(); // B사 초기요금 금액
			int R = sc.nextInt(); // B사 초기요금 리터
			int S = sc.nextInt(); // B사 초과 리터당 요금
			int W = sc.nextInt(); // 사용 리터
			
			int A = P * W;
			int B = Q;
			if (W > R) {
				B += (W - R) * S;
			}
			
			int ans = Math.min(A, B);
			
			System.out.println("#" + tc + " " + ans);
			
		}
		
	}

}
