package uyyh_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 빌런호석_22251 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] NKPX = br.readLine().split(" ");
		int N = Integer.parseInt(NKPX[0]); // 빌딩 층
		int K = Integer.parseInt(NKPX[1]); // 자리수
		int P = Integer.parseInt(NKPX[2]); // 반전 가능 수
		int X = Integer.parseInt(NKPX[3]); // 현재 층
		
		int[][] nums = {{1, 1, 1, 0, 1, 1, 1},
						{0, 0, 1, 0, 0, 1, 0},
						{1, 0, 1, 1, 1, 0, 1},
						{1, 0, 1, 1, 0, 1, 1},
						{0, 1, 1, 1, 0, 1, 0},
						{1, 1, 0, 1, 0, 1, 1},
						{1, 1, 0, 1, 1, 1, 1},
						{1, 0, 1, 0, 0, 1, 0},
						{1, 1, 1, 1, 1, 1, 1},
						{1, 1, 1, 1, 0, 1, 1}};
		
		int[][] realX = new int[K][7];
		for (int i = K-1; i >= 0; i--) {
			realX[i] = nums[X%(10*(K-i))];
		}
		
		
		
		
	}

}
