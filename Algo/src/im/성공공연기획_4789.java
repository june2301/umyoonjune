package im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 성공공연기획_4789 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			char[] input = br.readLine().toCharArray();
			int[] man = new int[input.length];
			for (int i = 0; i < input.length; i++) {
				man[i] = input[i] - '0';
			}
			
			int cnt = 0;
			int ans = 0;
			for (int i = 0; i < man.length; i++) { // i번째 사람
				if (man[i] > 0 && i > cnt) {
					ans += i - cnt;
					cnt += i - cnt;
				}
				cnt += man[i]; // i번째까지 기립한 사람수
			}
			System.out.println("#" + tc + " " + ans);
			
		}
		
	}

}
