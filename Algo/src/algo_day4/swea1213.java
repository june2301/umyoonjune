package algo_day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea1213 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int tc = 0; tc < 10; tc++) {
			int T = Integer.parseInt(br.readLine());
			
			char[] sch = br.readLine().toCharArray();
			char[] txt = br.readLine().toCharArray();
			int sl = sch.length;
			int tl = txt.length;
			
			int cnt = 0;
			int ans = 0;
			for (int i = 0; i < tl - sl + 1; i++) {
				for (int j = 0; j < sl; j++) {
					// 글자 맞는지 확인
					if (txt[i+j] == sch[j]) {
						cnt++;
					}
					// sch 만큼 글자수가 맞다면 ans++
					if (cnt == sch.length) {
						ans++;
					}
				}
				cnt = 0;
			}
			
			System.out.println("#"+T+" "+ans);
		}
		
	}

}
