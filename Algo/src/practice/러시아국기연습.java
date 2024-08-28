package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 러시아국기연습 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			
			String[] NM = br.readLine().split(" ");
			int N = Integer.parseInt(NM[0]);
			int M = Integer.parseInt(NM[1]);
			
			// 줄마다 색깔 몇개씩인지 cnt
			int[] Wcnt = new int[N];
			int[] Bcnt = new int[N];
			int[] Rcnt = new int[N];
			
			char[][] flag = new char[N][M];
			for (int r = 0; r < N; r++) {
				char[] rowInput = br.readLine().toCharArray();
				for (int c = 0; c < M; c++) {
					flag[r][c] = rowInput[c];
					if (rowInput[c] == 'W') 
						Wcnt[r]++;
					if (rowInput[c] == 'B') 
						Bcnt[r]++;
					if (rowInput[c] == 'R') 
						Rcnt[r]++;
				}
			}
			
			int max = N*M;
			for (int i = 0; i < N-2; i++) {
				for (int j = i+1; j < N-1; j++) {
					
					int sum = 0;
					
					for (int W = 0; W <= i ; W++) {
						sum += Bcnt[W] + Rcnt[W];
					}
					for (int B = i + 1; B <= j; B++) {
						sum += Wcnt[B] + Rcnt[B];
					}
					for (int R = j + 1; R < N; R++) {
						sum += Wcnt[R] + Bcnt[R];
					}
					
					if (sum < max) {
						max = sum;
					}
				}
			}
			
			System.out.println("#" + tc + " " + max);
		}
		
	}

}
