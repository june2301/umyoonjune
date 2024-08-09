package algo_day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea2068 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		int max = 0;
		for (int tc = 1; tc <= T; tc++) {
			String[] input = br.readLine().split(" ");
			int[] arr1 = new int[10];
			
			for (int i = 0; i < arr1.length; i++) {
				arr1[i] = Integer.parseInt(input[i]);
			}
			
			for (int i = 0; i < arr1.length; i++) {
				if (arr1[i] > max) {
					max = arr1[i];
				}
			}
			
			System.out.println("#"+tc+" "+max);
			
		}
		
	}

}
