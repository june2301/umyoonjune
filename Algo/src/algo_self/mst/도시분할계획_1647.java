package algo_self.mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 도시분할계획_1647 {
	
	static class Edge implements Comparable<Edge>{
		int from;
		int to;
		int cost;
		
		public Edge(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return this.cost - o.cost;
		}

	}
	
	static int[] p;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] NM = br.readLine().split(" ");
		
		int N = Integer.parseInt(NM[0]);
		int M = Integer.parseInt(NM[1]);
		
		p = new int[N+1];
		for (int i = 1; i <= N; i++) {
			p[i] = i;
		}
		
		List<Edge> edges = new ArrayList<Edge>();
		for (int i = 0; i < M; i++) {
			String[] input = br.readLine().split(" ");
			int from = Integer.parseInt(input[0]);
			int to = Integer.parseInt(input[1]);
			int cost = Integer.parseInt(input[2]);
			
			edges.add(new Edge(from, to, cost));
		}
		
		Collections.sort(edges);
		
		int sum = 0;
		int max = 0;
		int cnt = 0;
		for (int i = 0; i < edges.size(); i++) {
			Edge curr = edges.get(i);
			int from = curr.from;
			int to = curr.to;
			
			if (find(from) != find(to)) {
				sum += curr.cost;
				max = Math.max(max, curr.cost);
				union(from, to);
				cnt++;
			}
			if (cnt == N-1) break;
		}
		
		System.out.println(sum-max);
		
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
 * MST - 크루스칼
 * 
 * [문제]
 * 집 개수 N과 길의 수 M이 주어지고, 시작/도착/유지비 의 간선들이 주어진다.
 * 여기서 마을(최소 집 1개)을 2개로 나누면서 유지비의 합이 최소가 되도록 구하시오.
 * 
 * 최소 비용으로 마을을 2개로 나눈다
 * => MST를 만들고 가장 비싼 간선 하나 제거
 * 
 * 크루스칼 알고리즘을 사용하여 unoin-find를 통해 MST를 만든다.
 * cnt : 선택된 간선 개수 카운트 - cnt = N-1이면 모든 정점 연결 완료
 * sum : 전체 비용 합
 * max : 가장 높은 비용
 * -> sum - max 출력
 * 
 * *Collections.sort() 까먹지 말 것.
 */

