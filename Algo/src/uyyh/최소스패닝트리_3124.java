package uyyh;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class 최소스패닝트리_3124 {

	static class Node implements Comparable<Node> {
		int from;
		int to;
		int value;
		
		public Node(int from, int to, int value) {
			this.from = from;
			this.to = to;
			this.value = value;
		}

		@Override
		public int compareTo(Node o) {
			return this.value - o.value;
		}
		
	}
	
/*

1
3 3
1 2 1
2 3 2
1 3 3
from to value

 */
	static List<Node> nList;
	static int ans = 0;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int V = sc.nextInt();
		int E = sc.nextInt();
		
		nList = new ArrayList<>();
		for (int i = 0; i < E; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			int value = sc.nextInt();
			Node input = new Node(from, to, value);
			nList.add(input);
		}
		
	}
	
	static void prim(int start) {
		
		Queue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(1,0,0));
		
		while (!pq.isEmpty()) {
			Node save = pq.poll();
			int from = save.from;
			int to = save.to;
			int value = save.value;
			
			// to 들 중에 제일 낮은 value 선택
			// 
			
		}
		
		
		
		
		
	}
	
	

}
