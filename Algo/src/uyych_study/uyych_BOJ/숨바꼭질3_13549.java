package uyych_study.uyych_BOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 숨바꼭질3_13549 {

	public static void main(String[] args) {
		
Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		boolean[] visited = new boolean[100001];
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] {N, 0});
		int ans = 0;
		while (!q.isEmpty()) {
			int[] save = q.poll();
			int curr = save[0];
			ans = save[1];
			visited[curr] = true;
			
			if (curr == K) break;
			
			if (curr-1 >= 0 && !visited[curr-1]) {
				q.add(new int[] {curr-1, ans+1});
			}
			if (curr+1 <= 100000 && !visited[curr+1]) {
				q.add(new int[] {curr+1, ans+1});
			}
			if (curr*2 <= 100000 && !visited[curr*2]) {
				q.add(new int[] {curr*2, ans});
			}
			
		}
		
		System.out.println(ans);
		
	}

}
