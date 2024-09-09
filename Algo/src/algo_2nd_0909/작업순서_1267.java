package algo_2nd_0909;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 작업순서_1267 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		for (int tc = 1; tc <= 10; tc++) {
			int V = sc.nextInt();
			int E = sc.nextInt();
			int[][] adj = new int[V+1][V+1];
			int[] degree = new int[V+1];
			for (int i = 0; i < E; i++) {
				int A = sc.nextInt();
				int B = sc.nextInt();
				adj[A][B] = 1;
				degree[B]++;
			}
			
			Queue<Integer> q = new LinkedList<>();
			for (int i = 1; i < V+1; i++) {
				if (degree[i] == 0) {
					q.add(i);
				}
			}
			StringBuilder sb = new StringBuilder();
			while (!q.isEmpty()) {
				int curr = q.poll();
				sb.append(curr + " ");
				for (int i = 1; i < V+1; i++) {
					if (adj[curr][i] == 1) {
						degree[i]--;
						
						if (degree[i] == 0) {
							q.add(i);
						}
					}
				}
				
			}
			System.out.println("#" + tc + " " + sb);
		}
		
	}

}
