package algo_self.mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 최소스패닝트리_1197 {
	
	static int[] p;
	static class Node implements Comparable<Node> {
		int to;
		int from;
		int v;
		
		public Node(int to, int from, int v) {
			this.to = to;
			this.from = from;
			this.v = v;
		}

		@Override
		public int compareTo(Node o) {
			return this.v - o.v;
		}
		
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] VE = br.readLine().split(" ");
		
		int V = Integer.parseInt(VE[0]);
		int E = Integer.parseInt(VE[1]);
		
		p = new int[V+1];
		for (int i = 1; i <= V; i++) {
			p[i] = i;
		}
		
		List<Node> list = new ArrayList<Node>();
		for (int i = 0; i < E; i++) {
			String[] input = br.readLine().split(" ");
			int A = Integer.parseInt(input[0]);
			int B = Integer.parseInt(input[1]);
			int C = Integer.parseInt(input[2]);
			list.add(new Node(A, B, C));
		}
		
		Collections.sort(list);
		
		int ans = 0;
		for (int i = 0; i < E; i++) {
			Node now = list.get(i);
			int to = now.to;
			int from = now.from;
			
			if (find(to) != find(from)) {
				ans += now.v;
				union(now.to, now.from);
			}
		}
		
		System.out.println(ans);
		
	}
	
	static void union(int x, int y) {
		int px = find(x);
		int py = find(y);
		if (px != py) {
			p[py] = px;
		}
		
	}
	
	static int find(int x) {
		if (x != p[x]) {
			p[x] = find(p[x]);
		}
		return p[x];
	}

}

/**
 * 최소 스패닝 트리(Minimum Spanning Tree, MST)
 * : 연결 그래프에서 모든 정점을 연결하면서 가중치 합이 최소인 트리
 * 
 * 크루스칼 알고리즘
 * : 모든 정점을 최소 비용으로 연결하는 트리 구조
 * - 간선 중심으로 동작, 가장 가중치가 낮은 간선부터 선택해 사이클이 생기지 않도록 트리 확장
 * 1. 가중치 기준으로 정렬
 * 2. 가중치 낮은 간선부터 차례로 선택
 * 3. 간선이 사이클을 만들지 않으면 선택
 * 4. 정점수-1개의 간선을 선택하면 종료(MST 완성)
 * 
 * 시간 복잡도 : O(E log E)
 */
