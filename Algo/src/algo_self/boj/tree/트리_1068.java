package algo_self.boj.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 트리_1068 {
	
	static List<Integer>[] tree;
	static int remove, ans;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		tree = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			tree[i] = new ArrayList<Integer>();
		}
		
		String[] input = br.readLine().split(" ");
		int root = 0;
		for (int i = 0; i < N; i++) {
			int curr = Integer.parseInt(input[i]);
			if (curr == -1) {
				root = i;
			} else {
				tree[curr].add(i);
			}
		}
		
		remove = Integer.parseInt(br.readLine());
		if (remove == root) {
			System.out.println(0);
			return;
		}
		
		ans = 0;
		dfs(root);
		
		System.out.println(ans);
	}
	
	static void dfs(int curr) {
		if (curr == remove) return;
		
		int child = 0;
		for (Integer next : tree[curr]) {
			if (next == remove) continue;
			child++;
			dfs(next);
		}
		
		if (child == 0) ans++;
	}

}

/**
 * 트리
 * [문제]
 * 자식 노드가 0개인 노드를 리프 노드라고 한다.
 * N개의 노드로 이루어진 트리가 주어지고, 제거할 노드의 번호가 주어졌을 때(해당 노드의 모든 자식 노드도 제거)
 * 남아있는 리프 노드의 개수를 구하시오.
 * 
 * 트리를 구현하는 과정에서 각 노드마다 어떤 자식 노드를 가지고 있는지 기록하기 위해 인접리스트 방식으로 기록
 * 
 * 루트 노드의 시작점이 -1로 주어지기 때문에 root에 기록을 해두며,
 * 인접리스트의 각 노드에 어떤 자식 노드가 있는지 기록
 * 이 때, 제거하려는 노드가 루트 노드인 경우 리프노드 0으로 바로 종료
 * 
 * 이후 dfs를 통해 최하단 노드까지 이동하며
 * 만약 자식 노드가 있는 경우 리프노드X
 * 제거하려는 노드로는 이동X
 * 자식 노드가 없는 노드 = 리프노드 카운트
 */

