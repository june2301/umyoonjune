package algo_day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea1216 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int tc = 1; tc <= 10; tc++) {
			int T = Integer.parseInt(br.readLine());
			char[][] map = new char[102][102];
			
			for (int r = 1; r < 101; r++) {
				char[] input = br.readLine().toCharArray();
				for (int c = 1; c < 101; c++) {
					map[r][c] = input[c-1];
				}
			}
			
			int cnt = 1;
			int max = 0;
			// 가로
			for (int r = 1; r < 101; r++) {
				for (int c = 1; c < 101; c++) {
					// 홀수
					while(map[r][c-cnt] == map[r][c+cnt]) {
						cnt++;
					}
					if (cnt*2-1 > max) {
						max = cnt*2-1;
					}
					cnt = 0;
					// 짝수
					while(map[r][c-cnt+1] == map[r][c+cnt]) {
						cnt++;
					}
					if ((cnt-1)*2 > max) {
						max = (cnt-1)*2;
					}
					cnt = 0;
				}
			}
			
			// 세로
			for (int r = 1; r < 101; r++) {
				for (int c = 1; c < 101; c++) {
					// 홀수
					while(map[r-cnt][c] == map[r+cnt][c]) {
						cnt++;
						if (cnt*2-1 > max) {
							max = cnt*2-1;
						}
					}
					cnt = 0;
					// 짝수
					while(map[r-cnt+1][c] == map[r+cnt][c]) {
						cnt++;
						if ((cnt-1)*2 > max) {
							max = (cnt-1)*2;
						}
					}
					cnt = 0;
				}
			}
			System.out.println("#"+T+" "+(max));
		}
		
	}

}
