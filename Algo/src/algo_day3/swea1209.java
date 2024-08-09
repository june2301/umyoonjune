package algo_day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea1209 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int tc = 1; tc <= 10; tc++) {
			
			int T = Integer.parseInt(br.readLine());
			
			int[][] arr = new int[100][100];
			
			for (int r = 0; r < 100; r++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int c = 0; c < 100; c++) {
					arr[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			int max = 0;
			int sum = 0;
			
//			ㅡ
			for (int r = 0; r < 100; r++) {
				for (int c = 0; c < 100; c++) {
					sum += arr[r][c];
					if (sum > max) {
						max = sum;
					}
				}
				sum = 0;
			}
			
//			ㅣ
			for (int r = 0; r < 100; r++) {
				for (int c = 0; c < 100; c++) {
					sum += arr[c][r];
					if (sum > max) {
						max = sum;
					}
				}
				sum = 0;
			}
			
//			\
			for (int c = 0; c < 100; c++) {
				sum += arr[c][c];
				if (sum > max) {
					max = sum;
				}
			}
			sum = 0;
			
//			/
			for (int r = 99; r >= 0; r--) {
				for (int c = 0; c < 100; c++) {
					sum += arr[r][c];
					if (sum > max) {
						max = sum;
					}
				}
				sum = 0;
			}
			
			System.out.println("#" + T + " " +max);
		}
		
	}

}
