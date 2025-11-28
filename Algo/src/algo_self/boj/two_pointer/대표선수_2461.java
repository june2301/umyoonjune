package algo_self.boj.two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 대표선수_2461 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] NM = br.readLine().split(" ");
		
		int N = Integer.parseInt(NM[0]);
		int M = Integer.parseInt(NM[1]);
		
		int[][] nums = new int[N*M][2];
		int idx = 0;
		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				nums[idx][0] = Integer.parseInt(input[j]);
				nums[idx][1] = i;
				idx++;
			}
		}
		
		Arrays.sort(nums, (a, b) -> a[0] - b[0]);
		
		int ans = Integer.MAX_VALUE;
		
		int l = 0;
		int r = 0;
		
		int[] cnt = new int[N];
		cnt[nums[0][1]] = 1;
		int check = 1;
		
		while (r < N*M) {
			if (check == N) {
				ans = Math.min(ans, nums[r][0] - nums[l][0]);
				cnt[nums[l][1]] -= 1;
				if (cnt[nums[l][1]] == 0) check--;
				l++;
			} else {
				r++;
				if (r >= N*M) break;
				cnt[nums[r][1]] += 1;
				if (cnt[nums[r][1]] == 1) check++;
			}
		}
		
		System.out.println(ans);
		
	}

}

/**
 * 투포인터 + 정렬
 * [문제]
 * N개의 학급이 각각 M명으로 구성되어 있고, 각 반의 각 학생들의 능력치가 주어진다.
 * 이 때 각 반마다 대표를 1명씩 골랐을 때 대표로 선발된 모든 학생들의 능력치의 최대와 최소의 차이가 최솟값이 되는 경우를 구하시오.
 * 
 * [중요 포인트]
 * - 모든 학급에서 한 명씩 포함되어야 함 -> 슬라이딩 윈도우
 * - 결국 최대와 최소만 따지면 됨 -> 투포인터
 * 
 * 이차원 배열에 {능력치, 반 번호} 를 저장 후 능력치 기준으로 정렬
 * 이 후 투포인터를 통해 윈도우 구간을 늘려가며 모든 학급이 포함되도록 함
 * 모든 학급이 포함되면 최대와 최소 차이를 통해 정답 갱신
 * 
 * 모든학급 미포함 -> r++
 * 모든학급 포함 -> 답 갱신, l++
 * 
 * 이 때 모든 학급이 포함되었는지 카운트하기 위해 N크기 배열 생성 후
 * 해당 학급이 윈도우 내에 몇 번 포함되어 있는지 진행하면서 체크
 * 해당 학급이 1번 포함되었을 때 총 학급 확인(check)에 +1
 * l++에서 해당 학급이 0번 포함된 경우 check -1
 */

