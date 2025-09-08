package algo_self.programmers.greedy;

import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        int ans = 0;
        
        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < costs.length; i++) {
            int[] curr = costs[i];
            graph[curr[0]].add(new int[] {curr[1], curr[2]});
            graph[curr[1]].add(new int[] {curr[0], curr[2]});
        }
        
        boolean[] visited = new boolean[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {return a[1] - b[1];});
        
        visited[0] = true;
        for (int[] next : graph[0]) {
            pq.add(next);
        }
        
        int idx = 1;
        while (idx < n && !pq.isEmpty()) {
            int[] curr = pq.poll();
            int to = curr[0];
            int cost = curr[1];
            
            if (visited[to]) continue;
            
            ans += cost;
            visited[to] = true;
            
            for (int[] next : graph[to]) {
                if (visited[next[0]]) continue;
                pq.add(next);
            }
            
        }
        
        return ans;
    }
}

/**
 * 프림 알고리즘
 * [문제]
 * 1이상 100이하의 섬의 수 n과 각 섬을 연결하는 다리정보 costs[from, to, cost]가 주어질 때,
 * 모든 섬을 연결하는 최소 비용을 구하시오
 * 
 * -> MST구하기
 * 프림 알고리즘 적용
 * 간선그래프 형태로 입력을 받은 후(무방향이므로 양방향 모두 추가) 
 * 0부터 시작하여 연결 진행
 * 
 * 비용 오름차순 PQ를 만든 후 0과 연결된 간선들 추가
 * 이후 방문 안한 간선들을 탐색하며
 * 비용이 최저인 간선들만 연결하면서 진행
 */

