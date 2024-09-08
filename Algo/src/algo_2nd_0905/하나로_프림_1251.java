package algo_2nd_0905;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 하나로_프림_1251 {
	
	static class Edge implements Comparable<Edge>{
		int Form;
		int To;
		double W;
		
		public Edge(int from, int to, double w) {
			super();
			Form = from;
			To = to;
			W = w;
		}

		@Override
		public int compareTo(Edge o) {
			return Double.compare(this.W, o.W);
		}
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			
			int[] xs = new int[N];
			int[] ys = new int[N];
			for (int i = 0; i < N; i++) {
				xs[i] = sc.nextInt();
			}
			for (int i = 0; i < N; i++) {
				ys[i] = sc.nextInt();
			}
			
			double E = sc.nextDouble(); // 배율
			
			List<Edge>[] edges = new ArrayList[N>2 ? N + ((N*(N-3))/2) : N];
			
			for (int i = 0; i < (N>2 ? N + ((N*(N-3))/2) : N); i++) {
				edges[i] = new ArrayList<>();
			}
			
			for (int i = 0; i < N-1; i++) {
				for (int j = i+1; j < N; j++) { // 모든 간선 경우의 수 계산
					double w = Math.sqrt(Math.pow(xs[i]-xs[j], 2) + Math.pow(ys[i]-ys[j], 2));
					edges[i].add(new Edge(i, j, w));
					edges[j].add(new Edge(j, i, w));
				}
			}
			
			PriorityQueue<Edge> pq = new PriorityQueue<>();
			pq.addAll(edges[0]);
			
			boolean[] visited = new boolean[N];
			visited[0] = true;
			
			double sum = 0;
			int pick = 1;
			
			while (pick != N) {
				Edge e = pq.poll();
				if (visited[e.To]) continue; 
				
				sum += Math.pow(e.W, 2);
				visited[e.To] = true;
				pick++;
				
				pq.addAll(edges[e.To]);
				
			}
			System.out.println("#" + tc + " " + Math.round(E*sum));
		}
		
	}
	
}
