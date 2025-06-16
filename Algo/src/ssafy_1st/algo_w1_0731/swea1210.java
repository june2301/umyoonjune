package ssafy_1st.algo_w1_0731;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea1210 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int tc = 0; tc < 10; tc++) {
			int T = Integer.parseInt(br.readLine());
			int[][] arr = new int[100][102];
			for (int r = 0; r < 100; r++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int c = 1; c < 101; c++) {
					arr[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			int ansr = 0;
			int ansc = 0;
			// 2찾기
			for (int r = 0; r < 100; r++) {
				for (int c = 1; c < 101; c++) {
					if(arr[r][c] == 2) {
						ansr = r;
						ansc = c;
					}
				}
			}
			
			for (int r = ansr; r > 0; r--) {
				// 왼쪽 1 체크
				if(arr[r][ansc - 1] == 1) {
					while(arr[r][ansc - 1] == 1) {
						ansc--;
					}
				}
				// 오른쪽 1 체크
				else if(arr[r][ansc + 1] == 1) {
					while(arr[r][ansc + 1] == 1) {
						ansc++;
					}
				}
			}
			System.out.println("#"+T+" "+(ansc-1));
		}
	}
}
