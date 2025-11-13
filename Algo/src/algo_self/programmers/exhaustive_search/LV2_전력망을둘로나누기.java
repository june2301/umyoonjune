package algo_self.programmers.exhaustive_search;

import java.util.*;

class LV2_전력망을둘로나누기 {
    
    int N;
    List<Integer>[] edges;
    
    public int solution(int n, int[][] wires) {
        int ans = n;
        N = n;
        
        edges = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }
        
        for (int[] e : wires) {
            edges[e[0]].add(e[1]);
            edges[e[1]].add(e[0]);
        }
        
        for (int i = 0; i < wires.length; i++) {
            int cnt = bfs(wires[i][0], wires[i][1]);
            int diff = Math.abs((N-cnt) - cnt);
            ans = Math.min(diff, ans);
        }
        
        return ans;
    }
    
    int bfs(int a, int b) {
        Queue<Integer> q = new LinkedList<>();
        q.add(a);
        
        boolean[] visited = new boolean[N+1];
        visited[a] = true;
        
        int cnt = 1;
        while (!q.isEmpty()) {
            int curr = q.poll();
            for (Integer next : edges[curr]) {
                if (visited[next]) continue;
                if ((curr == a && next == b) 
                    || (curr == b && next == a)) continue;
                q.add(next);
                visited[next] = true;
                cnt++;
            }
        }
        
        return cnt;
    }
}

/**
 * 완전탐색 + 트리
 * [문제]
 * n개의 송전탑이 하나의 트리 형태로 연결되어 있으며 이에 대한 간선 정보가 wires[][]로 주어진다.
 * 이 때 하나의 전선을 끊어서 전력망을 2개로 분할하려고 한다.
 * 전력망을 이루는 2개의 그룹 간의 송전탑 차이의 최솟값을 구하시오.
 * 
 * 인접리스트로 간선 정보를 저장한 후 한 전선씩 끊어보며 최솟값 구하기
 * 
 * wires[i]에 해당하는 두 노드[a, b]에 대해 탐색 진행
 * 이 때 a<->b 로 연결된 간선은 사용하지 않도록 탐색 진행
 * 방문처리를 통해 중복없이 연결된 노드수 카운트
 * 
 * 둘 중 하나로만 탐색 후 전체 노드 개수에서 뺀 값이 반대편 노드 수
 * a와 연결된 노드수와 b와 연결된 노드수의 차이값을 비교하며 최솟값 갱신
 */

