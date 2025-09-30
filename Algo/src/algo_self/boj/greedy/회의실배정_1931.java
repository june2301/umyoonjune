package algo_self.boj.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 회의실배정_1931 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		List<int[]> list = new ArrayList<int[]>();
		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			int st = Integer.parseInt(input[0]);
			int en = Integer.parseInt(input[1]);
			list.add(new int[] {st, en});
		}
		
		Collections.sort(list, (a, b) -> {
			if (a[1] == b[1]) return a[0] - b[0]; 
			return a[1] - b[1];
		});
		
		int time = 0;
		int ans = 0;
		for (int i = 0; i < N; i++) {
			int[] curr = list.get(i);
			if (curr[0] >= time) {
				time = curr[1];
				ans++;
			}
		}
		
		System.out.println(ans);
		
	}

}

/**
 * 그리디
 * [문제]
 * 1개의 회의실에 N개의 회의에 대해 사용표를 만드려고 한다.
 * 각 회의의 시작/끝 시간이 주어지고, 회의가 시작되면 중단될 수 없으며, 시간/끝이 같은 회의도 주어진다.
 * 이 때 최대 회의 개수를 구하시오.
 * 
 * 회의를 끝나는 시간 기준으로 정렬한 후
 * 각각의 회의의 시작시간이 저장된 끝 시간과 같거나 큰 경우들을 골라서 회의 개수를 채운다
 * 
 * 이 때, 회의의 시작/끝이 같은 경우가 있을 수 있으므로 시작시간에 대한 정렬도 반드시 적용할 것.
 */

