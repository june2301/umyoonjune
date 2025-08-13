package uyych_study.uyych_swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class A_Test {

	public class Prim {
		
	    static class Edge implements Comparable<Edge>{ // sub node와 cost 정보를 저장할 클래스 -> PriorityQueue 구현됨
	        int w, cost;
	        
	        public Edge(int w, int cost) {
	            super();
	            this.w = w;
	            this.cost = cost;
	        }
	        @Override
	        public int compareTo(Edge e) {
	            return this.cost - e.cost;
	        }
	    }
	    static int V, E; // # of node & edge
	    static List<Edge>[] graph; // ArrayList 요소로 ArrayList를 생성 -> new ArrayList[new ArrayList, new ArrayList, new ArrayList]
	                               // 하나의 node에 여러 개의 edge을 넣기 위함
	                               // -> ArrayList[ [v1: Edge(w1, cost1), Edge(w2, cost2), Edge(w3, cost3)], [v2: Edge(w4, cost4), Edge(w5, cost5)], [v3: Edge(w1, cost1)] ]
	    public static void main(String[] args) throws IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        
	        V = Integer.parseInt(st.nextToken());
	        E = Integer.parseInt(st.nextToken());
	        
	        graph = new ArrayList[V + 1]; // graph의 ArrayList는 V + 1개 -> 0 인덱스는 사용하지 않기 때문
	        
	        for (int i = 1; i < V + 1; i++) {
	        	graph[i] = new ArrayList<>(); // 각 ArrayList 배열에 ArrayList을 선언하여 담기
	        }
	        for (int i = 0; i < E; i++) { // graph 정보 담기 -> edge의 수 만큼
	            st = new StringTokenizer(br.readLine());
	            int v = Integer.parseInt(st.nextToken()); // main node
	            int w = Integer.parseInt(st.nextToken()); // sub node
	            int cost = Integer.parseInt(st.nextToken());
	            graph[v].add(new Edge(w, cost)); // 양방향 노드 저장 -> main이 sub을 가리키면 sub도 main을 가리키는 것임
	            graph[w].add(new Edge(v, cost));
	        }
	        System.out.println(prim(1));
	    }
	    
	    static int prim(int start) { // 최소 비용 합을 출력하는 프림 알고리즘 메서드
	    	
	        int costSum = 0;
	        boolean[] visit = new boolean[V + 1]; // MST을 구현하기 위한 노드들의 방문 정보
	        
	        PriorityQueue<Edge> pq = new PriorityQueue<>(); // 우선순위큐
	        pq.offer(new Edge(1, 0)); // 시작 노드 -> 1, 다음 연산부터 new Edge(sub node, cost)로 node 정보를 pq에 던져줄 것이기에 시작 노드의 비용은 0로 설정
	        
	        while(!pq.isEmpty()) {
	        	
	            Edge edge = pq.poll();
	            
	            if(visit[edge.w]) continue; // 방문한 노드이면 계산 안함 -> MST 구현
	            
	            visit[edge.w] = true; // 방문처리
	            costSum += edge.cost; // 최소 비용 합 연산
	            
	            for (Edge e : graph[edge.w]) { // main node에 연결된 방문안한 모든 간선 추가
	                if(visit[e.w]) continue;
	                pq.offer(e);
	            }
	        }
	        return costSum;
	    }
	}

	/*
	 * sample input(첫 줄의 첫 숫자는 정점의 개수, 두 번째 숫자는 간선의 개수).
	5 7
	1 2 10
	1 3 3
	1 4 8
	2 3 13
	2 5 14
	4 5 9
	5 2 14
	output: 30
	 */

}
