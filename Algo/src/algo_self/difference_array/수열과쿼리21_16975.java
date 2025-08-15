package algo_self.difference_array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수열과쿼리21_16975 {

	static long[] diff;
	static int N;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());

		long[] arr = new long[N + 2];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}

		int M = Integer.parseInt(br.readLine());

		diff = new long[N + 2];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int type = Integer.parseInt(st.nextToken());

			if (type == 1) {
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				long num = Long.parseLong(st.nextToken());
				add(start, num);
				add(end + 1, -num);

			} else {
				int index = Integer.parseInt(st.nextToken());
				long ans = arr[index] + sum(index);
				sb.append(ans).append("\n");
			}
		}

		System.out.print(sb);
	}

	static void add(int index, long num) {
		while (index <= N + 1) {
			diff[index] += num;
			index += (index & -index);
		}
	}

	static long sum(int index) {
		long ans = 0;
		while (index > 0) {
			ans += diff[index];
			index -= (index & -index);
		}
		return ans;
	}
}

/**
 * 차분 배열 + 빠른 누적합
 *
 * [문제 요약]
 * 수열 A(1..N)가 주어지고, 두 종류의 쿼리를 실시간으로 처리
 * 1 i j k : 구간 i~j 모든 원소에 k를 더함
 * 2 x     : A[x]의 현재 값을 출력
 *
 * 단순 차분 배열만 사용할 경우
 * 쿼리가 섞여 들어와 매번 계간값을 1~x까지 직접 더하면 
 * O(N) → 전체 O(N·M) = 시간초과 (최악 = 100,000 * 100,000)
 * 
 * -> Fenwick Tree(BIT) 또는 세그먼트 트리(lazy) 중 하나를 반드시 사용
 *
 * [BIT]
 * index & -index 연산을 통해 index의 2진수 표현 중 가장 낮은 위치의 1비트 값을 뽑아냄
 * BIT에서 해당 인덱스가 담당하는 구간의 크기를 알아내어 다음 노드로 이동하면서 값을 더함.
 * 구간 더하기(1 i j k): add(i, +k), add(j+1, -k)
 * 점 조회(2 x): sum(x)로 Δx를 가져와서 A[x] + Δx 출력
 * 
 * 시간복잡도
 * : add / sum 각각 O(log N), 쿼리 M개 → 총 O(M log N)
 */

