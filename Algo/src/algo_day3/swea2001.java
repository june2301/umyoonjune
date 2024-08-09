package algo_day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea2001 {

public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			
			String[] NM = br.readLine().split(" ");
			int N = Integer.parseInt(NM[0]);
			int M = Integer.parseInt(NM[1]);
			
			int[][] area = new int[N][N];
			for (int i = 0; i < N; i++) {
				String[] areaNum = br.readLine().split(" ");
				for (int j = 0; j < N; j++) {
					area[i][j] = Integer.parseInt(areaNum[j]);
				}
			}
			
			int sum = 0;
			int ans = 0;
			
			for (int r = 0; r < N-M+1; r++) {
				for (int c = 0; c < N-M+1; c++) {
					for (int i = r; i < r+M; i++) {
						for (int j = c; j < c+M; j++) {
							sum += area[i][j];
							if (sum > ans) {
								ans = sum;
							}
						}
					}
					sum = 0;
				}
			}
			System.out.println("#"+tc+" "+ans);
		}
		
	}

}
