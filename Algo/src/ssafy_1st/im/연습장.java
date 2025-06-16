package ssafy_1st.im;

import java.util.Scanner;

public class 연습장 {

	static int N, M, ans;
	static int[] card, save;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		card = new int[N];
		for (int i = 0; i < N; i++) {
			card[i] = sc.nextInt();
		}
		ans = 0;
		save = new int[3];
		comb(0, 0);
		System.out.println(ans);
	}
	
	static void comb(int idx, int sidx) {
		if (sidx == 3) {
			int sum = 0;
			for (int i = 0; i < 3; i++) {
				sum += save[i];
			}
			if (sum <= M && sum > ans) {
				ans = sum;
			}
			return;
		}
		
		for (int i = idx; i <= N-3+sidx; i++) {
			save[sidx] = card[i];
			comb(i+1, sidx+1);
		}
		
	}

}
