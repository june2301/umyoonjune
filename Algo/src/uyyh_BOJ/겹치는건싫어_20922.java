package uyyh_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 겹치는건싫어_20922 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] NK = br.readLine().split(" ");
		
		int N = Integer.parseInt(NK[0]);
		int K = Integer.parseInt(NK[1]);
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] nums = new int[N];
		int cnt = 1;
		int ans = 0;
		int num = 0;
		int check = 1;
		nums[0] = Integer.parseInt(st.nextToken());
		for (int i = 1; i < N; i++) {
			num = Integer.parseInt(st.nextToken());
			nums[i] = num;
			cnt++;
			if (nums[i-1] == num) {
				check++;
				cnt--;
			} else if (check > 1) {
				check = 1;
			}
			if (check > K) {
				if (cnt > ans) {
					ans = cnt;
				}
				cnt = 0;
				check = 1;
			}
		}
		if (cnt > ans) {
			ans = cnt;
		}
		System.out.println(ans);
		
	}

}
