package uyyh;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 최적경로_1247 {
	
	static class Edge implements Comparable<Edge>{
		int From;
		int To;
		int W;
		public Edge(int from, int to, int w) {
			super();
			From = from;
			To = to;
			W = w;
		}
		@Override
		public int compareTo(Edge o) {
			return this.W - o.W;
		}
	}
	
	static int N, ans;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		int[] xs = new int[N+2];
		int[] ys = new int[N+2];
		for (int i = 0; i < N+2; i++) {
			xs[i] = sc.nextInt();
			ys[i] = sc.nextInt();
		}
		
		List<Edge>[] edges = new ArrayList[N>2 ? N + ((N*(N-3))/2) : N];
		
		for (int i = 0; i < (N>2 ? N + ((N*(N-3))/2) : N); i++) {
			edges[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < N+1; i++) {
			for (int j = i+1; j < N+2; j++) { // 모든 간선 경우의 수 계산
				int w = Math.abs(xs[i] - xs[j]) + Math.abs(ys[i] - ys[j]);
				edges[i].add(new Edge(i, j, w));
				edges[j].add(new Edge(j, i, w));
			}
		}
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.addAll(edges[0]);
		boolean[] visited = new boolean[N+2];
		visited[0] = true;
		
		ans = 0;
		int pick = 1;
		
		while (pick != N+2) {
			Edge e = pq.poll();
			if (visited[e.To]) continue; 
			
			ans += e.W;
			visited[e.To] = true;
			pick++;
			
			pq.addAll(edges[e.To]);
			
		}
		
		System.out.println(ans);
//		System.out.println("#" + tc + " " + );
		// 시작 위치와 끝 위치를 정하는 방법에 대해
	}

}
