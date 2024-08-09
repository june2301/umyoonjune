package algo_w2_day5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea4613 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			
			String[] NM = br.readLine().split(" ");
			int N = Integer.parseInt(NM[0]);
			int M = Integer.parseInt(NM[1]);
			
			char[][] input = new char[N][M];
			int[] wCount = new int[N];
			int[] bCount = new int[N];
			int[] rCount = new int[N];
			int wcnt = 0;
			int bcnt = 0;
			int rcnt = 0;
			for (int r = 0; r < N; r++) {
				String row1 = br.readLine();
				for (int c = 0; c < M; c++) {
					input[r][c] = row1.charAt(c);
					if (input[r][c] == 'W') {
						wcnt++;
					}
					if (input[r][c] == 'B') {
						bcnt++;
					}
					if (input[r][c] == 'R') {
						rcnt++;
					}
				}
				wCount[r] = wcnt;
				wcnt = 0;
				bCount[r] = bcnt;
				bcnt = 0;
				rCount[r] = rcnt;
				rcnt = 0;
			}
			int sum = 0;
			int min = N*M;
			for (int i = 0; i < N - 2; i++) {
				for (int j = i + 1; j < N - 1; j++) {
					
					for (int w = 0; w <= i; w++) {
						sum += (bCount[w] + rCount[w]);
					}
					
					for (int b = i + 1; b <= j; b++) {
						sum += (wCount[b] + rCount[b]);
					}
					
					for (int r = j + 1; r < N; r++) {
						sum += (wCount[r] + bCount[r]);
					}
					
					if (sum < min) {
						min = sum;
					}
					sum = 0;
				}
			}
			System.out.println("#" + tc + " " + min);
		}
		
	}

}
