package algo_self.boj.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 트리와쿼리_15681 {
	
	static List<Integer>[] edges;
	static int[] child;

	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
		String[] NRQ = br.readLine().split(" ");
		int N = Integer.parseInt(NRQ[0]);
		int R = Integer.parseInt(NRQ[1]);
		int Q = Integer.parseInt(NRQ[2]);
		
		edges = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			edges[i] = new ArrayList<>();
		}
		for (int i = 0; i < N-1; i++) {
			String[] input = br.readLine().split(" ");
			int A = Integer.parseInt(input[0]);
			int B = Integer.parseInt(input[1]);
			edges[A].add(B);
			edges[B].add(A);
		}
		
		child = new int[N+1];
		
		dfs(R, R);
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < Q; i++) {
			int query = Integer.parseInt(br.readLine());
			sb.append(child[query] + "\n");
		}
		
		System.out.println(sb);
		
	}
	
	static void dfs(int curr, int parent) {
		child[curr] = 1;
		for (int next : edges[curr]) {
			if (next != parent) {
				dfs(next, curr);
				child[curr] += child[next];
			}
		}
	}

}

/**
 * 트리 + dfs
 * [문제]
 * 정점 수 N 과 루트번호 R 과 쿼리의 수 Q가 주어진다.
 * 그리고 N-1개의 간선 정보가 주어진 후, 쿼리 개수만큼의 숫자가 주어진다.
 * 이 때 해당 숫자를 루트로 하는 서브 트리에 속한 정점의 수를 출력하시오.
 * 
 * [아이디어]
 * 루트 노드부터 시작하여 서브 노드들을 탐색하며 각 노드에 속한 개수 저장
 * 
 * 인접리스트에 간선 정보들을 저장한 후
 * 루트 노드부터 dfs로 탐색 시작
 * 
 * child 배열 선언 후 자기자신을 포함하기 위해 1로 초기화
 * 이후 현재 노드와 연결된 노드가 부모 노드가 아닌 경우(자식 노드인 경우)
 * dfs(자식, 현재)로 진행하며
 * child[현재]에 child[자식]만큼 더하기
 * 
 * 이후 쿼리에서 요청한 번호의 자식 노드 수(자신 포함) 출력
 */

