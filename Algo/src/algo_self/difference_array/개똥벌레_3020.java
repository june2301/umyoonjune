package algo_self.difference_array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 개똥벌레_3020 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] NH = br.readLine().split(" ");

		int N = Integer.parseInt(NH[0]);
		int H = Integer.parseInt(NH[1]);

		int[] diff = new int[H + 2];
		for (int i = 0; i < N; i++) {
			int len = Integer.parseInt(br.readLine());

			if (i % 2 == 0) {
				int l = 1, r = len;
				if (r >= 1) {
					diff[l] += 1;
					if (r + 1 <= H) {
						diff[r + 1] -= 1;
					}
				}
			} else {
				int l = H-len+1, r = H;
				if (l < 1) {
					l = 1;
				}
				if (l <= r) {
					diff[l] += 1;
					if (r + 1 <= H) {
						diff[r + 1] -= 1;
					}
				}
			}

		}
		int min = Integer.MAX_VALUE;
		int cnt = 0;

		int cur = 0;
		for (int i = 1; i <= H; i++) {
			cur += diff[i];
			if (cur < min) {
				min = cur;
				cnt = 1;
			} else if (cur == min) {
				cnt++;
			}
		}

		System.out.println(min + " " + cnt);

	}

}

/**
 * 차분 배열(Diffenece Array)
 * [문제]
 * 동굴의 길이(N)와 높이(H)가 주어지고,
 * 홀수번째에는 석순(1~) 짝수번째에는 종유석(~H)이 주어진다.
 * 이 때 개똥벌레가 날아가면서 석순과 종유석을 최소로 부수는 개수와 구간의 수를 구하시오.
 * 
 * 차분배열diff를 사용하여 각 높이(len)마다 부셔야 하는 개수의 변화량을 기록
 * 석순(홀수)
 * : 1에 +1 / len+1에 -1
 * 종유석(짝수)
 * : H-len+1에 +1 / H+1에 -1
 * -> 석순과 종유석이 걸치기 시작하는 영역에 +1 / 끝나는 다음 구간에 -1
 * (diff 배열은 H+1에서 다음 구간까지 계산하기 위해 [H+2] 크기로 초기화)
 * 
 * 이후 각 높이마다 변화량을 더해가며 석/종을 몇 개 부셔야하는지 기록
 */

