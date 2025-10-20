package algo_self.boj.topology_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class 작업_2056 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		List<Integer>[] works = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			works[i] = new ArrayList<>();
		}
		int[] indegree = new int[N+1];
		int[] time = new int[N+1];
		
		Deque<Integer> deq = new ArrayDeque<Integer>();
		int[] dp = new int[N+1];
		for (int i = 1; i <= N; i++) {
			String[] input = br.readLine().split(" ");
			int t = Integer.parseInt(input[0]);
			int cnt = Integer.parseInt(input[1]);
			indegree[i] = cnt;
			time[i] = t;
			for (int j = 0; j < cnt; j++) {
				int prev = Integer.parseInt(input[2+j]);
				works[prev].add(i);
			}
			if (cnt == 0) {
				deq.add(i);
				dp[i] = t;
			}
		}
		
		while (!deq.isEmpty()) {
			int curr = deq.pollFirst();
			
			for (Integer next : works[curr]) {
				dp[next] = Math.max(dp[next], dp[curr] + time[next]);
				if (--indegree[next] == 0) {
					deq.addLast(next);
				}
			}
		}
		
		int ans = 0;
		for (int i = 1; i <= N; i++) {
			ans = Math.max(ans, dp[i]);
		}
		
		System.out.println(ans);
	}

}

/**
 * 위상정렬 + DP
 * [문제]
 * 수행해야 할 작업 N개에 대해 각각 선행작업들이 있으며, 선행 관계가 없는 작업이 반드시 주어진다.
 * 작업시간, 필요 선행작업 개수, 필요 선행작업 번호 가 N개의 작업 순서대로 주어질 때,
 * 모든 작업 완료를 위한 최소 시간을 출력하시오.
 * 
 * 선행작업 관계를 위상정렬로 나타내기 위해 생성
 * indegree : 필요 선행 작업 수
 * works : 해당 작업 이후에 가능한 작업들을 담은 인접리스트
 * time : 각 작업 수행 시간
 * 
 * 선행 관계가 없는 작업들의 번호를 Deque에 우선 담은 후
 * while문을 통해 해당 작업 완료 후 진행할 작업들을 Deque에 담으며 진행
 * 
 * 이 때 시간 기록을 위해 DP 배열 사용
 * 선행 관계 없는 작업에 대해 시간 우선 기록
 * 이후 while문에서 다음 수행할 작업들을 찾을 때 해당 작업들의 시간 중 가장 긴 시간 1개만 추가
 * 가장 크게 기록된 dp배열값을 답으로 반환
 */

