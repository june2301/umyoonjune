package uyyh;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 최소스패닝트리_3124 {

    static class Node implements Comparable<Node> {
        int to;
        int value;

        public Node(int to, int value) {
            this.to = to;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return this.value - o.value;
        }
    }

    static List<Node>[] graph;
    static int V, E;

    public static void main(String[] args) throws IOException {

    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	V = Integer.parseInt(st.nextToken());
	        E = Integer.parseInt(st.nextToken());
            
            graph = new ArrayList[V + 1]; // 정점 번호 1번부터 시작이므로 +1
            for (int i = 1; i < V + 1; i++) {
                graph[i] = new ArrayList<>(); // ArrayList 요소로 ArrayList 생성
            }
            
            for (int i = 0; i < E; i++) {
            	st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int value = Integer.parseInt(st.nextToken());
                graph[from].add(new Node(to, value));
                graph[to].add(new Node(from, value)); // 양방향 간선
            }
            
            System.out.println("#" + tc + " " + prim(1));
        }
    }

    static long prim(int start) {

    	long ans = 0;
    	boolean[] visited = new boolean[V + 1];
    	
        Queue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1, 0));

        while (!pq.isEmpty()) {
            Node save = pq.poll();

            if (visited[save.to]) {
                continue;
            }

            visited[save.to] = true;
            ans += save.value;

            for (Node node : graph[save.to]) {
                if (!visited[node.to]) {
                    pq.add(node);
                }
            }
        }
        return ans;
    }
}
