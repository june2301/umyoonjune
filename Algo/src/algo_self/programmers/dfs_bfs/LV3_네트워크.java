package algo_self.programmers.dfs_bfs;

import java.util.*;

class LV3_네트워크 {

    int[][] coms;
    boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        int ans = 0;
        
        coms = computers;
        
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            bfs(i);
            ans++;
        }
        
        return ans;
    }
    
    void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        
        q.add(start);
        visited[start] = true;
        
        while(!q.isEmpty()) {
            int curr = q.poll();
            for (int i = 0; i < coms[curr].length; i++) {
                if (coms[curr][i] == 1) {
                    if (visited[i]) continue;
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }
    
}

/**
 * bfs(or dfs)
 * [문제]
 * [[1, 1, 0], [1, 1, 0], [0, 0, 1]] 
 * 이런식으로 자기자신을 포함한 연결된 컴퓨터 번호들이 주어졌을 때, 몇 덩어리의 네트워크가 형성되는지 구하시오.
 * 
 * 0번부터 bfs탐색을 하며 주어진 배열에 숫자가 1인 컴퓨터들을 탐색
 * visited를 통한 방문처리를 하여 이미 연결 확인한 컴퓨터는 탐색X
 * 해당 컴퓨터와 연결된(값이 1인) 컴퓨터들을 q에 넣으면서 탐색 진행
 * 
 * 한 번의 탐색마다 1개의 네트워크를 형성하고 있으므로 정답 개수 카운트
 */

