package algo_2nd_0827;

import java.util.Scanner;

public class 햄버거다이어트_5215 {

	static int N, L;
	static int[] pt, cal;
	static int[] savePt, saveCal;
	static int ans;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			L = sc.nextInt();
			pt = new int[N];
			cal = new int[N];
			for (int i = 0; i < N; i++) {
				pt[i] = sc.nextInt();
				cal[i] = sc.nextInt();
			}
			ans = 0;
			for (int i = 1; i <= N; i++) {
				savePt = new int[N];
				saveCal = new int[N];
				comb(0, 0, i);
			}
			System.out.println("#" + tc + " " + ans);
		}
	}
	
	public static void comb(int idx, int sidx, int R) {
		
		if (sidx == R) {
			int sumPt = 0;
			int sumCal = 0;
			for (int i = 0; i < R; i++) {
				sumPt += savePt[i];
				sumCal += saveCal[i];
			}
			if (sumCal <= L && sumPt > ans) {
				ans = sumPt;
			}
			return;
		}
		
		for (int i = idx; i <= N-R+sidx; i++) {
			savePt[sidx] = pt[i];
			saveCal[sidx] = cal[i];
			comb(i+1, sidx+1, R);
		}
		
	}

}
