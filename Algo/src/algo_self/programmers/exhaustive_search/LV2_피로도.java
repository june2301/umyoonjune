package algo_self.programmers.exhaustive_search;

import java.util.*;

class LV2_피로도 {
    
    int ans;
    int N;
    int[][] dg;
    
    public int solution(int k, int[][] dungeons) {
        ans = 0;
        N = dungeons.length;
        dg = dungeons;

        dfs(k, new boolean[N], 0);
        
        return ans;
    }
    
    void dfs(int now, boolean[] visited, int cnt) {
        ans = Math.max(ans, cnt);
        
        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;
            if (now >= dg[i][0]) {
                visited[i] = true;
                dfs(now - dg[i][1], visited, cnt + 1);
                visited[i] = false;
            }
        }
    }
}

/**
 * 완전탐색
 * [문제]
 * 피로도 시스템이 존재하는 게임에서 현재 피로도 k가 주어지고,
 * [최소 필요 피로도, 소모 피로도] 형식의 던전들이 주어질 때,
 * 최대 몇 개의 던전을 탐험 가능한지 구하시오.
 * 
 * 던전이 1~8개 주어지기 때문에 완전탐색을 해도 충분
 * dfs를 통해 모든 던전 탐험 경우의 수를 확인
 * 
 * 매 실행마다 던전 탐험 수 갱신
 * 던전 방문처리를 하며 현재 피로도를 기준으로 입장 가능 여부 확인 후
 * 소모 피로도를 빼고, 방문처리와 cnt를 늘려주며 재귀 반복
 */

