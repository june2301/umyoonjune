package algo_self.programmers.dfs_bfs;

import java.util.*;

class LV2_게임맵최단거리 {
    
    int[] dr = {0, 0, 1, -1};
    int[] dc = {1, -1, 0, 0};
    
    public int solution(int[][] maps) {
        int ans = 0;
        
        int N = maps.length;
        int M = maps[0].length;
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0, 0, 1});
        boolean[][] visited = new boolean[N][M];
        visited[0][0] = true;
        
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            int w = curr[2];
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (nr < 0 || nc < 0 || nr >= N || nc >= M || visited[nr][nc]) continue;
                if (nr == N-1 && nc == M-1) {
                    ans = w + 1;
                    return ans;
                }
                if (maps[nr][nc] == 1) {
                    q.add(new int[] {nr, nc, w+1});
                    visited[nr][nc] = true;
                }
            }
            
        }
        
        
        return -1;
    }
}

/**
 * BFS
 * [문제]
 * 1과 벽0으로 이루어진 maps가 주어지고, 0,0에서 출발하여 n-1,m-1까지 가는데 걸리는 최단거리를 구하시오.
 * 
 * 정석적인 bfs문제로 mapse 배열에 주어진 행열 길이를 구하여 N, M으로 저장
 * Queue와 방문처리용 boolean배열을 만들고 0,0 시작지점 처리
 * while문으로 탐색을 이어가며 4방향으로 1인 위치들 탐색 진행
 * 만약 N-1,M-1지점이 나타나면 거리+1 return
 * 
 * while문을 모두 돌동안 N-1,M-1에 도착하지 못할 경우 -1 return
 */

