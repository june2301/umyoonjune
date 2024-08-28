package practice;

import java.util.Scanner;

public class 파리퇴치연습 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int[][] map = new int[N][N];
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					map[r][c] = sc.nextInt();
				}
			}
			
			//파리퇴치3
			int idx = 0;
			int[] d = new int[2*M-1];
			for (int i = -M+1; i <= M-1; i++) {
				d[idx++] = i;
			}
			
			int max = 0;
			// +
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					int sum = 0;
					
					for (int i = 0; i < d.length; i++) {
                        int dr = r + d[i];
                        if (dr >= 0 && dr < N) {
                            sum += map[dr][c];  
                        }
                        
                        int dc = c + d[i];
                        if (dc >= 0 && dc < N) {
                            sum += map[r][dc]; 
                        }
                    }
                    sum -= map[r][c];
					
					if (sum > max) {
						max = sum;
					}
				}
			}
			
			// X
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					int sum = 0;
					
					for (int i = 0; i < d.length; i++) {
                        int dr1 = r + d[i];
                        int dc1 = c + d[i];
                        if (dr1 >= 0 && dr1 < N && dc1 >= 0 && dc1 < N) {
                            sum += map[dr1][dc1];
                        }
                        
                        int dr2 = r + d[i];
                        int dc2 = c - d[i];
                        if (dr2 >= 0 && dr2 < N && dc2 >= 0 && dc2 < N) {
                            sum += map[dr2][dc2];
                        }
                    }
                    sum -= map[r][c];
					
					if (sum > max) {
						max = sum;
					}
				}
			}
			System.out.println("#" + tc + " " + max);
			
			
			
//			// 파리퇴치
//			int max = 0;
//			for (int r = 0; r < N - M + 1; r++) {
//				for (int c = 0; c < N - M + 1; c++) {
//					int sum = 0;
//					
//					for (int i = 0; i < M; i++) {
//						for (int j = 0; j < M; j++) {
//							sum += map[r+i][c+j];
//						}
//					}
//					if (sum > max) {
//						max = sum;
//					}
//				}
//			}
//			System.out.println("#" + tc + " " + max);
		}
		
	}

}
