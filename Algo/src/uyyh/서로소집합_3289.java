package uyyh;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class 서로소집합_3289 {
	
	static class Node {
		int from;
        int to;

        public Node(int from, int to) {
        	this.from = from;
            this.to = to;
        }
    }
	
	static List<Node> nums;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		nums = new ArrayList<>();
		
		for (int i = 0; i < M; i++) {
			List<Integer> input = new ArrayList<Integer>();
			int check = sc.nextInt();
			
			if (check == 0) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				Node save = new Node(a, b);
				nums.add(save);
			}
			if (check == 1) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				connect(a, b);
			}
		}
		
	}
	
	static void connect(int a, int b) {
		
		Queue<Node> q = new PriorityQueue<>();
		q.add(new Node(a,b));
		
		while (!q.isEmpty()) {
			Node save = q.poll();
			
			
			
		}
		
		
		
		
		
		
		
		
		
	}

}
