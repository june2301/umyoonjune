package uyych_study.uyych;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class 창용마을무리의개수_7465 {
	
	static class Edge {
		int from;
		int to;
		
		public Edge(int from, int to) {
			this.from = from;
			this.to = to;
		}
	}
	
	static int[] p;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); // V 정점
			int M = sc.nextInt(); // E 간선
			
			Edge[] edges = new Edge[M];
			
			for (int i = 0; i < M; i++) {
				int from = sc.nextInt();
				int to = sc.nextInt();
				edges[i] = new Edge(from, to);
			}
			
			p = new int[N+1]; // 1번부터 시작
			for (int i = 1; i < N+1; i++) {
				p[i] = i;
			}
			
			for (int i = 0; i < M; i++) {
				int px = findSet(edges[i].from);
				int py = findSet(edges[i].to);
				
				// from과 to의 root가 다를경우 -> union
				if (px != py) {
					union(px, py);
				}
			}
			
			Set<Integer> ans = new HashSet<>();
			for (int i = 1; i < N + 1; i++) {
				ans.add(findSet(i));
			}
			System.out.println("#" + tc + " " + ans.size());
		}
		
	}
	
	static int findSet(int x) { // root찾는 메서드
		if (x != p[x]) {
			p[x] = findSet(p[x]);
		}
		return p[x];
	}
	
	static void union(int x, int y) { // root 합치기
		p[y] = p[x];
	}
	

}
