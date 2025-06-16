package uyych_study.uyych_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class 최단경로_1753 {
	
	static class Node implements Comparable<Node> {
		int to;
		int w;
		
		public Node(int to, int w) {
			this.to = to;
			this.w = w;
		}
		
		@Override
		public int compareTo(Node o) {
			return w - o.w;
		}
	}
	
	static int V,E;
	static List<Node>[] list;
	static int[] dist;

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] VE = br.readLine().split(" ");
		
        V = Integer.parseInt(VE[0]);
        E = Integer.parseInt(VE[1]);
		
        int start = Integer.parseInt(br.readLine());
		
        list = new ArrayList[V + 1];
        dist = new int[V + 1];
        
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        for (int i = 1; i <= V; i++) {
			list[i] = new ArrayList<>();
		}
        
        for (int i = 0; i < E; i++) {
        	String[] input = br.readLine().split(" ");
        	int from = Integer.parseInt(input[0]);
        	int to = Integer.parseInt(input[1]);
        	int w = Integer.parseInt(input[2]);
        	
        	list[from].add(new Node(to, w));
		}
        
        dijkstra(start);
        
		for(int i = 1; i <= V; i++){
			if(dist[i] == Integer.MAX_VALUE) {
				System.out.println("INF");
			} else {
				System.out.println(dist[i]);
			}
		}
		
	}
	
	static void dijkstra(int from) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[V + 1];
		pq.add(new Node(from, 0));
		dist[from] = 0;
		
		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			int next = cur.to;
			
			if (visited[next] == true) continue;
			visited[next] = true;
			
			for (Node node : list[next]) {
				if (dist[node.to] > dist[next] + node.w) {
					dist[node.to] = dist[next] + node.w;
					pq.add(new Node(node.to, dist[node.to]));
				}
			}
		}
	}
	
}
