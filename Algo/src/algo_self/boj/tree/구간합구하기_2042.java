package algo_self.boj.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 구간합구하기_2042 {

	static int N, M, K;
	static long[] arr;
	static long[] tree;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] NMK = br.readLine().split(" ");
		N = Integer.parseInt(NMK[0]);
		M = Integer.parseInt(NMK[1]);
		K = Integer.parseInt(NMK[2]);

		arr = new long[N+1];
		for (int i = 1; i <= N; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}

		tree = new long[4*N];

		build(1, N, 1);

		StringBuilder sb = new StringBuilder();

		int Q = M + K;
		for (int i = 0; i < Q; i++) {
			String[] input = br.readLine().split(" ");
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);
			long c = Long.parseLong(input[2]);

			if (a == 1) {
				update(1, N, 1, b, c);
			} else {
				sb.append(query(1, N, 1, b, (int) c) + "\n");
			}
		}

		System.out.print(sb);
	}

	static long build(int start, int end, int node) {
		if (start == end) {
			return tree[node] = arr[start];
		}

		int mid = (start + end) / 2;

		long left = build(start, mid, node*2);
		long right = build(mid + 1, end, node*2 + 1);

		return tree[node] = left + right;
	}

	static long update(int start, int end, int node, int idx, long value) {
		if (idx < start || idx > end)
			return tree[node];

		if (start == end) {
			return tree[node] = value;
		}

		int mid = (start + end) / 2;

		long left = update(start, mid, node*2, idx, value);
		long right = update(mid + 1, end, node*2 + 1, idx, value);

		return tree[node] = left + right;
	}

	static long query(int start, int end, int node, int left, int right) {
		if (end < left || start > right) {
			return 0; 
		}

		if (left <= start && end <= right) {
			return tree[node];
		}

		int mid = (start + end) / 2;

		long q1 = query(start, mid, node*2, left, right);
		long q2 = query(mid + 1, end, node*2 + 1, left, right);

		return q1 + q2;
	}
	
}

/**
 * 세그먼트 트리
 * [문제]
 * 수의 개수 N, 수의 변경 횟수 M, 구간합 구하는 횟수 K가 주어지고 이후 N개만큼의 수가 주어진다.
 * 이후 M+K번만큼 수의 변경/구간합 구하는 식이 a b c 형태로 주어지며,
 * a가 1이면 b와 c 수를 변경하고, a가 2이면 b~c 구간 합을 출력하시오.
 * 
 * 세그먼트 트리를 구성/변경/구간합 을 구하기 위해 각각의 메서드 생성
 * 
 * build(start, end, node)
 * 루트 노드에서 반씩 쪼개면서 최하위 노드까지 진행하며 해당 노드 위치에 구간의 합 저장
 * 
 * update(start, end, node, idx, value)
 * 세그먼트 트리에서 특정 인덱스(idx)의 값을 value로 변경
 * start==end -> idx인 지점까지 내려간 후 값을 바꿈
 * 이후 다시 올라가면서 바뀐 값을 바탕으로 구간합들 업데이트
 * 
 * query(start, end, node, left, right)
 * 요청한 구간[left, right]의 합을 구하는 메서드
 * 현재 노드 구간과 요청 구간의 관계를 기준으로 처리:
 * 1. 전혀 겹치지 않는 경우 → 0 반환
 * 2. 완전히 포함되는 경우 → 해당 노드의 값(tree[node]) 바로 사용
 * 3. 일부만 겹치는 경우 → 왼쪽/오른쪽 자식 구간을 재귀적으로 조회하여 합산
 */

