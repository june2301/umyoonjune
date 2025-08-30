package algo_self.boj.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class 멀티탭스케줄링_1700 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] NK = br.readLine().split(" ");
		int N = Integer.parseInt(NK[0]);
		int K = Integer.parseInt(NK[1]);

		String[] input = br.readLine().split(" ");
		int[] order = new int[K];
		for (int i = 0; i < K; i++) {
			order[i] = Integer.parseInt(input[i]);
		}

		Set<Integer> plug = new HashSet<>();
		int cnt = 0;
		for (int i = 0; i < K; i++) {
			int curr = order[i];

			if (plug.contains(curr)) continue;

			if (plug.size() < N) {
				plug.add(curr);
				continue;
			}

			int last = -1;
			int remove = -1;
			for (int p : plug) {
				int next = Integer.MAX_VALUE;
				for (int j = i + 1; j < K; j++) {
					if (order[j] == p) {
						next = j;
						break;
					}
				}

				if (next > last) {
					last = next;
					remove = p;
				}
			}

			plug.remove(remove);
			plug.add(curr);
			cnt++;
		}

		System.out.println(cnt);
	}
	
}

/**
 * 그리디 알고리즘
 * 
 * 미래 상황에서 "가장 늦게 다시 사용되거나 아예 사용 안하는 것" 찾기
 * 
 * plug를 Set으로 두어 중복되지 않게 해두고,
 * 자리가 있는 경우 일단 추가.
 * 그 후, 남은 order중에서 가장 멀리 있는 혹은 아예 사용 안하는 번호 찾기
 * -> 가장 멀리 있음 : 우선 교체하고 제일 나중에 다시 교체(next = 가장 먼 숫자)
 * -> 아예 사용 안함 : 필요없으니 교체(next = Integer.Max_Value)
 * 
 */

