package ssafy_1st.im;

import java.util.Scanner;

public class magentic_1220 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		for (int tc = 1; tc <= 10; tc++) {
			int N = sc.nextInt();
			int[][] map = new int[N][N];
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					map[r][c] = sc.nextInt();
				}
			}
			
			// 1은 아래로
			// 2는 위로
			// 밖으로 나가는 1,2 다 계산 후 <- 안해도 OK
			// 줄별로 1,2 개수 계산
//			for (int c = 0; c < N; c++) {
//				for (int r = 0; r < N; r++) {
//					if (map[r][c] == 2) {
//						map[r][c] = 0;
//					}else if (map[r][c] == 1) {
//						break;
//					}
//				}
//				for (int r = N-1; r >= 0; r--) {
//					if (map[r][c] == 1) {
//						map[r][c] = 0;
//					}else if (map[r][c] == 2) {
//						break;
//					}
//				}
//			}
			
			int ans = 0;
			for (int c = 0; c < N; c++) {
				int cnt = 0;
				for (int r = 0; r < N; r++) {
					if (map[r][c] == 1) {
						cnt++;
					}
					if (cnt >= 1 && map[r][c] == 2) {
						ans++;
						cnt = 0;
					}
				}
			}
			System.out.println("#" + tc + " " + ans);
		}
	}

}
