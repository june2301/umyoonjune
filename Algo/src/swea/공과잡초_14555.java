package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 공과잡초_14555 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String text = br.readLine();
			
			char[] input = text.toCharArray();
			
			int cnt = 0;
			for (int i = 0; i < input.length; i++) {
				if (input[i] == '|') {
					if (i >= 1) {
						if (input[i - 1] == '(') {
							cnt++;
						}
					}
					if (i < input.length - 1) {
						if (input[i + 1] == ')') {
							cnt++;
						}
					}
				}
				if (i < input.length - 1) {
					if (input[i] == '(' && input[i + 1] == ')') {
						cnt++;
						i++;
					}
				}
			}
			System.out.println("#" + tc + " " + cnt);
		}
		
	}

}
