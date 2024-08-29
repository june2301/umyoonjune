import java.util.Scanner;

public class SWEA_5215_햄버거다이어트 {

	static int N, L; // N : 재료 개수, L : 제한 칼로리
	static int[] cals;
	static int[] scores;
	static int ans;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			L = sc.nextInt();
			scores = new int[N];
			cals = new int[N];
			for (int i = 0; i < N; i++) {
				scores[i] = sc.nextInt();
				cals[i] = sc.nextInt();
			}
			ans = 0;
			
			// 1. 비트마스킹 풀 수 있다
			makeBurger(0, 0, 0);
			System.out.println("#" + tc + " " + ans);
			
			
			
		}
		
		
	}

	static void makeBurger(int idx, int sumScore, int sumCal) {
		if (sumCal > L) { // idx-1번째까지 고려했었는데, 이미 제한 칼로리 벗어나서 할 필요X
			return;
		}
		
		// 기저조건
		if (idx == N) {
			// 모든 재료를 전부 다 고려했다
			if (ans < sumScore) {
				ans = sumScore;
			}
			// 베스트인지 아닌지 판단
			return;
		}
		
		
		// 재귀부분
		// 이번에 idx 재료 사용했다
		makeBurger(idx+1, sumScore+scores[idx], sumCal+cals[idx]);
		// 이번에 재료를 사용하지 않았다
		makeBurger(idx+1, sumScore, sumCal);
		
	}
	
	
	
}
