package ssafy_1st.algo_2nd_0905;

import java.util.Scanner;

public class 보호필름_2112 {
	
	static int D,W,K; 
	static int[][] film;
	static int ans;
	static int[] A, B;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			D = sc.nextInt();
			W = sc.nextInt();
			K = sc.nextInt();
			film = new int[D][W];
			for (int r = 0; r < D; r++) {
				for (int c = 0; c < W; c++) {
					film[r][c] = sc.nextInt();
				}
			}
			A = new int[W]; // 이거 대신 Arrays.fill 쓰는 것도 생각
			B = new int[W];
			for (int i = 0; i < W; i++) {
				B[i] = 1;
			}
			ans = K;
			
			test(0, 0);
			
			System.out.println("#" + tc + " " + ans);
		}
	}
	
	static void test(int idx, int cnt) {
		// idx = r 번호
		// cnt = 약품처리횟수
		
		if (idx == D) {
			if (check()) {
				ans = Math.min(ans, cnt);
			}
			return;
		}
		
		test(idx+1, cnt); // 약품X
		
		int[] save = film[idx];
		
		film[idx] = A;
		test(idx+1, cnt+1); // A약품
		film[idx] = B;
		test(idx+1, cnt+1); // B약품
		
		film[idx] = save;
		
	}
	
	
	static boolean check() {
		for (int c = 0; c < W; c++) { // c 0~W까지
			boolean ans = false;
			int cnt = 1;
			for (int r = 1; r < D; r++) {
				if (film[r][c] == film[r-1][c]) { // 1번부터 시작 | 이전거랑 같으면
					cnt++;
				}else { // 다르면 다시 cnt 1부터 시작
					cnt = 1;
				}
				if (cnt >= K) { // 한 줄 평가
					ans = true;
					break;
				}
			}
			if (!ans) { // 한 줄만 달라도 바로 return
				return false;
			}
		} // 걸린게 없다면 통과
		return true;
	}
	

}
