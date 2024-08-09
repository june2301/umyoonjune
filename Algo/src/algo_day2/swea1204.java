package algo_day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea1204 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(br.readLine());
			int[] nums = new int[1000];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 1000; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			int[] cnts = new int[101];
			for (int i = 0; i < nums.length; i++) {
				cnts[nums[i]]++;
			}
			int max = 0;
			int ans = 0;
			for (int i = 0; i < cnts.length; i++) {
				if (cnts[i] >= max) {
					max = cnts[i];
					ans = i;
				}
			}
			System.out.println("#"+n+" "+ans);
		}
	}
}
