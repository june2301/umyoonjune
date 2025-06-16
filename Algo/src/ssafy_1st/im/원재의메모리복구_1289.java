package ssafy_1st.im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 원재의메모리복구_1289 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			
			char[] input = br.readLine().toCharArray();
			int[] bit = new int[input.length];
			int[] save = new int[input.length];
			for (int i = 0; i < input.length; i++) {
				bit[i] = input[i] - '0';
			}
			
			int cnt = 0;
			for (int i = 0; i < bit.length; i++) {
				if (bit[i] != save[i]) {
					cnt++;
					for (int j = i; j < save.length; j++) {
						save[j] = bit[i];
					}
				}
			}
			System.out.println("#" + tc + " " + cnt);
		}
		
	}

}
