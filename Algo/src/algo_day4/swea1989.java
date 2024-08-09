package algo_day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class swea1989 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String str = br.readLine();
			
			char[] arr1 = str.toCharArray();
			char[] arr2 = new char[str.length()];
			for (int i = 0; i < str.length(); i++) {
				arr2[i] = arr1[str.length()-1-i];
			}
			
			if (Arrays.toString(arr2).equals(Arrays.toString(arr1))) {
				System.out.println("#"+tc+" "+ 1);
			}else {
				System.out.println("#"+tc+" "+ 0);
			}
			
		}
		
	}

}
