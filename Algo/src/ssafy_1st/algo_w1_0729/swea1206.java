package ssafy_1st.algo_w1_0729;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea1206 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int tc = 1; tc <= 10; tc++) {
			
			int bnum = Integer.parseInt(br.readLine());
			
			String[] input = br.readLine().split(" ");
			int[] arr = new int[bnum];
			for (int i = 0; i < bnum; i++) {
				arr[i] = Integer.parseInt(input[i]);
			}
			
			int max = 0;
			int sum = 0;
			for (int i = 2; i < arr.length - 2; i++) {
				if (arr[i] > arr[i-2] &&
					arr[i] > arr[i-1] &&
					arr[i] > arr[i+1] &&
					arr[i] > arr[i+2]) {
					for (int j = 0; j < 2; j++) {
						if (arr[i-2 + j] > max) {
							max = arr[i-2 + j];
						}
						if (arr[i+1 + j] > max) {
							max = arr[i+1 + j];
						}
					}
					sum += arr[i]-max;
					max = 0;
				}
				
			}
			System.out.println("#"+tc+" "+sum);
		
		}
	}
}
