package algo_self.programmers.graph;

import java.util.*;

class LV3_가장먼노드 {
    
    List<Integer>[] graph;
    int N;
    
    public int solution(int n, int[][] edge) {
        N = n;
        
        graph = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < edge.length; i++) {
            graph[edge[i][0]].add(edge[i][1]);
            graph[edge[i][1]].add(edge[i][0]);
        }
        
        int ans = bfs();
        
        return ans;
    }
    
    int bfs() {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[N+1];
        int[] dist = new int[N+1];
        
        q.add(1);
        visited[1] = true;
        
        int max = 0;
        
        while (!q.isEmpty()) {
            int curr = q.poll();
            for (Integer next : graph[curr]) {
                if (visited[next]) continue;
                q.add(next);
                visited[next] = true;
                dist[next] = dist[curr]+1;
                if (dist[next] > max) max = dist[next];
            }
        }
        
        int cnt = 0;
        for (Integer num : dist) {
            if (num == max) cnt++;
        }
        
        return cnt;
    }
}

/**
 * 그래프 + bfs
 * [문제]
 * 노드의 개수 n과 간선정보 edge가 주어진다.
 * 이를 활용해서 1번 노드에서 가장 멀리 떨어져 있는 노드의 개수를 구하시오.
 * 
 * 간선 정보를 인접리스트에 저장 후 bfs로 탐색
 * 
 * 방향성이 없기 때문에 양방향으로 저장 후
 * bfs에서 방문처리 + 각 노드별 거리 저장
 * 
 * 가장 먼 거리(max)에 해당하는 노드 개수(cnt) 구하기
 */

