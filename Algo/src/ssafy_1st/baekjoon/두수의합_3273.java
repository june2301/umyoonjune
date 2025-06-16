package ssafy_1st.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 두수의합_3273 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		String sinput = br.readLine();
		
		StringTokenizer st = new StringTokenizer(sinput);
		List<Integer> nums = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			nums.add(Integer.parseInt(st.nextToken()));
		}
		int m = Integer.parseInt(br.readLine());
		Collections.sort(nums);
		int cnt = 0;
		List<Integer> rest = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			rest.add(m - nums.get(i));
			if (sinput.contains(Integer.toString(rest.get(i)))) {
				cnt++;
			}
		}
		System.out.println(cnt / 2);
	}

}
