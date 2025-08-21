package algo_self.topology_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class 줄세우기_2252 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] NM = br.readLine().split(" ");
		int N = Integer.parseInt(NM[0]);
		int M = Integer.parseInt(NM[1]);
		
		List<Integer>[] list = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		int[] indeg = new int[N+1];
		
		for (int i = 1; i <= M; i++) {
			String[] input = br.readLine().split(" ");
			int A = Integer.parseInt(input[0]);
			int B = Integer.parseInt(input[1]);
			list[A].add(B);
			indeg[B]++;
		}
		
		Deque<Integer> d = new ArrayDeque<>();
		for (int i = 1; i <= N; i++) {
			if (indeg[i] == 0) {
				d.add(i);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		while (!d.isEmpty()) {
			int curr = d.poll();
			sb.append(curr + " ");
			
			for (int next : list[curr]) {
				if (--indeg[next] == 0) {
					d.add(next);
				}
			}
		}
		
		System.out.println(sb);
		
	}

}

/**
 * 위상정렬
 * [문제]
 * N명의 학생을 키 순서대로 줄을 세우기
 * 일부 학생들만 2명씩 비교한 M개의 결과(오름차순 A < B)가 주어지고,
 * 이를 바탕으로 오름차순으로 줄 세운 결과 출력
 * 
 * 위상정렬은 기본적으로 순환하지 않는 방향 그래프의 방향성을 보존한 채 일렬로 나열
 * 보통 배열 + 인접리스트를 사용하여
 * 배열 - 본인 앞에 있어야 할 숫자 카운트
 * 인접리스트 - 본인 뒤에 누가 있는지 조회
 * 
 * 덱을 생성하여 배열에 0인 숫자들을 넣음 : 본인 앞에 있어야 할 숫자X
 * 덱의 숫자(A)를 하나씩 꺼내며
 * -> if (--indeg[next] == 0) 을 통해 본인(B) 앞에 하나(A)를 빼주면서 
 * 해당 숫자(A) 뒤에 오는 숫자(B)들을 덱에 넣음 
 * 
 * => 앞에 올 게 없는 노드부터 출력하고, 
 * => 그 노드 뒤에 있는 노드들의 진입 차수를 줄여서 
 * => 새로 0이 된 노드를 덱에 추가하는 방식으로 순서를 만들어 가는 것
 */

