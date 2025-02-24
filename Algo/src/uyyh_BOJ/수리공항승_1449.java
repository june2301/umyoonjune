package uyyh_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 수리공항승_1449 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] NL = br.readLine().split(" ");
		
		int N = Integer.parseInt(NL[0]);
		int L = Integer.parseInt(NL[1]);
		
		String[] input = br.readLine().split(" ");
		int[] pipe = new int[1001];
		for (int i = 0; i < N; i++) {
			pipe[Integer.parseInt(input[i])] = 1;
		}
		
		int ans = 0;
		for (int i = 1; i < 1001; i++) {
			if (pipe[i] == 1) {
				ans++;
				i += L-1;
			}
		}
		
		System.out.println(ans);
		
	}

}
