package algo_day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea12712 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			
			String[] NM = br.readLine().split(" ");
			int N = Integer.parseInt(NM[0]);
			int M = Integer.parseInt(NM[1]);
			
			// N+2*(M-1) 만큼 area 생성
			int num = 0;
			int[][] area = new int[N+2*(M-1)][N+2*(M-1)];
			for (int i = M-1; i < N+M-1; i++) {
				String[] areaNum = br.readLine().split(" ");
				for (int j = M-1; j < N+M-1; j++) {
					area[i][j] = Integer.parseInt(areaNum[num++]);
				}
				num = 0;
			}
			
			int max = 0;
			int sum = 0;
			
//			델타 생성
			int idx = 0;
			int[] d = new int[M*2-1];
			for (int i = -M+1; i < M; i++) {
				d[idx++] = i;
			}
			
//			+
			for (int r = M-1; r < N+M-1; r++) {
				for (int c = M-1; c < N+M-1; c++) {
					for (int i = 0; i < d.length; i++) {
						sum += area[r][c+d[i]];
						sum += area[r+d[i]][c];
					}
					sum -= area[r][c];
					if (sum > max) {
						max = sum;
					}
					sum = 0;
				}
			}
			
//			X
			for (int r = M-1; r < N+M-1; r++) {
				for (int c = M-1; c < N+M-1; c++) {
					for (int i = 0; i < d.length; i++) {
						sum += area[r+d[i]][c+d[i]];
						sum += area[r+d[i]][c-d[i]];
					}
					sum -= area[r][c];
					if (sum > max) {
						max = sum;
					}
					sum = 0;
				}
			}
			
			System.out.println("#"+tc+" "+max);
		}

	}

}
