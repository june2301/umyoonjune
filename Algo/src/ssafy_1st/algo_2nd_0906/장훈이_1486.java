package ssafy_1st.algo_2nd_0906;

import java.util.Scanner;

public class 장훈이_1486 {
	
	static int N, S, ans;
	static int[] hei;
	static boolean[] sel;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			S = sc.nextInt();
			hei = new int[N];
			for (int i = 0; i < N; i++) {
				hei[i] = sc.nextInt();
			}
			ans = Integer.MAX_VALUE;
			sel = new boolean[N];
			powerset(0);
			System.out.println("#" + tc + " " + ans);
		}
	}

	static void powerset(int idx) {
		if (idx == N) {
			int sum = 0;
			for (int i = 0; i < N; i++) {
				if (sel[i]) {
					sum += hei[i];
				}
			}
			if (sum >= S && sum - S <= ans) {
				ans = sum - S;
			}
			return;
		}
		
		sel[idx] = true;
		powerset(idx+1);
		sel[idx] = false;
		powerset(idx+1);
		
	}
	
}
